(ns aoc2020.day8.core
  (:require [clojure.string :as string]))

(def input-file (slurp "./src/aoc2020/day8/resources/input1.txt"))

(def input (->> input-file
                string/split-lines))

(defn convert-to-instruction [s]
  (let [[_ instruction sign num] (re-find #"^([a-z]*) (\-|\+)(\d*)$" s)]
    {:instruction instruction
     :num         (* (if (= sign "-") -1 1) (Integer/parseInt num))}))

(defn update-data [instruction num ind acc visited]
  (case instruction
    "acc" [(inc ind) (+ acc num) (conj visited ind)]
    "jmp" [(+ ind num) acc (conj visited ind)]
    "nop" [(inc ind) acc (conj visited ind)]))

(defn perform-instructions [ instructions]
  (loop [instructions instructions
         ind          0
         acc          0
         visited      #{}]
    (if (contains? visited ind) {:acc acc :ind ind :visited visited :exit false }
        (if (= ind (count instructions)) {:acc acc :ind ind :visited visited :exit true}
            (let [instruction                      (get instructions ind)
                  [next-ind next-acc next-visited] (update-data (:instruction instruction) (:num instruction) ind acc visited)]
              (recur instructions next-ind next-acc next-visited))))))

(def part1
  (->> input
       (mapv convert-to-instruction)
       perform-instructions
       :acc))

(defn flip-instruction [ind instructions]
  (update-in instructions [ind :instruction] #(if (= "jmp" %) "nop" "jmp")))

(def part2
  (let [instructions (mapv convert-to-instruction input)
        part1-res    (perform-instructions instructions)
        jmp-or-nop   (filter (fn [ind]
                               (let [inst (get instructions ind)]
                                 (or (= (:instruction inst) "jmp")
                                     (= (:instruction inst) "nop"))))
                             (:visited part1-res))]
    (:acc (first (filter :exit (for [ind jmp-or-nop]
                                 (->> instructions
                                      (flip-instruction ind)
                                      (perform-instructions))))))))

(comment

  input

  part1

  part2

  0 )


