package jjava.strings;

import java.util.Scanner;

/****************************************************
 * https://www.hackerrank.com/challenges/java-regex *
 ****************************************************/

public class JavaRegex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex {

    private String _0to255 = "([01]?\\d\\d?|" +
            "2[0-4]\\d|" +
            "25[0-5])";

    String pattern = String.format("^%s\\.%s\\.%s\\.%s",_0to255,_0to255,_0to255,_0to255);

}