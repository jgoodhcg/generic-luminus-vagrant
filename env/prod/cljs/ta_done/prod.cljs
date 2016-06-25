(ns ta-done.app
  (:require [ta-done.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
