(ns flatten-array)

(defn flatten [arr] 
  (into (vector) (filter some? (clojure.core/flatten arr)))
  )
