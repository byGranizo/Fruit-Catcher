package com.example.bygra.fruitcatcher.View.Game;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.bygra.fruitcatcher.Controller.Game.GameEngine;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{

    GameThread gameThread;
    GameEngine gameEngine;

    public GameView(Context context, Boolean difficulty) {
        super(context);

        //Set the callback
        getHolder().addCallback(this);
        //Make GameView can handle events
        setFocusable(true);

        gameEngine = new GameEngine(context, difficulty);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    //Create the Thread that contains the gameloop, and start it
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameThread = new GameThread(this,holder,gameEngine);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    //Block the thread until it finish
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(gameThread.isRunning()){
            gameThread.setRunning(false);
            boolean retry = true;
            while(retry){
                try {
                    gameThread.join();
                    retry = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

