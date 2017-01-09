package jjava.introduction;

import java.util.Scanner;

/**********************************************************
 * https://www.hackerrank.com/challenges/java-end-of-file *
 **********************************************************/

public class JavaEndOfLine {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNext()) {
            System.out.println(String.format("%s %s", ++i, scanner.nextLine()));
        }
    }
}