(ns advent-of-code-2025.day-3-test
  (:require [advent-of-code-2025.day-3 :refer :all]
            [advent-of-code-2025.utils :refer [def-]]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(def example-input
  (string/join "\n" ["987654321111111"
                     "811111111111119"
                     "234234234234278"
                     "818181911112111"]))

(deftest solution-part-one-given-example-input-then-example-result
  (is (= 357 (solution-part-one example-input))))

(deftest solution-part-one-given-problem-input-then-problem-result
  (is (= 17263 (solution-part-one problem-input))))

(deftest solution-part-two-given-example-input-then-example-result
  (is (= 3121910778619 (solution-part-two example-input))))

(deftest solution-part-two-given-problem-input-then-problem-result
  (is (= 170731717900423 (solution-part-two problem-input))))

