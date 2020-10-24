# FirstSetFinder
A java program to find first sets of non-terminals of productions.

> List<String> orderMaintainer does not affect correctness of the algorithm, it is used solely to maintain the order of the output.

> Recurively found for Firsts of non-terminating characters, can use Map<String, Set<Character>> for caching.

> When I started coding, I didnt think of multi-character non-terminals like 'extends', so use single character non-terminals.

> Epsilon(null) is pound(#).

> Don't keep spaces while providing the RHS in the productions. 
(good: abAB|rR|PQ|#	bad: abAB | rR | PQ | #)

> Nulls will be shown first in the output as 
ASCII('#') < ASCII(any_english_letter_or_punc), and I have used TreeSet.
