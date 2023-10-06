package com.bomfim.java13;

/**
 * <a href="https://openjdk.org/jeps/354">JEP 354: Switch Expressions (Second Preview)</a>
 */
public class SwitchExpressionYield {

    public int getNumbersLettersOldSwitch(String day) {
        int numLetters;
        switch (day) {
            case "MONDAY":
            case "FRIDAY":
            case "SUNDAY":
                numLetters = 6;
                break;
            case "TUESDAY":
                numLetters = 7;
                break;
            case "THURSDAY":
            case "SATURDAY":
                numLetters = 8;
                break;
            case "WEDNESDAY":
                numLetters = 9;
                break;
            default:
                System.out.println("Error: Not found day");
                numLetters = day.length();
                break;
        }
        return numLetters;
    }

    public int getNumbersLettersNewSwitch(String day) {
       return switch (day) {
            case "MONDAY","FRIDAY","SUNDAY"   -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> 9;
            default      -> {
                System.out.println("Error: Not found day");
                yield day.length();
            }
        };

    }



}
