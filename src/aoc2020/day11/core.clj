(ns aoc2020.day11.core
  (:require [clojure.string :as string]))

(defn transform-line-to-index-map [line]
  (map-indexed (fn [y row]
                 (apply merge (map-indexed (fn [x char] {[x y] char}) row)))
               line))

(def input-file (slurp "./src/aoc2020/day11/resources/input1.txt"))
(def test-file (slurp "./src/aoc2020/day11/resources/test.txt"))

(def input (->> input-file
                string/split-lines
                transform-line-to-index-map
                (apply merge)))

(def directions
  {:up         [identity dec]
   :down       [identity inc]
   :right      [inc identity]
   :left       [dec identity]
   :up-right   [inc dec]
   :up-left    [dec dec]
   :down-right [inc inc]
   :down-left  [dec inc]})

(defn stringify [seat-map]
  (let [xmax          (apply max (map first (keys seat-map)))
        ymax          (apply max (map second (keys seat-map)))
        ordered-chars (for [x (range (inc xmax))
                            y (range (inc ymax))]
                        (seat-map [y x]))]
    (->> ordered-chars
         (partition (inc xmax))
         (map string/join)
         (map (fn [line] (println line) line)))))

(defn scan-surroundings [seat-map x y]
  (->> (vals directions)
       (map (fn [[fx fy]] [(fx x) (fy y)]))
       (map #(seat-map %))))

(defn scan-sightlines [seat-map x y]
  (->> (vals directions)
       (map (fn [[fx fy]]
              (let [line (map #(vector %1 %2)
                              (iterate fx (fx x))
                              (iterate fy (fy y)))]
                (first (drop-while #(= \. (seat-map %)) line)))))
       (map #(seat-map %))))

(defn decision-fn [seat-map {:keys [nearby-num surrounding-fn]}]
  (fn [[[x y] tile]]
    (let [surroundings (surrounding-fn seat-map x y)
          tile         (seat-map [x y])]
      (cond
        (and (= tile \L)
             (nil? (get (frequencies surroundings) \#)))            #(assoc % [x y] \#)
        (and (= tile \#)
             (<= nearby-num (get (frequencies surroundings) \# 0))) #(assoc % [x y] \L)
        :else                                                       identity))))

(defn seat-passengers [seat-map opts]
  (->> seat-map
       (map (decision-fn seat-map opts))
       (reduce (fn [acc f] (f acc)) seat-map)))

(defn seat-dance [seat-map opts]
  (let [next-seat-map (seat-passengers seat-map opts)]
    (if (= seat-map next-seat-map) next-seat-map
        (recur next-seat-map opts))))

(def part1-opts {:nearby-num 4 :surrounding-fn scan-surroundings})
(defn part1 []
  (-> (seat-dance input part1-opts)
      vals
      frequencies
      (get \#)))

(def part2-opts {:nearby-num 5 :surrounding-fn scan-sightlines})
(defn part2 []
  (-> (seat-dance input part2-opts)
      vals
      frequencies
      (get \#)))

(comment

  input

  (part1)
  ;; => 2178
  (part2)
  ;; => 1978
  0)
