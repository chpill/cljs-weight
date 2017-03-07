(ns cljs-weight.using-client-routing
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]))

(def app-state (atom {}))

(def routes ["/" {"" :index
                  "other-route" :other-route}])

(defn init []
  (pushy/start! (pushy/pushy (fn [page]
                               (swap! app-state assoc
                                      :current-page page))
                             (partial bidi/match-route routes))))
