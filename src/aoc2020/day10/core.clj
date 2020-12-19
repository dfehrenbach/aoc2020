(ns aoc2020.day10.core
  (:require [clojure.string :as string]))


(def input-file (slurp "./src/aoc2020/day10/resources/input1.txt"))
(def test-file (slurp "./src/aoc2020/day10/resources/test.txt"))
(def small-file (slurp "./src/aoc2020/day10/resources/test-small.txt"))

(def input (->> input-file
                string/split-lines
                (map #(Integer. %))))

(defn add-default-adapters [adapters]
  (let [max-adapter     (apply max adapters)
        with-added-zero (cons 0 adapters)
        with-added-max  (conj (vec with-added-zero) (+ 3 max-adapter))]
    with-added-max))

(defn mult-1-and-3 [freqs]
  (* (get freqs 1) (get freqs 3)))

(defn get-lengths-between-adapters [input]
  (->> input sort
       add-default-adapters
       (partition 2 1)
       (map #(- (second %) (first %)))))

(defn part1 []
  (->> input
       get-lengths-between-adapters
       frequencies
       mult-1-and-3))

(defn group-insignificant-ones [lengths]
  (filter seq
          (map #(string/replace % #"3" "")
               (string/split (string/join lengths) #"13"))))

(defn group-to-permutations [group]
  ;; Seems theres only 3 lengths in the input file. Bummer.
  ;; 111 is 7 because there's 8 permutations but we can't have only 000
  (case group
    "1"   2
    "11"  4
    "111" 7))

(defn part2 []
  (->> input
       get-lengths-between-adapters
       group-insignificant-ones
       (map group-to-permutations)
       (reduce *)))

(comment

  input

  (part1)
  ;; => 1917

  (part2)
  ;; => 113387824750592

  0)
