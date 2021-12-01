# Day 8:

## --- Day 8: Handheld Halting ---

> Your flight to the major airline hub reaches cruising altitude without incident. While you consider checking the in-flight menu for one of those drinks that come with a little umbrella, you are interrupted by the kid sitting next to you.\
> \
> Their [handheld game console](https://en.wikipedia.org/wiki/Handheld_game_console) won't turn on! They ask if you can take a look.\
> \
> You narrow the problem down to a strange infinite loop in the boot code (your puzzle input) of the device. You should be able to fix it, but first you need to be able to run the code in isolation.\
> \
> The boot code is represented as a text file with one instruction per line of text. Each instruction consists of an operation (`acc`, `jmp`, or `nop`) and an argument (a signed number like `+4` or `-20`).\
> \
> `acc` increases or decreases a single global value called the accumulator by the value given in the argument. For example, `acc +7` would increase the accumulator by 7. The accumulator starts at 0. After an `acc` instruction, the instruction immediately below it is executed next.\
> \
> `jmp` jumps to a new instruction relative to itself. The next instruction to execute is found using the argument as an offset from the `jmp` instruction; for example, `jmp +2` would skip the next instruction, `jmp +1` would continue to the instruction immediately below it, and `jmp -20` would cause the instruction 20 lines above to be executed next.\
> \
> `nop` stands for No OPeration - it does nothing. The instruction immediately below it is executed next.\
> \
> For example, consider the following program:

```
nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6
```

> These instructions are visited in this order:

```
nop +0  | 1
acc +1  | 2, 8(!)
jmp +4  | 3
acc +3  | 6
jmp -3  | 7
acc -99 |
acc +1  | 4
jmp -4  | 5
acc +6  |
```

> First, the `nop +0` does nothing. Then, the accumulator is increased from 0 to 1 (`acc +1`) and `jmp +4` sets the next instruction to the other `acc +1` near the bottom. After it increases the accumulator from 1 to 2, `jmp -4` executes, setting the next instruction to the only `acc +3`. It sets the accumulator to 5, and `jmp -3` causes the program to continue back at the first `acc +1`.\
> \
> This is an infinite loop: with this sequence of jumps, the program will run forever. The moment the program tries to run any instruction a second time, you know it will never terminate.\
> \
> Immediately before the program would run an instruction a second time, the value in the accumulator is `5`.\
> \
> Run your copy of the boot code. Immediately before any instruction is executed a second time, what value is in the accumulator?

Day 8 sees a gentle return to some form of instruction interpreter. We might see more of these, but this one was pretty fun. It seems the community drew inspiration from the "computer-like" form that the problem took. Check these funky and creative solutions out: [BBC Basic / 6502 assembler as UEF cassette tape (yep)](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf5nwwa?utm_source=share&utm_medium=web2x&context=3), [VIM](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf1a2cd?utm_source=share&utm_medium=web2x&context=3), [Emojicode](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf163wp?utm_source=share&utm_medium=web2x&context=3), [Bash](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf12dul?utm_source=share&utm_medium=web2x&context=3), [Excel](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf2god2?utm_source=share&utm_medium=web2x&context=3), [AWK](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf11e00?utm_source=share&utm_medium=web2x&context=3), and [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf0zxih?utm_source=share&utm_medium=web2x&context=3).

As for the impressive ones, there was definitely some smarter ways to get to solution especially on the second half. I happened to just trim possibilities and force the rest (since it wasn't penalized with ridiculous run times). Check out these, especially the first one, that explains a way more efficient logical way to have done it: [Rust](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf1du97?utm_source=share&utm_medium=web2x&context=3), [Python](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf1du97?utm_source=share&utm_medium=web2x&context=3) (21/6) (not immediately readable, but impressive anyway!), [Ruby](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf0zdyb?utm_source=share&utm_medium=web2x&context=3) (6/2) (same deal as last, and forced, but still impressive), [Julia](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf1dchr?utm_source=share&utm_medium=web2x&context=3) (reportedly very fast), [Swift](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf11qt3?utm_source=share&utm_medium=web2x&context=3), [Java](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf1a0ox?utm_source=share&utm_medium=web2x&context=3), [Go/Golang](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf17a3f?utm_source=share&utm_medium=web2x&context=3), [Haskell](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf3ooml?utm_source=share&utm_medium=web2x&context=3) (in fact, there are a ton of GREAT Haskell solutions to this day. Some are over engineering to prep for extensions of this problem in the future. Great explanations and some have live casts), and [Clojure](https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/gf14qd6?utm_source=share&utm_medium=web2x&context=3).

Hope you all enjoyed. I'm looking forward to Day 9 solutions that aren't forced or use some intelligent data structures.

Here's the megathread for day 8:

https://www.reddit.com/r/adventofcode/comments/k8xw8h/2020_day_08_solutions/?sort=confidence (edited)
