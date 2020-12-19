(ns aoc2020.day5.core
  (:require [clojure.string :as string]))

(def input-file (slurp "./src/aoc2020/day5/resources/input1.txt"))

(def input (->> input-file
                string/split-lines))

(defn extract-instructions [seat-code]
  (let [[_ row-instructions col-instructions]
        (first (re-seq #"([F|B]*)([R|L]*)" seat-code))]
    {:row-instructions row-instructions
     :col-instructions col-instructions}))

(defn update-range [low-key high-key]
  (fn [{:keys [low high] :as acc} instruction]
    (let [avg (int (/ (+ low high) 2))]
      (cond
        (= low-key instruction)  (assoc acc :high avg)
        (= high-key instruction) (assoc acc :low (inc avg))))))

(defn update-row [{:keys [row-instructions] :as seat}]
  (let [row (reduce (update-range \F \B) {:low 0 :high 127} row-instructions)]
    (assoc seat :row (:low row))))

(defn update-col [{:keys [col-instructions] :as seat}]
  (let [col (reduce (update-range \L \R) {:low 0 :high 7} col-instructions)]
    (assoc seat :col (:low col))))

(defn calc-seat-id [{:keys [row col] :as seat}]
  (assoc seat :seat-id (+ (* row 8) col)))

(defn do-calculations [input]
  (map (comp
        calc-seat-id
        update-row
        update-col
        extract-instructions)
       input))

(defn scan-for-adjacent-ids [seat-ids]
  (let [id-set            (set seat-ids)
        id-min            (apply min id-set)
        id-max            (apply max id-set)
        possible-seat-ids (filter #(not (contains? id-set %))
                                  (range (inc id-min) (dec id-max)))]
    (first (filter (fn [id]
                     (and (contains? id-set (inc id))
                          (contains? id-set (dec id))))
                   possible-seat-ids))))

(defn part1 []
  (->> input
       do-calculations
       (apply max-key :seat-id)
       :seat-id))

(defn part2 []
  (->> input
       do-calculations
       (map :seat-id)
       scan-for-adjacent-ids))

(comment

  input

  (part1)

  (part2)

  0)
