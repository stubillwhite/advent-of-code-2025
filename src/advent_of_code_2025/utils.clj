(ns advent-of-code-2025.utils
  (:require [clojure.string :as string]))

(defmacro def-
  ([name & decls]
    (list* `def (vary-meta name assoc :private true) decls)))

(defmacro defmulti-
  [name & decls]
  (list* `defmulti (vary-meta name assoc :private true) decls))

(defmacro defmethod-
  [name & decls]
  (list* `defmethod (vary-meta name assoc :private true) decls))
