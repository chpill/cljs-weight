(set-env!
 :source-paths    #{"src/cljs"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs          "1.7.228-2"  :scope "test"]
                 [org.clojure/clojurescript "1.9.293"]

                 [rum "0.10.7" :scope "test"]

                 [org.clojure/core.async "0.2.395" :scope "test"]

                 [bidi "2.0.16" :exclusions [org.clojure/clojurescript]]
                 [kibu/pushy "0.3.6" :scope "test"]

                 [com.taoensso/sente "1.11.0"]
                 [com.cognitect/transit-cljs "0.8.239" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]])

(def cljs-options
  {:optimizations :advanced
   :compiler-options {:parallel-build true
                      :compiler-stats true}})

(deftask build
  [o only ONLY str "only build this cljs build id"]
  (let [cljs-options
        (if only
          (assoc cljs-options :ids #{only})
          cljs-options)]
    (task-options! cljs cljs-options))
  (comp (speak)
        (cljs)
        (target))))
