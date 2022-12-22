package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String oldNumber;
    private String operator;
    private Boolean isNew = true;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
    }

    public void clickNumber (View view) {
        if (isNew)
            editText.setText("");
        isNew = false;
        String number = editText.getText().toString();
        switch (view.getId()) {
            case R.id.button0: number = number + "0" ;
            break;
            case R.id.button1: number = number + "1" ;
                break;
            case R.id.button2: number = number + "2" ;
                break;
            case R.id.button3: number = number + "3" ;
                break;
            case R.id.button4: number = number + "4" ;
                break;
            case R.id.button5: number = number + "5" ;
                break;
            case R.id.button6: number = number + "6" ;
                break;
            case R.id.button7: number = number + "7" ;
                break;
            case R.id.button8: number = number + "8" ;
                break;
            case R.id.button9: number = number + "9" ;
                break;
            case R.id.buttonDot: number = number + "." ;
                break;
            case R.id.buttonPlusMinus: number =  "-" + number;
                break;
        }
        editText.setText(number);
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();

        switch (view.getId()) {
            case R.id.buttonPlus: operator = "+";
                break;
            case R.id.buttonMinus: operator = "-";
                break;
            case R.id.buttonDivide: operator = "/";
                break;
            case R.id.buttonMultiply: operator = "*";
                break;
        }
    }

    public void buttonEqual(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        switch (operator) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;

        }
        editText.setText(result + "");


    }

    public void cancel(View view) {
        editText.setText("0");
        isNew = true;
    }
}