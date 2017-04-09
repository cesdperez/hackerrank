package data.structures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays
 */

public class SparseArrays {

    private static Map<String, Integer> occurrences = new HashMap<>();

    public static void main(String... args) {
        Scanner scanner = new Scanner(in);

        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) addOccurrence(scanner.nextLine());

        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) printOccurrencesOf(scanner.nextLine());
    }

    private static void addOccurrence(String line) {
        if (!occurrences.containsKey(line)) {
            occurrences.put(line, 1);
            return;
        }

        Integer actualOccurrences = occurrences.get(line);
        occurrences.put(line, actualOccurrences + 1);
    }

    private static void printOccurrencesOf(String line) {
        out.println(getOccurrences((line)));
    }

    private static Integer getOccurrences(String line) {
        if (!occurrences.containsKey(line)) return 0;

        return occurrences.get(line);
    }
}
