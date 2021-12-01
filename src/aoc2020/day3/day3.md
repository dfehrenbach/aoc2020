# Day 3

https://adventofcode.com/2020/day/3

## --- Day 3: Toboggan Trajectory ---

> With the toboggan login problems resolved, you set off toward the airport. While travel by toboggan might be easy, it’s certainly not safe: there’s very minimal steering and the area is covered in trees. You’ll need to see which angles will take you near the fewest trees.\
> \
> Due to the local geology, trees in this area only grow on exact integer coordinates in a grid. You make a map (your puzzle input) of the open squares (`.`) and trees (`#`) you can see. For example:

```
..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#
```

> These aren’t the only trees, though; due to something you read about once involving arboreal genetics and biome stability, the same pattern repeats to the right many times:

```
..##.........##.........##.........##.........##.........##.......  --->
#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
.#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
.#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....  --->
.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
.#........#.#........#.#........#.#........#.#........#.#........#
#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...
#...##....##...##....##...##....##...##....##...##....##...##....#
.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
```

> You start on the open square (`.`) in the top-left corner and need to reach the bottom (below the bottom-most row on your map).\
> \
> The toboggan can only follow a few specific slopes (you opted for a cheaper model that prefers rational numbers); start by counting all the trees you would encounter for the slope right 3, down 1:\
> \
> From your starting position at the top-left, check the position that is right 3 and down 1. Then, check the position that is right 3 and down 1 from there, and so on until you go past the bottom of the map.\
> \
> The locations you’d check in the above example are marked here with `O` where there was an open square and `X` where there was a tree:

```
..##.........##.........##.........##.........##.........##....... --->
#..O#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
.#....X..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
..#.#...#O#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
.#...##..#..X...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
..#.##.......#.X#.......#.##.......#.##.......#.##.......#.##..... --->
.#.#.#....#.#.#.#.O..#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
.#........#.#........X.#........#.#........#.#........#.#........#
#.##...#...#.##...#...#.X#...#...#.##...#...#.##...#...#.##...#...
#...##....##...##....##...#X....##...##....##...##....##...##....#
.#..#...#.#.#..#...#.#.#..#...X.#.#..#...#.#.#..#...#.#.#..#...#.# --->
```

> In this example, traversing the map using this slope would cause you to encounter `7` trees.\
> \
> Starting at the top-left corner of your map and following a slope of right 3 and down 1, how many trees would you encounter?

You can feel the difficulty starting to gently go up with the puzzle input, but that hasn’t squashed any of the community creativity just yet.

The solutions are still on the simple side and there’s some funky ones in: [Rockstar](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gegsjgc?utm_source=share&utm_medium=web2x&context=3) (becoming a true staple of this year’s solvers), [VIM](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gegzt2a?utm_source=share&utm_medium=web2x&context=3) (this one too), [AWK](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gegovyn?utm_source=share&utm_medium=web2x&context=3), [C Ascii Art](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gehy1od?utm_source=share&utm_medium=web2x&context=3) (and the Python solution that it was based on was churned out rather quickly), [COBOL](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gejgt6h?utm_source=share&utm_medium=web2x&context=3), and [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/geglr07?utm_source=share&utm_medium=web2x&context=3) (Aliens?!).

Then, of course, there’s some honest to goodness solutions across a variety of languages like [Rust](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/geh0gqn?utm_source=share&utm_medium=web2x&context=3), [Haskell](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/geh2d5o?utm_source=share&utm_medium=web2x&context=3) (not very readable, but mind-bending), [Javascript](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gegjeha?utm_source=share&utm_medium=web2x&context=3), [Python](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gegmo0u?utm_source=share&utm_medium=web2x&context=3), [Haskell](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gegve36?utm_source=share&utm_medium=web2x&context=3) (again, but with a nice bit of commentary), [Clojure & Elixir](https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/gegz4c1?utm_source=share&utm_medium=web2x&context=3).

There wasn’t too much difference between solutions, except for the usage of laziness which could infinitely extend the pattern to the right instead of using a modulus (or remainder) operation to be looking at the appropriate index on a line. The first Haskell solution above creates an infinite sequence of each line as it comes and takes the index of that. Similar things could have been done in other languages that support laziness. In my opinion, while cool and cuts a line or two of code, the math might make more sense.

Here’s the megathread for the day:

https://www.reddit.com/r/adventofcode/comments/k5qsrk/2020_day_03_solutions/?sort=top

Goodluck on Day 4! (edited)
