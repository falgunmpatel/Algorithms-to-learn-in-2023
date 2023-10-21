
## Basic Binary Search

The basic binary search algorithm introduces a significant optimization by taking advantage of the sorted nature of the collection. It follows the following steps:

1. Start with a sorted collection.
2. Define two pointers, `left` and `right`, initially pointing to the beginning and end of the collection.
3. Calculate the middle index as `(left + right) / 2`.
4. Compare the middle element to the target.

    - If the middle element is equal to the target, you've found it.
    - If the middle element is greater than the target, adjust `right` to `mid - 1` and search in the left subarray.
    - If the middle element is less than the target, adjust `left` to `mid + 1` and search in the right subarray.

5. Repeat steps 3 and 4 until `left` is less than or equal to `right`.
6. If the target is not found, it does not exist in the collection.

Basic binary search has a time complexity of O(log n).

## Optimized Binary Search

Optimized binary search further refines the algorithm to avoid potential issues with integer overflow and provides a cleaner implementation. Here's an optimized version:

1. Start with a sorted collection.
2. Define two pointers, `left` and `right`, initially pointing to the beginning and end of the collection.
3. While `left` is less than or equal to `right`:

   a. Calculate the middle index as `left + (right - left) / 2` to avoid integer overflow.

   b. Compare the middle element to the target.

    - If the middle element is equal to the target, you've found it.
    - If the middle element is greater than the target, adjust `right` to `mid - 1` and search in the left subarray.
    - If the middle element is less than the target, adjust `left` to `mid + 1` and search in the right subarray.

4. If the target is not found, it does not exist in the collection.

This optimized binary search retains the O(log n) time complexity and is more robust in the face of large input data.

Binary search is a fundamental algorithm, and understanding its evolution from a brute force approach to an optimized solution is essential for algorithmic problem-solving.
