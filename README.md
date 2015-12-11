# Conway's Game of Life

A Java console implementation with the following features:
* Infinite grid (well, probably exception after Integer.MAX_VALUE/Integer.MIN_VALUE
* Static viewport (0,0 to 19,19)
* Runs until you stop it

### How to run

```bash
gradle run -Dargs="<list of coordinates that should be alive as seed>"
```

The list of coordinates are simple tuples, separated by comma, e.g.:
(1, 1), (-2, 40)
