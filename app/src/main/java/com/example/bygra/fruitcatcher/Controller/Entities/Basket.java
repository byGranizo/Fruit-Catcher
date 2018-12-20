package com.example.bygra.fruitcatcher.Controller.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.example.bygra.fruitcatcher.R;

public class Basket {
    private Context context;
    private Point size;
    private Point location;
    private Bitmap bitmap;

    public Basket(Context context) {
        this.context = context;

        setSize(setSize());
        setBitmap(resizedBitmap());

        setSpawnLocation();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Point getSize() {
        return size;
    }

    public void setSize(Point size) {
        this.size = size;
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

    private Point getScreenSize(){
        Log.d("cut","-1");
        Point screenSize = new Point();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        d.getRealSize(screenSize);
        return screenSize;
    }
    //Set basket size in relation with screen size
    private Point setSize(){
        Point size = getScreenSize();
        size.x *= 0.20;
        size.y *= 0.12;
        return size;
    }
    //Create basket bitmap with adapted size
    private Bitmap resizedBitmap(){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.entity_basket);
        bitmap = Bitmap.createScaledBitmap(bitmap, getSize().x, getSize().y, false);
        return bitmap;
    }
    //Set spawn in relation with screen size
    public void setSpawnLocation(){
        location = new Point();
        location.x = (getScreenSize().x / 2) - (size.x / 2);
        location.y = (int)(getScreenSize().y * 0.85);
    }
}
