# Dutch National Flag Algorithm

The **Dutch National Flag Algorithm**, also known as the **3-way partitioning quicksort** or the **three-way partitioning algorithm**, is a sorting algorithm designed to efficiently sort an array containing only three distinct elements or values, such as red, white, and blue. It was originally developed by Dutch computer scientist Edsger Dijkstra and is particularly useful for sorting problems with limited distinct keys. The algorithm is often used in cases like sorting colors or categorizing items into three groups.

## Algorithm Overview

The intuition behind the Dutch National Flag Algorithm is to partition the array into three sections, each representing one of the distinct elements. The goal is to rearrange the elements in such a way that all elements of the first type come first, followed by all elements of the second type, and finally, all elements of the third type.

### Step-by-Step Explanation

1. Initialize three pointers:
   - `low` points to the first element of the array (initially 0).
   - `mid` points to the first element that is yet to be categorized (initially 0).
   - `high` points to the last element of the array (initially `n-1`, where `n` is the size of the array).

2. Traverse the array using the `mid` pointer, which keeps track of the unprocessed elements, until `mid` is less than or equal to `high`:

    a. If the element at `mid` is of the first type, swap it with the element at the `low` position, and increment both `low` and `mid` pointers.

    b. If the element at `mid` is of the second type, leave it in place and increment the `mid` pointer.

    c. If the element at `mid` is of the third type, swap it with the element at the `high` position, and decrement the `high` pointer. This step ensures that all elements of the third type are moved to the end of the array.

3. Continue this process until `mid` becomes greater than `high`. At this point, the array will be partitioned into three sections, with all elements of the first type to the left, all elements of the second type in the middle, and all elements of the third type to the right.

## Efficiency

The Dutch National Flag Algorithm is efficient because it only requires a single pass through the array, making it a linear-time sorting algorithm. It is particularly useful when sorting an array with a small number of distinct elements, as it avoids redundant comparisons and swaps. This makes it a valuable tool for various sorting and categorization tasks.
