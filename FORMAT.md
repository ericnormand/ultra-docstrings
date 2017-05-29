# Formatting docstrings

We follow a standardized format for our docstrings to help us quickly
find the information we need after a few uses. Perhaps an example
would be the best way to explain it.

Notes are below.

Let's say you wanted to learn how to use `map`. At the REPL, you run
`doc`, which is built into Clojure.

```
user=> (doc map)
-------------------------
clojure.core/map
([f] [f coll] [f c1 c2] [f c1 c2 c3] [f c1 c2 c3 & colls])
  

Use clojure.core/map to transform a collection of something into a
sequence of something else.


(map inc [1 2 3])

This expression should increment all of the numbers in the collection.

* The first argument should be a function of one argument.
* The second argument is a collection or iterable.
* map always returns a sequence, regardless the type of the argument.
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


```
