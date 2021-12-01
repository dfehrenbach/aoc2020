# Day 21

https://adventofcode.com/2020/day/21

## --- Day 21: Allergen Assessment ---

> You reach the train’s last stop and the closest you can get to your vacation island without getting wet. There aren’t even any boats here, but nothing can stop you now: you build a raft. You just need a few days’ worth of food for your journey.\
> \
> You don’t speak the local language, so you can’t read any ingredients lists. However, sometimes, allergens are listed in a language you do understand. You should be able to use this information to determine which ingredient contains which allergen and work out which foods are safe to take with you on your trip.\
> \
> You start by compiling a list of foods (your puzzle input), one food per line. Each line includes that food’s ingredients list followed by some or all of the allergens the food contains.\
> \
> Each allergen is found in exactly one ingredient. Each ingredient contains zero or one allergen. Allergens aren’t always marked; when they’re listed (as in `(contains nuts, shellfish)` after an ingredients list), the ingredient that contains each listed allergen will be somewhere in the corresponding ingredients list. However, even if an allergen isn’t listed, the ingredient that contains that allergen could still be present: maybe they forgot to label it, or maybe it was labeled in a language you don’t know.\
> \
> For example, consider the following list of foods:

```
mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
trh fvjkl sbzzf mxmxvkd (contains dairy)
sqjhc fvjkl (contains soy)
sqjhc mxmxvkd sbzzf (contains fish)
```

> The first food in the list has four ingredients (written in a language you don’t understand): `mxmxvkd`, `kfcds`, `sqjhc`, and `nhms`. While the food might contain other allergens, a few allergens the food definitely contains are listed afterward: `dairy` and `fish`.\
> \
> The first step is to determine which ingredients can’t possibly contain any of the allergens in any food in your list. In the above example, none of the ingredients `kfcds`, `nhms`, `sbzzf`, or `trh` can contain an allergen. Counting the number of times any of these ingredients appear in any ingredients list produces 5: they all appear once each except sbzzf, which appears twice.\
> \
> Determine which ingredients cannot possibly contain any of the allergens in your list. How many times do any of those ingredients appear?

A good set theory puzzle! I haven’t started on it yet, because I’m still fishing out sea monsters in between wrapping presents, but it seems like the day has had a good reception :slightly_smiling_face:.

Starting with the interesting: [AWK](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggl3niq?utm_source=share&utm_medium=web2x&context=3), [JQ](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggma4yi?utm_source=share&utm_medium=web2x&context=3) (wow!), [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggk836o?utm_source=share&utm_medium=web2x&context=3) 54/62 (I think this person might actually be a wizard), [Excel](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggka4qv?utm_source=share&utm_medium=web2x&context=3) (probably a better solution out there, but impressive anyway), [Prolog](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggki20x?utm_source=share&utm_medium=web2x&context=3), [Matlab](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggkavor?utm_source=share&utm_medium=web2x&context=3), [Matlab](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggkfwkl?utm_source=share&utm_medium=web2x&context=3)

And then the awesome: [Python](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggkh6nh?utm_source=share&utm_medium=web2x&context=3) 15/6, [Python](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggk50fa?utm_source=share&utm_medium=web2x&context=3) 7/27, [Haskell](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggk8s0t?utm_source=share&utm_medium=web2x&context=3), [Clojure](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggkm0vv?utm_source=share&utm_medium=web2x&context=3), [Haskell 533/536 & Python & Kotlin & Rust](https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/ggkvn29?utm_source=share&utm_medium=web2x&context=3)

Here’s the megathread for the day:

https://www.reddit.com/r/adventofcode/comments/khaiyk/2020_day_21_solutions/?sort=confidence

Have fun with day 22! (edited)
