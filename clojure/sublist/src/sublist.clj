(ns sublist)

(defn classify [list1 list2]
  (let [count1 (count list1)
        count2 (count list2)]
    (cond
      (= list1 list2) :equal
      (and (< count1 count2)
           (loop [start-pos 0
                  end-pos   count1
                  sub-2     (subvec list2 start-pos end-pos)]
             (cond
               (= list1 sub-2) true
               (and (= end-pos count2) (not= list1 sub-2)) false
               :else (recur
                      (inc start-pos)
                      (inc end-pos)
                      (subvec list2 (inc start-pos) (inc end-pos)))))) :sublist
      (and (> count1 count2)
           (loop [start-pos 0
                  end-pos   count2
                  sub-1     (subvec list1 start-pos end-pos)]
             (cond
               (= list2 sub-1) true
               (and (= end-pos count1) (not= list2 sub-1)) false
               :else (recur
                      (inc start-pos)
                      (inc end-pos)
                      (subvec list1 (inc start-pos) (inc end-pos)))))) :superlist
      :else :unequal)))
