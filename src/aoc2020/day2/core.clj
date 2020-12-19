(ns aoc2020.day2.core
  (:require [clojure.string :as str]))

(def input-file (slurp "./src/aoc2020/day2/resources/input1.txt"))

(defn read-input-line [line]
  (let [[criteria password] (str/split line #": ")
        [range letter]      (str/split criteria #" ")
        [low high]          (mapv #(Integer/parseInt %) (str/split range #"-"))]
    {:low      low
     :high     high
     :letter   letter
     :password password}))

(def input (->> input-file
                str/split-lines
                (map read-input-line)))

(defn validate-password-part1 [m]
  (<= (:low m)
      (or ((frequencies (:password m)) (first (:letter m))) -1)
      (:high m)))

(defn part1 []
  (let [valid-passwords (filter validate-password-part1 input)]
    (count valid-passwords)))

(defn validate-password-part2 [m]
  (let [a  (nth (:password m) (dec (:low m)))
        b  (nth (:password m) (dec (:high m)))
        ch (first (:letter m))]
    (not= (= a ch) (= b ch))))

(defn part2 []
  (let [valid-passwords (filter validate-password-part2 input)]
    (count valid-passwords)))

(comment

  (part1)

  (part2)

  0)
