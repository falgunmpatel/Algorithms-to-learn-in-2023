public class SieveOfEratosthenes {
    public static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }

    public static void main(String[] args) {
        int limit = 50; // You can change this to the desired limit
        List<Integer> primeNumbers = sieve(limit);

        System.out.print("Prime numbers up to " + limit + " are: ");
        for (int prime : primeNumbers) {
            System.out.print(prime + " ");
        }
    }
}
