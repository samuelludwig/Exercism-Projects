(ns grade-school)

(defn grade [school grade]
  (get school grade []))

(defn add [school name grade]
  (assoc school grade (conj (grade-school/grade school grade) name)))

(defn sorted [school]
  (zipmap (sort (keys school)) (map vec (map sort (vals (into (sorted-map) school))))))
