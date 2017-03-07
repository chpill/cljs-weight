(ns cljs-weight.using-clojure-spec
  (:require [clojure.spec :as s]))

(s/def ::some-spec
  (s/and number?
         pos?))

(defn init []
  (let [validated-by-spec?
        (s/valid? ::some-spec -2)]
    (js/alert (str "is -2 a positive number? Well "
                  (if (validated-by-spec?) "yes" "no")))))
