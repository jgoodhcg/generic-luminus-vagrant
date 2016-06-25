(ns ta-done.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [ta-done.layout :refer [error-page]]
            [ta-done.routes.home :refer [home-routes]]
            [ta-done.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [ta-done.env :refer [defaults]]
            [mount.core :as mount]
            [ta-done.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    #'service-routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
