(ns advent-of-code-2025.day-1-test
  (:require [advent-of-code-2025.day-1 :refer :all]
            [advent-of-code-2025.utils :refer [def-]]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(def example-input
  (string/join "\n" ["L68"
                     "L30"
                     "R48"
                     "L5"
                     "R60"
                     "L55"
                     "L1"
                     "L99"
                     "R14"
                     "L82"]))

(deftest solution-part-one-given-example-input-then-example-result
  (is (= 3 (solution-part-one example-input))))

(deftest solution-part-one-given-problem-input-then-problem-result
  (is (= 1097 (solution-part-one problem-input))))

(deftest solution-part-two-given-example-input-then-example-result
  (is (= 6 (solution-part-two example-input))))

(deftest solution-part-two-given-problem-input-then-problem-result
  (is (= 7101 (solution-part-two problem-input))))

