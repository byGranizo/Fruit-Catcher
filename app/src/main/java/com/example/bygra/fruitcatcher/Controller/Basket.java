package com.example.bygra.fruitcatcher.Controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.example.bygra.fruitcatcher.R;

public class Basket {
    private Context context;
    private Point location;
    private Bitmap bitmap;

    public Basket(Context context, Point location) {
        this.context = context;
        this.bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.entity_basket);
        this.location = location;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
