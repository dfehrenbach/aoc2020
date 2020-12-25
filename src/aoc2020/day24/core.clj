(ns aoc2020.day24.core
  (:require [clojure.string :as string]))

(def input-file (slurp "./src/aoc2020/day24/resources/input1.txt"))

(defn parse-into-instructions [line]
  (re-seq #"nw|ne|sw|se|w|e" line))

(def direction->fns
  {"ne" [#(+ % 0.5) #(+ % 0.5)]
   "nw" [#(- % 0.5) #(+ % 0.5)]
   "se" [#(+ % 0.5) #(- % 0.5)]
   "sw" [#(- % 0.5) #(- % 0.5)]
   "e" [#(+ % 1) identity]
   "w" [#(- % 1) identity]})

(defn instructions-to-coords [instruction-list]
  (let [counts (frequencies instruction-list)]
    (reduce (fn [coords [direction times]]
              (reduce (fn [[x y] [fnx fny]]
                        [(fnx x) (fny y)])
                      coords (repeat times (direction->fns direction))))
            [0 0] counts)))

(def input (->> input-file
                string/split-lines
                (map parse-into-instructions)))

(defn part1 []
  (->> input
       (map instructions-to-coords)
       frequencies
       (filter #(odd? (second %)))
       count))

(defn create-tile-map [black-tiles]
  (reduce (fn [acc coords]
            (assoc acc coords :black))
          {} (map first black-tiles)))

(defn get-neighbor-coords [coords]
  (map (fn [[_direction [fnx fny]]]
         [(fnx (first coords)) (fny (second coords))])
       direction->fns))

(defn get-surrounding-tiles [tile-map coords]
  (->> coords
       get-neighbor-coords
       (map tile-map)))

(defn surround-in-white [tile-map]
  (let [black-tiles (filter (fn [[k v]] (= v :black))
                            tile-map)
        all-neighbors (set (mapcat get-neighbor-coords
                                   (keys black-tiles)))]
    (reduce (fn [acc coords]
              (if (nil? (acc coords))
                (assoc acc coords :white)
                acc))
            tile-map all-neighbors)))

(defn collect-flip-fns [tile-map]
  (map (fn [[coords color]]
         (let [surrounding-tiles (get-surrounding-tiles tile-map coords)
               num-black-tiles (count (filter (partial = :black) surrounding-tiles))]
           (cond
             (and (= color :white)
                  (= 2 num-black-tiles)) #(assoc % coords :black)
             (and (= color :black)
                  (or (zero? num-black-tiles)
                      (< 2 num-black-tiles))) #(assoc % coords :white)
             :else identity)))
       tile-map))

(defn do-round [tile-map]
  (surround-in-white
   (reduce (fn [acc f] (f acc))
           tile-map (collect-flip-fns tile-map))))

(defn part2 []
  (let [tile-map (->> input
                      (map instructions-to-coords)
                      frequencies
                      (filter #(odd? (second %)))
                      create-tile-map
                      surround-in-white)]
    (->> tile-map
         (iterate do-round)
         (map (fn [tm] (count (filter #(= :black (second %)) tm))))
         (drop 100)
         first)))

(comment
  input

  (part1)
  ;; => 497

  (part2)
  ;; => 4156

  0)
