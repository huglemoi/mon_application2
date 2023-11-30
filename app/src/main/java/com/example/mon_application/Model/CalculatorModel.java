package com.example.mon_application.Model;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorModel {
    public static String exec(String text) {
        if (text.length() == 0) {
            return "";
        }
        Expression _expression = new ExpressionBuilder(text).build();
        try {
            return String.valueOf(_expression.evaluate());
        } catch (Exception e) {
            return "Invalid Operation";
        }
    }
}
