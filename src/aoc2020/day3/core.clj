(ns aoc2020.day3.core
  (:require [clojure.string :as str]))

(def input-file (slurp "./src/aoc2020/day3/resources/input1.txt"))

(def input (->> input-file
                str/split-lines))

(defn tree? [ch]
  (= \# ch))

(defn part1 []
  (let [pattern-len (count (first input))
        inf-indexes (iterate #(rem (+ 3 %) pattern-len) 0)
        slope-data  (map (fn [slope1 terrain-line]
                           {:tree (tree? (nth terrain-line slope1))})
                         inf-indexes input)]
    (count (filter :tree slope-data))))

(defn part2 []
  (let [pattern-len      (count (first input))
        slope1-indexes   (iterate #(rem (+ 1 %) pattern-len) 0)
        slope3-indexes   (iterate #(rem (+ 3 %) pattern-len) 0)
        slope5-indexes   (iterate #(rem (+ 5 %) pattern-len) 0)
        slope7-indexes   (iterate #(rem (+ 7 %) pattern-len) 0)
        slope1-2-indexes (iterate #(rem (+ 0.5 %) pattern-len) 0)
        slope-data       (map (fn [slope1 slope3 slope5 slope7 slope1-2 terrain-line]
                                {:tree1   (tree? (nth terrain-line slope1))
                                 :tree3   (tree? (nth terrain-line slope3))
                                 :tree5   (tree? (nth terrain-line slope5))
                                 :tree7   (tree? (nth terrain-line slope7))
                                 :tree1-2 (when (zero? (rem slope1-2 1))
                                            (tree? (nth terrain-line slope1-2)))})
                              slope1-indexes
                              slope3-indexes
                              slope5-indexes
                              slope7-indexes
                              slope1-2-indexes
                              input)]
    (* (count (filter :tree1 slope-data))
       (count (filter :tree3 slope-data))
       (count (filter :tree5 slope-data))
       (count (filter :tree7 slope-data))
       (count (filter :tree1-2 slope-data)))))



(comment

  input

  (part1)
  ;; => 223

  (part2)
  ;; => 3517401300

  0)
