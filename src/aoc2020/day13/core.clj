(ns aoc2020.day13.core
  (:require [clojure.string :as string]
            [clojure.math.numeric-tower :as math]))

(def input-file (slurp "./src/aoc2020/day13/resources/input1.txt"))

(def input (->> input-file
                string/split-lines))

(defn find-bus-time [earliest-time bus]
  (let [time (->> bus
                  (iterate #(+ % bus))
                  (drop-while #(< % earliest-time))
                  first)]
    {:bus bus :time time}))

(defn extract-running-buses [bus-info]
  (->> (string/split bus-info #",")
       (filter #(not= % "x"))
       (map #(Integer/parseInt %))))

(defn convert-to-answer [earliest-time bus]
  (* (:bus bus) (- (:time bus) earliest-time)))

(defn part1 []
  (let [[earliest-time bus-info] input
        time                     (Integer/parseInt earliest-time)]
    (->> bus-info
         extract-running-buses
         (map (partial find-bus-time time))
         (apply min-key :time)
         (convert-to-answer time))))

(defn extract-running-buses-with-intervals [bus-info]
  (->> (string/split bus-info #",")
       (map-indexed (fn [i item]
                      (when (not= item "x")
                        {:bus (BigInteger. item) :interval i})))
       (filter seq)))

(defn extended-gcd [a b]
  (loop [[old-r r] [a b]
         [old-s s] [1 0]
         [old-t t] [0 1]]
    (if (zero? r) {:coefficients [old-s old-t] :gcd old-r :quotients-by-gcd [t s]}
        (let [quotient (bigint (/ old-r r))]
          (recur
           [r, (- old-r (* quotient r))]
           [s, (- old-s (* quotient s))]
           [t, (- old-t (* quotient t))])))))

(defn crazy-lcm [a b]
  (println a)
  (let [[s t]   (:coefficients (extended-gcd (:bus a) (:bus b)))
        z       (- (:interval a) (:interval b)) ;; BUG WAS HERE FOR 6 HOURS. Is A-B not B-A
        m       (* z s)
        n       (* (* -1 z) t)
        periodC (math/lcm (:bus a) (:bus b))
        x       (mod (- (* m (:bus a)) (:interval a)) periodC)
        phase   (mod (+ (* (* -1 m) (:bus a)) (:interval a)) periodC)]
    {:bus (math/lcm (:bus a) (:bus b)) :interval phase :collide x}))

(defn part2 []
  (let [[_ bus-info] input]
    (->> bus-info
         extract-running-buses-with-intervals
         (reduce crazy-lcm)
         :collide)))

(comment

  input

  (part1)
  ;; => 3606
  (part2)
  ;; => 379786358533423N

  0)
