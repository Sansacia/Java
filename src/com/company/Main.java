package com.company;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n1, n2;
    static char op;
    static int result;
    public static void main(String[] args) {
        System.out.println("Введите два числа: [X][Знак][Y]: ");
        String userInput = scanner.nextLine();
        char[] Numchar = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            Numchar[i] = userInput.charAt(i);
            if (Numchar[i] == '+') op = '+';
            if (Numchar[i] == '-') op = '-';
            if (Numchar[i] == '/') op = '/';
            if (Numchar[i] == '*') op = '*';
        }
        String under_charString = String.valueOf(Numchar);
        String[] posit = under_charString.split("[+-/*]");
        String num1 = posit[0];
        String op2 = posit[1];
        String num2 = op2.trim();
        n1 = RomNumber(num1);
        n2 = RomNumber(num2);
        if (n1 < 0 && n2 < 0) {
            result = 0;
        }
        else {
            if (n1 == -1 || n2 == -1){
                System.exit(0);
            }
            result = calculated(n1, n2, op);
            String resultRoman = RomanNumbers(result);
            System.out.println("Ответ: " + resultRoman);
        }
        try{
            n1 = Integer.parseInt(num1);
            n2 = Integer.parseInt(num2);
            result = calculated(n1, n2, op);
            if ((n1 | n2) > 10){
                System.exit(0);
            }
            else{
                System.out.println("Ответ: " + result);
            }
        }catch (NumberFormatException e){
            System.exit(0);
        }
    }
    private static String RomanNumbers(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[numArabian];
    }


    private static int RomNumber(String roman) {
        try {
            return switch (roman) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> -1;
            };
        } catch (NumberFormatException e) {
            System.exit(0);
        }

        return 0;
    }

    public static int calculated(int num1, int num2, char op) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }
}