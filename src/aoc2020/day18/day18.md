# Day 18

https://adventofcode.com/2020/day/18

## --- Day 18: Operation Order ---

> As you look out the window and notice a heavily-forested continent slowly appear over the horizon, you are interrupted by the child sitting next to you. They’re curious if you could help them with their math homework.\
> \
> Unfortunately, it seems like this “math” follows different rules than you remember.\
> \
> The homework (your puzzle input) consists of a series of expressions that consist of addition (+), multiplication (_), and parentheses ((...)). Just like normal math, parentheses indicate that the expression inside must be evaluated before it can be used by the surrounding expression. Addition still finds the sum of the numbers on both sides of the operator, and multiplication still finds the product.\
> \
> However, the rules of operator precedence have changed. Rather than evaluating multiplication before addition, the operators have the same precedence, and are evaluated left-to-right regardless of the order in which they appear.\
> \
> For example, the steps to evaluate the expression `1 + 2 _ 3 + 4 \* 5 + 6` are as follows:

```
1 + 2 * 3 + 4 * 5 + 6
  3   * 3 + 4 * 5 + 6
      9   + 4 * 5 + 6
         13   * 5 + 6
             65   + 6
                 71
```

> Parentheses can override this order; for example, here is what happens if parentheses are added to form `1 + (2 * 3) + (4 * (5 + 6))`:

```
1 + (2 * 3) + (4 * (5 + 6))
1 +    6    + (4 * (5 + 6))
     7      + (4 * (5 + 6))
     7      + (4 *   11   )
     7      +     44
            51
```

> Here are a few more examples:\
> \
> `2 * 3 + (4 * 5)` becomes `26`.\
> `5 + (8 * 3 + 9 + 3 * 4 * 3)` becomes `437`.\
> `5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))` becomes `12240`.\
> `((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2` becomes `13632`.\
> \
> Before you can help with the homework, you need to understand it yourself. Evaluate the expression on each line of the homework; what is the sum of the resulting values?

There were some pretty clever solutions today! As we get higher and higher in days, there’s just so many very educational solutions for a multitude of topics and lines of thought. Enjoy!

First the creative and cool: [Flex + Bison (custom compiler?!)](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg848gq?utm_source=share&utm_medium=web2x&context=3), [AWK](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gga8qdo?utm_source=share&utm_medium=web2x&context=3) (rather stylistic too!), [VIM](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg8atiy?utm_source=share&utm_medium=web2x&context=3) (it’s back!), and [Mathematica](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg85y7q?utm_source=share&utm_medium=web2x&context=3)

And then the awesome: [Ruby](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg812h9?utm_source=share&utm_medium=web2x&context=3) (redefined operators), [Perl](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg9jmwo?utm_source=share&utm_medium=web2x&context=3) (yup, regex), [Python](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg8162d?utm_source=share&utm_medium=web2x&context=3) (again with redefining operators), [Python](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg8gyk8?utm_source=share&utm_medium=web2x&context=3) (part2 with reverse polish notation), [C++](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg868h3?utm_source=share&utm_medium=web2x&context=3) (with a “shunting-yard algorithm” made for converting to reverse polish notation or abstract syntax tree), [Python](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg8hl9v?utm_source=share&utm_medium=web2x&context=3) (with pyparsing), [Javascript](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg88lqc?utm_source=share&utm_medium=web2x&context=3) (very short and clever), [Haskell](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg8gjdg?utm_source=share&utm_medium=web2x&context=3) (monadic parsers, definitely going to study this one), [Haskell](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg9juv8?utm_source=share&utm_medium=web2x&context=3) (with walkthrough, very succinct, also a good one to study!), and [Clojure](https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/gg8kbp7?utm_source=share&utm_medium=web2x&context=3) (clean parsing with good tips in comments).

See what else you can find. Here’s the megathread for the day:

https://www.reddit.com/r/adventofcode/comments/kfeldk/2020_day_18_solutions/?sort=confidence

Good luck on day 19! (edited)
