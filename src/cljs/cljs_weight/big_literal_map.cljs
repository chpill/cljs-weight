(ns cljs-weight.big-literal-map)

(defn init [])

(def unused-small-literal-map
  {:1 "I am not used anywhere, but I am dead code eliminated. All is well."
   :2 2
   :3 3
   :4 4
   :5 5
   :6 6
   :7 7
   :8 8})

(def unused-big-literal-map
  {:1 "I am not used anywhere. SEARCH ME!!"
   :2 2
   :3 3
   :4 4
   :5 5
   :6 6
   :7 7
   :8 8
   :9 9})
