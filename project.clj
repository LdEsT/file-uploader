(defproject file-uploader "0.1.0-SNAPSHOT"
  :description "Server for file uploading"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [io.pedestal/pedestal.service "0.5.10"]
                 [io.pedestal/pedestal.service-tools "0.5.10"]
                 [io.pedestal/pedestal.jetty "0.5.10"]
                 [io.pedestal/pedestal.immutant "0.5.10"]
                 [io.pedestal/pedestal.log "0.5.10"]
                 [io.pedestal/pedestal.interceptor "0.5.10"]
                 [io.pedestal/pedestal.route "0.5.10"]
                 [environ/environ "1.2.0"]
                 [org.clojure/tools.logging "1.2.4"]
                 [com.googlecode.juniversalchardet/juniversalchardet "1.0.3"]]
  :repl-options {:init-ns file-uploader.core})
