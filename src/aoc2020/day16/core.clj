(ns aoc2020.day16.core
  (:require [clojure.string :as string]))

(def input-file (slurp "./src/aoc2020/day16/resources/input1.txt"))

(defn combine-ranges [range1 range2]
  (clojure.set/union range1 range2))

(defn parse-fields [sfields]
  (reduce (fn [acc line]
            (let [[_ skey slo1 shi1 slo2 shi2] (re-find #"(.*): (\d*)-(\d*) or (\d*)-(\d*)" line)
                  [range1 range2]              [(set (range (Integer/parseInt slo1) (inc (Integer/parseInt shi1))))
                                                (set (range (Integer/parseInt slo2) (inc (Integer/parseInt shi2))))]
                  range                        (combine-ranges range1 range2)
                  k                            (keyword (string/replace skey #" " "-"))]
              (assoc acc k range)))
          {} sfields))

(defn parse-your-ticket [ticket]
  (vec (map #(Integer/parseInt %)
            (string/split (second ticket) #","))))

(defn parse-nearby-tickets [tickets]
  (vec (map (fn [line]
              (vec (map #(Integer/parseInt %)
                        (string/split line #",")))) (drop 1 tickets))))

(def input
  (let [[fields your-ticket nearby-tickets] (map string/split-lines
                                                 (string/split input-file #"\n\n"))] ;;TODO
    {:fields         (parse-fields fields)
     :your-ticket    (parse-your-ticket your-ticket)
     :nearby-tickets (parse-nearby-tickets nearby-tickets)}))

(defn collect-bad-vals [ticket]
  (let [allranges (reduce clojure.set/union (vals (:fields input)))]
    (filter #(not (contains? allranges %)) ticket)))

(defn part1 []
  (->> (:nearby-tickets input)
       (mapcat collect-bad-vals)
       (reduce +)))

(defn clean-tickets [bad-vals-per-ticket]
  (->> bad-vals-per-ticket
       (map vector (:nearby-tickets input))
       (filter (comp empty? second))
       (map first)))

(defn fits-in-field? [range column]
  (every? #(contains? range %) column))

(defn transpose-with-index [arr]
  (map-indexed vector (vec (apply map vector arr))))

(defn discover-candidates [cleaned-tickets]
  (for [[i col]   (transpose-with-index (conj cleaned-tickets (:your-ticket input)))
        [field r] (:fields input)
        :when     (fits-in-field? r col)]
    [i field]))

(defn group-candidates [candidates]
  (reduce (fn [acc [i field]]
            (update acc i conj field))
          {} candidates))

(defn remove-field-from-all [m field]
  (zipmap (keys m)
          (map (fn [xs] (remove (fn [xfield]
                                  (when (< 1 (count xs)) (= xfield field)))
                                xs))
               (vals m))))

(defn narrow-down [candidate-map]
  (loop [candidate-map candidate-map
         it            0]
    (let [settled (set (filter (comp (partial = 1) count) (vals candidate-map)))]
      (if (< 200 it) :break
          (if (= (count settled) (count candidate-map)) candidate-map
              (recur (reduce remove-field-from-all candidate-map settled)
                     (inc it)))))))

(defn narrow-down-list [candidate-lists]
  (let [settled (apply clojure.set/union (filter (comp (partial = 1) count) candidate-lists))]
    (if (= (count settled) (count candidate-lists)) (map first candidate-lists)
        (recur (map (fn [candidates]
                      (if (= 1 (count candidates)) candidates
                          (clojure.set/difference candidates settled)))
                    candidate-lists)))))

(defn map-your-ticket-fields [fields]
  (zipmap fields (:your-ticket input)))

(defn select-departure-info [m]
  (select-keys m [:departure-time :departure-platform :departure-station :departure-location :departure-track :departure-date]))

(defn part2 []
  (->> (:nearby-tickets input)
       (map collect-bad-vals)
       clean-tickets
       discover-candidates
       group-candidates
       sort vals (map set)
       narrow-down-list
       map-your-ticket-fields
       select-departure-info
       vals (reduce *)))

(comment

  input

  (part1)
  ;; => 26053
  (part2)
  ;; => 1515506256421

  0)
