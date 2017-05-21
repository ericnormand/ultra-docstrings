(ns ultra-docstrings.core)

(def docstrings
  '{clojure.core
    {map "This is how you map stuff 2."}
    ring.jetty
    {start-server "This is how you start a server."}})

(defn replace-docstrings []
  (doseq [[ns vars] docstrings]
    (when (try
            (require ns)
            :success
            (catch Exception e
              nil))
      (doseq [[var docstring] vars]
        (when-let [v (ns-resolve *ns* var)]
          (alter-meta! v (fn [meta]
                           (cond-> meta
                             (not (contains? meta :friendly/old-doc))
                             (assoc :friendly/old-doc (:doc meta))

                             true
                             (assoc :doc docstring)))))))))

