(ns collatz-conjecture)

(defn collatz [n]
  "The Collatz Conjecture or 3x+1 problem can be summarized as follows:

  Take any positive integer n. If n is even, divide n by 2 to get n / 2. If n is odd, 
  multiply n by 3 and add 1 to get 3n + 1. Repeat the process indefinitely. 
  The conjecture states that no matter which number you start with, you will always reach 1 eventually.

  Given a number n, return the number of steps required to reach 1"
  (loop [steps 0
         n n]
    (cond
      (= n 1) steps
      (and (pos-int? n) (even? n)) (recur (inc steps) (/ n 2))
      (and (pos-int? n) (odd? n)) (recur (inc steps) (+ 1 (* 3 n)))
      :else (throw Throwable))))
