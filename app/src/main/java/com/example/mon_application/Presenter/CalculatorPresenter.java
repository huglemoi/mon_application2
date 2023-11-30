package com.example.mon_application.Presenter;

import com.example.mon_application.View.CalculatorView;
import com.example.mon_application.Model.CalculatorModel;

public class CalculatorPresenter {

    CalculatorView _view;

    public CalculatorPresenter(CalculatorView view) {
        _view = view;
    }

    public String addCharacter(String s, char c) {
        return s + c;
    }

    public String suppr(String s) {
        if (s.length() == 0) {
            return "";
        }
        return s.subString(0, s.length()-1);
    }

    public String exec(String s) {
        double result;
        if (s.length() == 0) {
            return "";
        }
        try {
            result = CalculatorModel.exec(s);
        } catch (Exception e) {
            _view.setErrorState();
            return "Invalid operation";
        }
        return String.valueOf(result);
    }
}
