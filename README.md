# FirstSetFinder
A java program to find first sets of non-terminals of productions.

> List<String> orderMaintainer does not affect correctness of the algorithm, 
it is used solely to maintain the order of the output.

> Recurively asked for Firsts of non-terminating characters, 
would have included caching of those in real life scenarios using Map<String, Set<Character>>.

> I have attached screenshots of all the examples provided by MSB sir in Ch4e_Handouts.pdf 
along with the solution output-ed by my java code.

> When I started coding, I didnt think of multi-character non-terminals like 'extends',
I have substituted them with single character non-terminals in the screenshots.

> Same thing goes with dashed non-terminals (eg. E')
substituted them with the character before them (ie. E' => D) in the screenhots.

> Epsilon(null) is pound(#)

> Don't keep spaces while providing the RHS in the productions. 
(good: abAB|rR|PQ|#	bad: abAB | rR | PQ | #)

> Nulls will be shown first in the output as 
ASCII('#') < ASCII(any_english_letter_or_punc), and I have used TreeSet.
