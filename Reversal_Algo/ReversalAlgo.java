public class ArrayRotation {
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n; // To handle the case when d is greater than the array length

        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2; // Number of positions to rotate

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        leftRotate(arr, d);

        System.out.println("\nArray after left rotation by " + d + " positions:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
