# Day 6

## --- Day 6: Custom Customs ---

> As your flight approaches the regional airport where you'll switch to a much larger plane, customs declaration forms are distributed to the passengers.\
> \
> The form asks a series of 26 yes-or-no questions marked `a` through `z`. All you need to do is identify the questions for which anyone in your group answers "yes". Since your group is just you, this doesn't take very long.\
> \
> However, the person sitting next to you seems to be experiencing a language barrier and asks if you can help. For each of the people in their group, you write down the questions for which they answer "yes", one per line. For example:

```
abcx
abcy
abcz
```

> In this group, there are `6` questions to which anyone answered "yes": `a`, `b`, `c`, `x`, `y`, and `z`. (Duplicate answers to the same question don't count extra; each question counts at most once.)\
> \
> Another group asks for your help, then another, and eventually you've collected answers from every group on the plane (your puzzle input). Each group's answers are separated by a blank line, and within each group, each person's answers are on a single line. For example:

```
abc

a
b
c

ab
ac

a
a
a
a

b
```

> This list represents answers from five groups:
>
> - The first group contains one person who answered "yes" to `3` questions: `a`, `b`, and `c`.
> - The second group contains three people; combined, they answered "yes" to `3` questions: `a`, `b`, and `c`.
> - The third group contains two people; combined, they answered "yes" to `3` questions: `a`, `b`, and `c`.
> - The fourth group contains four people; combined, they answered "yes" to only `1` question, `a`.
> - The last group contains one person who answered "yes" to only `1` question, `b`.

> In this example, the sum of these counts is `3 + 3 + 3 + 1 + 1 = 11`.\
> \
> For each group, count the number of questions to which anyone answered "yes". What is the sum of those counts?

A very simple and quick day for those that used set unions/intersections. As such the solutions today are short. First, the goofy and absurd in: [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/getjg8r?utm_source=share&utm_medium=web2x&context=3), and [Mathematica](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/ges8jld?utm_source=share&utm_medium=web2x&context=3).

But mostly the short and sweet ones are a sight to behold like these in [Ruby](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/ges7bz7?utm_source=share&utm_medium=web2x&context=3) (1/1), [Python](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/ges8u7n?utm_source=share&utm_medium=web2x&context=3), [Ruby](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/ges6nvc?utm_source=share&utm_medium=web2x&context=3) (9/31), and then [Haskell](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/gesc59h?utm_source=share&utm_medium=web2x&context=3), More [Haskell](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/gesebja?utm_source=share&utm_medium=web2x&context=3), Even More [Haskell](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/geuxki4?utm_source=share&utm_medium=web2x&context=3), and a spattering of [Elixir & Clojure](https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/get66bu?utm_source=share&utm_medium=web2x&context=3).

With that day out of the way, 7 starts to ramp up a little bit. From sets to graphs. More on that tomorrow. Good luck!

Here's the megathread for the day. Behold the brevity!:

https://www.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/?sort=confidence (edited)
