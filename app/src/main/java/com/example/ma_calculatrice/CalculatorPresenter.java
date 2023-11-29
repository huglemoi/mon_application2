package com.example.ma_calculatrice;public class CalculatorPresenter {

    CalculatorActivity _view;
    public CalculatorPresenter(CalculatorActivity calculatorView) {
        _view = calculatorView;
    }

    public void addCharacter(String s) {
        _view.input.setText(_view.input.getText() + s);
    }

    public void suppr() {
        String text = (String) _view.input.getText();
        if (text.length() == 0) {
            return;
        }
        _view.input.setText(text.substring(0,text.length()-1));
    }

    public void exec() {
        _view.input.setText(CalculatorModel.exec((String) _view.input.getText()));
    }
}
