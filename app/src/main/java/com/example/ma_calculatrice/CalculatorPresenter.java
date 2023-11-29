package com.example.ma_calculatrice;public class CalculatorPresenter {

    CalculatorActivity _view;
    public CalculatorPresenter(CalculatorActivity calculatorView) {
        _view = calculatorView;
    }

    public void addCharacter(String s) {
        _view.result.setText(_view.result.getText() + s);
    }

    public void suppr() {
        String text = (String) _view.result.getText();
        if (text.length() == 0) {
            return;
        }
        _view.result.setText(text.substring(0,text.length()-1));
    }

    public void exec() {
        _view.result.setText(CalculatorModel.exec((String) _view.result.getText()));
    }
}
