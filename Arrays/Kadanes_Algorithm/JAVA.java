public class MaximumSubarraySum {

    // Brute-Force Approach
    public static int maxSubArraySumBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // Improved Brute-Force Approach
    public static int maxSubArraySumImprovedBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // Divide and Conquer Approach
    public static int maxSubArraySumDivideConquer(int[] nums) {
        return maxSubArraySumDivideConquer(nums, 0, nums.length - 1);
    }

    private static int maxSubArraySumDivideConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int leftSum = maxSubArraySumDivideConquer(nums, left, mid);
        int rightSum = maxSubArraySumDivideConquer(nums, mid + 1, right);
        int crossingSum = maxCrossingSum(nums, left, mid, right);

        return Math.max(leftSum, Math.max(rightSum, crossingSum);
    }

    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    // Kadane's Algorithm
    public static int maxSubArraySumKadane(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int num : nums) {
            max_ending_here = Math.max(num, max_ending_here + num);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Brute-Force Approach: " + maxSubArraySumBruteForce(arr));
        System.out.println("Improved Brute-Force Approach: " + maxSubArraySumImprovedBruteForce(arr));
        System.out.println("Divide and Conquer Approach: " + maxSubArraySumDivideConquer(arr));
        System.out.println("Kadane's Algorithm: " + maxSubArraySumKadane(arr));
    }
}
