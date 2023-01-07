import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59 };
        Map<Integer, RateInfo> rateInfoMap = new HashMap<>();
        for (int prime : primes) {
            rateInfoMap.put(prime, new RateInfo(prime));
        }

        File file = new File("resources/corncob_lowercase.txt");
        Scanner scanner = new Scanner(file);
        long total = 0;
        while (scanner.hasNextLine()) {
            String value = scanner.nextLine().trim();
            if (!value.isBlank()) {
                total++;
                for (int i = 0; i < primes.length; i++) {
                    int hashValue = hashCode(value, primes[i]);
                    rateInfoMap.get(primes[i]).addValue(hashValue);
                }
            }
        }
        scanner.close();
        System.out.println("Total number of words: " + total);
        for (int prime : primes) {
            System.out.println(
                    String.format("Collision Rate of %s : %.2f%%", prime,
                            (double) rateInfoMap.get(prime).getCollision() / total * 100));
        }
    }

    public static int hashCode(String str, int prime) {
        return hashCode(str.toCharArray(), prime);
    }

    // Self implementation of hashCode
    public static int hashCode(char[] values, int prime) {
        int h = 0;
        int length = values.length;
        for (int i = 0; i < length; i++) {
            h = prime * h + values[i];
        }
        return h;
    }
}
