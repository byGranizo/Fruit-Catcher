package com.example.bygra.fruitcatcher.View.Game;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

import com.example.bygra.fruitcatcher.Controller.Game.GameEngine;

public class GameThread extends Thread {

    private boolean running;

    GameView gameView;
    SurfaceHolder surfaceHolder;
    GameEngine gameEngine;

    long startTime, loopTime;
    //Minimum time(millis) between frames -> 30 fps aprox
    long DELAY = 33;

    public GameThread(GameView gameView, SurfaceHolder surfaceHolder, GameEngine gameEngine) {
        this.gameView = gameView;
        this.surfaceHolder = surfaceHolder;
        this.gameEngine = gameEngine;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    //Gameloop
    @Override
    public void run() {
        while(running){
            startTime = SystemClock.uptimeMillis();
            //Get canvas from surface holder and lock it to draw
            Canvas canvas = surfaceHolder.lockCanvas(null);

            if(canvas != null){
                //Avoid other code from accesing to canvas while drawing and updating
                synchronized (canvas){
                    gameEngine.update();
                    gameEngine.onDraw(canvas);
                }
                //Unlock canvas
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            //Set interval to redraw canvas
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
