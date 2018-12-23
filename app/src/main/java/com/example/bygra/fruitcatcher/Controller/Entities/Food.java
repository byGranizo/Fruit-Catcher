package com.example.bygra.fruitcatcher.Controller.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class Food {

    private Context context;
    private Point size;
    private Point location;
    private Bitmap bitmap;
    private Boolean lifeLose;
    private int score;

    public Food(Context context, Point location) {
        this.context = context;
        this.location = location;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {//creo que se puede eliminar
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

    public Boolean getLifeLose() {
        return lifeLose;
    }

    public void setLifeLose(Boolean lifeLose) {
        this.lifeLose = lifeLose;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //Get the screen size in pixels
    protected Point getScreenSize(){
        Point screenSize = new Point();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        d.getRealSize(screenSize);
        return screenSize;
    }
}


