(ns cljs-weight.using-websockets
  (:require [clojure.core.async :as async :refer [<!]]
            [taoensso.sente :as sente]
            [taoensso.sente.packers.transit :as sente-transit-packer])
  (:require-macros [cljs.core.async.macros :refer [go-loop]]))

(defn start! [events-store]
  (let [{:keys [chsk ch-recv send-fn state]}
        (sente/make-channel-socket!
         "/sente-ws"
         {:type :ws
          :packer (sente-transit-packer/get-transit-packer :json)})]
    (go-loop []
      (let [[_ [event-kw event-data]] (:event (<! ch-recv))]
        (swap! events-store conj event-data)
        (recur)))))

(defn init [] (start! (atom [])))

