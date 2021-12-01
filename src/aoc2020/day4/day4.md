# Day 4

## --- Day 4: Passport Processing ---

> You arrive at the airport only to realize that you grabbed your North Pole Credentials instead of your passport. While these documents are extremely similar, North Pole Credentials aren’t issued by a country and therefore aren’t actually valid documentation for travel in most of the world.\
> \
> It seems like you’re not the only one having problems, though; a very long line has formed for the automatic passport scanners, and the delay could upset your travel itinerary.\
> \
> Due to some questionable network security, you realize you might be able to solve both of these problems at the same time.\
> \
> The automatic passport scanners are slow because they’re having trouble detecting which passports have all required fields. The expected fields are as follows:

```
byr (Birth Year)
iyr (Issue Year)
eyr (Expiration Year)
hgt (Height)
hcl (Hair Color)
ecl (Eye Color)
pid (Passport ID)
cid (Country ID)
```

> Passport data is validated in batch files (your puzzle input). Each passport is represented as a sequence of key:value pairs separated by spaces or newlines. Passports are separated by blank lines.\
> \
> Here is an example batch file containing four passports:

```
ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
hcl:#cfa07d byr:1929

hcl:#ae17e1 iyr:2013
eyr:2024
ecl:brn pid:760753108 byr:1931
hgt:179cm

hcl:#cfa07d eyr:2025 pid:166559648
iyr:2011 ecl:brn hgt:59in
```

> The first passport is valid - all eight fields are present. The second passport is invalid - it is missing hgt (the Height field).\
> \
> The third passport is interesting; the only missing field is cid, so it looks like data from North Pole Credentials, not a passport at all! Surely, nobody would mind if you made the system temporarily ignore missing cid fields. Treat this “passport” as valid.\
> \
> The fourth passport is missing two fields, cid and byr. Missing cid is fine, but missing any other field is not, so this passport is invalid.\
> \
> According to the above rules, your improved system would report 2 valid passports.\
> \
> Count the number of valid passports - those that have all required fields. Treat cid as optional. In your batch file, how many passports are valid?

The input complexity went up a little bit for this day, and that’s where it seems most of the problem came from (that and having a series of validations). So, it’s completely unsurprising to have a multitude of solutions like these in [Regex](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gekmj50?utm_source=share&utm_medium=web2x&context=3) ([Another](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gelrhke?utm_source=share&utm_medium=web2x&context=3)), [Shell & Regex](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gekf1pd?utm_source=share&utm_medium=web2x&context=3), and this [Horrifying Javascript Solution](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gekfzj6?utm_source=share&utm_medium=web2x&context=3) :scream:.

And then of course the creative solutions like these in [Emojicode](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/geks5ia?utm_source=share&utm_medium=web2x&context=3), [Apple Shortcuts](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gekw741?utm_source=share&utm_medium=web2x&context=3), and [Excel](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gem5gln?utm_source=share&utm_medium=web2x&context=3).
Finally, some honest to goodness solutions in [Functional Javascript](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gemknb2?utm_source=share&utm_medium=web2x&context=3), [Haskell](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gemeo8v?utm_source=share&utm_medium=web2x&context=3), [Elixir](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gem63m3?utm_source=share&utm_medium=web2x&context=3), [C#](https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gekzbux?utm_source=share&utm_medium=web2x&context=3), and [Clojure](https://www.reddit.com/r/Clojure/comments/k6uuqv/advent_of_code_day_4_in_clojure_intro_to_clojure/?utm_source=share&utm_medium=web2x&context=3) (video walkthrough)

Here’s the megathread for the day:

https://www.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/?sort=top

Good luck on day 5! (edited)
