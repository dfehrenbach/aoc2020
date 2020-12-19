(ns aoc2020.day12.core
  (:require [clojure.string :as string]
            [clojure.set :as set]))

(def input-file (slurp "./src/aoc2020/day12/resources/input1.txt"))
(def test-file (slurp "./src/aoc2020/day12/resources/test.txt"))

(def input (->> input-file
                string/split-lines))

(def char->instructions
  {"N" :north
   "S" :south
   "E" :east
   "W" :west
   "L" :left
   "R" :right
   "F" :forward})

(def clockwise-heading {:north :east
                        :east  :south
                        :south :west
                        :west  :north})

(defn parse-input [line]
  (let [[_ str-inst str-num] (re-find #"(\D)(\d*)" line)
        instruction          (char->instructions str-inst)
        num                  (Integer/parseInt str-num)]
    {:instruction instruction :num num}))

(defn ship-forward [ship-state working-inst]
  (case (:heading ship-state)
    :north (update ship-state :y + (:num working-inst))
    :south (update ship-state :y + (* -1 (:num working-inst)))
    :east  (update ship-state :x + (:num working-inst))
    :west  (update ship-state :x + (* -1 (:num working-inst)))))

(defn rotate-ship [heading rotate-map num]
  (let [rotation (int (/ num 90))]
    (first (drop rotation (iterate rotate-map heading)))))

(defn move-ship [instructions]
  (loop [instructions instructions
         ship-state   {:heading :east
                       :x       0
                       :y       0}]
    (if (empty? instructions) ship-state
        (let [working-inst   (first instructions)
              new-ship-state (case (:instruction working-inst)
                               :north   (update ship-state :y + (:num working-inst))
                               :south   (update ship-state :y - (:num working-inst))
                               :east    (update ship-state :x + (:num working-inst))
                               :west    (update ship-state :x - (:num working-inst))
                               :right   (update ship-state :heading rotate-ship clockwise-heading (:num working-inst))
                               :left    (update ship-state :heading rotate-ship (set/map-invert clockwise-heading) (:num working-inst))
                               :forward (ship-forward ship-state working-inst))]
          (recur (rest instructions)
                 new-ship-state)))))

(defn manhatten-distance [{:keys [x y]}]
  (+ (Math/abs x)
     (Math/abs y)))

(defn part1 []
  (->> input
       (map parse-input)
       move-ship
       manhatten-distance))

(defn make-pos [n]
  (Math/abs n))

(defn make-neg [n]
  (* -1 (Math/abs n)))

(defn flip [x y]
  [y x])

(defn quadrant? [x y]
  (cond
    (and (pos? x) (pos? y)) :q1
    (and (neg? x) (pos? y)) :q2
    (and (neg? x) (neg? y)) :q3
    (and (pos? x) (neg? y)) :q4))

(def quadrant-transform {:q1 [make-pos make-pos]
                         :q2 [make-neg make-pos]
                         :q3 [make-neg make-neg]
                         :q4 [make-pos make-neg]})

(def clockwise-quadrant {:q1 :q4
                         :q4 :q3
                         :q3 :q2
                         :q2 :q1})

(defn rotate-waypoint [{waypoint-x :waypoint/x waypoint-y :waypoint/y :as ship-state}
                       {num :num}
                       rotation-map]
  (let [current-quadrant (quadrant? waypoint-x waypoint-y)
        rotation-count   (int (/ num 90))
        next-quadrant    (first (drop rotation-count (iterate rotation-map current-quadrant)))
        [fnx fny]        (quadrant-transform next-quadrant)
        [x y]            (if (odd? rotation-count) (flip waypoint-x waypoint-y) [waypoint-x waypoint-y])]
    (-> ship-state
        (assoc :waypoint/x (fnx x))
        (assoc :waypoint/y (fny y)))))

(defn ship-toward-waypoint [ship-state {num :num}]
  (-> ship-state
      (update :ship/x + (* num (:waypoint/x ship-state)))
      (update :ship/y + (* num (:waypoint/y ship-state)))))

(defn move-waypoint-and-ship [instructions]
  (loop [instructions instructions
         ship-state   {:ship/x     0
                       :ship/y     0
                       :waypoint/x 10
                       :waypoint/y 1}]
    (if (empty? instructions) ship-state
        (let [working-inst   (first instructions)
              new-ship-state (case (:instruction working-inst)
                               :north   (update ship-state :waypoint/y + (:num working-inst))
                               :south   (update ship-state :waypoint/y - (:num working-inst))
                               :east    (update ship-state :waypoint/x + (:num working-inst))
                               :west    (update ship-state :waypoint/x - (:num working-inst))
                               :right   (rotate-waypoint ship-state working-inst clockwise-quadrant)
                               :left    (rotate-waypoint ship-state working-inst (set/map-invert clockwise-quadrant))
                               :forward (ship-toward-waypoint ship-state working-inst))]
          (recur (rest instructions)
                 new-ship-state)))))

(defn part2 []
  (->> input
       (map parse-input)
       move-waypoint-and-ship
       ((fn [m] {:x (:ship/x m)
                 :y (:ship/y m)}))
       manhatten-distance))

(comment

  input

  (part1)

  (part2)

  0)
