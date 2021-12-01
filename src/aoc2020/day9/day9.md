# Day 9

## --- Day 9: Encoding Error ---

> With your neighbor happily enjoying their video game, you turn your attention to an open data port on the little screen in the seat in front of you.\
> \
> Though the port is non-standard, you manage to connect it to your computer through the clever use of several paperclips. Upon connection, the port outputs a series of numbers (your puzzle input).\
> \
> The data appears to be encrypted with the eXchange-Masking Addition System (XMAS) which, conveniently for you, is an old cypher with an important weakness.\
> \
> XMAS starts by transmitting a preamble of 25 numbers. After that, each number you receive should be the sum of any two of the 25 immediately previous numbers. The two numbers will have different values, and there might be more than one such pair.\
> \
> For example, suppose your preamble consists of the numbers `1` through `25` in a random order. To be valid, the next number must be the sum of two of those numbers:\
> \
> `26` would be a valid next number, as it could be `1` plus `25` (or many other pairs, like `2` and `24`).\
> `49` would be a valid next number, as it is the sum of `24` and `25`.\
> `100` would not be valid; no two of the previous `25` numbers sum to `100`.\
> `50` would also not be valid; although `25` appears in the previous 25 numbers, the two numbers in the pair must be different.\
> \
> Suppose the 26th number is `45`, and the first number (no longer an option, as it is more than 25 numbers ago) was `20`. Now, for the next number to be valid, there needs to be some pair of numbers among `1-19`, `21-25`, or `45` that add up to it:\
> \
> `26` would still be a valid next number, as `1` and `25` are still within the previous 25 numbers.\
> `65` would not be valid, as no two of the available numbers sum to it.\
> `64` and `66` would both be valid, as they are the result of `19+45` and `21+45` respectively.\
> \
> Here is a larger example which only considers the previous 5 numbers (and has a preamble of length 5):

```
35
20
15
25
47
40
62
55
65
95
102
117
150
182
127
219
299
277
309
576
```

> In this example, after the 5-number preamble, almost every number is the sum of two of the previous 5 numbers; the only number that does not follow this rule is `127`.\
> \
> The first step of attacking the weakness in the XMAS data is to find the first number in the list (after the preamble) which is not the sum of two of the 25 numbers before it. What is the first number that does not have this property?

Today was a cool problem. First with the creative and fun ones: [Rockstar](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf6gqkn?utm_source=share&utm_medium=web2x&context=3), [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf52o73?utm_source=share&utm_medium=web2x&context=3) (687/724), [AWK](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf60whd?utm_source=share&utm_medium=web2x&context=3), [Emojicode](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf59e8d?utm_source=share&utm_medium=web2x&context=3), [SQL](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf55255?utm_source=share&utm_medium=web2x&context=3), and [Excel](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf52dcn?utm_source=share&utm_medium=web2x&context=3) (no vim today!)

And the honest, fast, readable, and informative solutions, [Python](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf51lz7?utm_source=share&utm_medium=web2x&context=3) (2/3), [Haskell](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf55agu?utm_source=share&utm_medium=web2x&context=3), [Python](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf51awj?utm_source=share&utm_medium=web2x&context=3) (11/10) (LOTS of python today and usually in the leaderboards), [Ruby](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf5pkr1?utm_source=share&utm_medium=web2x&context=3), [Perl](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf5sh6h?utm_source=share&utm_medium=web2x&context=3), [Haskell](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf53hxh?utm_source=share&utm_medium=web2x&context=3) (some more), [Rust](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf79k12?utm_source=share&utm_medium=web2x&context=3) (fast!), [Rust](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf8pned?utm_source=share&utm_medium=web2x&context=3) (faster!), and [Clojure](https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/gf5h1me?utm_source=share&utm_medium=web2x&context=3).

Day 10 starts simple and then throws a mind bending wrench that took some sleep to figure out. Good luck!

Here's the megathread for Day 9:

https://www.reddit.com/r/adventofcode/comments/k9lfwj/2020_day_09_solutions/?sort=confidence
