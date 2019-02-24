(ns hamming)

(defn distance [strand1 strand2]
  (if
   (not (= (count strand1) (count strand2))) nil
   (loop [s1 strand1
          s2 strand2
          distance 0]
     (cond
       (= (count s1) 0) distance
       (= (first s1) (first s2)) (recur (rest s1) (rest s2) (+ distance 0))
       :else (recur (rest s1) (rest s2) (+ distance 1))))))

(distance "ACCAGGG" "ACTATGG")
