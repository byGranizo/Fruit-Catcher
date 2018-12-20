package com.example.bygra.fruitcatcher.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bygra.fruitcatcher.R;

public class StartActivity extends AppCompatActivity {

    Button btStart, btEasy, btHard;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        hideUI();

        initUI();
    }

    //Executed when user touch de Start Button
    public void startButton(View v){
        ivLogo.setVisibility(View.INVISIBLE);
        btStart.setVisibility(View.INVISIBLE);
        btEasy.setVisibility(View.VISIBLE);
        btHard.setVisibility(View.VISIBLE);
    }

    //Executed when user touch de Easy Difficulty Button
    public void easyButton(View v){
        launchGameActivity(false);
    }

    //Executed when user touch de Hard Difficulty Button
    public void hardButton(View v){
        launchGameActivity(true);
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

    //Initialize the game UI
    private void initUI(){
        ivLogo = findViewById(R.id.ivLogo);
        btStart = findViewById(R.id.btStart);
        btEasy = findViewById(R.id.btEasy);
        btHard = findViewById(R.id.btHard);
    }

    //Launch the game activity when difficulty is selected
    public void launchGameActivity(Boolean difficulty){
        Intent game = new Intent(this, GameActivity.class);
        game.putExtra("difficulty",difficulty);
        startActivity(game);
    }

    //When user returns to the activity
    @Override
    protected void onResume() {
        super.onResume();
        hideUI();
    }


}
