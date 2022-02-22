(ns file-uploader.logic.encoder-detector
  (:require [clojure.java.io :as io])
  (:import (java.io InputStream)
           (org.mozilla.universalchardet UniversalDetector)))

(defn- judge-seq! [buf ^InputStream in-stream
                   ^UniversalDetector detector]
  (let [n (.read in-stream buf)
        proceed? (and (< 0 n)
                      (not (do (.handleData detector buf 0 n)
                               (.isDone detector))))]
    (if proceed?
      (recur buf in-stream detector)
      nil)))

(defn detect [target]
  (let [buf (make-array Byte/TYPE 4096)
        detector (UniversalDetector. nil)]
    (with-open [in-stream (io/input-stream target)]
      (dorun (judge-seq! buf in-stream detector))
      (.dataEnd detector)
      (or (.getDetectedCharset detector)
          (throw (ex-info "encoding not detected" {}))))))