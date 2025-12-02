(ns advent-of-code-2025.day-1
  (:require
   [advent-of-code-2025.utils :as utils :refer [def-]]
   [clojure.java.io :as io]
   [clojure.string :as string]))

(def problem-input
  (string/trim (slurp (io/resource "day-1-input.txt"))))

(defn- parse-instruction [s]
  {:direction (get s 0)
   :distance  (parse-long (apply str (drop 1 s)))})

(defn- parse-input [input]
  (->> (string/split-lines input)
       (map parse-instruction)))

(defn- count-zeroes-hit [{:keys [position zeroes]} {:keys [direction distance]}]
  (let [op           (case direction \R + \L -)
        new-position (mod (op position distance) 100)]
    {:position new-position
     :zeroes   (if (zero? new-position) (inc zeroes) zeroes)}))

(defn solution-part-one [input]
  (->> (parse-input input)
       (reduce count-zeroes-hit {:position 50 :zeroes 0})
       (:zeroes)))

;; Part two

(defn- count-zeroes-passed [{:keys [position zeroes]} {:keys [direction distance]}]
  (case direction
    \R {:position (mod (+ position distance) 100)
        :zeroes   (+ zeroes (quot (+ distance position) 100))}

    \L (let [crossed-zero? (and (> position 0) (<= (- position distance) 0))]
         {:position (mod (- position distance) 100)
          :zeroes   (+ zeroes
                       (quot (- distance position) 100)
                       (if crossed-zero? 1 0))})))

(defn solution-part-two [input]
  (->> (parse-input input)
       (reduce count-zeroes-passed {:position 50 :zeroes 0})
       (:zeroes)))

