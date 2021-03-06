(ns aoc2020.core
  (:require [aoc2020.day1.core :as day1]
            [aoc2020.day2.core :as day2]
            [aoc2020.day3.core :as day3]
            [aoc2020.day4.core :as day4]
            [aoc2020.day5.core :as day5]
            [aoc2020.day6.core :as day6]
            [aoc2020.day7.core :as day7]
            [aoc2020.day8.core :as day8]
            [aoc2020.day9.core :as day9]
            [aoc2020.day10.core :as day10]
            [aoc2020.day11.core :as day11]
            [aoc2020.day12.core :as day12]
            [aoc2020.day13.core :as day13]
            [aoc2020.day14.core :as day14]
            [aoc2020.day15.core :as day15]
            [aoc2020.day16.core :as day16]
            [aoc2020.day17.core :as day17]
            [aoc2020.day18.core :as day18]
            [aoc2020.day19.core :as day19]
            [aoc2020.day20.core :as day20]
            [aoc2020.day21.core :as day21]
            [aoc2020.day22.core :as day22]
            [aoc2020.day23.core :as day23]
            [aoc2020.day24.core :as day24]))

(comment
  (day1/part1)
  ;; => {:x 21, :y 1999, :result 41979}
  (day1/part2)
  ;; => {:x 277, :y 624, :z 1119, :result 193416912}

  (day2/part1)
  ;; => 569
  (day2/part2)
  ;; => 346

  (day3/part1)
  ;; => 223
  (day3/part2)
  ;; => 3517401300

  (day4/part1)
  ;; => 233
  (day4/part2)
  ;; => 111

  (day5/part1)
  ;; => 858
  (day5/part2)
  ;; => 557

  (day6/part1)
  ;; => 6930
  (day6/part2)
  ;; => 3585

  (day7/part1)
  ;; => 205
  (day7/part2)
  ;; => 80902

  (day8/part1)
  ;; => 2058
  (day8/part2)
  ;; => 1000

  (day9/part1)
  ;; => 731031916
  (day9/part2)
  ;; => 93396727N

  (day10/part1)
  ;; => 1917
  (day10/part2)
  ;; => 113387824750592

  (day11/part1)
  ;; => 2178
  (day11/part2)
  ;; => 1978

  (day12/part1)
  ;; => 1589
  (day12/part2)
  ;; => 23960

  (day13/part1)
  ;; => 3606
  (day13/part2)
  ;; => 379786358533423N

  (day14/part1)
  ;; => 15403588588538
  (day14/part2)
  ;; => 3260587250457

  (day15/part1)
  ;; => 758
  (day15/part2)
  ;; => 814

  (day16/part1)
  ;; => 26053
  (day16/part2)
  ;; => 1515506256421

  (day17/part1)
  ;; => 295
  (day17/part2)
  ;; => 1972

  (day18/part1)
  ;; => 7147789965219
  (day18/part2)
  ;; => 136824720421264

  (day19/part1)
  ;; => 248
  (day19/part2)
  ;; => 381

  (day20/part1)
  ;; => 5775714912743

  (day21/part1)
  ;; => 1685
  (day21/part2)
  ;; => "ntft,nhx,kfxr,xmhsbd,rrjb,xzhxj,chbtp,cqvc"

  (day22/part1)
  ;; => 31781
  (day22/part2)
  ;; => 35154

  (day23/part1)
  ;; => "52937846"

  (day24/part1)
  ;; => 497
  (day24/part2)
  ;; => 4156

  0)
