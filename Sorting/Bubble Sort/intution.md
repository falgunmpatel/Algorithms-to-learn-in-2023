# Bubble Sort in Java

Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The algorithm continues to do this until no more swaps are needed, which indicates that the list is sorted. It is not the most efficient sorting algorithm but is often used for educational purposes due to its simplicity.

## How Bubble Sort Works

The basic idea behind Bubble Sort can be summarized in the following steps:

1. **Repeatedly Compare and Swap**: Start at the beginning of the list. Compare the first two elements, and if they are in the wrong order (e.g., the first is greater than the second), swap them. Move to the next pair of elements, and continue this process until you reach the end of the list.

2. **Repeat**: After the first pass, the largest element will have "bubbled up" to the end of the list. Repeat the process for the remaining unsorted elements, excluding the last one (since it's already in its correct position).

3. **Continue Until Sorted**: Keep repeating this process, excluding one more element from the end each time, until the entire list is sorted. The largest elements will continue to "bubble up" to their correct positions.

## Java Code Example

Here's a simple Java implementation of the Bubble Sort algorithm:

```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no two elements were swapped in inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}


 * Average case = O(n^2)<br>
 * Worst case = O(n^2)<br>
 * Best case = O(n)<br>
