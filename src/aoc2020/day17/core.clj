(ns aoc2020.day17.core
  (:require [clojure.string :as string]))

(def input-file (slurp "./src/aoc2020/day17/resources/input1.txt"))
(def test-file (slurp "./src/aoc2020/day17/resources/test.txt"))

(def input (->> input-file
                string/split-lines
                (map (comp vec seq)) vec))

(def test-input (->> test-file
                     string/split-lines
                     (map (comp vec seq)) vec))

(defn transform-to-3d [slice]
  (apply merge (map-indexed (fn [irow row]
                              (apply merge (map-indexed (fn [icol value]
                                                          {[icol irow 0] (when (= \# value) value)})
                                                        row))) slice)))

(defn transform-to-4d [slice]
  (apply merge (map-indexed (fn [irow row]
                              (apply merge (map-indexed (fn [icol value]
                                                          {[icol irow 0 0] (when (= \# value) value)})
                                                        row))) slice)))

(def neighbors
  (for [x [dec identity inc]
        y [dec identity inc]
        z [dec identity inc]
        :when (not (every? (partial = identity) [x y z]))]
    [x y z]))

(def neighbors-4d
  (for [x [dec identity inc]
        y [dec identity inc]
        z [dec identity inc]
        w [dec identity inc]
        :when (not (every? (partial = identity) [x y z w]))]
    [x y z w]))

(defn fill-in-explored-area [dimension neighbor-coords]
  (reduce (fn [acc coords]
            (if (nil? (acc coords))
              (assoc acc coords \.)
              acc))
          dimension neighbor-coords))

(defn get-neighbor-coords [neighbors coords]
  (map (fn [fns]
         (vec (map #(%1 %2) fns coords)))
       neighbors))

(defn test-active [dimension neighbors coords]
  (let [neigh-coords (get-neighbor-coords neighbors coords)
        neigh-vals   (frequencies (map dimension neigh-coords))]
    (if (or (= (get neigh-vals \#) 2)
            (= (get neigh-vals \#) 3))
      (fn [d] (assoc d coords \#))
      (fn [d] (assoc d coords \.)))))

(defn test-inactive [dimension neighbors coords]
  (let [neigh-coords (get-neighbor-coords neighbors coords)
        neigh-vals   (frequencies (map dimension neigh-coords))]
    (if (or (= (get neigh-vals \#) 3))
      (fn [d] (assoc d coords \#))
      (fn [d] (assoc d coords \.)))))

(defn test-cube [dimension neighbors [coords v]]
  (case v
    \#  (test-active dimension neighbors coords)
    \.  (test-inactive dimension neighbors coords)
    nil (test-inactive dimension neighbors coords)))

(defn expand [neighbors dimension]
  (let [active-cubes (filter (fn [[_ v]] (= v \#)) dimension)]
    (reduce (fn [acc [coords _]]
              (->> coords
                   (get-neighbor-coords neighbors)
                   (fill-in-explored-area acc)))
            dimension active-cubes)))

(defn perform-cycle [neighbors dimension]
  (let [expanded-dimension (expand neighbors dimension)
        fns (map (partial test-cube expanded-dimension neighbors) expanded-dimension)]
    (reduce (fn [acc f] (f acc)) expanded-dimension fns)))

(defn count-active-cubes [dimension]
  (count (filter (partial = \#) (vals dimension))))

(def part1
  (->> (transform-to-3d input)
       (iterate (partial perform-cycle neighbors))
       (drop 6)
       first
       count-active-cubes))

(def part2
  (->> (transform-to-4d input)
       (iterate (partial perform-cycle neighbors-4d))
       (drop 6)
       first
       count-active-cubes))

(comment
  part1

  part2

  0)
