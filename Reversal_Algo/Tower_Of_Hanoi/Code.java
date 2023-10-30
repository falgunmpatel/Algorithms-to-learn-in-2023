public class TowerOfHanoi {

    // Brute Force Approach
    public static void towerOfHanoi(int n, char source, char target, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        towerOfHanoi(n - 1, source, auxiliary, target);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        towerOfHanoi(n - 1, auxiliary, target, source);
    }

    // Optimized Approach
    public static void towerOfHanoiOptimized(int n, char source, char target, char auxiliary) {
        if (n > 0) {
            towerOfHanoiOptimized(n - 1, source, auxiliary, target);
            System.out.println("Move disk " + n + " from " + source + " to " + target);
            towerOfHanoiOptimized(n - 1, auxiliary, target, source);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks

        System.out.println("Brute Force Approach:");
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B, and C are rod names

        System.out.println("\nOptimized Approach:");
        towerOfHanoiOptimized(n, 'A', 'C', 'B');
    }
}
