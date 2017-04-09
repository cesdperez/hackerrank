package algorithms.sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

/**
 * https://www.hackerrank.com/challenges/lilys-homework
 */

public class LilysHomework {

    public static void main(String... args) {
        Integer[] original = parseInput();

        int swapsAscending = new SwapsCalculator(original, Comparator.naturalOrder()).calculate();
        int swapsDescending = new SwapsCalculator(original, Comparator.reverseOrder()).calculate();

        out.println(Math.min(swapsAscending, swapsDescending));
    }

    private static Integer[] parseInput() {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        Integer[] array = new Integer[n];

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    private static class SwapsCalculator {

        private Integer[] array;
        private Map<Integer, Integer> positions;
        Comparator<Integer> order;

        SwapsCalculator(Integer[] array, Comparator<Integer> order) {
            this.array = copyOf(array, array.length);
            this.positions = parsePositions(array);
            this.order = order;
        }

        int calculate() {
            Integer[] sorted = copyOf(array, array.length);
            sort(sorted, order);

            return calculateSwaps(array, sorted);
        }

        private Map<Integer, Integer> parsePositions(Integer[] array) {
            Map<Integer, Integer> positions = new HashMap<>(array.length);
            for (int i = 0; i < array.length; i++) {
                positions.put(array[i], i);
            }

            return positions;
        }

        private int calculateSwaps(Integer[] original, Integer[] sorted) {
            int swaps = 0;
            for (int i = 0; i < original.length; i++) {
                if (!original[i].equals(sorted[i])) {
                    swap(original, i, sorted[i], positions);
                    swaps++;
                }
            }
            return swaps;
        }

        private void swap(Integer[] array, int p, Integer element, Map<Integer, Integer> positions) {
            Integer j = positions.get(element);
            if (j == null) return;

            Integer temp = array[p];
            array[p] = element;
            array[j] = temp;

            positions.put(array[p], p);
            positions.put(array[j], j);
        }
    }
}
