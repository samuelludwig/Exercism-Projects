(ns robot-name)

(def name-registry [])

(defn build-name []
  (apply str
         (-> ""
             (concat (str (char (+ (rand-int 26) 65))))
             (concat (str (char (+ (rand-int 26) 65))))
             (concat (str (char (+ (rand-int 10) 48))))
             (concat (str (char (+ (rand-int 10) 48))))
             (concat (str (char (+ (rand-int 10) 48)))))))

(defn robot []
  (loop [this-name (build-name)]
    (if (some #{this-name} name-registry)
      (recur (build-name))
      (do
        (def name-registry (conj name-registry this-name))
        (def bot (atom this-name))))))

(defn robot-name [robot]
  @bot)

(defn reset-name [robot]
  (loop [this-name (build-name)]
    (if (some #{this-name} name-registry)
      (recur
       (build-name))
      (do
        (def name-registry (conj name-registry this-name))
        (reset! bot this-name)))))
