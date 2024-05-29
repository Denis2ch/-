import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String input = scaner.nextLine();
        System.out.println(calc(input));
    }
    public static String  calc(String input) {
        String roman;
        String [] calc = input.split(" ");
        boolean a = false;
        boolean r = false;
        if (calc.length != 3) {
            return (" throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (calc.length < 3) {
            return ( "throws Exception //т.к. строка не является математической операцией");
        }
        String operator = calc[1];
        if (num(calc[0]) && num(calc[2])) {
            a=true;
            if (Integer.parseInt(calc[0]) > 10 || Integer.parseInt(calc[2]) > 10) {
                return ("Выход за пределы // от 1 до 10");
            }
            return String.valueOf(operation(calc[0], calc[2], operator));
        }
        else {
            roman = convertInRoman(calc[0], calc[2]);
            if (!roman.equals("0")) {
                r= true;
                calc = roman.split(" ");
                if (operator.equals("-")) {
                    if (Integer.parseInt(calc[0]) < Integer.parseInt(calc[1])) {
                        return ("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    }
                }
                return convertInArab(String.valueOf(operation(calc[0], calc[1], operator)));
            }
        }
        return ("throws Exception //т.к. используются одновременно разные системы счисления");
    }
    private static boolean num(String s) {
        int intValue;
        try {
            intValue = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String convertInRoman(String A, String B) {
        String[] r = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X","XI","XII","XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
                "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
                "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
                "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
                "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        boolean check1 = false;
        boolean check2 = false;
        for (int i = 0; i < r.length; i++) {
            if (A.equals(r[i])) {
                check1 = true;
            }
            if (B.equals(r[i])) {
                check2 = true;
            }
        }
        if (check1 && check2) {
            return A + " " + B;
        }
        else return "0";
    }
    private static String convertInArab(String A) {
        String[] r = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X","XI","XII","XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
                "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
                "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
                "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
                "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int c= Integer.valueOf(A);
        for (int i = 0; i <= r.length; i++) {
        if (i ==c) {
            return r[i-1];
        }
        }
        return "выход за предел";
    }
    private static String operation( String A, String B, String operator) {
        int A1 = Integer.parseInt(A);
        int B1 = Integer.parseInt(B);
        switch (operator) {
            case "-":
                return String.valueOf(A1 - B1);
            case "+":
                return String.valueOf(A1 + B1);
            case "/": {
                if (B1 != 0) {
                    return String.valueOf(A1 / B1);
                }
                else return (" на ноль делить нельзя");
            }
            case "*":
                return String.valueOf(A1 * B1);

        }
        return (" неизвестная операция");
    }
}
