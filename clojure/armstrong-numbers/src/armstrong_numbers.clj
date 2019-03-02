(ns armstrong-numbers)

(require '[clojure.math.numeric-tower :as mat])

(defn armstrong? [num]
  (= num (loop [num-sum 0
                num-pos 0
                num-len (count (str num))
                num-seq (map #(- % 48) (map int (seq (char-array (str num)))))]
           (if (= num-pos num-len) num-sum
               (recur (+ num-sum (mat/expt (first num-seq) num-len))
                      (inc num-pos)
                      num-len
                      (rest num-seq))))))
