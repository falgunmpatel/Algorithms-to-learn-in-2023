public class TwoPointersAlgorithm {

    public static int[] findPairWithSum(int[] nums, int target) {
        int left = 0; // Pointer starting from the beginning of the array
        int right = nums.length - 1; // Pointer starting from the end of the array

        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                // We found a pair with the target sum
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                // If the current sum is less than the target, move the left pointer to the right
                left++;
            } else {
                // If the current sum is greater than the target, move the right pointer to the left
                right--;
            }
        }

        // If no such pair is found, return null or an appropriate result
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 11, 15};
        int target = 9;

        int[] result = findPairWithSum(nums, target);

        if (result != null) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found with the given sum.");
        }
    }
}
