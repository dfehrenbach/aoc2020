(ns aoc2020.day19.core
  (:require [clojure.string :as string]
            [instaparse.core :as insta]))

(def input-file (slurp "./src/aoc2020/day19/resources/input1.txt"))
(def input-file2 (slurp "./src/aoc2020/day19/resources/input2.txt"))

(defn solve [input]
  (let [[rules messages] (string/split input #"\n\n")
        parser (insta/parser rules :start :0)]
    (->> messages
         string/split-lines
         (map parser)
         (filter (complement :index))
         count)))

(defn part1 []
  (solve input-file))

(defn part2 []
  (solve input-file2))

(comment
  (part1)
  ;; => 248

  (part2)
  ;; => 381

  0)
