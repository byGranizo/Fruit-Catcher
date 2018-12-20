package com.example.bygra.fruitcatcher.View.Game;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.example.bygra.fruitcatcher.Controller.Basket;
import com.example.bygra.fruitcatcher.Controller.Burger;
import com.example.bygra.fruitcatcher.Controller.Food;
import com.example.bygra.fruitcatcher.Controller.FriedEgg;
import com.example.bygra.fruitcatcher.Controller.HotDog;
import com.example.bygra.fruitcatcher.Controller.Onion;
import com.example.bygra.fruitcatcher.Controller.Tomatoe;
import com.example.bygra.fruitcatcher.Controller.Watermelon;

import java.util.ArrayList;
import java.util.Random;

public class GameObjects {

    Context context;
    Point screenSize;
    int spawnFoodY = -1 ;

    protected Basket b;
    protected ArrayList<Food> foodList;

    public GameObjects(Context context) {
        this.context = context;
        getScreenSize();
    }

    private void initBasket(){
        b = new Basket(context,getBasketSpawn());
    }

    public void newFood(){
        Point p = randomFoodSpawnPoint();
        Random r = new Random();
        int foodIndex = r.nextInt(6)+1;

        switch (foodIndex){
            case 1:
                foodList.add(new Burger(context,p));
                break;
            case 2:
                foodList.add(new FriedEgg(context,p));
                break;
            case 3:
                foodList.add(new HotDog(context,p));
                break;
            case 4:
                foodList.add(new Onion(context,p));
                break;
            case 5:
                foodList.add(new Tomatoe(context,p));
                break;
            case 6:
                foodList.add(new Watermelon(context,p));
                break;
        }
    }

    private Point randomFoodSpawnPoint(){
        Random r = new Random();

        Point p = new Point(r.nextInt(screenSize.x),spawnFoodY);

        return p;
    }

    private void getScreenSize(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        d.getSize(screenSize);
    }

    private Point getBasketSpawn(){
        Point spawn = new Point();

        spawn.x = screenSize.x / 2;

        spawn.y = (int)(screenSize.y * 0.95);


        return spawn;
    }
}
