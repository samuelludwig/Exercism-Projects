(ns beer-song)

(defn bot-str [n]
  (str
   (format "%d bottles of beer" n)))

(defn verse
  "Returns the nth verse of the song."
  [num]
  ; (print-str (format "%s on the wall, %s.\nTake one down and pass it around, %s on the wall.\n" (bot-str num) (bot-str num) (bot-str (dec num))
  ;                    ))
  (str
   (cond
     (= 0 num) "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
     (= 1 num) "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
     (= 2 num) "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
     :else (format "%s on the wall, %s.\nTake one down and pass it around, %s on the wall.\n" 
                   (bot-str num)
                   (bot-str num)
                   (bot-str (dec num))
                   )))
  )
  
(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] 
   (apply str (for [x (range start -1 -1)]
                (verse x))))
  
  ([start end] 
   (apply str (for [x (range start (- end 1) -1)]
                (verse x))))
  )
