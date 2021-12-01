# Day 20:

https://adventofcode.com/2020/day/20#part2

## --- Day 20: Jurassic Jigsaw ---

> The high-speed train leaves the forest and quickly carries you south. You can even see a desert in the distance! Since you have some spare time, you might as well see if there was anything interesting in the image the Mythical Information Bureau satellite captured.\
> \
> After decoding the satellite messages, you discover that the data actually contains many small images created by the satellite’s camera array. The camera array consists of many cameras; rather than produce a single square image, they produce many smaller square image tiles that need to be reassembled back into a single image.\
> \
> Each camera in the camera array returns a single monochrome image tile with a random unique ID number. The tiles (your puzzle input) arrived in a random order.\
> \
> Worse yet, the camera array appears to be malfunctioning: each image tile has been rotated and flipped to a random orientation. Your first task is to reassemble the original image by orienting the tiles so they fit together.\
> \
> To show how the tiles should be reassembled, each tile’s image data includes a border that should line up exactly with its adjacent tiles. All tiles have this border, and the border lines up exactly when the tiles are both oriented correctly. Tiles at the edge of the image also have this border, but the outermost edges won’t line up with any other tiles.\
> \
> For example, suppose you have the following nine tiles:

```
Tile 2311:
..##.#..#.
##..#.....
#...##..#.
####.#...#
##.##.###.
##...#.###
.#.#.#..##
..#....#..
###...#.#.
..###..###

Tile 1951:
#.##...##.
#.####...#
.....#..##
#...######
.##.#....#
.###.#####
###.##.##.
.###....#.
..#.#..#.#
#...##.#..

Tile 1171:
####...##.
#..##.#..#
##.#..#.#.
.###.####.
..###.####
.##....##.
.#...####.
#.##.####.
####..#...
.....##...

Tile 1427:
###.##.#..
.#..#.##..
.#.##.#..#
#.#.#.##.#
....#...##
...##..##.
...#.#####
.#.####.#.
..#..###.#
..##.#..#.

Tile 1489:
##.#.#....
..##...#..
.##..##...
..#...#...
#####...#.
#..#.#.#.#
...#.#.#..
##.#...##.
..##.##.##
###.##.#..

Tile 2473:
#....####.
#..#.##...
#.##..#...
######.#.#
.#...#.#.#
.#########
.###.#..#.
########.#
##...##.#.
..###.#.#.

Tile 2971:
..#.#....#
#...###...
#.#.###...
##.##..#..
.#####..##
.#..####.#
#..#.#..#.
..####.###
..#.#.###.
...#.#.#.#

Tile 2729:
...#.#.#.#
####.#....
..#.#.....
....#..#.#
.##..##.#.
.#.####...
####.#.#..
##.####...
##..#.##..
#.##...##.

Tile 3079:
#.#.#####.
.#..######
..#.......
######....
####.#..#.
.#...#.##.
#.#####.##
..#.###...
..#.......
..#.###...
```

> By rotating, flipping, and rearranging them, you can find a square arrangement that causes all adjacent borders to line up:

```
#...##.#.. ..###..### #.#.#####.
..#.#..#.# ###...#.#. .#..######
.###....#. ..#....#.. ..#.......
###.##.##. .#.#.#..## ######....
.###.##### ##...#.### ####.#..#.
.##.#....# ##.##.###. .#...#.##.
#...###### ####.#...# #.#####.##
.....#..## #...##..#. ..#.###...
#.####...# ##..#..... ..#.......
#.##...##. ..##.#..#. ..#.###...

#.##...##. ..##.#..#. ..#.###...
##..#.##.. ..#..###.# ##.##....#
##.####... .#.####.#. ..#.###..#
####.#.#.. ...#.##### ###.#..###
.#.####... ...##..##. .######.##
.##..##.#. ....#...## #.#.#.#...
....#..#.# #.#.#.##.# #.###.###.
..#.#..... .#.##.#..# #.###.##..
####.#.... .#..#.##.. .######...
...#.#.#.# ###.##.#.. .##...####

...#.#.#.# ###.##.#.. .##...####
..#.#.###. ..##.##.## #..#.##..#
..####.### ##.#...##. .#.#..#.##
#..#.#..#. ...#.#.#.. .####.###.
.#..####.# #..#.#.#.# ####.###..
.#####..## #####...#. .##....##.
##.##..#.. ..#...#... .####...#.
#.#.###... .##..##... .####.##.#
#...###... ..##...#.. ...#..####
..#.#....# ##.#.#.... ...##.....
```

> For reference, the IDs of the above tiles are:

```
1951    2311    3079
2729    1427    2473
2971    1489    1171
```

> To check that you’ve assembled the image correctly, multiply the IDs of the four corner tiles together. If you do this with the assembled tiles from the example above, you get `1951 * 3079 * 2971 * 1171 = 20899048083289`.\
> \
> Assemble the tiles into an image. What do you get if you multiply together the IDs of the four corner tiles?

Wow this day starts with an easier problem and then explodes into what feels like 3 separate day’s worth of problems in the second half, especially if you take the shortcut in the first half. Nobody is particularly proud of their solutions for the day and most are long and rather unwieldy, but sometimes the approaches, at least in pseudo, are quite good. And on top of that, the consensus is that the difficulty was enjoyed and incredibly satisfying to see work. Enjoy!

First the creative: [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/kgo01p/2020_day_20_solutions/ggg9c1j?utm_source=share&utm_medium=web2x&context=3) 47/65 (holy smokes! I like the grid reconstruction method)

And then the awesome: [Python](https://www.reddit.com/r/adventofcode/comments/kgo01p/2020_day_20_solutions/ggg6a06?utm_source=share&utm_medium=web2x&context=3) 48/1 (honestly kinda a mess, but very impressive on the speed, and actually did the grid reconstruction) (LOTS of python in the solutions today), [Java](https://www.reddit.com/r/adventofcode/comments/kgo01p/2020_day_20_solutions/ggg7itx?utm_source=share&utm_medium=web2x&context=3) 311/84, [Golang](https://www.reddit.com/r/adventofcode/comments/kgo01p/2020_day_20_solutions/ggi59sa?utm_source=share&utm_medium=web2x&context=3), [Haskell](https://www.reddit.com/r/adventofcode/comments/kgo01p/2020_day_20_solutions/gggb49z?utm_source=share&utm_medium=web2x&context=3) 1518/210

Here’s the megathread for day 20:

https://www.reddit.com/r/adventofcode/comments/kgo01p/2020_day_20_solutions/?sort=confidence

Good luck on 21! (edited)
