# Ultra Docstrings

Use Ultra Docstrings to make your Clojure docstrings extra friendly
and informative.

## Background

Clojure's built-in docstrings are made for quick reference to remind
you of how something works without breaking you out of flow. Although
they are good at that purpose, they're not very good for learning how
things work the first time. That's what Ultra Docstrings is all about.

## Usage

**Step 1**

Add a development dependency to your project.

Leiningen :dev :dependencies are added to `project.clj`:

```clojure
[com.lispcast/ultra-docstrings "0.1.0-SNAPSHOT"]
```

Boot dependencies

TODO

**Step 2**

Start your application or REPL as you normally would.

```
lein repl
```

OR

```
boot repl
```

**Step 3**

Require the code and run it.

```clojure
(require 'ultra-docstrings.core)
(ultra-docstrings.core/replace-docstrings)
```

## Objectives

* To provide excellent in-REPL beginner-friendly documentation for all
  of Clojure's core library.
* To facilitate contributing to said documentation by people of all
  experience levels.
  
## Format of docstrings

We follow a standardized format for our docstrings to help us quickly
find the information we need after a few uses. Perhaps an example
would be the best way to explain it. Please see the FORMAT.md document
in this directory.

## Contributing

We welcome people to contribute in any way they can, regardless of
experience level. We need help in the following areas:

* Writing docstrings. This is an excellent way to get to know the
  Clojure core library.
* Making improvements to docstrings. If you find a typo or something
  missing or incorrect, please let us know. We also want to keep a
  high standard, so if you have a better way to explain something,
  we're all ears. Open an issue and let's talk about it.
* Documenting this library. We could always use help to make the
  process easier for us and future contributors.

## License

Copyright © 2017 Eric Normand

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
