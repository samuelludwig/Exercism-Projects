(ns binary-search)

(defn search-for [x col]
  ;; call middle
  ;; compare middle to x
  ;; if middle < x, lower_bound = middle, get middle of [lower, upper]
  ;; if middle > x, upper_bound = middle, get middle of [lower, upper]
  ;; if middle = x, return position
  (loop [lower_bound 0
         upper_bound (count col)
         mid         (middle col)]
    (cond
      (= x mid)
      (> x mid)
      (< x mid))))

(defn middle [col]
  (div (count col) 2))

(defn middle [col start end]
  )
