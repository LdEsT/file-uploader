(ns file-uploader.views.upload
  (:require [file-uploader.logic.encoder-detector :as detector]))


(defn upload
  [request]
  (let [[in _] ((juxt :tempfile :filename)
                (-> request :multipart-params (get "file")))
        enc (detector/detect in)]
    {:status 200
     :body   (prn-str enc)})
  )