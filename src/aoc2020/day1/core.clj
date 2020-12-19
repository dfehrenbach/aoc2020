(ns aoc2020.day1.core
  (:require [clojure.string :as str]))

(def input-file (slurp "./src/aoc2020/day1/resources/input1.txt"))

(def input (->> input-file
                str/split-lines
                (mapv #(Integer/parseInt %))))

(defn part1 []
  (first
   (filter #(not (nil? %))
           (for [x (set input)
                 y (set (filter #(<= (- 2020 x) %) input))]
             (if (= 2020 (+ x y))
               {:x x :y y :result (* x y)})))))

(defn part2 []
  (first
   (filter #(not (nil? %))
           (for [x (set input)
                 y (set (filter #(<= % (- 2020 x)) input))
                 z (set (filter #(<= % (- 2020 x y)) input))]
             (if (= 2020 (+ x y z))
               {:x x :y y :z z :result (* x y z)})))))

(comment
  input

  (part1)

  (part2)

  0)
