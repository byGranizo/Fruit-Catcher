package com.example.bygra.fruitcatcher.Controller;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.example.bygra.fruitcatcher.R;

public class FriedEgg extends Food {

    public FriedEgg(Context context, Point position) {
        super(context, position);
        this.setBitmap(BitmapFactory.decodeResource(this.getContext().getResources(),R.drawable.entity_tomatoe));
        setLifeLose(true);
        setScore(0);
    }
}
