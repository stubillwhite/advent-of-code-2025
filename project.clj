(defproject advent-of-code-2025 "0.1.0-SNAPSHOT"

  :description "TODO"

  :url "TODO"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :repl-options {:port 4555}

  :plugins [[lein-eftest "0.5.9"]]
  
  :eftest {:multithread? :vars
           :thread-count 4
           :test-warn-time 250}
  
  :dependencies [;; Core
                 [org.clojure/tools.nrepl "0.2.13"]
                 [org.clojure/clojure "1.12.0"]
                 [org.clojure/tools.trace "0.8.0"]

                 ;; Spec helpers
                 [expound "0.9.0"]

                 ;; Logging
                 [com.taoensso/timbre "6.6.1"]
  
                 ;; Spec helpers
                 [expound "0.9.0"]

                 ;; DI
                 [mount "0.1.20"]

                 ;; Profiling
                 [com.taoensso/tufte "2.6.3"]]
  
  :profiles {:dev     {:dependencies [[org.clojure/tools.namespace "1.5.0"]]
                       :source-paths ["dev"]}})
