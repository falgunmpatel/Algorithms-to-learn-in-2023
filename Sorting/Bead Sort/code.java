public class BeadSort {
    public static void beadSort(int[] a)
    {
        // Find the maximum element
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // allocating memory
        int[][] beads = new int[a.length][max];

        // mark the beads
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i]; j++) {
                beads[i][j] = 1;
            }
        }

        // move down the beads
        for (int j = 0; j < max; j++) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += beads[i][j];
                beads[i][j] = 0;
            }

            for (int i = a.length - 1; i >= a.length - sum;
                 i--) {
                a[i] = j + 1;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] a = { 4, 2, 6, 1, 8 };
        beadSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}