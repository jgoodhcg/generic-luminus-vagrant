(ns ta-done.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [ta-done.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[project started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[project has shutdown successfully]=-"))
   :middleware wrap-dev})
