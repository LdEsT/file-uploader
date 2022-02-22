(ns file-uploader.core
  (:require [io.pedestal.http :as http]
            [environ.core :refer [env]]
            [clojure.tools.logging :as log]
            [file-uploader.routes :refer [routes]]))

(def service-map
  {::http/routes routes
   ::http/type   :jetty
   ::http/port   (int (or (env :port) 5100))})              ; trying to config

(defn start-server []
  (http/start (http/create-server service-map)))


(defn -main
  "The entry-point for 'lein run'"
  [& _]
  (log/info "Starting server...")
  (start-server))