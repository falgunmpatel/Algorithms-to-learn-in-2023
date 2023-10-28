public class Subarraysum {

    // Function to find a subarray with a given sum
    public static int[] findSubarraySum(int[] arr, int targetSum) {
        int left = 0;
        int right = 0;
        int currentSum = 0;

        while (right < arr.length) {
            currentSum += arr[right];

            while (currentSum > targetSum) {
                currentSum -= arr[left];
                left++;
            }

            if (currentSum == targetSum) {
                // Subarray found, return it
                int[] subarray = new int[right - left + 1];
                System.arraycopy(arr, left, subarray, 0, right - left + 1);
                return subarray;
            }

            right++;
        }

        // If no subarray is found with the targetSum
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int targetSum = 9;

        int[] result = findSubarraySum(arr, targetSum);

        if (result.length > 0) {
            System.out.print("Subarray with sum " + targetSum + ": ");
            for (int num : result) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("No subarray found with the target sum.");
        }
    }
}
