(ns aoc2020.day14.core
  (:require [clojure.string :as string]
            [clojure.math.numeric-tower :as math]
            [clojure.edn :as edn]
            [clojure.math.combinatorics :as combo]))

(def input-file (slurp "./src/aoc2020/day14/resources/input1.txt"))

(def input (->> input-file
                string/split-lines))

(defn create-and-mask [mask-str]
  (edn/read-string (str "2r" (string/replace mask-str #"X" "1"))))
(defn create-or-mask [mask-str]
  (edn/read-string (str "2r" (string/replace mask-str #"X" "0"))))

(defn transform-line [line]
  (cond
    (string/starts-with? line "mask") (let  [[_ mask] (string/split line #" = ")]
                                        {:type          :mask
                                         :original-mask mask
                                         :and           (create-and-mask mask)
                                         :or            (create-or-mask mask)})
    (string/starts-with? line "mem")  (let [[_ sloc sval] (re-find #"\[(\d*)\] = (\d*)" line)
                                            [loc val]     (map #(Integer/parseInt %) [sloc sval])]
                                        {:type :set-memory
                                         :loc  loc
                                         :val  val})))

(defn set-memory [instruction mask memory]
  (let [new-val (->> (:val instruction)
                     (bit-and (:and mask))
                     (bit-or (:or mask)))]
    (assoc memory (:loc instruction) new-val)))

(defn perform-instructions [initial-instructions]
  (loop [instructions (rest initial-instructions)
         current-mask (first initial-instructions)
         memory       {}]
    (if (empty? instructions) memory
        (recur (rest instructions)
               (if (= :mask (:type (first instructions)))
                 (first instructions)
                 current-mask)
               (if (= :set-memory (:type (first instructions)))
                 (set-memory (first instructions) current-mask memory)
                 memory)))))

(defn part1 []
  (->> input
       (map transform-line)
       perform-instructions
       vals
       (reduce +)))

(defn find-xs [mask]
  (->> mask
       reverse
       (map-indexed (fn [i c] [i c]))
       (filter (fn [[_ c]] (= c \X)))
       (map first)))

(defn set-floating-memory [instruction mask memory]
  (let [or-loc      (bit-or (:or mask) (:loc instruction))
        pos-of-xs   (find-xs (:original-mask mask))
        fnsets      (combo/selections [bit-clear bit-set] (count pos-of-xs))
        memory-locs (map (fn [fns]
                           (reduce
                            (fn [acc [i f]] (f acc i))
                            or-loc
                            (map vector pos-of-xs fns)))
                         fnsets)]
    (reduce (fn [acc loc] (assoc acc loc (:val instruction)))
            memory
            memory-locs)))

(defn perform-floating-instructions [initial-instructions]
  (loop [instructions (rest initial-instructions)
         current-mask (first initial-instructions)
         memory       {}]
    (if (empty? instructions) memory
        (recur (rest instructions)
               (if (= :mask (:type (first instructions)))
                 (first instructions)
                 current-mask)
               (if (= :set-memory (:type (first instructions)))
                 (set-floating-memory (first instructions) current-mask memory)
                 memory)))))

(defn part2 []
  (->> input
       (map transform-line)
       perform-floating-instructions
       vals
       (reduce +)))

(comment

  input

  (part1)
  ;; => 15403588588538

  (part2)
  ;; => 3260587250457

  0)
