public class JumpSearch {

    // Brute force approach for jump search
    public static int jumpSearchBruteForce(int[] arr, int x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));

        for (int i = 0; i < n; i += step) {
            if (arr[i] == x) {
                return i;
            } else if (arr[i] > x) {
                for (int j = i - step; j < i; j++) {
                    if (arr[j] == x) {
                        return j;
                    }
                }
                return -1;
            }
        }

        for (int j = (n / step) * step; j < n; j++) {
            if (arr[j] == x) {
                return j;
            }
        }

        return -1;
    }

    // Optimized approach for jump search
    public static int jumpSearchOptimized(int[] arr, int x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }

        while (arr[prev] < x) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        if (arr[prev] == x) {
            return prev;
        }

        return -1;
    }

    // Example usage in a main method
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int target = 14;

        // Using the brute force approach
        int indexBrute = jumpSearchBruteForce(arr, target);
        if (indexBrute != -1) {
            System.out.println("Using brute force: Element found at index " + indexBrute);
        } else {
            System.out.println("Using brute force: Element not found in the array");
        }

        // Using the optimized approach
        int indexOptimized = jumpSearchOptimized(arr, target);
        if (indexOptimized != -1) {
            System.out.println("Using optimized solution: Element found at index " + indexOptimized);
        } else {
            System.out.println("Using optimized solution: Element not found in the array");
        }
    }
}
