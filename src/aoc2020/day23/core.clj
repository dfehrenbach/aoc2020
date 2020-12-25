(ns aoc2020.day23.core
  (:require [clojure.string :as string]
            [clojure.edn :as edn]))

(def input-file (slurp "./src/aoc2020/day23/resources/input1.txt"))

(def input (->> (re-seq #"\d" input-file)
                (map edn/read-string)))

;; :input [1 4 5 3] 3
;; :output 1
;; :input [2 3 5] 2
;; :output 5
(defn get-destination-cup [arr current-cup]
  (let [smaller-cups (filter #(< % current-cup) arr)]
    (if (empty? smaller-cups)
      (apply max arr)
      (apply max smaller-cups))))

;; :input [1 4 5 3] 3 
;; :output 3 
(defn get-cup-index [arr cup]
  (->> arr
       (map-indexed vector)
       (filter #(= cup (second %)))
       ffirst))

;; :input [4 5 6 1 2 7 8 3] 1
;; :output [6 1 2]
;; :input [3 4 5 6] 3
;; :output [3 4 5]
(defn grab-three [arr current-cup-index]
  (vec (take 3 (drop (inc current-cup-index) (flatten (repeat 2 arr))))))

;; :input [4 5 6 1 2 7 8 3] 2 
;; :output [6 1 2 7 8 3 4 5]
(defn rotate-arr [arr next-current-index]
  (vec (take (count arr) (drop next-current-index (flatten (repeat 2 arr))))))

(defn do-round [arr]
  (let [extracted-three (grab-three arr 0)
        trimmed-arr (vec (concat [(first arr)]
                                 (subvec arr 4)))
        current-cup (first arr)
        destination-index (->> current-cup
                               (get-destination-cup trimmed-arr)
                               (get-cup-index trimmed-arr))
        next-arr (vec (concat (subvec trimmed-arr 0 (inc destination-index))
                              extracted-three
                              (subvec trimmed-arr (inc destination-index))))
        next-cup-index (mod (inc (get-cup-index next-arr current-cup))
                            (count next-arr))
        rotated-arr (rotate-arr next-arr next-cup-index)]
    rotated-arr))


(defn solve-part1 [input]
  (let [answer  (->> (iterate do-round (do-round (vec input)))
                     (drop 99)
                     first)
        rotated-to-one (rotate-arr answer (get-cup-index answer 1))]
    (string/join (drop 1 rotated-to-one))))


(defn part1 []
  (solve-part1 input))

(comment

  input

  (subvec [3 2 5 4 6 7] 2)

  (part1 input)
  ;; => "52937846"

  (def part2-input (concat input
                           (range (apply max input) (inc 1000000))))

  (part1 part2-input)


  0)
