package com.kids.mathschallenge;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class Calculator extends AppCompatActivity {

    public static int answer;
    EditText ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        TextView box = findViewById(R.id.question);
        String[] collection = {"multiply", "add", "minus", "power"};
        int a = new Random().nextInt(10);
        int b = new Random().nextInt(10);
        int c = new Random().nextInt(10);
        int d = new Random().nextInt(4);
        String A, B, C, display;
        A = Integer.toString(a);
        B = Integer.toString(b);
        C = Integer.toString(c);
        if (collection[d].equals("multiply")) {
            answer = a * b * c;
            display = A + "*" + B + "*" + C;


        } else if (collection[d].equals("add")) {
            answer = a + b + c;
            display = A + "+" + B + "+" + C;
        } else if (collection[d].equals("minus")) {
            answer = a - b - c;
            display = A + "-" + B + "-" + C;
        } else {

            answer = (int) (Math.pow(a, b));
            display = A + "^" + B;
        }

        box.setText(display);
        ans = findViewById(R.id.input);
        final Button ansButton = findViewById(R.id.submit);
        ansButton.setEnabled(false);
        ans.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() == 0) {
                    ansButton.setEnabled(false);
                } else {
                    ansButton.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sent = ans.getText().toString();
                Intent sendData = new Intent(Calculator.this, result.class);
                sendData.putExtra("user", sent);
                startActivity(sendData);
            }
        });
    }

    public void results(View view) {
        Intent myIntent = new Intent(Calculator.this, result.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(myIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}