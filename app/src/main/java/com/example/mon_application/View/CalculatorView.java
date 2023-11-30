package com.example.mon_application.View;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ma_calculatrice.R;
import com.example.mon_application.Model.CalculatorModel;
import com.example.mon_application.Presenter.CalculatorPresenter;

public class CalculatorView extends AppCompatActivity {

    CalculatorPresenter presenter;
    bool errorState;

    TextView input;
    TableLayout tableLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        presenter = new CalculatorPresenter(this);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        tableLayout = findViewById(R.id.tableLayout);

        error = false;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        int marginBottom = (int) (screenHeight * 0.05);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) tableLayout.getLayoutParams();
        params.bottomMargin = marginBottom;
        tableLayout.setLayoutParams(params);

        double buttonWidthPercentage = 0.333;
        double buttonHeightPercentage = 0.07;
        int buttonWidth = (int) (screenWidth * buttonWidthPercentage);
        int buttonHeight = (int) (screenHeight * buttonHeightPercentage);
        int textSize = (int) (buttonHeight * 0.75);


        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            View child = tableLayout.getChildAt(i);

            if (child instanceof TableRow) {
                TableRow tableRow = (TableRow) child;
                int buttonCount = tableRow.getChildCount();

                TableRow.LayoutParams rowParams = new TableRow.LayoutParams(screenWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
                tableRow.setLayoutParams(rowParams);

                for (int j = 0; j < buttonCount; j++) {
                    View view = tableRow.getChildAt(j);

                    if (view instanceof Button) {
                        TableRow.LayoutParams buttonParams = new TableRow.LayoutParams(buttonWidth, buttonHeight);
                        buttonParams.textSize = textSize;
                        view.setLayoutParams(buttonParams);
                    }
                }
            }
        }
    }

    public void setErrorState() {
        errorState = true;
    }

    public void addCharacter(View button) {
        if (errorState) {
            input.setText("");
            errorState = false;
        }
        char c = (char) button.getText();
        String oldExpression = (String) input.getText();
        String newExpression = presenter.addCharacter(oldExpression, c);
        input.setText(newExpression);
        output.setText(presenter.exec(newExpression));
    }

    public void suppr(View view) {
        String text = input.getText()
        input.setText(presenter.suppr(text));
    }

    public void exec(View view) {
        String result = output.getText();
        input.setText(result);
        if (result.equals("Invalid operation")) {
            setErrorState();
        }
        output.setText("");
    }
}
