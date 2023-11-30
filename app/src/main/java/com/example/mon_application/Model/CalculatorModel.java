package com.example.mon_application.Model;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorModel {
    public static double exec(String text) {
        Expression _expression = new ExpressionBuilder(text).build();
        return _expression.evaluate();
    }
}