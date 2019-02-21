(ns nucleotide-count)
(require '[clojure.string :as str])

(defn nuc-count [nucleotide strand]
  "Evaluates to the count of given nucleotide in a given strand
nucleotide will be represented by a backslash followed by 
a letter indicating one of the 4 nucleotides: A, T, G, C."
  (let [nucleotide (str nucleotide)
        strand     strand]
    (if
     (or
      (= nucleotide "C")
      (= nucleotide "A")
      (= nucleotide "G")
      (= nucleotide "T"))
      (count (apply str (re-seq (re-pattern nucleotide) strand)))
      (throw (AssertionError. "Invalid Input")))))

(defn nucleotide-counts [strand]
  "Takes a string of nucleotides (A,T,G,C) and outputs the 
frequencies of each letter in a key value pair in a hash-map"
  (let [strand strand]
    (merge {\A (nuc-count \A strand)}
           {\T (nuc-count \T strand)} 
           {\G (nuc-count \G strand)} 
           {\C (nuc-count \C strand)})))
