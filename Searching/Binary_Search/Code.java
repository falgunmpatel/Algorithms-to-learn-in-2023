import java.util.Arrays;

public class BinarySearchEvolution {
    // Brute Force Approach (O(n))
    public static int bruteForceSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Target not found
    }

    // Basic Binary Search (O(log n))
    public static int basicBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // Target not found
    }

    // Optimized Binary Search (O(log n)
    public static int optimizedBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;

        // Brute Force
        int bruteForceResult = bruteForceSearch(sortedArray, target);
        System.out.println("Brute Force Result: " + bruteForceResult);

        // Basic Binary Search
        int basicBinaryResult = basicBinarySearch(sortedArray, target);
        System.out.println("Basic Binary Search Result: " + basicBinaryResult);

        // Optimized Binary Search
        int optimizedBinaryResult = optimizedBinarySearch(sortedArray, target);
        System.out.println("Optimized Binary Search Result: " + optimizedBinaryResult);
    }
}
