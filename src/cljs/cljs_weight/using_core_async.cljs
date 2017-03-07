(ns cljs-weight.using-core-async
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [clojure.core.async :as async]))

(def the-only-channel (async/chan))

(defn init []
  (go (js/alert (async/<! the-only-channel)))
  (async/put! the-only-channel
              "This message went through a channel before arriving on your screen!"))

