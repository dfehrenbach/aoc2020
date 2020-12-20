(ns wedding-list.core)

(def coming-guess
  {5 :yes
   4 :maybe-yes
   3 :maybe
   2 :maybe-not
   1 :no})

(def dad-side
  [{:name "Mark" :rank 0 :coming 5}
   {:name "Marie" :rank 1 :coming 4}
   {:name "John" :rank 1 :coming 4}
   {:name "Adam" :rank 2 :coming 4}
   {:name "Jessica" :rank 2 :coming 4}
   {:name "Jennifer" :rank 2 :coming 2}
   {:name "Jennifer SO" :rank 2 :coming 2}
   {:name "Jackie" :rank 2 :coming 3}
   {:name "Julie" :rank 2 :coming 3}
   {:name "Julie SO" :rank 2 :coming 3}
   {:name "Julie kid 1" :rank 3 :coming 2}
   {:name "Julie kid 2" :rank 3 :coming 2}
   {:name "Dana" :rank 1 :coming 3}
   {:name "Rob" :rank 1 :coming 3}
   {:name "Rachel" :rank 2 :coming 3}
   {:name "Rachel +1" :rank 4 :coming 2}
   {:name "Taylor" :rank 2 :coming 3}
   {:name "Taylor +1" :rank 4 :coming 2}
   {:name "Greg" :rank 1 :coming 3}
   {:name "Natalie" :rank 1 :coming 3}
   {:name "Hope" :rank 2 :coming 2}
   {:name "Casey" :rank 2 :coming 2}
   {:name "Charlotte (Siti)" :rank 1 :coming 4}
   {:name "Ashley Pitman" :rank 4 :coming 2}
   {:name "Mr. Pitman" :rank 4 :coming 2}
   {:name "Uncle Steve" :rank 2 :coming 2}])

(def mom-side
  [{:name "Grandpa" :rank 1 :coming 2}
   {:name "Grandma" :rank 1 :coming 2}
   {:name "Gretchen" :rank 1 :coming 2}
   {:name "Sue" :rank 1 :coming 4}
   {:name "Vern" :rank 1 :coming 4}
   {:name "Trey" :rank 2 :coming 4}
   {:name "Trey +1" :rank 4 :coming 2}
   {:name "Clayton" :rank 2 :coming 3}
   {:name "Kaitlin" :rank 2 :coming 3}
   {:name "Renee" :rank 2 :coming 3}
   {:name "Renee SO" :rank 2 :coming 3}
   {:name "Kim" :rank 1 :coming 4}
   {:name "Larry" :rank 1 :coming 4}
   {:name "Jenn" :rank 2 :coming 3}
   {:name "Musa" :rank 2 :coming 3}
   {:name "Julie" :rank 2 :coming 3}
   {:name "Julie +1" :rank 4 :coming 2}
   {:name "Jackie" :rank 2 :coming 3}
   {:name "Jackie +1" :rank 4 :coming 2}])

(def others
  [{:name "Sebastian" :rank 1 :coming 5}
   {:name "Sebastian +1" :rank 2 :coming 3}
   {:name "Brian Cardoza" :rank 3 :coming 3}
   {:name "Susan Cardoza" :rank 3 :coming 3}
   {:name "Anthony Cardoza" :rank 3 :coming 2}
   {:name "Casandra Cardoza" :rank 3 :coming 2}
   {:name "Nick Lapel" :rank 2 :coming 3}
   {:name "Chris Lapel " :rank 3 :coming 3}
   {:name "Michael Lapel" :rank 3 :coming 2}
   {:name "Helen" :rank 2 :coming 4}
   {:name "Christian" :rank 2 :coming 3}
   {:name "Christian +1" :rank 2 :coming 4}
   {:name "John Paul" :rank 3 :coming 3}
   {:name "John Paul SO" :rank 3 :coming 4}
   {:name "Elizabeth" :rank 3 :coming 3}
   {:name "Elizabeth SO" :rank 3 :coming 4}
   {:name "Father (dad's friend)" :rank 1 :coming 4}])

(defn trim-below-rank-above-coming [{:keys [rank coming]} side]
  (filter (fn [person]
            (and (< (:rank person) rank)
                 (< coming (:coming person))))
          side))

(def all (partial trim-below-rank-above-coming {:rank 10 :coming 0}))
(def trim-likely (partial trim-below-rank-above-coming {:rank 4 :coming 2}))
(def trim-definitely (partial trim-below-rank-above-coming {:rank 4 :coming 3}))

(defn full-count [trimfn & sides]
  (let [sidecounts (vec (map (comp count trimfn) sides))]
    (conj sidecounts {:sum (reduce + sidecounts)})))

(comment

  (full-count all dad-side mom-side others)
  ;; => [26 19 17 {:sum 62}]

  (full-count trim-likely dad-side mom-side others)
  ;; => [15 13 14 {:sum 42}]

  (full-count trim-definitely dad-side mom-side others)
  ;; => [6 5 6 {:sum 17}]

  0)
