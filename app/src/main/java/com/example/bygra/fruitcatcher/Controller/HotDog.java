package com.example.bygra.fruitcatcher.Controller;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.example.bygra.fruitcatcher.R;

public class HotDog extends Food {

    public HotDog(Context context, Point position) {
        super(context, position);
        this.setBitmap(BitmapFactory.decodeResource(this.getContext().getResources(),R.drawable.entity_hotdog));
        setLifeLose(true);
        setScore(0);
    }
}
