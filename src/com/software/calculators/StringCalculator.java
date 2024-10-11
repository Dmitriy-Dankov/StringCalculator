package com.software.calculators;

public class StringCalculator {
    public static String sum(String str1, String str2) {
        return '"' + str1 + str2 + '"';
    }

    public static String diff(String str1, String str2) {
        StringBuilder temp = new StringBuilder();
        
        if(str1.equals(str2)) return "";
        
        int index = str1.indexOf(str2) - 1;
        
        if(index < 0) return '"' + str1 + '"';

        for (int i = 0; i < str1.length(); ++i) {
            if (i <= index || i >= (index + str2.length()+1))
                temp.append(str1.charAt(i));
        }

        return '"' + temp.toString() + '"';
    }

    public static String multi(String str1, int num) {
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < num; ++i) {
            temp.append(str1);
        }

        return '"' + temp.toString() + '"';
    }

    public static String div(String str1, int num) {
        StringBuilder temp = new StringBuilder();

        int index = str1.length() / num;
        if(index < 1) return "\"\"";

        for(int i = 0; i < index; ++i) {
            temp.append(str1.charAt(i));
        }

        return '"' + temp.toString() + '"';
    }
}
