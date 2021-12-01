# Day 24

https://adventofcode.com/2020/day/24

## --- Day 24: Lobby Layout ---

> Your raft makes it to the tropical island; it turns out that the small crab was an excellent navigator. You make your way to the resort.\
> \
> As you enter the lobby, you discover a small problem: the floor is being renovated. You can’t even reach the check-in desk until they’ve finished installing the new tile floor.\
> \
> The tiles are all hexagonal; they need to be arranged in a [hex grid](https://en.wikipedia.org/wiki/Hexagonal_tiling) with a very specific color pattern. Not in the mood to wait, you offer to help figure out the pattern.\
> \
> The tiles are all white on one side and black on the other. They start with the white side facing up. The lobby is large enough to fit whatever pattern might need to appear there.\
> \
> A member of the renovation crew gives you a list of the tiles that need to be flipped over (your puzzle input). Each line in the list identifies a single tile that needs to be flipped by giving a series of steps starting from a reference tile in the very center of the room. (Every line starts from the same reference tile.)\
> \
> Because the tiles are hexagonal, every tile has six neighbors: east, southeast, southwest, west, northwest, and northeast. These directions are given in your list, respectively, as `e`, `se`, `sw`, `w`, `nw`, and `ne`. A tile is identified by a series of these directions with no delimiters; for example, `esenee` identifies the tile you land on if you start at the reference tile and then move one tile east, one tile southeast, one tile northeast, and one tile east.\
> \
> Each time a tile is identified, it flips from white to black or from black to white. Tiles might be flipped more than once. For example, a line like `esew` flips a tile immediately adjacent to the reference tile, and a line like `nwwswee` flips the reference tile itself.\
> \
> Here is a larger example:

```
sesenwnenenewseeswwswswwnenewsewsw
neeenesenwnwwswnenewnwwsewnenwseswesw
seswneswswsenwwnwse
nwnwneseeswswnenewneswwnewseswneseene
swweswneswnenwsewnwneneseenw
eesenwseswswnenwswnwnwsewwnwsene
sewnenenenesenwsewnenwwwse
wenwwweseeeweswwwnwwe
wsweesenenewnwwnwsenewsenwwsesesenwne
neeswseenwwswnwswswnw
nenwswwsewswnenenewsenwsenwnesesenew
enewnwewneswsewnwswenweswnenwsenwsw
sweneswneswneneenwnewenewwneswswnese
swwesenesewenwneswnwwneseswwne
enesenwswwswneneswsenwnewswseenwsese
wnwnesenesenenwwnenwsewesewsesesew
nenewswnwewswnenesenwnesewesw
eneswnwswnwsenenwnwnwwseeswneewsenese
neswnwewnwnwseenwseesewsenwsweewe
wseweeenwnesenwwwswnew
```

> In the above example, 10 tiles are flipped once (to black), and 5 more are flipped twice (to black, then back to white). After all of these instructions have been followed, a total of 10 tiles are black.\
> \
> Go through the renovation crew’s list and determine which tiles they need to flip. After all of the instructions have been followed, how many tiles are left with the black side up?

Fun day! A bit simpler once you realize how to navigate the “interesting” hexagonal grid (yes there’s a trick… multiple actually). I even remember seeing someone who did many more iterations on part2 to find an emergent pattern. It’s very clever, cool, and has a bit of humor. (Trying to find it). [HERE! DON'T MISS THIS LINK! LOL](https://www.reddit.com/r/adventofcode/comments/kjev7f/2020_day_24_part_2_i_let_it_run_for_10m/)

First the fun: [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvj56i?utm_source=share&utm_medium=web2x&context=3) 437/288 (with the mapping to 2d approach… still alien!), [Literate Elm](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvrls4?utm_source=share&utm_medium=web2x&context=3) (I LOVE seeing literate programming in this setting, and I’m surprised I haven’t seen much of it. Check it out!), [Mathematica](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvlwoc?utm_source=share&utm_medium=web2x&context=3) (still love seeing this language coming in from the academic math world)

And the awesome: [Python](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvggpj?utm_source=share&utm_medium=web2x&context=3) 36/29 (used a unique coordinate system referenced in post! Interesting and helpful if but a little complicated), [Python](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvo9qm?utm_source=share&utm_medium=web2x&context=3) 21/11 (with mapping coordinates to 2d), [Clojure](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvopjy?utm_source=share&utm_medium=web2x&context=3) (aha! the trick I used to represent the hexagons i.e. diagonals doing “half” movements, just with some extra clojure fanciness, love this), [Typescript](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvs8rc?utm_source=share&utm_medium=web2x&context=3) (author also got some code-reuse out of a previous day), [Haskell](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvpncc?utm_source=share&utm_medium=web2x&context=3), [Elixir](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvqq3c?utm_source=share&utm_medium=web2x&context=3), [Rust](https://www.reddit.com/r/adventofcode/comments/kj96iw/2020_day_24_solutions/ggvt4zm?utm_source=share&utm_medium=web2x&context=3)

Here’s the megathread for the day. There’s many wonderful solutions of all colors left to discover. See what you can find:

https://www.reddit.com/r/adventofcode/comments/kimluc/2020_day_23_solutions/?sort=confidence

Good luck on Day 25 and MERRY CHRISTMAS: :tree: :tree: :tree: (edited)
