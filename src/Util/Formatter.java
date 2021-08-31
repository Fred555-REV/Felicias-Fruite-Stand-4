package Util;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Formatter {
    public static String getDisplayPrice(int price) {
        return NumberFormat.getCurrencyInstance().format(price / 100.0);
    }

    public static void test() {
        Scanner scan = new Scanner(System.in);
        try {
            scan.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println(3);
        }
        try {
            scan.nextInt();
        } catch (Exception exception) {
            Exception exception1 = new Exception("Nice",exception);
            System.out.println(exception1);
            System.out.println(2);
        }
    }
}
