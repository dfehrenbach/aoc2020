# Day 22

https://adventofcode.com/2020/day/22

## --- Day 22: Crab Combat ---

> It only takes a few hours of sailing the ocean on a raft for boredom to sink in. Fortunately, you brought a small deck of space cards! You’d like to play a game of Combat, and there’s even an opponent available: a small crab that climbed aboard your raft before you left.\
> \
> Fortunately, it doesn’t take long to teach the crab the rules.\
> \
> Before the game starts, split the cards so each player has their own deck (your puzzle input). Then, the game consists of a series of rounds: both players draw their top card, and the player with the higher-valued card wins the round. The winner keeps both cards, placing them on the bottom of their own deck so that the winner’s card is above the other card. If this causes a player to have all of the cards, they win, and the game ends.\
> \
> For example, consider the following starting decks:

```
Player 1:
9
2
6
3
1

Player 2:
5
8
4
7
10
```

> This arrangement means that player 1's deck contains 5 cards, with 9 on top and 1 on the bottom; player 2's deck also contains 5 cards, with 5 on top and 10 on the bottom.\
> \
> The first round begins with both players drawing the top card of their decks: 9 and 5. Player 1 has the higher card, so both cards move to the bottom of player 1's deck such that 9 is above 5. In total, it takes 29 rounds before a player has all of the cards:

```
-- Round 1 --
Player 1's deck: 9, 2, 6, 3, 1
Player 2's deck: 5, 8, 4, 7, 10
Player 1 plays: 9
Player 2 plays: 5
Player 1 wins the round!

-- Round 2 --
Player 1's deck: 2, 6, 3, 1, 9, 5
Player 2's deck: 8, 4, 7, 10
Player 1 plays: 2
Player 2 plays: 8
Player 2 wins the round!

-- Round 3 --
Player 1's deck: 6, 3, 1, 9, 5
Player 2's deck: 4, 7, 10, 8, 2
Player 1 plays: 6
Player 2 plays: 4
Player 1 wins the round!

-- Round 4 --
Player 1's deck: 3, 1, 9, 5, 6, 4
Player 2's deck: 7, 10, 8, 2
Player 1 plays: 3
Player 2 plays: 7
Player 2 wins the round!

-- Round 5 --
Player 1's deck: 1, 9, 5, 6, 4
Player 2's deck: 10, 8, 2, 7, 3
Player 1 plays: 1
Player 2 plays: 10
Player 2 wins the round!
```

> ...several more rounds pass...\

```
-- Round 27 --
Player 1's deck: 5, 4, 1
Player 2's deck: 8, 9, 7, 3, 2, 10, 6
Player 1 plays: 5
Player 2 plays: 8
Player 2 wins the round!

-- Round 28 --
Player 1's deck: 4, 1
Player 2's deck: 9, 7, 3, 2, 10, 6, 8, 5
Player 1 plays: 4
Player 2 plays: 9
Player 2 wins the round!

-- Round 29 --
Player 1's deck: 1
Player 2's deck: 7, 3, 2, 10, 6, 8, 5, 9, 4
Player 1 plays: 1
Player 2 plays: 7
Player 2 wins the round!

== Post-game results ==
Player 1's deck:
Player 2's deck: 3, 2, 10, 6, 8, 5, 9, 4, 7, 1
```

> Once the game ends, you can calculate the winning player’s score. The bottom card in their deck is worth the value of the card multiplied by 1, the second-from-the-bottom card is worth the value of the card multiplied by 2, and so on. With 10 cards, the top card is worth the value on the card multiplied by 10. In this example, the winning player’s score is:

```
  3  * 10
+ 2  * 9
+ 10 * 8
+ 6  * 7
+ 8  * 6
+ 5  * 5
+ 9  * 4
+ 4  * 3
+ 7  * 2
+ 1  * 1
= 306
```

> So, once the game ends, the winning player’s score is 306.\
> \
> Play the small crab in a game of Combat using the two decks you just dealt. What is the winning player’s score?

Fun day for a good recursive problem! Also turns out that there was some game theory involved. You’d be remiss to not check out the first awesome solution in this list! :smile:.

First the fun: [Vim Keystrokes](https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/ggpalhj?utm_source=share&utm_medium=web2x&context=3) YUP (there’s also an animation of part1 which is REALLY COOL), [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/ggo29gl?utm_source=share&utm_medium=web2x&context=3) 276/410

And then the awesome: [Python](https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/ggpcsnd?utm_source=share&utm_medium=web2x&context=3) (AWESOME game theory and proof by contradiction to handle some optimization. Super cool read), [Python](https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/ggnz1l4?utm_source=share&utm_medium=web2x&context=3) 454/29, [Javascript](https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/ggnz3xj?utm_source=share&utm_medium=web2x&context=3) 107/35, [Rust](https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/ggq1jdc?utm_source=share&utm_medium=web2x&context=3) (very fast and with bit-shift arithmetic… woah, a bit extensive and convoluted, but still impressive), [Golang](https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/ggo7hng?utm_source=share&utm_medium=web2x&context=3), [Python](https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/ggpz074?utm_source=share&utm_medium=web2x&context=3) (yep, more fast and clever python. Good thread underneath), [Clojure](https://github.com/rjray/advent-2020-clojure/blob/master/src/advent_of_code/day22.clj) (looks pretty similar to mine! :D), [Haskell](https://topaz.github.io/paste/#XQAAAQBRBgAAAAAAAAA2m8ixrhLu7YJFrd2FLde+PAG1Aui2yN36LCvqT8ZOJmqbLYgEC+r5NdsR9rXyndqRCa8KaADJLTU5fqu1ReVKfyP1B2BlbNqE5ATplEHjS7HXCrfsw8VcuCtzc6sQ3Xt4XIAHCiVDJVCO56VQJIs50yG8Fx0dd+oQU4m/fC61YwGLE7PmAbN1MH8XGNezER87NMOXzi79p/AEWft5fWslMTwhBkPQZ6SSOjgpeHJOJ7Pwo8OULbDiMpC8dyNxCXkKylkNs9bg7udZATGOHHbj1bGbr6QbgmYAp0SrDus+ih8RruW81VGm1EQLi9O692nrXRpM3FQVcgnWQi6s2iLoZ9W1QsWawY6dF36XP6g8Q4/8JSc0fNB+isP0wGijJMV97xGcRWGKRnxMD8V7NFOYOdGV1NxOS5OdAQblZ/1/14eqPYaVtty+1BOtVjbDqJeREAJLO1GFB+jszXdx8SLnaL249I0sKPKyK8JF1XYIngt6dAkaX9mpachb74oCCA+knYLth2b35lWwJPL0Xvrx4JaLjIj8V5LwrNkiXD5ZLM1anSEIhfK9RfAcXG/R6nufVjr6gjgWiyct/Nz45cpi9QUTkTwCKeCbtwlNsFgzgpcXJnhIYH7Kn8CRrGT3ESmBxiNSFTped/ZhjyeUMBGm45yADoPW2RxbGTmhpIphffXuMMzk4Scw4t8pP3cGsW/LhpBvb1kRXaapjmbB6FLGEjqLA93/D6ozIn4jUkpN+uNbMkTULcueD1C1sDvzuqljo+hr1H2I72+yS1nCa/cyC+nVzJxF8e5uPsNm+tXWRcIom4I32Dqqspv86+ubTxihRzaTopRTH24De1wgsjuZkDNDncEU8sbS3MYg+2Hn7o4/GgcrEOrAnv+3izCUpAkcfuZZ1v77NUHy)

There’s some other great solutions in here, so check out the megathread:

https://www.reddit.com/r/adventofcode/comments/khyjgv/2020_day_22_solutions/?sort=confidence

Good luck on day 23! (edited)
