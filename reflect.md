## Reflection on Week 04

This week I will say was a little bit more messy than usual. I had some family even through out the last week, in which I lost some time to work on both the last and this assigment. However, I think I did pretty well still on this assignment.

The first thing I wanted to point out was minor: consolidating variable assignments. In the `add` method, the week before I assigned tail twice in the method. However, this week I noticed that I could clean up that method specifically by only assigning `tail` once.

The next thing, which is more of a coding style problem, was how I wanted to impliment compareTo. At first, I wanted to compare them lexicographically, like we went over in class. However, I ran into a problem converting ASCII characters to integers consistently, adn would then in turn, consistently fail that specific test. As a consequence, I decided to implement it in the same way as the solution showed, comparing their sizes rather than their alphabetical order.

Last, but not least - my toString method was a mess. It was a last minute addition riddled with magic values and lacking comments to explain my thinking. In the future (especially in assignment 5) I will make sure this doesn't happen again, as this was due to me being in a rush.
