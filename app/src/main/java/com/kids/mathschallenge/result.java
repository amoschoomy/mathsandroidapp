package com.kids.mathschallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        CheckedTextView output = findViewById(R.id.userAnswer);
        CheckedTextView actual = findViewById(R.id.actualAnswer);
        int check = Calculator.answer;
        Intent intent = getIntent();
        String results = intent.getStringExtra("user");
        int verify = Integer.parseInt(results);
        output.setText("You answered : " + results);
        actual.setText("Answer is : " + check);
        if (check == verify) {
            output.setChecked(true);

        }
    }

    public void nextQuestion(View view) {
        Intent myIntent = new Intent(result.this, Calculator.class);
        startActivity(myIntent);
        finish();
    }

    public void onBackPressed() {
        {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
}