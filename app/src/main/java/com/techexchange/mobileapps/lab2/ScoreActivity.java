package com.techexchange.mobileapps.lab2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    static final String KEY_RESTART_QUIZ = "RetakeQuiz";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button againButton = findViewById(R.id.again_button);
        againButton.setOnClickListener(v -> onAgainButtonPressed());

        TextView scoreText = findViewById(R.id.score_text);
        int score = getIntent().getIntExtra(MainActivity.KEY_SCORE, 0);
        scoreText.setText("Quiz Score: " + score);

        Context context = getApplicationContext();
        CharSequence text = ("Quiz Score: " + score) ;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void onAgainButtonPressed() {
        Intent data = new Intent();
        data.putExtra(KEY_RESTART_QUIZ, true);
        setResult(Activity.RESULT_OK, data);

        Intent scoreIntent = new Intent(this, MainActivity.class);
        startActivityForResult(scoreIntent, 0);
        // finish();

    }


}
