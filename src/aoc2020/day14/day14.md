# Day14

## --- Day 14: Docking Data ---

> As your ferry approaches the sea port, the captain asks for your help again. The computer system that runs this port isn’t compatible with the docking program on the ferry, so the docking parameters aren’t being correctly initialized in the docking program’s memory.\
> \
> After a brief inspection, you discover that the sea port’s computer system uses a strange bitmask system in its initialization program. Although you don’t have the correct decoder chip handy, you can emulate it in software!\
> \
> The initialization program (your puzzle input) can either update the bitmask or write a value to memory. Values and memory addresses are both 36-bit unsigned integers. For example, ignoring bitmasks for a moment, a line like mem[8] = 11 would write the value 11 to memory address 8.\
> \
> The bitmask is always given as a string of 36 bits, written with the most significant bit (representing 2^35) on the left and the least significant bit (2^0, that is, the 1s bit) on the right. The current bitmask is applied to values immediately before they are written to memory: a 0 or 1 overwrites the corresponding bit in the value, while an X leaves the bit in the value unchanged.\
> \
> For example, consider the following program:

```
mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
mem[8] = 11
mem[7] = 101
mem[8] = 0
```

> This program starts by specifying a bitmask (mask = ....). The mask it specifies will overwrite two bits in every written value: the 2s bit is overwritten with 0, and the 64s bit is overwritten with 1.\
> \
> The program then attempts to write the value 11 to memory address 8. By expanding everything out to individual bits, the mask is applied as follows:

```
value: 000000000000000000000000000000001011 (decimal 11)
mask: XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
result: 000000000000000000000000000001001001 (decimal 73)
```

> So, because of the mask, the value 73 is written to memory address 8 instead. Then, the program tries to write 101 to address 7:

```
value: 000000000000000000000000000001100101 (decimal 101)
mask: XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
result: 000000000000000000000000000001100101 (decimal 101)
```

> This time, the mask has no effect, as the bits it overwrote were already the values the mask tried to set. Finally, the program tries to write 0 to address 8:

```
value: 000000000000000000000000000000000000 (decimal 0)
mask: XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
result: 000000000000000000000000000001000000 (decimal 64)
```

> 64 is written to address 8 instead, overwriting the value that was there previously.\
> \
> To initialize your ferry’s docking program, you need the sum of all values left in memory after the initialization program completes. (The entire 36-bit address space begins initialized to the value 0 at every address.) In the above example, only two values in memory are not zero - 101 (at address 7) and 64 (at address 8) - producing a sum of 165.\
> \
> Execute the initialization program. What is the sum of all values left in memory after it completes?

Alright! First the fun and interesting: [C w/ Custom OS?!](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfsej90?utm_source=share&utm_medium=web2x&context=3), [GWBASIC](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfu5z4y?utm_source=share&utm_medium=web2x&context=3), [AWK](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gftd8lf?utm_source=share&utm_medium=web2x&context=3) (what can’t you do in AWK?!), [Dyalog APL 67/307](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfsbizq?utm_source=share&utm_medium=web2x&context=3) (continuously amused and very impressed)

And the great and/or cool: [Python](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfshjtl?utm_source=share&utm_medium=web2x&context=3), [Python](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfs8m4f?utm_source=share&utm_medium=web2x&context=3) 15/21 (a good thread follows this one), [Python](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfsbmlg?utm_source=share&utm_medium=web2x&context=3) 2/5, [Typescript](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfsu8sf?utm_source=share&utm_medium=web2x&context=3) (with interesting tree approach), [Haskell](https://topaz.github.io/paste/#XQAAAQDBAwAAAAAAAAA0m0pnuFI8c3wwear+l/XhMj/9lOxSKAKzjIx6hK+ZMsYA5IDDY99P114jU3/0++q6leoCQ6VbLm/wesBz2e21/123ht14J2ibbz3qruKxP+aRkLfS+xm1NYJv3XJOUolF0wMgJZmkAtHb2uaVy9zX2Q48mxoKEftonpnk6RaewWD+DWjHC4jBRKLEcYRb4Ifb1mLyagbOeqg1TmbO/P4xZN10tJmgQsVP5YYOfwNtNlwmBir7qOO6a7aD3o9TBu6iwRpEobVaixrfcuTn74PRP5msqGTXzT3/KYg/xawPKza6ZBnxd+V9tWk+1fHdsHW9lZVMr0dQca5IopCA6m8mpMZKCIGVi3VtUYHvGL8D5i9Y8IzCadGrqRaoku5Q/1uyBHIXyQVBlvdjjp+HqrBPpu4dVAssaF0bOjgO66r6IvKCUs6voJEJp1HFEWNZWMmMkO7Zgw9JT3UBVElmnc4Ke5UzuWOB+gQdPNc84QcM2NJTnBZ4f5V9oZd2Yqd4Qdk/ztjrqXbCk7MzGHCV+CP78Ih0XHM9UaCokQP/iv4LgA==) (I can’t get over how pretty these always look), [Rust](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfsa0dn?utm_source=share&utm_medium=web2x&context=3) 940/650, [Lua](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfsabh6?utm_source=share&utm_medium=web2x&context=3) 30/23, [Haskell](https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/gfslonr?utm_source=share&utm_medium=web2x&context=3) (wowee, look at this explanation! Well done).

Here’s the megathread for day 14:

https://www.reddit.com/r/adventofcode/comments/kcr1ct/2020_day_14_solutions/?sort=confidence

Good luck on day 15! Relatively quick, with a performance quirk in the second half. Fast access data structures are the name of this game. (edited)
