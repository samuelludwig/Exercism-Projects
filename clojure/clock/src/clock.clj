(ns clock)

(defn clock->string [clock]
  ;; turn vector passed by clock into a string
  (let [hours   (first clock)
        minutes (second clock)]
    (def ret-str "")
    (if (< hours 10) (def ret-str (concat ret-str "0")))
    (def ret-str (concat ret-str (str hours) ":"))
    (if (< minutes 10) (def ret-str (concat ret-str "0")))
    (def ret-str (concat ret-str (str minutes)))
    (apply str ret-str)))

(defn clock [hours minutes]
  (let [tru-min (mod minutes 60)
        hour-ov (quot minutes 60)
        tru-hrs (if (< minutes 0) (mod (- (+ hours hour-ov) 1) 24) (mod (+ hours hour-ov) 24))]
    (vector tru-hrs tru-min)))

(defn add-time [clock time]
  (let [tru-min (mod (+ (second clock) time) 60)
        hour-ov (quot (+ (second clock) time) 60)
        tru-hrs (if (and (< time 0) (> (* time -1) (second clock))) (mod (- (+ (first clock) hour-ov) 1) 24) (mod (+ (first clock) hour-ov) 24))]
    (vector tru-hrs tru-min)))

