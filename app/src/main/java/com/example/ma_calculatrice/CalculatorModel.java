package com.example.ma_calculatrice;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorModel {

    private static Expression _expression;
    public static String exec(String text) {
        if (text.length() == 0) {
            return "";
        }
        _expression = new ExpressionBuilder(text).build();
        try {
            return String.valueOf(_expression.evaluate());
        } catch (Exception e) {
            return "Invalid Operation";
        }
    }
}
