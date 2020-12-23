(ns aoc2020.day20.core
  (:require [clojure.string :as string]
            [clojure.edn :as edn]
            [clojure.set :as set :refer [union]]))

(def input-file (slurp "./src/aoc2020/day20/resources/input1.txt"))

(defn transpose [ars]
  (vec (apply map vector ars)))

(defn get-edges [base-tile]
  (let [transposed (transpose base-tile)
        [top bottom] [(first base-tile) (last base-tile)]
        [left right] [(first transposed) (last transposed)]]
    [top bottom left right]))

(defn parse-tile [tile]
  (let [[header & tile-lines] (string/split-lines tile)
        [_ tile-id] (re-find #"(\d+)" header)
        base-tile (map vec tile-lines)
        [top bottom left right] (get-edges base-tile)]
    {(edn/read-string tile-id) {:id (edn/read-string tile-id) :base base-tile
                                :top top :bottom bottom
                                :left left :right right}}))

(def input (string/split input-file #"\n\n"))

(defn update-tile [tile new-base new-top new-bottom new-left new-right]
  (-> tile
      (assoc :base new-base)
      (assoc :top new-top)
      (assoc :bottom new-bottom)
      (assoc :left new-left)
      (assoc :right new-right)))

(defn flipY [tile]
  (let [new-base (->> (:base tile) transpose (map (comp vec reverse)) transpose)
        [newt newb newl newr]  (get-edges new-base)]
    (update-tile tile new-base newt newb newl newr)))

(defn flipX [tile]
  (let [new-base (->> (:base tile) (map (comp vec reverse)))
        [newt newb newl newr]  (get-edges new-base)]
    (update-tile tile new-base newt newb newl newr)))

(defn rotateRight [tile]
  (let [new-base (->> (:base tile) transpose (map (comp vec reverse)))
        [newt newb newl newr]  (get-edges new-base)]
    (update-tile tile new-base newt newb newl newr)))

(defn rotateLeft [tile]
  (let [new-base (->> (:base tile) (map (comp vec reverse)) transpose)
        [newt newb newl newr]  (get-edges new-base)]
    (update-tile tile new-base newt newb newl newr)))

(defn rotate180 [tile]
  (->> tile rotateRight rotateRight))

(defn all-edges [tiles]
  (vec (mapcat (fn [[_id tile]] [(:top tile) (:bottom tile)
                                 (:left tile) (:right tile)])
               tiles)))

(defn get-edge-info [tile k]
  {:tile (k tile)
   :id (:id tile)
   :reversed false
   :side k})

(defn all-edges-with-info [tiles]
  (vec (mapcat (fn [[_id tile]] [(get-edge-info tile :top) (get-edge-info tile :bottom)
                                 (get-edge-info tile :left) (get-edge-info tile :right)])
               tiles)))

(defn find-edges-without-matches [edges]
  (->> (concat edges (map reverse edges))
       frequencies
       (filter (comp (partial = 1) second))
       (map first)
       (filter vector?)))

(defn match-id-edge [tiles edge]
  [(:id (first (filter (fn [tile]
                         (some #(= edge %) [(:top tile) (:bottom tile)
                                            (:left tile) (:right tile)]))
                       (vals tiles))))
   edge])

(defn find-corners [tiles]
  (let [basic-edges (all-edges tiles)
        edges-without-match (find-edges-without-matches basic-edges)
        tile-id-edges (map (partial match-id-edge tiles) edges-without-match)]
    (->> tile-id-edges
         (group-by first)
         (filter (comp (partial = 2) count second))
         keys)))

(defn part1 []
  (->> input
       (map parse-tile)
       (apply merge)
       find-corners
       (reduce *)))

(defn get-tile-pairs [matched-edges edge-id]
  (->> matched-edges
       (filter (fn [[first-edge second-edge]]
                 (or (= edge-id (:id first-edge))
                     (= edge-id (:id second-edge)))))
       (map (fn [edges] (sort-by #(if (= (:id %) edge-id) 0 1) edges)))
       (remove (comp :reversed first))))

(defn m [tile]
  #_(println (:id tile))
  (println (:base tile))
  tile)

(defn flip-rotate-tile [tilemap [first-edge second-edge]]
  (if (nil? second-edge) tilemap
      (let [tile-id (:id second-edge)
            tile (tilemap tile-id)
            reversed? (:reversed second-edge)]
        (letfn [(modify-tile [normal-fn reversed-fn]
                  (assoc tilemap tile-id (if reversed?
                                           (reversed-fn tile)
                                           (normal-fn tile))))]
          (case [(:side first-edge) (:side second-edge)]
            [:top :top] (modify-tile flipY rotate180)
            [:top :bottom] (modify-tile identity flipX)
            [:top :left] (modify-tile rotateLeft (comp flipX rotateLeft))
            [:top :right] (modify-tile (comp flipX rotateRight) rotateRight)
            [:bottom :bottom] (modify-tile flipY rotate180)
            [:bottom :top] (modify-tile identity flipX)
            [:bottom :left] (modify-tile (comp flipX rotateRight) rotateRight)
            [:bottom :right] (modify-tile rotateLeft (comp flipX rotateLeft))
            [:left :left] (modify-tile flipX rotate180)
            [:left :right] (modify-tile identity flipY)
            [:left :top] (modify-tile rotateRight (comp flipY rotateRight))
            [:left :bottom] (modify-tile (comp flipY rotateLeft) rotateLeft)
            [:right :right] (modify-tile flipX rotate180)
            [:right :left] (modify-tile identity flipY)
            [:right :top] (modify-tile (comp flipY rotateLeft) rotateLeft)
            [:right :bottom] (modify-tile rotateRight (comp flipY rotateRight))
            :break)))))

(defn stitch-tiles [tilemap]
  (loop [tilemap tilemap
         working-ids #{(key (first tilemap))}
         locked-ids #{}
         iteration 0]
    (println iteration (count working-ids) (count locked-ids))
    (if (< 100000 iteration) [:break tilemap]
        (if (= (count locked-ids) (count tilemap)) tilemap
            (let [edge-info (all-edges-with-info tilemap)
                  reversed-edges (map (fn [edge] (-> edge
                                                     (update :tile (comp vec reverse))
                                                     (assoc :reversed true))) edge-info)
                  matched-edges (vals (group-by :tile (concat edge-info reversed-edges)))
                  filtered-working-edges (mapcat (partial get-tile-pairs matched-edges) working-ids)
                  next-working-ids (map (comp :id second) filtered-working-edges)
                  new-tilemap (reduce flip-rotate-tile tilemap filtered-working-edges)]
              (recur new-tilemap
                     (set (remove nil? next-working-ids))
                     (union locked-ids working-ids)
                     (inc iteration)))))))

(comment

  input

  (part1)
  ;; => 5775714912743

  (flipX
   {:id 3881
    :base '([\# \. \# \# \# \. \. \. \# \.] [\# \. \. \. \. \. \. \# \. \.] [\# \. \. \. \. \. \# \. \. \#] [\. \. \. \. \. \. \# \. \. \#] [\# \. \. \. \. \. \. \. \# \.] [\# \. \# \. \. \# \. \. \# \.] [\# \# \. \. \. \. \# \# \. \.] [\# \. \. \# \. \# \. \. \. \#] [\# \. \# \. \. \. \. \. \. \#] [\. \# \. \. \. \# \. \# \# \#])
    :top [\# \. \# \# \# \. \. \. \# \.], :bottom [\. \# \. \. \. \# \. \# \# \#]
    :left [\# \# \# \. \# \# \# \# \# \.], :right [\. \. \# \# \. \. \. \# \# \#]})

  (def penguin (->> input (map parse-tile) (apply merge)))
  (all-edges-with-info penguin)
  (def penguin2 (stitch-tiles penguin))
  penguin2

  (count (filter (comp (partial = 1) count second) (group-by :tile (all-edges-with-info penguin2))))


  (count (filter (comp (partial = 2) count second) (group-by :tile (all-edges-with-info penguin2))))

  (def elephant
    (vals (group-by :tile  (concat (all-edges-with-info penguin2)
                                   (map (fn [edge] (-> edge
                                                       (update :tile (comp vec reverse))
                                                       (assoc :reversed true)))
                                        (all-edges-with-info penguin2))))))

  (count (filter (comp (partial = 1) count second) elephant))

  (mapcat (partial get-tile-pairs elephant) #{2069})
  (reduce flip-rotate-tile penguin (mapcat (partial get-tile-pairs elephant) #{2069}))
  (reduce flip-rotate-tile penguin (list (first (drop 2 (mapcat (partial get-tile-pairs elephant) #{2069})))))
  (first (drop 0 (mapcat (partial get-tile-pairs elephant) #{2069})))
  (let [edge-id 3217]
    (remove (comp :reversed first)
            (map (fn [edges] (sort-by #(if (= (:id %) edge-id) 0 1) edges))
                 (filter (fn [[first-edge second-edge]]
                           (or (= edge-id (:id first-edge))
                               (= edge-id (:id second-edge))))
                         (vals (group-by :tile elephant))))))

  (filter (fn [edge-pair]
            (when (= 2 (count edge-pair))
              (and (every? (comp not :reversed) edge-pair)
                   (or (and (= :top (:side (first edge-pair)))
                            (= :bottom (:side (second edge-pair))))
                       (and (= :bottom (:side (first edge-pair)))
                            (= :top (:side (second edge-pair))))
                       (and (= :left (:side (first edge-pair)))
                            (= :right (:side (second edge-pair))))
                       (and (= :right (:side (first edge-pair)))
                            (= :left (:side (second edge-pair)))))))) elephant)

  0)
