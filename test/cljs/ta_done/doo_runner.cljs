(ns ta-done.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [ta-done.core-test]))

(doo-tests 'ta-done.core-test)

