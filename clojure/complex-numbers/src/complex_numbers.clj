(ns complex-numbers)
(require '[clojure.math.numeric-tower :as math])

(defn real [[a b]]
  a)

(defn imaginary [[a b]]
  b)

(defn abs [[a b]]
  (math/sqrt (+ (math/expt (double a) 2) 
                (math/expt (double b) 2))))

(defn conjugate [[a b]]
  [a (* -1 b)])

(defn add [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]]
  [(- a c) (- b d)])

(defn mul [[a b] [c d]]
  [(- (* a c) (* b d)) (+ (* b c) (* a d))])

(defn div [[a b] [c d]]
  [(/ (double (+ (* a c) (* b d))) (+ (math/expt c 2) (math/expt d 2)))
   (/ (double (- (* b c) (* a d))) (+ (math/expt c 2) (math/expt d 2)))])
