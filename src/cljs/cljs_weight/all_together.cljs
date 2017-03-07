(ns cljs-weight.all-together
  (:require [cljs-weight.empty :as empty]
            [cljs-weight.one-rum-view :as one-rum-view]
            [cljs-weight.using-core-async :as using-core-async]
            [cljs-weight.using-client-routing :as using-client-routing]
            [cljs-weight.using-clojure-spec :as using-clojure-spec]
            [cljs-weight.using-websockets :as using-websockets]))

(defn init []
  (empty/init)
  (one-rum-view/init)
  (using-core-async/init)
  (using-client-routing/init)
  (using-clojure-spec/init)
  (using-websockets/init))
