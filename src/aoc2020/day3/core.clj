(ns aoc2020.day3.core
  (:require [clojure.string :as str]))

(def input-file (slurp "./src/aoc2020/day3/resources/input1.txt"))

(def input (->> input-file
                str/split-lines))

(comment

  input

  0)
