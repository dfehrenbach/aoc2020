(ns aoc2020.day21.core
  (:require [clojure.string :as string]
            [clojure.edn :as edn]
            [clojure.set :as set :refer [union intersection]]))

(def input-file (slurp "./src/aoc2020/day21/resources/input1.txt"))

(defn parse-line [line]
  (let [[_ ingredients allergens] (re-find #"(.*)\(contains (.*)\)" line)]
    {:ingredients (string/split ingredients #" ")
     :allergens (string/split allergens #", ")}))

(def input (->> input-file
                string/split-lines
                (map parse-line)))

(defn intersect-for-ingredient [menu ingredient]
  {ingredient (->> menu
                   (filter #(some #{ingredient} (:allergens %)))
                   (map (comp set :ingredients))
                   (apply intersection))})

(defn collect-different-allergens [menu]
  (set (mapcat :allergens menu)))

(defn create-allergen->possible-ingredients [menu allergens]
  (apply merge (map (partial intersect-for-ingredient menu) allergens)))

(defn find-allergen-ridden-ingredients [allergen->possible-ingredients]
  (apply union (vals allergen->possible-ingredients)))

(defn create-allergen->ingredient [allergen->possible-ingredients]
  (loop [allergen->ingredient-list (sort-by (comp count val) allergen->possible-ingredients)
         settled []]
    (if (empty? allergen->ingredient-list) settled
        (let [[head] allergen->ingredient-list
              next-list (map (fn [[allergen ingredients]]
                               [allergen (set (remove (second head) ingredients))])
                             (rest allergen->ingredient-list))]
          (recur (sort-by (comp count second) next-list)
                 (conj settled head))))))

(defn part1 []
  (let [allergen-ridden-ingredients
        (->> input
             collect-different-allergens
             (create-allergen->possible-ingredients input)
             find-allergen-ridden-ingredients)]
    (->> input
         (mapcat :ingredients)
         (remove allergen-ridden-ingredients)
         count)))

(defn part2 []
  (->> input
       collect-different-allergens
       (create-allergen->possible-ingredients input)
       create-allergen->ingredient
       (sort-by first)
       (map (comp first second))
       (string/join ",")))

(comment
  input

  (part1)
  ;; => 1685

  (part2)
  ;; => "ntft,nhx,kfxr,xmhsbd,rrjb,xzhxj,chbtp,cqvc"

  0)
