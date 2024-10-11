package com.software.validators;

public class ValidatorForStrСalc {
    public static boolean checkNumRange(int num) {
        try {
            if(num > 10 || num < 1)
                throw new ValidExForCalc("only numbers in the range 1 to 10 are allowed");
        } catch (ValidExForCalc e) {
            System.out.println(e);
            System.exit(1);
        }
        return true;
    }

    public static boolean checkStrLength(String str) {
        try {
            if(str.length() > 12)
                throw new ValidExForCalc("the line length exceeds the allowed size of 10 characters.");
        } catch (ValidExForCalc e) {
            System.out.println(e);
            System.exit(1);
        }
        return true;
    }

    public static boolean isQuotes(String str) {
        try {
            if(str.charAt(0) != '"' || str.charAt(str.length()-1) != '"')
                throw new ValidExForCalc("invalid string format");
        } catch (ValidExForCalc e) {
            System.out.println(e);
            System.exit(1);
        }
        return true;
    }

    public static boolean isString(String str) {
        try {
            if(str.isEmpty())
                throw new ValidExForCalc("is not a string");
        } catch (ValidExForCalc e) {
            System.out.println(e);
            System.exit(1);
        }
        return true;
    }

    public static boolean isInteger(Integer num) {
        try {
            if(num == null)
                throw new ValidExForCalc("is not a integer");
        } catch (ValidExForCalc e) {
            System.out.println(e);
            System.exit(1);
        }
        return true;
    }
}
