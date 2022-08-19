package com.example.bitmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

public class DrawRectangle extends View {
    private Paint paint=new Paint();

    public DrawRectangle(Context context)
    {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //clear canvas
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        //draw line
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        canvas.drawRect(100,1000,800,100,paint);
    }
}
