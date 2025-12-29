(ns advent-of-code-2025.day-2
  (:require
   [advent-of-code-2025.utils :as utils :refer [sum]]
   [clojure.java.io :as io]
   [clojure.string :as string]))

(def problem-input
  (string/trim (slurp (io/resource "day-2-input.txt"))))

(defn- parse-range [s]
  (->> (string/split s #"-")
       (map parse-long)))

(defn- parse-input [input]
  (->> (string/split input #",")
       (map parse-range)))

(defn- invalid-ids-in-range [pred [start end]]
  (filter pred (range start (inc end))))

(defn- repeated-chunks [x]
  (let [s           (str x)
        len         (count s)
        chunk-sizes (for [n (range 1 (inc (/ len 2))) :when (zero? (mod len n))] n)]
    (->> chunk-sizes
         (map (fn [n] (partition n s)))
         (filter (fn [xs] (apply = xs))))))

(defn- has-two-repeated-chunks? [x]
  (not-empty (filter (fn [xs] (= (count xs) 2)) (repeated-chunks x))))

(defn solution-part-one [input]
  (->> (parse-input input)
       (mapcat (partial invalid-ids-in-range has-two-repeated-chunks?))
       (sum)))

;; Part two

(defn- has-at-least-two-repeated-chunks? [x]
  (not-empty (filter (fn [xs] (>= (count xs) 2)) (repeated-chunks x))))

(defn solution-part-two [input]
  (->> (parse-input input)
       (mapcat (partial invalid-ids-in-range has-at-least-two-repeated-chunks?))
       (sum)))
