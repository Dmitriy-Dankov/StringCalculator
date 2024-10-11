package com.software.validators;

public class ValidExForCalc extends Exception {
    private String detail;

    public ValidExForCalc(String str) {
        detail = str;
    }

    @Override
    public String toString() {
        return "ValidExForCalc: " + detail;
    }
}
