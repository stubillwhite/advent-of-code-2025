(ns advent-of-code-2025.day-3
  (:require
   [advent-of-code-2025.utils :as utils :refer [sum]]
   [clojure.java.io :as io]
   [clojure.string :as string]))

(def problem-input
  (string/trim (slurp (io/resource "day-3-input.txt"))))

(defn parse-input [input]
  (->> (string/split-lines input)
       (map (fn [s] (map (comp parse-long str) (seq s))))))

(defn- largest-joltage [n xs]
  (if (zero? n)
    nil
    (let [largest (apply max (drop-last (dec n) xs))]
      (lazy-seq (cons largest
                      (largest-joltage (dec n) (drop (inc (.indexOf xs largest)) xs)))))))

(defn solution-part-one [input]
  (->> (parse-input input)
       (map (partial largest-joltage 2))
       (map (comp parse-long (partial apply str)))
       (sum)))

;; Part two

(defn solution-part-two [input]
  (->> (parse-input input)
       (map (partial largest-joltage 12))
       (map (comp parse-long (partial apply str)))
       (sum)))

