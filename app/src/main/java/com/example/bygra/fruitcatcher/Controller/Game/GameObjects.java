package com.example.bygra.fruitcatcher.Controller.Game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.example.bygra.fruitcatcher.Controller.Entities.Basket;
import com.example.bygra.fruitcatcher.Controller.Entities.Burger;
import com.example.bygra.fruitcatcher.Controller.Entities.Food;
import com.example.bygra.fruitcatcher.Controller.Entities.FriedEgg;
import com.example.bygra.fruitcatcher.Controller.Entities.HotDog;
import com.example.bygra.fruitcatcher.Controller.Entities.Onion;
import com.example.bygra.fruitcatcher.Controller.Entities.Tomato;
import com.example.bygra.fruitcatcher.Controller.Entities.Watermelon;
import com.example.bygra.fruitcatcher.R;

import java.util.ArrayList;
import java.util.Random;

public class GameObjects {

    Context context;
    Point screenSize = new Point();
    int spawnFoodY = -100 ;

    boolean debug = true;

    Bitmap background;

    public Basket basket;
    public ArrayList<Food> foodList = new ArrayList<>();

    public GameObjects(Context context) {
        this.context = context;
        getScreenSize();

        initBackground();
        initBasket();
    }
    //Create background bitmap with adapted size
    private void initBackground(){
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.game_background);
        background = Bitmap.createScaledBitmap(background, screenSize.x, screenSize.y, false);
    }
    //Create basket
    private void initBasket(){
        basket = new Basket(context);
    }
    //Create a random food type
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
                foodList.add(new Tomato(context,p));
                break;
            case 6:
                foodList.add(new Watermelon(context,p));
                break;
        }
    }
    //Set random spawn a random spawn point in the same Y
    private Point randomFoodSpawnPoint(){
        Random r = new Random();

        Point p = new Point(r.nextInt(screenSize.x),spawnFoodY);

        if(p.x > screenSize.x * 0.9){
            p.x =(int) (screenSize.x * 0.9);
        }

        return p;
    }
    //Get the screen size in pixels
    public void getScreenSize(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        d.getRealSize(screenSize);
        System.out.println(screenSize.x + " - " + screenSize.y);
    }
}
