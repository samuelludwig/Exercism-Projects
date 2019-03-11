(ns etl
  (:require [clojure.string :as str]))

(defn transform [source]
  (loop [source      source
         new-table   {}
         point-vals  (keys source)
         letters     (vals source)
         this-point  (first point-vals)
         this-letter (first letters)]

    (if (< 0 (count point-vals))
      (recur
       source
       (merge new-table
              (apply hash-map
                     (into (vector)
                           (interleave (map str/lower-case this-letter) (repeat this-point)))))
       (rest point-vals)
       (rest letters)
       (first (rest point-vals))
       (first (rest letters)))
      new-table)))
