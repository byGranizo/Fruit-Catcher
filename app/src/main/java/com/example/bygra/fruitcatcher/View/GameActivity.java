package com.example.bygra.fruitcatcher.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    Boolean difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the difficulty level from the intent
        difficulty = getIntent().getExtras().getBoolean("difficulty");

        //Launch the game view
        GameView gv = new GameView(this, difficulty);
        setContentView(gv);
    }
}
