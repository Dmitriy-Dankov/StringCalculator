package com.software.app_start;

import java.io.IOException;

import com.software.calculators.StringCalculator;
import com.software.console.Reader;
import com.software.functions.Functions;
import com.software.validators.ValidExForCalc;
import com.software.validators.ValidatorForStrCalc;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        try {
            reader.openStreamIn();
            //////////////////////////////////// application_body////////////////////////////////////
            System.out.println("Enter expression: ");

            String word1 = reader.readWord();
            ValidatorForStrCalc.isString(word1); // проверить, что это строка
            ValidatorForStrCalc.isQuotes(word1); // проверить на содержание кавычек
            ValidatorForStrCalc.checkStrLength(word1); // проверить длину строки
            word1 = Functions.cutOffQuotes(word1); // убрать кавычки

            char ch = reader.readChar();

            switch (ch) {
                case '+': {
                    String word2 = reader.readWord();
                    ValidatorForStrCalc.isString(word2); // проверить, что это строка
                    ValidatorForStrCalc.isQuotes(word2); // проверить на содержание кавычек
                    ValidatorForStrCalc.checkStrLength(word2); // проверить длину строки
                    word2 = Functions.cutOffQuotes(word2); // убрать кавычки
                    System.out.println(StringCalculator.sum(word1, word2)); // сложить и вывести результат
                }
                    break;
                case '-': {
                    String word2 = reader.readWord();
                    ValidatorForStrCalc.isString(word2); // проверить, что это строка
                    ValidatorForStrCalc.isQuotes(word2); // проверить на содержание кавычек
                    ValidatorForStrCalc.checkStrLength(word2);  // проверить длину строки
                    word2 = Functions.cutOffQuotes(word2); // убрать кавычки
                    System.out.println(StringCalculator.diff(word1, word2)); // вычесть и вывести результат
                }
                    break;
                case '/': {
                    int num = reader.readInteger();
                    ValidatorForStrCalc.isInteger(num); // проверить что это число
                    ValidatorForStrCalc.checkNumRange(num); // проверить диапазон
                    System.out.println(StringCalculator.div(word1, num)); // вывести результат
                }
                    break;
                case '*': {
                    int num = reader.readInteger();
                    ValidatorForStrCalc.isInteger(num); // проверить что это число
                    ValidatorForStrCalc.checkNumRange(num); // проверить диапазон
                    String result = StringCalculator.multi(word1, num); // умножить
                    System.out.println(Functions.trimLine(result)); // вывести результат
                }
                    break;
                default: {
                    try {
                        throw new ValidExForCalc("unknown expression");
                    } catch (ValidExForCalc e) {
                        System.out.println(e);
                        System.exit(1);
                    }
                }
            }

            /////////////////////////////////////////// end_app_body//////////////////////////////////////
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException | StringIndexOutOfBoundsException e){
            System.out.println("Error: incorrect expression");
        } finally {
            try {
                reader.closeStreamIn();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
