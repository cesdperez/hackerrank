package jjava.introduction;

import java.util.Scanner;

/***********************************************************************
 * https://www.hackerrank.com/challenges/java-static-initializer-block *
 ***********************************************************************/

public class JavaStaticInitializerBlock {

    private static Scanner input = new Scanner(System.in);
    private static boolean flag = true;
    private static int B = input.nextInt();
    private static int H = input.nextInt();

    static {
        try {
            if (B <= 0 || H <= 0) {
                flag = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }//end of main
}