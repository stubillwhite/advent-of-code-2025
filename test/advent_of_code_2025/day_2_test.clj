(ns advent-of-code-2025.day-2-test
  (:require [advent-of-code-2025.day-2 :refer :all]
            [advent-of-code-2025.utils :refer [def-]]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(def example-input
  "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")

(deftest solution-part-one-given-example-input-then-example-result
  (is (= 1227775554 (solution-part-one example-input))))

(deftest solution-part-one-given-problem-input-then-problem-result
  (is (= 9188031749 (solution-part-one problem-input))))

(deftest solution-part-two-given-example-input-then-example-result
  (is (= 4174379265 (solution-part-two example-input))))

(deftest solution-part-two-given-problem-input-then-problem-result
  (is (= 11323661261 (solution-part-two problem-input))))

