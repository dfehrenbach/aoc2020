(ns aoc2020.day9.core
  (:require [clojure.string :as string]))


(def input-file (slurp "./src/aoc2020/day9/resources/input1.txt"))

(def input (->> input-file
                string/split-lines
                (map #(BigInteger. %))))

(defn has-addends? [set25 goal]
  (loop [setxs set25
         goal  goal]
    (if (empty? setxs) false
        (if (contains? (disj setxs (first setxs)) (- goal (first setxs))) true
            (recur (set (rest setxs)) goal)))))

(defn check-numbers [integer-list]
  (loop [xs integer-list]
    (let [set25  (set (take 25 xs))
          next-x (first (drop 25 xs))]
      (if (not (has-addends? set25 next-x)) next-x
          (recur (rest xs))))))

(defn part1 []
  (check-numbers input))

(defn check-reductions [integer-list bad-num]
  (loop [xs integer-list
         i  0]
    (let [possibilities (take-while #(<= % bad-num) (reductions + xs))]
      (if (= (last possibilities) bad-num) [i possibilities]
          (recur (rest xs) (inc i))))))

(defn part2 []
  (let [bad-num            (check-numbers input)
        [i reduction]      (check-reductions (filter #(< % bad-num) input) bad-num)
        subrange           (subvec (vec input) i (+ i (count reduction)))
        [smallest largest] [(apply min subrange) (apply max subrange)]]
    (+ smallest largest)))

(comment

  input

  (part1)
  ;; => 731031916

  (part2)
  ;; => 93396727N
  0)
