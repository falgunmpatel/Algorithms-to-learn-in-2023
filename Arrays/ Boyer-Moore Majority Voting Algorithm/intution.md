# Boyer-Moore Voting Algorithm

## Overview

The Boyer-Moore Voting Algorithm is a clever technique used to find the majority element in a sequence of elements. This algorithm is incredibly efficient, with a linear runtime complexity, making it a popular choice for practical applications. It's based on the intuition that if a majority element exists, it will eventually dominate other elements when canceled out one by one.

## Major Element Search

Suppose you have a sequence of elements, and you want to find the majority element (an element that appears more than n/2 times, where n is the length of the sequence).

## Intuition

The key idea behind the Boyer-Moore Voting Algorithm is to keep track of a candidate element and a count. Initially, we assume the first element is the majority element and set the count to 1.

As we traverse the sequence, we compare the current element with the candidate:

- If they are the same, we increment the count.
- If they are different, we decrement the count.

The magic happens when the count reaches zero. When the count becomes zero, we discard the current candidate and select the current element as the new candidate. This is because if a majority element exists in the sequence, it will eventually outnumber all other elements.

## Voting Process

1. Initialize a candidate and a count.
2. Iterate through the sequence:
   - If the count is zero, update the candidate and set the count to 1.
   - If the current element is the same as the candidate, increment the count. Otherwise, decrement the count.
3. After the iteration, the candidate will hold the majority element.

## Example

Let's walk through an example to illustrate the algorithm:

Sequence: [3, 3, 4, 2, 4, 4, 2, 4, 4]

1. Initialize candidate as 3 and count as 1.
2. Iterate through the sequence:
   - 3 (current) == 3 (candidate) -> Increment count to 2.
   - 3 (current) == 3 (candidate) -> Increment count to 3.
   - 4 (current) != 3 (candidate) -> Decrement count to 2.
   - 2 (current) != 3 (candidate) -> Decrement count to 1.
   - 4 (current) != 3 (candidate) -> Decrement count to 0. Candidate becomes 2 (current).
   - 4 (current) != 2 (candidate) -> Decrement count to -1. Candidate becomes 4 (current).
   - 2 (current) != 4 (candidate) -> Decrement count to 0. Candidate becomes 2 (current).
   - 4 (current) != 2 (candidate) -> Decrement count to -1. Candidate becomes 4 (current).
   - 4 (current) == 4 (candidate) -> Increment count to 1.
3. The final candidate is 4, which is the majority element in the sequence.

## Conclusion

The Boyer-Moore Voting Algorithm is an elegant and efficient way to find the majority element in a sequence by cleverly canceling out elements that are not the majority. It demonstrates a strong intuition for tackling majority problems.
