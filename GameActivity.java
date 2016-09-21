package com.example.tom.guessthenumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Button b_plus, b_minus, b_check, b_reset, b_more;
    TextView tv_number, tv_title;

    int current_number, number_to_guess, guesses;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        r = new Random();
        number_to_guess = r.nextInt(50);

        b_reset = (Button) findViewById(R.id.b_reset);
        b_more = (Button) findViewById(R.id.b_more);
        b_check = (Button) findViewById(R.id.b_check);
        b_plus = (Button) findViewById(R.id.b_plus);
        b_minus = (Button) findViewById(R.id.b_minus);
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_title = (TextView) findViewById(R.id.tv_title);

        guesses = 1;
        current_number = 0;
        tv_number.setText("" + current_number);

        b_check.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_number == number_to_guess) {
                    tv_title.setText(getString(R.string.text_congrats) + guesses + getString(R.string.text_tries));
                    b_check.setEnabled(false);
                    b_plus.setEnabled(false);
                    b_minus.setEnabled(false);


                } else if (current_number > number_to_guess) {
                    tv_title.setText("Down!");
                    guesses++;
                } else if (current_number < number_to_guess) {
                    tv_title.setText("Up!");
                    guesses++;

                }
            }
        });
        b_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(intent);
                finish();
            }
        });


        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_number < 50) {
                    current_number++;
                }
                tv_number.setText("" + current_number);
            }
        });
        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_number > 0) {
                    current_number--;
                }
                tv_number.setText("" + current_number);
            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);
    }


}
