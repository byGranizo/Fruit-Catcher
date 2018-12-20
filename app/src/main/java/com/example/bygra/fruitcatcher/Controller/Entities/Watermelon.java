package com.example.bygra.fruitcatcher.Controller.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.example.bygra.fruitcatcher.R;

public class Watermelon extends Food {

    public Watermelon(Context context, Point position) {
        super(context, position);

        setSize(setFoodSize());
        setBitmap(resizedBitmap());

        setLifeLose(false);
        setScore(10);
    }
    //Set watermelon size in relation with screen size
    private Point setFoodSize(){
        Point size = getScreenSize();

        size.x *= 0.05;
        size.y *= 0.05;

        return size;
    }
    //Create watermelon bitmap with adapted size
    private Bitmap resizedBitmap(){
        Bitmap bitmap = BitmapFactory.decodeResource(this.getContext().getResources(),R.drawable.entity_watermelon);
        bitmap = Bitmap.createScaledBitmap(bitmap, getSize().x, getSize().y, false);
        return bitmap;
    }
}

