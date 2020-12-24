(ns aoc2020.day22.core
  (:require [clojure.string :as string]
            [clojure.edn :as edn]))

(def input-file (slurp "./src/aoc2020/day22/resources/input1.txt"))

(def input (->> (string/split input-file #"\n\n")
                (map (comp vec
                           (partial map edn/read-string)
                           (partial drop 1)
                           string/split-lines))))

(defn play-game [[player1 player2]]
  (if (or (empty? player1) (empty? player2)) (first (remove nil? [player1 player2]))
      (let [[top1 & rest1] player1
            [top2 & rest2] player2]
        (if (< top1 top2)
          (recur [rest1 (concat rest2 [top2 top1])])
          (recur [(concat rest1 [top1 top2]) rest2])))))

(defn multiply-cards-by-position [final-cards]
  (let [positions (reverse (range 1 (inc (count final-cards))))]
    (map (fn [card position] (* card position))
         final-cards positions)))

(defn part1 []
  (->> input
       play-game
       multiply-cards-by-position
       (reduce +)))

(conj #{[1 2] [3 4] [[3 4] [5 6]]} [[3 4] [5 7]])

(defn play-recursive-game
  ([[player1 player2]]
   (play-recursive-game [player1 player2] #{}))
  ([[player1 player2] history]
   (cond
     (contains? history [player1 player2]) {:winner :player1 :cards player1}
     (empty? player1) {:winner :player2 :cards player2}
     (empty? player2) {:winner :player1 :cards player1}
     :else
     (let [[top1 & rest1] player1
           [top2 & rest2] player2]
       (if (and (<= top1 (count rest1)) (<= top2 (count rest2)))
         (let [winner (:winner (play-recursive-game [(take top1 rest1) (take top2 rest2)] history))]
           (case winner
             :player1 (recur [(concat rest1 [top1 top2]) rest2] (conj history [player1 player2]))
             :player2 (recur [rest1 (concat rest2 [top2 top1])] (conj history [player1 player2]))))
         (cond (< top2 top1)
               (recur [(concat rest1 [top1 top2]) rest2] (conj history [player1 player2]))
               (< top1 top2)
               (recur [rest1 (concat rest2 [top2 top1])] (conj history [player1 player2]))))))))


(defn part2 []
  (->> input
       play-recursive-game
       :cards
       multiply-cards-by-position
       (reduce +)))

(comment

  input

  (part1)
  ;; => 31781

  (play-recursive-game [[9 2 6 3 1] [5 8 4 7 10]])
  ;; => {:winner :player2, :cards (7 5 6 2 4 1 10 8 9 3)}

  (play-recursive-game [[43 19] [2 29 14]])
  ;; => {:winner :player1, :cards (43 19)}

  (part2)
  ;; => 35154

  0)
