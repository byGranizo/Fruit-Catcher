package com.example.bygra.fruitcatcher.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bygra.fruitcatcher.R;
import com.example.bygra.fruitcatcher.View.Game.GameActivity;

public class ScoreActivity extends AppCompatActivity {

    TextView tvScore;
    Boolean difficulty;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        tvScore = findViewById(R.id.tvUserPoints);

        score = getIntent().getExtras().getInt("score");
        difficulty = getIntent().getExtras().getBoolean("difficulty");

        tvScore.setText(score + " pts");

    }

    public void playAgain(View v){
        Intent playAgain = new Intent(this, GameActivity.class);
        playAgain.putExtra("difficulty", difficulty);
        startActivity(playAgain);
    }

    //Hide the Android UI to execute the game in fullscreen
    private void hideUI(){
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideUI();
    }
}
