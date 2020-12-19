(ns aoc2020.day15.core
  (:require [clojure.string :as string]))

(def input-file (slurp "./src/aoc2020/day15/resources/input1.txt"))

(defn split-on-comma [s]
  (string/split s #","))

(def input (->> input-file
                string/split-lines
                first
                split-on-comma
                (map #(Integer/parseInt %))))

(defn setup-game [numbers]
  (reduce
   (fn [acc [i number]]
     (assoc acc number [(inc i)]))
   {} (map-indexed vector numbers)))

(defn one? [xs]
  (= 1 (count xs)))

(defn add-and-drop-if-more-than-two [xs newval]
  (if (= (count xs) 2)
    (conj (vec (drop 1 xs)) newval)
    (conj (vec xs) newval)))

(defn play-game [stopping-turn numbers]
  (loop [numbers      numbers
         current-turn (inc (count numbers))
         last-num     (last (keys numbers))]
    (if (= current-turn stopping-turn) {:turn current-turn :last-num last-num}
        (let [number-to-speak (if (one? (get numbers last-num)) 0
                                  (- (dec current-turn) (last (butlast (get numbers last-num)))))]
          (recur (update numbers number-to-speak add-and-drop-if-more-than-two current-turn)
                 (inc current-turn)
                 number-to-speak)))))

(defn part1 []
  (->> input
       setup-game
       (play-game 2021)
       :last-num))

(defn part2 []
  (->> input
       setup-game
       (play-game 30000001)
       :last-num))

(comment

  input
  ;; => (2 20 0 4 1 17)
  (part1)
  ;; => 758
  (part2)
  ;; => 814

  0)
