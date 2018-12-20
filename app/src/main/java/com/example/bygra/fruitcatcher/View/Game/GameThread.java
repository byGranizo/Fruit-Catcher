package com.example.bygra.fruitcatcher.View.Game;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    private boolean running;

    GameView gameView;
    SurfaceHolder surfaceHolder;

    long startTime, loopTime;
    long DELAY = 33;

    public GameThread(GameView gameView, SurfaceHolder surfaceHolder) {
        this.gameView = gameView;
        this.surfaceHolder = surfaceHolder;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while(running){
            startTime = SystemClock.uptimeMillis();

            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (canvas){
                    //update
                    //draw
                }
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

            loopTime = SystemClock.uptimeMillis() - startTime;
            if(loopTime < DELAY){
                try {
                    Thread.sleep(DELAY - loopTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }




}
