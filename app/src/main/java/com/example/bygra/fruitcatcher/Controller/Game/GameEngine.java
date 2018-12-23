package com.example.bygra.fruitcatcher.Controller.Game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

import java.util.Random;

public class GameEngine {

    Context context;
    GameObjects gameObjects;
    Point screen;

    MotionEvent cursor;
    boolean basketMove = false;

    Boolean difficulty;

    public GameEngine(Context context, Boolean difficulty) {
        this.context = context;
        gameObjects = new GameObjects(context);
        screen = getScreenSize();
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

        Random r = new Random();
        int spawnFood = r.nextInt(30);
        if(spawnFood == 0){
            gameObjects.newFood();
        }

        moveFood();

        deleteFood();

        System.out.println(gameObjects.foodList.size());
    }

    public void onDraw(Canvas canvas){
        //Draw background
        canvas.drawBitmap(gameObjects.background, 0, 0, null);

        //Draw fruits
        for(int i=0;i<gameObjects.foodList.size();i++){
            canvas.drawBitmap(gameObjects.foodList.get(i).getBitmap(),gameObjects.foodList.get(i).getLocation().x,gameObjects.foodList.get(i).getLocation().y,null);
        }

        //Draw basket
        canvas.drawBitmap(gameObjects.basket.getBitmap(),gameObjects.basket.getLocation().x,gameObjects.basket.getLocation().y, null);
    }

    public Point getScreenSize(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        Point screenSize = new Point();
        d.getRealSize(screenSize);

        return screenSize;
    }

    public void moveBasketLeft(){
        Point location = gameObjects.basket.getLocation();

        location.x -= screen.x*0.015;
        if(location.x < 0){
            location.x = 0;
        }
        gameObjects.basket.setLocation(location);
    }

    public void moveBasketRight(){
        Point location = gameObjects.basket.getLocation();

        location.x += screen.x*0.015;
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

    public void moveFood(){
        double velocity;
        if(difficulty){
            velocity = 0.015;
        } else {
            velocity = 0.01;
        }

        for(int i=0;i<gameObjects.foodList.size();i++){
            Point location = gameObjects.foodList.get(i).getLocation();
            location.y += screen.y*velocity;
            gameObjects.foodList.get(i).setLocation(location);
        }
    }

    public void deleteFood(){

        for(int i=0;i<gameObjects.foodList.size();i++){
            //Delete the object when it goes out of the screen
            if(gameObjects.foodList.get(i).getLocation().y > screen.y){
                gameObjects.foodList.remove(i);
            }
            //Delete the object when it collides with the basket
            if((gameObjects.foodList.get(i).getLocation().y + gameObjects.foodList.get(i).getSize().y >= gameObjects.basket.getLocation().y)
                    || (gameObjects.foodList.get(i).getLocation().y >= gameObjects.basket.getLocation().y + gameObjects.basket.getSize().y)){
                if((gameObjects.foodList.get(i).getLocation().x + gameObjects.foodList.get(i).getSize().x > gameObjects.basket.getLocation().x)
                        && (gameObjects.foodList.get(i).getLocation().x < gameObjects.basket.getLocation().x + gameObjects.basket.getSize().x)){
                    gameObjects.foodList.remove(i);
                }
            }
        }
    }


}
