(ns file-uploader.routes
  (:require [io.pedestal.http.route :as route]
            [io.pedestal.http.ring-middlewares :as middlewares]
            [io.pedestal.interceptor.chain :as chain]
            [io.pedestal.interceptor.error :as error]
            [file-uploader.views.index :refer [index]]
            [file-uploader.views.upload :refer [upload]]))

(def service-error-handler
  (error/error-dispatch [ctx ex]
                        [{:exception-type :java.lang.IllegalArgumentException}]
                        (assoc ctx :response {:status 400 :body "Invalid request"})

                        [{:exception-type :clojure.lang.ExceptionInfo}]
                        (assoc ctx :response {:status 400 :body (prn-str (ex-message ex))})

                        :else (assoc ctx ::chain/error ex)))

(defonce routes
         (route/expand-routes
           [[
             ["/" {:get `index}]
             ["/upload" ^:interceptors [service-error-handler (middlewares/multipart-params)] {:post `upload}]
             ]]))
