# Day25

https://adventofcode.com/2020/day/25

## --- Day 25: Combo Breaker ---

> You finally reach the check-in desk. Unfortunately, their registration systems are currently offline, and they cannot check you in. Noticing the look on your face, they quickly add that tech support is already on the way! They even created all the room keys this morning; you can take yours now and give them your room deposit once the registration system comes back online.\
> \
> The room key is a small [RFID](https://en.wikipedia.org/wiki/Radio-frequency_identification) card. Your room is on the 25th floor and the elevators are also temporarily out of service, so it takes what little energy you have left to even climb the stairs and navigate the halls. You finally reach the door to your room, swipe your card, and - beep - the light turns red.\
> \
> Examining the card more closely, you discover a phone number for tech support.\
> \
> “Hello! How can we help you today?” You explain the situation.\
> \
> “Well, it sounds like the card isn’t sending the right command to unlock the door. If you go back to the check-in desk, surely someone there can reset it for you.” Still catching your breath, you describe the status of the elevator and the exact number of stairs you just had to climb.\
> \
> “I see! Well, your only other option would be to reverse-engineer the cryptographic handshake the card does with the door and then inject your own commands into the data stream, but that’s definitely impossible.” You thank them for their time.\
> \
> Unfortunately for the door, you know a thing or two about cryptographic handshakes.\
> \
> The handshake used by the card and the door involves an operation that transforms a subject number. To transform a subject number, start with the value 1. Then, a number of times called the loop size, perform the following steps:
>
> - Set the value to itself multiplied by the subject number.
> - Set the value to the remainder after dividing the value by `20201227`.

> The card always uses a specific, secret loop size when it transforms a subject number. The door always uses a different, secret loop size.\
> \
> The cryptographic handshake works like this:
>
> - The card transforms the subject number of `7` according to the card’s secret loop size. The result is called the card’s public key.
> - The door transforms the subject number of `7` according to the door’s secret loop size. The result is called the door’s public key.
> - The card and door use the wireless RFID signal to transmit the two public keys (your puzzle input) to the other device. Now, the card has the door’s public key, and the door has the card’s public key. Because you can eavesdrop on the signal, you have both public keys, but neither device’s loop size.
> - The card transforms the subject number of the door’s public key according to the card’s loop size. The result is the encryption key.
> - The door transforms the subject number of the card’s public key according to the door’s loop size. The result is the same encryption key as the card calculated.

> If you can use the two public keys to determine each device’s loop size, you will have enough information to calculate the secret encryption key that the card and door use to communicate; this would let you send the `unlock` command directly to the door!\
> \
> For example, suppose you know that the card’s public key is `5764801`. With a little trial and error, you can work out that the card’s loop size must be 8, because transforming the initial subject number of `7` with a loop size of 8 produces `5764801`.\
> \
> Then, suppose you know that the door’s public key is `17807724`. By the same process, you can determine that the door’s loop size is `11`, because transforming the initial subject number of `7` with a loop size of `11` produces `17807724`.\
> \
> At this point, you can use either device’s loop size with the other device’s public key to calculate the encryption key. Transforming the subject number of `17807724` (the door’s public key) with a loop size of `8` (the card’s loop size) produces the encryption key, `14897079`. (Transforming the subject number of `5764801` (the card’s public key) with a loop size of `11` (the door’s loop size) produces the same encryption key: `14897079`.)\
> \
> What encryption key is the handshake trying to establish?

Some good little bit of cryptography and math to finish off the advent calendar. The fastest times made this one very short and finished in only a couple of lines. Seems like the problem took longer to read and understand than to program. This is consistent with Day 25 usually being an easier one to finish. Merry Christmas again, all!

Here’s the fun: [Mathematica](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggysahy?utm_source=share&utm_medium=web2x&context=3) (in two lines?!), [Mathematica](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggyv3do?utm_source=share&utm_medium=web2x&context=3) (another! and with a poem), [Dyalog APL](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggysh1k?utm_source=share&utm_medium=web2x&context=3) 395/315, [Golfed Javascript](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/gh12d13?utm_source=share&utm_medium=web2x&context=3)

And the awesome: [Python](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggyvnnj?utm_source=share&utm_medium=web2x&context=3) 36/33 (very clean and very fast), [Python](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggyrb6s?utm_source=share&utm_medium=web2x&context=3) 17/15, [Python](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggyrmun?utm_source=share&utm_medium=web2x&context=3) 325/273 (with a host of animations for a multitude of days in the comments! very cool), [Python](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggysxy3?utm_source=share&utm_medium=web2x&context=3) (5 lines)… And a whole host of other python solutions!, [Haskell](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggz4pqd?utm_source=share&utm_medium=web2x&context=3) (with a quick note on “until”), [Rust](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/gh084p5?utm_source=share&utm_medium=web2x&context=3) (with the record of all their daily runtimes. Geez Rust is FAST :ultrafastparrot: ), [Clojure](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggyrt73?utm_source=share&utm_medium=web2x&context=3) 232/202, [Ruby](https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/ggyspxo?utm_source=share&utm_medium=web2x&context=3) 616/518

See what else you can find at the megathread here:

https://www.reddit.com/r/adventofcode/comments/kjtg7y/2020_day_25_solutions/?sort=confidence

AND THAT’S IT!

Apparently the creator and some of the top scorers in the year were giving an AMA at https://www.twitch.tv/ecnerwala. I think this might be a fun thing to check out. Merry Christmas, Happy Holidays, and a Happy Near Year :new_year: everyone! (edited)
