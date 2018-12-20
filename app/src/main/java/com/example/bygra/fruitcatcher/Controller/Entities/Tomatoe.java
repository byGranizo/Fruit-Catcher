package com.example.bygra.fruitcatcher.Controller.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.example.bygra.fruitcatcher.R;

public class Tomatoe extends Food {

    public Tomatoe(Context context, Point position) {
        super(context, position);

        setSize(setFoodSize());
        setBitmap(resizedBitmap());

        setLifeLose(false);
        setScore(10);
    }
    //Set tomatoe size in relation with screen size
    private Point setFoodSize(){
        Point size = getScreenSize();

        size.x *= 0.05;
        size.y *= 0.05;

        return size;
    }
    //Create tomatoe bitmap with adapted size
    private Bitmap resizedBitmap(){
        Bitmap bitmap = BitmapFactory.decodeResource(this.getContext().getResources(),R.drawable.entity_tomatoe);
        bitmap = Bitmap.createScaledBitmap(bitmap, getSize().x, getSize().y, false);
        return bitmap;
    }
}

