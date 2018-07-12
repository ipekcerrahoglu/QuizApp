package com.example.lenovo.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.score_text_view);
    }

    public void submitQuiz(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        boolean hasCapital = isCity(name);

        CheckBox antalya = (CheckBox) findViewById(R.id.check_antalya);
        boolean hasAntalya = antalya.isChecked();

        CheckBox izmir = (CheckBox) findViewById(R.id.check_Izmir);
        boolean hasIzmir = izmir.isChecked();

        CheckBox mardin = (CheckBox) findViewById(R.id.check_mardin);
        boolean hasMardin = mardin.isChecked();


        RadioButton radioButtonIstanbul = (RadioButton) findViewById(R.id.radio_istanbul);
        boolean isRadioButtonChecked1 = radioButtonIstanbul.isChecked();

        RadioButton radioButton90 = (RadioButton) findViewById(R.id.radio_90);
        boolean isRadioButtonChecked2 = radioButton90.isChecked();

        int score = calculateScore(hasAntalya, hasIzmir, hasMardin, isRadioButtonChecked1, isRadioButtonChecked2, hasCapital);

        scoreTextView.setText("Your score is: " + String.valueOf(score));
        scoreTextView.setVisibility(View.VISIBLE);
    }

    private boolean isCity(String name) {

        if (name.equalsIgnoreCase("Ankara")) {
            return true;

        } else {
            return false;
        }
    }


    private int calculateScore(boolean hasAntalya, boolean hasIzmir, boolean hasMardin, boolean isRadioButtonChecked1, boolean isRadioButtonChecked2, boolean hasCapital) {

        int score = 0;

        if (hasAntalya && hasIzmir && !hasMardin) {
            score++;
        }

        if (isRadioButtonChecked1) {
            score++;
        }

        if (isRadioButtonChecked2) {
            score++;
        }

        if (hasCapital) {
            score++;
        }

        return score;
    }
}
