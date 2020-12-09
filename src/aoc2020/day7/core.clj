(ns aoc2020.day7.core
  (:require [clojure.string :as string]))

(def input-file (slurp "./src/aoc2020/day7/resources/input1.txt"))

(def input (->> input-file
                string/split-lines))

(def bags-regex #" bags contain |( bags, | bag, )|( bags.| bag.)")

(defn create-keyword [s]
  (keyword (string/replace s #" " "-")))

(defn build-single-edge-map [root contents]
  (fn [acc item]
    (if (= item "no other")
      (assoc acc root 0)
      (let [[_ num s] (first (re-seq #"(\d*) (\D*)" item))
            key       (create-keyword s)]
        (assoc-in acc [root key] (Integer/parseInt num))))))

(defn create-edges [line]
  (let [[root & contents] (vec (string/split line bags-regex))]
    (reduce (build-single-edge-map (create-keyword root) contents) {} contents)))

(defn travel-up-edges [edge-map]
  (loop [m              edge-map
         key-set        #{:shiny-gold}
         container-bags #{}]
    (if (empty? key-set) container-bags
        (let [parent-bags (set (filter #(when (map? (% m))
                                          (some key-set (keys (% m))))
                                       (keys m)))]
          (recur m parent-bags (clojure.set/union container-bags parent-bags))))))

(def part1
  (let [edge-map (apply merge (map create-edges input))]
    (count (travel-up-edges edge-map))))

(defn calc-child-bag-contents [edge-map next-bags]
  (map (fn [[color num]]
         (if (not (map? (color edge-map))) {}
             (zipmap
               (keys (color edge-map))
               (map (partial * num) (vals (color edge-map))))))
       next-bags))

(defn addup-down-edges [edge-map]
  (loop [next-bags (:shiny-gold (apply merge (map create-edges input)))
         bag-count 0]
    (if (empty? next-bags) bag-count
        (recur (apply merge-with + (calc-child-bag-contents edge-map next-bags))
               (+ bag-count (reduce + (vals next-bags)))))))

(def part2
  (let [edge-map (apply merge (map create-edges input))]
    (addup-down-edges edge-map)))

(comment
  input

  part1

  part2

  0)

