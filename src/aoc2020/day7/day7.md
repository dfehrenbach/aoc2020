# Day 7

## --- Day 7: Handy Haversacks ---

> You land at the regional airport in time for your next flight. In fact, it looks like you'll even have time to grab some food: all flights are currently delayed due to issues in luggage processing.\
> \
> Due to recent aviation regulations, many rules (your puzzle input) are being enforced about bags and their contents; bags must be color-coded and must contain specific quantities of other color-coded bags. Apparently, nobody responsible for these regulations considered how long they would take to enforce!\
> \
> For example, consider the following rules:

```
light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.
```

> These rules specify the required contents for 9 bag types. In this example, every `faded blue` bag is empty, every `vibrant plum` bag contains 11 bags (5 `faded blue` and 6 `dotted black`), and so on.\
> \
> You have a `shiny gold` bag. If you wanted to carry it in at least one other bag, how many different bag colors would be valid for the outermost bag? (In other words: how many colors can, eventually, contain at least one `shiny gold` bag?)\
> \
> In the above rules, the following options would be available to you:
>
> - A `bright white` bag, which can hold your `shiny gold` bag directly.
> - A `muted yellow` bag, which can hold your `shiny gold` bag directly, plus some other bags.
> - A `dark orange` bag, which can hold `bright white` and `muted yellow` bags, either of which could then hold your `shiny gold` bag.
> - A `light red` bag, which can hold `bright white` and `muted yellow` bags, either of which could then hold your `shiny gold` bag.

> So, in this example, the number of bag colors that can eventually contain at least one `shiny gold` bag is `4`.\
> \
> How many bag colors can eventually contain at least one `shiny gold` bag? (The list of rules is quite long; make sure you get all of it.)\

Today dealt with a graph and some solutions were surprisingly short. First some creative ones in: [VIM](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gey39fu?utm_source=share&utm_medium=web2x&context=3), [Prolog](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gexeipz?utm_source=share&utm_medium=web2x&context=3), [Mathematica](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gex2l72?utm_source=share&utm_medium=web2x&context=3) (274/2133) (and a poem), [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gexrctf?utm_source=share&utm_medium=web2x&context=3), and [x86-64 assembly for Linux](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gezq5e1?utm_source=share&utm_medium=web2x&context=3).

And then some impressive solutions that because of their fast/creative thinking/knowledge of graph theory ended up on the "fast" leaderboards. As it turns out, because of the brevity of them and lack of roundabout problem solving makes them easier to read than many of the later solutions. Things like: [Python](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gewyc98?utm_source=share&utm_medium=web2x&context=3) (16/8), [Python](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gex7xor?utm_source=share&utm_medium=web2x&context=3) (another), [Python](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gexio8m?utm_source=share&utm_medium=web2x&context=3) (w/ a nice library), [Haskell (58/45) & Kotlin & Python & Rust](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gex9ebh?utm_source=share&utm_medium=web2x&context=3), [Rust](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gewzx3t?utm_source=share&utm_medium=web2x&context=3) (662/335), and [Clojure](https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/gezcmfn?utm_source=share&utm_medium=web2x&context=3).

Goodluck on Day 8. If anyone is familiar with the instruction parsing from last year, it seems to be back in one form or another.

Here's the megathread for the day:

https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/?sort=top (edited)
