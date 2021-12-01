# Day12:

https://adventofcode.com/2020/day/12

## --- Day 12: Rain Risk ---

> Your ferry made decent progress toward the island, but the storm came in faster than anyone expected. The ferry needs to take evasive actions!

> Unfortunately, the ship's navigation computer seems to be malfunctioning; rather than giving a route directly to safety, it produced extremely circuitous instructions. When the captain uses the [PA system](https://en.wikipedia.org/wiki/Public_address_system) to ask if anyone can help, you quickly volunteer.

> The navigation instructions (your puzzle input) consists of a sequence of single-character actions paired with integer input values. After staring at them for a few minutes, you work out what they probably mean:
>
> - Action `N` means to move north by the given value.
> - Action `S` means to move south by the given value.
> - Action `E` means to move east by the given value.
> - Action `W` means to move west by the given value.
> - Action `L` means to turn left the given number of degrees.
> - Action `R` means to turn right the given number of degrees.
> - Action `F` means to move forward by the given value in the direction the ship is currently facing.

> The ship starts by facing east. Only the `L` and `R` actions change the direction the ship is facing. (That is, if the ship is facing east and the next instruction is `N10`, the ship would move north 10 units, but would still move east if the following action were `F`.)

> For example:

```
F10
N3
F7
R90
F11
```

> These instructions would be handled as follows:\
> \
> `F10` would move the ship 10 units east (because the ship starts by facing east) to east 10, north 0.\
> \
> `N3` would move the ship 3 units north to east 10, north 3.\
> \
> `F7` would move the ship another 7 units east (because the ship is still facing east) to east 17, north 3.\
> \
> `R90` would cause the ship to turn right by 90 degrees and face south; it remains at east 17, north 3.\
> \
> `F11` would move the ship 11 units south to east 17, south 8.\
> \
> At the end of these instructions, the ship's Manhattan distance (sum of the absolute values of its east/west position and its north/south position) from its starting position is `17 + 8 = 25`.\
> \
> Figure out where the navigation instructions lead. What is the Manhattan distance between that location and the ship's starting position?\
> \
> As usual, the day starts off simple, but then throws a curve ball. I hope you remember how to rotate coordinates 90 degrees around the origin (or use complex numbers?). As usual, there's some funky solutions and some hidden math tricks in here that make some of the solutions a sight to behold. It's rather educational!

First the funky: [Vim](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfjnuwi?utm_source=share&utm_medium=web2x&context=3), [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfhum43?utm_source=share&utm_medium=web2x&context=3), [AWK](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfiqf2a?utm_source=share&utm_medium=web2x&context=3), and [Commodore 64 Basic](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfm3xf0?utm_source=share&utm_medium=web2x&context=3).

And the great: [Python](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfhx168?utm_source=share&utm_medium=web2x&context=3) (complex numbers), [Python](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfhq8j4?utm_source=share&utm_medium=web2x&context=3) (4/48), [Python](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfhy27d?utm_source=share&utm_medium=web2x&context=3) (97/35), [Javascript ES6](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfhwa7p?utm_source=share&utm_medium=web2x&context=3) (similar to the python ones, just in es6), [Rust](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfiqf2a?utm_source=share&utm_medium=web2x&context=3) (241/996), [Python & Golang](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfhwsss?utm_source=share&utm_medium=web2x&context=3) (person did some fancy trig, before realizing it's only 90 degree increments), and [Haskell](https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/gfjwm9n?utm_source=share&utm_medium=web2x&context=3)

Here's the megathread for the day:

https://www.reddit.com/r/adventofcode/comments/kbj5me/2020_day_12_solutions/?sort=confidence

Good luck on Day 13. The author throws a performance curve-ball in the second half.
