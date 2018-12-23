package com.example.bygra.fruitcatcher.Controller.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.example.bygra.fruitcatcher.R;

public class FriedEgg extends Food {

    public FriedEgg(Context context, Point position) {
        super(context, position);

        setSize(setFoodSize());
        setBitmap(resizedBitmap());

        setLifeLose(true);
        setScore(0);
    }
    //Set friedegg size in relation with screen size
    private Point setFoodSize(){
        Point size = getScreenSize();

        size.x *= 0.15;
        size.y *= 0.1;

        return size;
    }
    //Create friedegg bitmap with adapted size
    private Bitmap resizedBitmap(){
        Bitmap bitmap = BitmapFactory.decodeResource(this.getContext().getResources(),R.drawable.entity_friedegg);
        bitmap = Bitmap.createScaledBitmap(bitmap, getSize().x, getSize().y, false);
        return bitmap;
    }
}
