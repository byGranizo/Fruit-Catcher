package com.example.bygra.fruitcatcher.Controller.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.example.bygra.fruitcatcher.R;

public class Burger extends Food {

    public Burger(Context context, Point position) {
        super(context, position);

        setSize(setFoodSize());
        setBitmap(resizedBitmap());

        setLifeLose(true);
        setScore(0);
    }
    //Set burger size in relation with screen size
    private Point setFoodSize(){
        Point size = getScreenSize();

        size.x *= 0.15;
        size.y *= 0.1;

        return size;
    }
    //Create burger bitmap with adapted size
    private Bitmap resizedBitmap(){
        Bitmap bitmap = BitmapFactory.decodeResource(this.getContext().getResources(),R.drawable.entity_burger);
        bitmap = Bitmap.createScaledBitmap(bitmap, getSize().x, getSize().y, false);
        return bitmap;
    }
}
