package com.example.simpleandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input_num;
    private TextView result;
    private double num1;
    private double num2;
    private int operatorIndicator;
    private String stringNum1;
    private String stringNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_num = (EditText) findViewById(R.id.inputnum);
        input_num.setShowSoftInputOnFocus(false);
        input_num.setFocusable(false);
        stringNum1 = input_num.getText().toString();

        result = findViewById(R.id.result);
        result.setShowSoftInputOnFocus(false);
        result.setFocusable(false);
        stringNum2 = result.getText().toString();
    }

    public void update_text(String toAdd){
        String previous = input_num.getText().toString();

        input_num.setSelection(input_num.getText().length());
        input_num.setText(previous.concat(toAdd));

    }

    public void operatorUpdate_text(String operator){
        num1 = Double.parseDouble(input_num.getText().toString());
        result.setText(String.format("%s %s", input_num.getText().toString(), operator));
        input_num.setText("");
        operatorIndicator = 1;
    }

    public void zero(View v){
        update_text("0");
    }
    public void doublezero(View v){
        update_text("00");
    }
    public void one(View v){
        update_text("1");
    }
    public void two(View v){
        update_text("2");
    }
    public void three(View v){
        update_text("3");
    }
    public void four(View v){
        update_text("4");
    }
    public void five(View v){
        update_text("5");
    }
    public void six(View v){
        update_text("6");
    }
    public void seven(View v){
        update_text("7");
    }
    public void eight(View v){
        update_text("8");
    }
    public void nine(View v){
        update_text("9");
    }
    public void dot(View v){
        update_text(".");
    }
    public void ce(View v){
        input_num.setText("");
    }

    public void prcnt(View v){
        double num = Double.parseDouble(input_num.getText().toString());
        input_num.setText(String.valueOf(""));
    }


    public void add(View v){
        operatorUpdate_text("+");
        operatorIndicator = 1;
    }
    public void subtract(View v){
        operatorUpdate_text("-");

        input_num.setText("");
        operatorIndicator = 2;
    }
    public void multiply(View v){
        operatorUpdate_text("x");

        input_num.setText("");
        operatorIndicator = 3;
    }
    public void divide(View v){
        operatorUpdate_text("÷");

        input_num.setText("");
        operatorIndicator = 4;
    }

    public void equals(View v){
        String num2String = input_num.getText().toString();
        String num1String = null;

        if ((int) num1 == num1){
            num1String = String.valueOf((int)num1);
        } else{
            num1String = String.valueOf(num1);
        }

        num2 = Double.parseDouble(num2String);

        String operator = null;
        double result1 = 0;

        if (operatorIndicator==1){
            result1 = (num1 + num2);
            operator = "+";
        } else if (operatorIndicator==2){
            result1 = (num1 - num2);
            operator = "-";
        } else if (operatorIndicator==3){
            result1 = (num1 * num2);
            operator = "*";
        } else if (operatorIndicator==4){
            result1 = (num1 / num2);
            operator = "÷";
        }

        if ((int) result1 == result1){
            input_num.setText(String.valueOf((int)result1));
        } else {
            input_num.setText(String.valueOf(result1));
        }

        result.setText(String.format("%s%s%s",num1String,operator,num2String));
    }

    public void backspace(View v){
        String word = input_num.getText().toString();
        int input = word.length();
        if (input > 0) {
            input_num.setText(word.substring(0, input - 1));
        }
    }
}