package com.example.bygra.fruitcatcher.Controller;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.example.bygra.fruitcatcher.R;

public class Onion extends Food {

    public Onion(Context context, Point position) {
        super(context, position);
        this.setBitmap(BitmapFactory.decodeResource(this.getContext().getResources(),R.drawable.entity_tomatoe));
        setLifeLose(false);
        setScore(10);
    }
}

