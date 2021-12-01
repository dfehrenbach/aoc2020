# Day 5

## --- Day 5: Binary Boarding ---

> You board your plane only to discover a new problem: you dropped your boarding pass! You aren’t sure which seat is yours, and all of the flight attendants are busy with the flood of people that suddenly made it through passport control.\
> \
> You write a quick program to use your phone’s camera to scan all of the nearby boarding passes (your puzzle input); perhaps you can find your seat through process of elimination.\
> \
> Instead of zones or groups, this airline uses binary space partitioning to seat people. A seat might be specified like FBFBBFFRLR, where F means “front”, B means “back”, L means “left”, and R means “right”.\
> \
> The first 7 characters will either be F or B; these specify exactly one of the 128 rows on the plane (numbered 0 through 127). Each letter tells you which half of a region the given seat is in. Start with the whole list of rows; the first letter indicates whether the seat is in the front (0 through 63) or the back (64 through 127). The next letter indicates which half of that region the seat is in, and so on until you’re left with exactly one row.\
> \
> For example, consider just the first seven characters of FBFBBFFRLR:

```
Start by considering the whole range, rows 0 through 127.
F means to take the lower half, keeping rows 0 through 63.
B means to take the upper half, keeping rows 32 through 63.
F means to take the lower half, keeping rows 32 through 47.
B means to take the upper half, keeping rows 40 through 47.
B keeps rows 44 through 47.
F keeps rows 44 through 45.

The final F keeps the lower of the two, row 44.
```

> The last three characters will be either L or R; these specify exactly one of the 8 columns of seats on the plane (numbered 0 through 7). The same process as above proceeds again, this time with only three steps. L means to keep the lower half, while R means to keep the upper half.\
> \
> For example, consider just the last 3 characters of FBFBBFFRLR:

```
Start by considering the whole range, columns 0 through 7.
R means to take the upper half, keeping columns 4 through 7.
L means to take the lower half, keeping columns 4 through 5.
The final R keeps the upper of the two, column 5.

So, decoding FBFBBFFRLR reveals that it is the seat at row 44, column 5.
```

> Every seat also has a unique seat ID: multiply the row by 8, then add the column. In this example, the seat has ID 44 \* 8 + 5 = 357.\
> \
> Here are some other boarding passes:

```
BFFFBBFRRR: row 70, column 7, seat ID 567.
FFFBBBFRRR: row 14, column 7, seat ID 119.
BBFFBBFRLL: row 102, column 4, seat ID 820.
```

> As a sanity check, look through your list of boarding passes. What is the highest seat ID on a boarding pass?

Yep, still on the easier side. As a result there’s still some fun and funky solutions, but I doubt these are going away even if the problems get significantly harder. Anyway, they’re fun to look at so check these solutions out in [Notepad++](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geod3el?utm_source=share&utm_medium=web2x&context=3) (yep…), [Bash](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geo96no?utm_source=share&utm_medium=web2x&context=3), [VIM](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geohvq4?utm_source=share&utm_medium=web2x&context=3) (slowly becoming one of my favorites to find, the author here goes over the keystrokes in a great commentary), [Brainf\*\*\*](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/gep9kcv?utm_source=share&utm_medium=web2x&context=3), [Scratch](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geodm88?utm_source=share&utm_medium=web2x&context=3), [SQL](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geoe4dr?utm_source=share&utm_medium=web2x&context=3), [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geonfks?utm_source=share&utm_medium=web2x&context=3) (still Aliens, what’s most impressive is the leaderboard placement part1: 147 and part2: 61), [Rockstar](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geop17a?utm_source=share&utm_medium=web2x&context=3), and [Excel](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geo934n?utm_source=share&utm_medium=web2x&context=3) (again with the nice placement being 321/274)

It seems that the tricks here are mostly realizing binary numerals can be created from the rules. Anyway, on with the honest-to-goodness solutions in: [Python](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geo8qy5?utm_source=share&utm_medium=web2x&context=3) (crazy 4/3 placement), [Clojure](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/georogu?utm_source=share&utm_medium=web2x&context=3), [Python again](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/gerudeo?utm_source=share&utm_medium=web2x&context=3) (this explicitly writes out the link between the instructions and binary more a learning tool than anything!), [Rust](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geosxob?utm_source=share&utm_medium=web2x&context=3), [Ruby](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geoa6oq?utm_source=share&utm_medium=web2x&context=3) (1/10), [Haskell](https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/geop17a?utm_source=share&utm_medium=web2x&context=3) (beneath the Rockstar solution. quite clean!). Many on this day lacked clarity and brevity. See what you can find!

Here’s the megathread for the day:

https://www.reddit.com/r/adventofcode/comments/k71h6r/2020_day_05_solutions/?sort=confidence (edited)
