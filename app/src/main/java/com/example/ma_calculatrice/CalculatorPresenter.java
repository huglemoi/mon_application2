package com.example.ma_calculatrice;public class CalculatorPresenter {

    CalculatorActivity _view;
    public CalculatorPresenter(CalculatorActivity calculatorView) {
        _view = calculatorView;
    }

    public void addCharacter(String s) {
        _view.result.setText(_view.result.getText() + s);
    }
}
