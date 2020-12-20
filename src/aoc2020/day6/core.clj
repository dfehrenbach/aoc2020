(ns aoc2020.day6.core
  (:require [clojure.string :as string]
            [clojure.set :refer [intersection]]))


(def input-file (slurp "./src/aoc2020/day6/resources/input1.txt"))

(def input (->> (string/split input-file #"\r\n\r\n")
                (map (comp (partial string/join " ") string/split-lines))))

(set "abc ")

(defn count-unique-answers [group-answers]
  (count (set (string/replace group-answers #" " ""))))

(defn part1 []
  (reduce + (map count-unique-answers input)))


(defn count-consensus-answers [group-answers]
  (let [answers-per-person (string/split group-answers #" ")]
    (count (apply intersection (map set answers-per-person)))))


(defn part2 []
  (reduce + (map count-consensus-answers input)))


(comment

  input

  (part1)

  (part2)

  0)
