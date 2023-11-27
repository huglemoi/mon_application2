package com.example.ma_calculatrice;public class CalculatorPresenter {

    CalculatorActivity _view;
    public CalculatorPresenter(CalculatorActivity calculatorView) {
        _view = calculatorView;
    }

    public void addNumber(int i) {
        _view.result.setText(_view.result.getText() + String.valueOf(i));
    }
}
