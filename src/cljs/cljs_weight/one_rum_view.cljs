(ns cljs-weight.one-rum-view
    (:require [rum.core :as rum]))

(rum/defc label [text]
  [:div
   [:h1 "A label"]
   [:p text]])

(defn init []
  (rum/mount (label) (. js/document (getElementById "container"))))
