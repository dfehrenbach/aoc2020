(ns wedding-list.core)

(def coming-guess
  {5 :yes
   4 :maybe-yes
   3 :maybe
   2 :maybe-not
   1 :no})

(def ranks)

(def dad-side
  [{:name "Mark" :rank 0 :coming 5}
   {:name "Marie" :rank 1 :coming 5}
   {:name "John" :rank 1 :coming 5}
   {:name "Adam" :rank 2 :coming 4}
   {:name "Jessica" :rank 2 :coming 4}
   {:name "Jennifer" :rank 2 :coming 2}
   {:name "Rob" :rank 2 :coming 2}
   {:name "Jackie" :rank 2 :coming 3}
   {:name "Jackie +1" :rank 3 :coming 3}
   {:name "Julie" :rank 2 :coming 3}
   {:name "Todd" :rank 2 :coming 3}
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
   {:name "Hope +1" :rank 2 :coming 2}
   {:name "Casey" :rank 2 :coming 2}
   {:name "Casey +1" :rank 2 :coming 2}
   {:name "Charlotte (Siti)" :rank 1 :coming 4}
   {:name "Aunt Philis" :rank 2 :coming 2}
   {:name "Uncle Steve" :rank 2 :coming 2}
   {:name "Linda" :rank 3 :coming 4}
   {:name "Randy" :rank 3 :coming 4}
   {:name "Christina" :rank 4 :coming 2}
   {:name "Christina SO" :rank 4 :coming 2}
   {:name "Sharron" :rank 3 :coming 4}
   {:name "Eric" :rank 3 :coming 4}
   {:name "Susane" :rank 4 :coming 3}
   {:name "Emily" :rank 4 :coming 3}
   {:name "Paula" :rank 3 :coming 2}
   {:name "Eddie" :rank 3 :coming 2}
   {:name "Barbarra" :rank 3 :coming 2}
   {:name "Gordon" :rank 3 :coming 2}
   {:name "Ricky" :rank 3 :coming 2}
   {:name "Ricky +1" :rank 3 :coming 2}
   {:name "Jay" :rank 3 :coming 2}
   {:name "Jay +1" :rank 3 :coming 2}
   {:name "Karen" :rank 3 :coming 2}
   {:name "Karen +1" :rank 3 :coming 2}
   {:name "Jilian" :rank 3 :coming 2}
   {:name "Jilian +1" :rank 3 :coming 2}
   {:name "Chris" :rank 3 :coming 2}
   {:name "Chris +1" :rank 3 :coming 2}
   {:name "Dawn" :rank 3 :coming 2}])

(def mom-side
  [{:name "Grandpa" :rank 1 :coming 2}
   {:name "Grandma" :rank 1 :coming 2}
   {:name "Gretchen" :rank 1 :coming 2}
   {:name "Sue" :rank 1 :coming 4}
   {:name "Vern" :rank 1 :coming 4}
   {:name "Trey" :rank 2 :coming 4}
   {:name "Trey +1" :rank 4 :coming 2}
   {:name "Clayton" :rank 2 :coming 4}
   {:name "Kaitlin" :rank 2 :coming 4}
   {:name "Renee" :rank 2 :coming 4}
   {:name "Paul" :rank 2 :coming 4}
   {:name "Kim" :rank 1 :coming 4}
   {:name "Larry" :rank 1 :coming 4}
   {:name "Jenn" :rank 2 :coming 4}
   {:name "Musa" :rank 2 :coming 4}
   {:name "Julie" :rank 2 :coming 3}
   {:name "Julie +1" :rank 4 :coming 2}
   {:name "Julia" :rank 2 :coming 3}
   {:name "Julia SO" :rank 3 :coming 2}
   {:name "Jodi" :rank 2 :coming 3}
   {:name "Jodi SO" :rank 3 :coming 2}])

(def others
  [{:name "Sebastian" :rank 1 :coming 5}
   {:name "Sebastian +1" :rank 2 :coming 3}
   {:name "Brian Cardoza" :rank 3 :coming 3}
   {:name "Susan Cardoza" :rank 3 :coming 3}
   {:name "Stella" :rank 4 :coming 3}
   {:name "Anthony Cardoza" :rank 3 :coming 2}
   {:name "Casandra Cardoza" :rank 3 :coming 2}
   {:name "Nick Lapel" :rank 2 :coming 3}
   {:name "Chris Lapel " :rank 3 :coming 3}
   {:name "Michael Lapel" :rank 3 :coming 2}
   {:name "Helen" :rank 2 :coming 4}
   {:name "Christian" :rank 2 :coming 3}
   {:name "Christian +1" :rank 2 :coming 3}
   {:name "John Paul" :rank 3 :coming 3}
   {:name "John Paul SO" :rank 3 :coming 3}
   {:name "Elizabeth" :rank 3 :coming 2}
   {:name "Elizabeth SO" :rank 3 :coming 2}
   {:name "KEN Father (dad's friend)" :rank 1 :coming 4}
   {:name "Michael Sheets" :rank 3 :coming 3}
   {:name "Joy Sheets" :rank 3 :coming 3}
   {:name "Jason" :rank 2 :coming 3}
   {:name "Kiki (get transitioned name)" :rank 3 :coming 3}
   {:name "Chet Chark." :rank 3 :coming 3}
   {:name "Beth Chark." :rank 3 :coming 3}
   {:name "Tera" :rank 4 :coming 2}
   {:name "Tera +1" :rank 5 :coming 2}
   {:name "Kyle" :rank 4 :coming 2}
   {:name "Kyle +1" :rank 5 :coming 2}
   {:name "Dan" :rank 3 :coming 4}
   {:name "Peg" :rank 3 :coming 4}
   {:name "Dick" :rank 3 :coming 2}
   {:name "Carla" :rank 3 :coming 2}
   {:name "Doug" :rank 4 :coming 2}
   {:name "Doug SO" :rank 4 :coming 2}
   {:name "Jeff" :rank 4 :coming 2}
   {:name "Jeff SO" :rank 4 :coming 2}
   {:name "Jeff Ancel" :rank 3 :coming 3}
   {:name "Jeff Ancel SO" :rank 3 :coming 3}
   {:name "Albert Engelbrecht" :rank 3 :coming 3}
   {:name "Albert Engelbrecht SO" :rank 3 :coming 3}])

(defn trim-below-rank-above-coming [{:keys [rank coming]} side]
  (filter (fn [person]
            (and (< (:rank person) rank)
                 (< coming (:coming person))))
          side))

(def all (partial trim-below-rank-above-coming {:rank 10 :coming 0}))
(def trim-likely (partial trim-below-rank-above-coming {:rank 5 :coming 2}))
(def trim-likely-close (partial trim-below-rank-above-coming {:rank 3 :coming 2}))
(def trim-definitely (partial trim-below-rank-above-coming {:rank 5 :coming 3}))
(def trim-definitely-close (partial trim-below-rank-above-coming {:rank 3 :coming 3}))
(def trim-definitely-super-close (partial trim-below-rank-above-coming {:rank 2 :coming 3}))

(defn full-count [trimfn & sides]
  (let [sidecounts (vec (map (comp count trimfn) sides))]
    (conj sidecounts {:sum (reduce + sidecounts)})))

(defn count-with-names [trimfn & sides]
  (let [members-arr (map trimfn sides)]
    members-arr))

(comment

  (full-count all dad-side mom-side others)
  ;; => [50 21 40 {:sum 111}]

  (full-count trim-likely dad-side mom-side others)
  ;; => [22 14 25 {:sum 61}]

  (full-count trim-likely-close dad-side mom-side others)
  ;; => [15 14 8 {:sum 37}]

  (full-count trim-definitely dad-side mom-side others)
  ;; => [10 11 5 {:sum 26}]

  (full-count trim-definitely-close dad-side mom-side others)
  ;; => [6 11 3 {:sum 20}]

  (full-count trim-definitely-super-close dad-side mom-side others)
  ;; => [4 4 2 {:sum 10}]

  (count-with-names trim-likely dad-side mom-side others)

  (count-with-names trim-definitely-close dad-side mom-side others)

  (count-with-names trim-definitely-super-close dad-side mom-side others)

  (count-with-names trim-definitely dad-side mom-side others)
  ;; => (({:name "Mark", :rank 0, :coming 5}
  ;;      {:name "Marie", :rank 1, :coming 5}
  ;;      {:name "John", :rank 1, :coming 5}
  ;;      {:name "Adam", :rank 2, :coming 4}
  ;;      {:name "Jessica", :rank 2, :coming 4}
  ;;      {:name "Charlotte (Siti)", :rank 1, :coming 4}
  ;;      {:name "Linda", :rank 3, :coming 4}
  ;;      {:name "Randy", :rank 3, :coming 4}
  ;;      {:name "Sharron", :rank 3, :coming 4}
  ;;      {:name "Eric", :rank 3, :coming 4})
  ;;     ({:name "Sue", :rank 1, :coming 4}
  ;;      {:name "Vern", :rank 1, :coming 4}
  ;;      {:name "Trey", :rank 2, :coming 4}
  ;;      {:name "Clayton", :rank 2, :coming 4}
  ;;      {:name "Kaitlin", :rank 2, :coming 4}
  ;;      {:name "Renee", :rank 2, :coming 4}
  ;;      {:name "Paul", :rank 2, :coming 4}
  ;;      {:name "Kim", :rank 1, :coming 4}
  ;;      {:name "Larry", :rank 1, :coming 4}
  ;;      {:name "Jenn", :rank 2, :coming 4}
  ;;      {:name "Musa", :rank 2, :coming 4})
  ;;     ({:name "Sebastian", :rank 1, :coming 5}
  ;;      {:name "Helen", :rank 2, :coming 4}
  ;;      {:name "KEN Father (dad's friend)", :rank 1, :coming 4}
  ;;      {:name "Dan", :rank 3, :coming 4}
  ;;      {:name "Peg", :rank 3, :coming 4}))

  0)
