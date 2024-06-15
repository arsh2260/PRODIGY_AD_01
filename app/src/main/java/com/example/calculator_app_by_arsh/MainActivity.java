package com.example.calculator_app_by_arsh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
// This is the code of simple calculator

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private StringBuilder input;
    private double num1, num2;
    private String operator;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        input = new StringBuilder();

        // Initialize operator to empty
        operator = "";

        // Set OnClickListener for number buttons (0-9)
        findViewById(R.id.button0).setOnClickListener(onClickListener);
        findViewById(R.id.button1).setOnClickListener(onClickListener);
        findViewById(R.id.button2).setOnClickListener(onClickListener);
        findViewById(R.id.button3).setOnClickListener(onClickListener);
        findViewById(R.id.button4).setOnClickListener(onClickListener);
        findViewById(R.id.button5).setOnClickListener(onClickListener);
        findViewById(R.id.button6).setOnClickListener(onClickListener);
        findViewById(R.id.button7).setOnClickListener(onClickListener);
        findViewById(R.id.button8).setOnClickListener(onClickListener);
        findViewById(R.id.button9).setOnClickListener(onClickListener);

        // Set OnClickListener for operator buttons (+, -, *, /)
        findViewById(R.id.buttonPlus).setOnClickListener(onClickListener);
        findViewById(R.id.buttonMinus).setOnClickListener(onClickListener);
        findViewById(R.id.buttonMultiply).setOnClickListener(onClickListener);
        findViewById(R.id.buttonDivide).setOnClickListener(onClickListener);

        // Set OnClickListener for decimal point button (.)
        findViewById(R.id.buttonDot).setOnClickListener(onClickListener);

        // Set OnClickListener for equals button (=)
        findViewById(R.id.buttonEquals).setOnClickListener(onClickListener);
    }

    // OnClickListener for all buttons
    public void onDigitClick(View view) {
        // Append clicked button's text to input StringBuilder
        Button button = (Button) view;
        input.append(button.getText().toString());
        textView.setText(input.toString());
    }

    public void onDecimalClick(View view) {
        // Prevent adding more than one decimal point
        if (!input.toString().contains(".")) {
            input.append(".");
            textView.setText(input.toString());
        }
    }

    public void onOperatorClick(View view) {
        // Store the first number and the operator
        Button button = (Button) view;
        operator = button.getText().toString();
        num1 = Double.parseDouble(input.toString());
        input.setLength(0);  // Clear StringBuilder for next input
    }

    public void onEqualsClick(View view) {
        // Perform calculation based on operator when equals (=) is clicked
        if (!operator.isEmpty()) {
            num2 = Double.parseDouble(input.toString());
            double result = performOperation(num1, num2, operator);
            textView.setText(String.valueOf(result));
            input.setLength(0);  // Clear StringBuilder for next input
            operator = "";  // Reset operator
        }
    }

    // Method to perform arithmetic operations
    private double performOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    return 0; // Handle division by zero error
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
}
