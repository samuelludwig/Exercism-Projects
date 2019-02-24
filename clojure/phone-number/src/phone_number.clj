(ns phone-number)
(require '[clojure.string :as string])

(defn number [num-string]
  (let [clean-num (string/replace num-string #"\(|\)|\.|\-|\ "  "")]
    (if (or (= 10 (count clean-num)) (and (= 11 (count clean-num)) (= (str (first clean-num)) "1")))
      (apply str (take-last 10 clean-num))
      "0000000000")))

(defn area-code [num-string]
  (apply str (take 3 (number num-string))))

(defn pretty-print [num-string]
  (let [s (partition-all 3 (number num-string))]
    (apply str (concat
                "(" (nth s 0) ") "
                (nth s 1) "-"
                (nth s 2)
                (nth s 3)))))
