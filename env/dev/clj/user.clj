(ns user
  (:require [mount.core :as mount]
            [ta-done.figwheel :refer [start-fw stop-fw cljs]]
            ta-done.core))

(defn start []
  (mount/start-without #'ta-done.core/repl-server))

(defn stop []
  (mount/stop-except #'ta-done.core/repl-server))

(defn restart []
  (stop)
  (start))


