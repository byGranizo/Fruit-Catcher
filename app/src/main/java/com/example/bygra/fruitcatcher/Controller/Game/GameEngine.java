package com.example.bygra.fruitcatcher.Controller.Game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

public class GameEngine {

    Context context;
    GameObjects gameObjects;

    MotionEvent cursor;
    boolean basketMove = false;

    Boolean difficulty;

    public GameEngine(Context context, Boolean difficulty) {
        this.context = context;
        gameObjects = new GameObjects(context);
        this.difficulty = difficulty;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void setCursor(MotionEvent cursor) {
        this.cursor = cursor;
    }

    public void setBasketMove(boolean basketMove) {
        this.basketMove = basketMove;
    }

    public boolean isBasketMove() {
        return basketMove;
    }

    public void update(){
        moveBasket();
    }

    public void onDraw(Canvas canvas){
        //Draw background
        canvas.drawBitmap(gameObjects.background, 0, 0, null);
        //Draw basket
        canvas.drawBitmap(gameObjects.basket.getBitmap(),gameObjects.basket.getLocation().x,gameObjects.basket.getLocation().y, null);
    }

    public void moveBasketLeft(){
        Point screen = getScreenSize();
        Point location = gameObjects.basket.getLocation();

        location.x -= screen.x*0.02;
        if(location.x < 0){
            location.x = 0;
        }
        gameObjects.basket.setLocation(location);
    }

    public void moveBasketRight(){
        Point screen = getScreenSize();
        Point location = gameObjects.basket.getLocation();

        location.x += screen.x*0.02;
        if(location.x > screen.x-gameObjects.basket.getSize().x){
            location.x = screen.x-gameObjects.basket.getSize().x;
        }
        gameObjects.basket.setLocation(location);
    }

    public void moveBasket(){
        if(basketMove){
            int x = (int)cursor.getX();

            if(x < getScreenSize().x/2 && x>=0){
                moveBasketLeft();
            }
            if(x >= getScreenSize().x/2 && x < getScreenSize().x){
                moveBasketRight();
            }
        }
    }

    public Point getScreenSize(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        Point screenSize = new Point();
        d.getRealSize(screenSize);

        return screenSize;
    }
}
