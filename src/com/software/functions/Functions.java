package com.software.functions;

public final class Functions {
    public static boolean isDigit(char ch){
        return switch (ch) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> true;
            default -> false;
        };
    }

    public static String cutOffQuotes(String str) {
        return str.substring(1, str.length()-1);
    }

    public static String trimLine(String str) {
        if(str.length() > 42) {
            return str.substring(0, 40) + "...\""; 
        }
        return str;
    }
}
