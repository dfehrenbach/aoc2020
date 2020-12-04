(ns aoc2020.day4.core
  (:require [clojure.string :as string]))

(def input-file (slurp "./src/aoc2020/day4/resources/input1.txt"))

(def input (->> (string/split input-file #"\r\n\r\n")
                (map (comp (partial string/join " ") string/split-lines))))

(defn parse-passport [raw-passport]
  (let [passport-field-arr (string/split raw-passport #" ")]
    (reduce
      (fn [acc field]
        (let [[key val] (string/split field #":")]
          (assoc acc (keyword key) val)))
      {} passport-field-arr)))

(defn remove-cid [passport]
  (dissoc passport :cid))

(def part1
  (->> input
       (map parse-passport)
       (map remove-cid)
       (filter (comp (partial = 7) count))
       count))

(defn valid-byr
  "(Birth Year) - four digits; at least 1920 and at most 2002."
  [{:keys [byr] }]
  (when byr
    (if-let [x (re-matches #"^[\d]{4}$" byr)]
      (<= 1920 (Integer/parseInt x) 2002))))

(defn valid-iyr
  "(Issue Year) - four digits; at least 2010 and at most 2020."
  [{:keys [iyr] }]
  (when iyr
    (if-let [x (re-matches #"^[\d]{4}$" iyr)]
      (<= 2010 (Integer/parseInt x) 2020))))

(defn valid-eyr
  "(Expiration Year) - four digits; at least 2020 and at most 2030."
  [{:keys [eyr] }]
  (when eyr
    (if-let [x (re-matches #"^[\d]{4}$" eyr)]
      (<= 2020 (Integer/parseInt x) 2030))))

(defn valid-hgt
  "(Height) - a number followed by either cm or in:
  - If cm, the number must be at least 150 and at most 193.
  - If in, the number must be at least 59 and at most 76."
  [{:keys [hgt] }]
  (when hgt
    (if-let [[_ num scale] (first (re-seq #"(\d+)(cm|in)" hgt))]
      (case scale
        "cm" (<= 150 (Integer/parseInt num) 193)
        "in" (<= 59 (Integer/parseInt num) 76)))))

(defn valid-hcl
  "(Hair Color) - a # followed by exactly six characters 0-9 or a-f."
  [{:keys [hcl] }]
  (when hcl
    (re-matches #"^#[0-9a-f]{6}$" hcl)))

(boolean (re-matches #"^#[0-9a-f]{6}$" "#abc123"))

(defn valid-ecl
  "(Eye Color) - exactly one of: amb blu brn gry grn hzl oth."
  [{:keys [ecl] }]
  (when ecl
    (re-matches #"amb|blu|brn|gry|grn|hzl|oth" ecl)))

(defn valid-pid
  "(Passport ID) - a nine-digit number, including leading zeroes."
  [{:keys [pid] }]
  (when pid
    (re-matches #"^\d{9}$" pid)))

(def part2
  (->> input
       (map parse-passport)
       (map remove-cid)
       (filter (comp (partial = 7) count))
       (filter (every-pred valid-byr valid-iyr valid-eyr valid-hgt valid-hcl valid-ecl valid-pid))
       count))

(comment
  input

  part1

  part2

  0)
