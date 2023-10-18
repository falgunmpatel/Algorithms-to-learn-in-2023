import java.util.*;
public class DutchNationalFlag {
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap the element at 'low' with the element at 'mid'
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // No swap needed, just move the 'mid' pointer
                mid++;
            } else {
                // Swap the element at 'mid' with the element at 'high'
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
