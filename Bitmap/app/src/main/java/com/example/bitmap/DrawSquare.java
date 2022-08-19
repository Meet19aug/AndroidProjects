package com.example.bitmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

public class DrawSquare extends View
{
    private Paint paint=new Paint();
    public DrawSquare(Context context){super(context);}
    @Override
    protected void onDraw(Canvas canvas){
        //clear canvas
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        //draw Square
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        canvas.drawRect(400,1000,800,600,paint);
    }

}
