(ns aoc2020.day18.core
  (:require [clojure.string :as string]
            [clojure.edn :as edn]))

(def input-file (slurp "./src/aoc2020/day18/resources/input1.txt"))

(def input (->> input-file
                string/split-lines
                (remove empty?)))

(defn solve-equal [s]
  (let [groups (re-seq #"(\d*) ([\+\*]) (\d*)" s)]
    (reduce (fn [acc [_ _num1 op num2]]
              (case op
                "+" (+ acc (edn/read-string num2))
                "*" (* acc (edn/read-string num2))))
            (edn/read-string (second (first groups)))
            groups)))

(defn solve-plus-first [s]
  (letfn [(solve-pluses [subgroup]
            (if (< (count (string/split subgroup #" \+ ")) 2) subgroup
                (str (solve-equal subgroup))))]
    (let [plus-groups (string/split s #" \* ")]
      (if (= 1 (count plus-groups))
        (->> (first plus-groups)
             solve-pluses
             edn/read-string)
        (->> plus-groups
             (map solve-pluses)
             (string/join " * ")
             solve-equal)))))

(defn solve-line [solve s]
  (loop [s s]
    (let [last-open (string/last-index-of s "(")]
      (if (nil? last-open)
        (solve s)
        (let [first-close (+ last-open (string/index-of (subs s last-open) ")"))
              no-parens (subs s (inc last-open) first-close)
              solution (solve no-parens)]
          (recur (str (subs s 0 last-open)
                      (str solution)
                      (subs s (inc first-close)))))))))

(defn part1 []
  (->> input
       (map (partial solve-line solve-equal))
       (reduce +)))

(defn part2 []
  (->> input
       (map (partial solve-line solve-plus-first))
       (reduce +)))

(comment

  input

  (part1)
  ;; => 7147789965219

  (part2)
  ;; => 136824720421264

  0)
