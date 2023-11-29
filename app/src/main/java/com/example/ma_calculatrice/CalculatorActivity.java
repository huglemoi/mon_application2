package com.example.ma_calculatrice;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    CalculatorPresenter presenter;

    TextView input;
    TableLayout tableLayout;
    Button divisionsButton;
    Button multiplicationButton;
    Button soustractionButton;
    Button additionButton;
    Button executionButton;
    Button deleteButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        presenter = new CalculatorPresenter(this);

        input = findViewById(R.id.textView);
        tableLayout = findViewById(R.id.tableLayout);
        divisionsButton = findViewById(R.id.divisionButton);
        multiplicationButton = findViewById(R.id.multiplicationButton);
        soustractionButton = findViewById(R.id.soustractionButton);
        additionButton = findViewById(R.id.additionButton);
        executionButton = findViewById(R.id.executionButton);
        deleteButton = findViewById(R.id.deleteButton);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

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
                        view.setLayoutParams(buttonParams);
                    }
                }
            }
        }
    }

    public void addCharacter(View view) {
        String s = (String) ((Button)view).getText();
        presenter.addCharacter(s);
    }

    public void suppr(View view) {
        presenter.suppr();
    }

    public void exec(View view) {
        presenter.exec();
    }
}
