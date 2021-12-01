# Day 2

https://adventofcode.com/2020/day/2

## --- Day 2: Password Philosophy ---

> Your flight departs in a few days from the coastal airport; the easiest way down to the coast from here is via toboggan.\
> \
> The shopkeeper at the North Pole Toboggan Rental Shop is having a bad day. “Something’s wrong with our computers; we can’t log in!” You ask if you can take a look.\
> \
> Their password database seems to be a little corrupted: some of the passwords wouldn’t have been allowed by the Official Toboggan Corporate Policy that was in effect when they were chosen.\
> \
> To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the corrupted database) and the corporate policy when that password was set.\
> \
> For example, suppose you have the following list:

```
1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
```

> Each line gives the password policy and then the password. The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.\
> \
> In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b, but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the limits of their respective policies.\
> \
> How many passwords are valid according to their policies?

Another simple day in the grand scheme of these puzzles. The creativity is still out in display with some funky solutions in [VIM](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gecqymv?utm_source=share&utm_medium=web2x&context=3), [Rockstar](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gecn4jo?utm_source=share&utm_medium=web2x&context=3), [AWK](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gecfytd?utm_source=share&utm_medium=web2x&context=3), [Postgresql](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/geeovh4?utm_source=share&utm_medium=web2x&context=3), [Google Sheets?!](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gece9kk?utm_source=share&utm_medium=web2x&context=3), [Excel?!](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gedqx5f?utm_source=share&utm_medium=web2x&context=3) (how fitting considering this deals with legacy passwords and password policies :laughing-lizard: ), [BBC Basic / 6502 assembler as UEF cassette tape?!?!?!?!](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gedwmlh?utm_source=share&utm_medium=web2x&context=3).

Then, again with the honest to goodness solutions in [Clojure](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gecf6o4?utm_source=share&utm_medium=web2x&context=3), [Go](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gee91gj?utm_source=share&utm_medium=web2x&context=3), [Python](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/geds6qx?utm_source=share&utm_medium=web2x&context=3), [Javascript](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gecbjcy?utm_source=share&utm_medium=web2x&context=3), [Haskell](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gecebaf?utm_source=share&utm_medium=web2x&context=3), [Rust](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gecg1p7?utm_source=share&utm_medium=web2x&context=3), and [so on](https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/gechebt?utm_source=share&utm_medium=web2x&context=3). There’s not much to write home about in terms of varying approaches. Most of the differences are coming from idiomatic language differences/semantics and whether or not the writer went for Golf or for reader-friendliness. (I prefer reader-friendly! The python one is great for this and further down is a super Golf’ed version that’s pretty impressive)

To keep track of other solutions and do some of your own browsing, here’s the megathread on Reddit:

https://www.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/?sort=confidence (edited)
