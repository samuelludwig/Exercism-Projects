(ns clock)

(defn clock->string [clock]
  ;; turn vector passed by clock into a string
  (let [hours    (str (nth clock 0))
        minutes  (str (nth clock 1))]
    (concat hours ":" minutes)))

(defn clock [hours minutes]
  (let [tru-min (mod minutes 60)
        hour-ov (quot minutes 60)
        tru-hrs (mod (+ hours hour-ov) 24)]
    (vector tru-hrs tru-min)))

(defn add-time [clock time]
  )
