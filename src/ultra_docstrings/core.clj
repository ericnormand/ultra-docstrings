(ns ultra-docstrings.core)

(def docstrings
  '{clojure.core
    {map "

Use clojure.core/map to transform a collection of something into a
sequence of something else.


(map inc [1 2 3])

This expression should increment all of the numbers in the collection.

* The first argument should be a function of one argument.
* The second argument is a collection or iterable.
* map always returns a sequence, regardless of the type of the argument.
* The sequence it returns is lazy.


(map + [1 2 3] [4 5 6])
(map * [0 1 2 3] [4 5] [2 3 4])

map can take multiple collections after the function argument. It
still returns one sequence.

* The first argument, the function, should take the same number of
  arguments as there are collections.
* The function will be called with one item from each collection in
  their respective orders.
* If the collections are of different sizes, the returned sequence
  will be the size of the smallest one.


(map inc)

map with a single argument returns a transducer that transforms every
item using the function you pass it. Transducers are an advanced
topic, but you can give this code a shot:

(sequence (map inc) [1 2 3 4])

If you want to learn more about transducers, see here:
http://gigasquidsoftware.com/blog/2014/09/06/green-eggs-and-transducers/


See also

* (doc clojure.core/reduce) -- combine items into a single value
* (doc clojure.core/filter) -- keep some items from a collection
* (doc clojure.core/mapv)   -- like map, but returns a vector and is not lazy
"}
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

(defn revert-docstrings []
  (doseq [[ns vars] docstrings]
    (when (try
            (require ns)
            :success
            (catch Exception e
              nil))
      (doseq [[var docstring] vars]
        (when-let [v (ns-resolve *ns* var)]
          (alter-meta! v (fn [meta]
                           (if (contains? meta :friendly/old-doc)
                             (-> meta
                                 (assoc :doc (:friendly/old-doc meta))
                                 (dissoc :friendly/old-doc))
                             meta))))))))
