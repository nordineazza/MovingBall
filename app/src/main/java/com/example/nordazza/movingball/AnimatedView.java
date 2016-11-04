package com.example.nordazza.movingball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import static java.lang.Math.abs;

/**
 * Created by Nordazza on 04/11/2016.
 */

public class AnimatedView extends View implements Runnable{

    private Path path = null;
    private Paint paint = null;
    private Context context;
    private float x =0;
    private float y = 0;
    private int dx, dy;
    BitmapDrawable bitmap = null;
    private Handler handler;
    boolean bord_x = false;
    boolean bord_y = false;
    private GestureDetector gestureDetector;
    float pente = 0;

    public AnimatedView(Context c)
    {
        super(c);
        this.context = c;
        x = y = 0;
        handler = new Handler();
        gestureDetector = new GestureDetector(c, new myTouch());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    protected void onDraw(Canvas canvas)
    {
        bitmap = (BitmapDrawable) context.getResources().getDrawable(R.drawable.ball, null);
        canvas.drawBitmap(bitmap.getBitmap(),x, y,paint);
        handler.postDelayed(this, 10);
    }

    @Override
    public void run() {
        invalidate();
        if(x >= getWidth())
            bord_x = true;
        if(x <= 0)
            bord_x = false;
        if(y > getHeight())
            bord_y = true;
        if(y <= 0)
            bord_y = false;

            x = (bord_x) ? x-10 : x+10;
            y = (bord_y) ? y-10 : y+10;


    }

    private class myTouch implements GestureDetector.OnGestureListener {


        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            pente = Math.abs(motionEvent1.getY()-motionEvent.getY())/((motionEvent1.getX() - motionEvent.getX()));
            if(v < 0)
                x += 10;
            else
                x = 10;
            if(v1 < 0)
                y = -pente * 10;
            else
                y = pente * 10;


            return true;
        }

        //Menu

    }

}
