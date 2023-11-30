package com.example.mon_application.Presenter;

import com.example.mon_application.View.CalculatorView;

public class CalculatorPresenter {

    CalculatorView _view;
    public CalculatorPresenter(CalculatorView calculatorView) {
        _view = calculatorView;
    }

    public String addCharacter(String s, char c) {
        return s + c;
    }

    public String suppr(String s) {
        if (s.length() == 0) {
            return "";
        }
        return s.subString(0,s.length()-1);
    }

}
