(ns ta-done.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[project started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[project has shutdown successfully]=-"))
   :middleware identity})
