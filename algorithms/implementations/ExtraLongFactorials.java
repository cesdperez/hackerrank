package algorithms.implementations;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials
 */

public class ExtraLongFactorials {

    public static void main(String... args) {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();

        out.println(factorial(n));
    }

    private static BigInteger factorial(int n) {
        BigInteger f = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }

        return f;
    }
}
