(ns series)
(require '[clojure.string :as str])

(defn isolate-slices [string length]
  "produces [(\"1\" \"2\" \"3\") (\"2\" \"3\" \"4\")]"
  (loop [str-vec   (str/split string #"")
         slice-vec []
         length    length]
    (cond
      (= str-vec [""]) []
      (= length 0) [""]
      (>= (count (take length str-vec)) length)
      (recur
       (rest str-vec)
       (conj slice-vec (take length str-vec))
       length)
      :else slice-vec)))

(defn slices [string length]
  "Given a string of digits, output all the contiguous 
substrings of length n in that string in the order that 
they appear. The result is retuned in a vector."

  (loop [iso-vec     (isolate-slices string length)
         rem-coll    (count iso-vec)
         form-slices []]
    (cond
      (= iso-vec []) form-slices
      (= rem-coll 0) form-slices
      :else (recur
             (rest iso-vec)
             (dec rem-coll)
             (conj form-slices (apply str (first iso-vec)))))))

(defn better-slices [string length]
  (if (zero? length) [""]
      (map (partial clojure.string/join "")
           (partition length 1 string))))
