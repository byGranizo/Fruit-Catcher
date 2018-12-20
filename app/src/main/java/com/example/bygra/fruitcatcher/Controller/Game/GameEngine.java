package com.example.bygra.fruitcatcher.Controller.Game;

import android.content.Context;
import android.graphics.Canvas;

public class GameEngine {

    Context context;
    GameObjects gameObjects;

    Boolean difficulty;

    public GameEngine(Context context, Boolean difficulty) {
        this.context = context;
        gameObjects = new GameObjects(context);
        this.difficulty = difficulty;
    }

    public void update(){

    }

    public void onDraw(Canvas canvas){
        //Draw background
        canvas.drawBitmap(gameObjects.background, 0, 0, null);
        //Draw basket
        canvas.drawBitmap(gameObjects.basket.getBitmap(),gameObjects.basket.getLocation().x,gameObjects.basket.getLocation().y, null);
    }
}
