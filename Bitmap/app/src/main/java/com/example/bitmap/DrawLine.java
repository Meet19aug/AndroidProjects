package com.example.bitmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

public class DrawLine extends View {
    private Paint paint=new Paint();

    public DrawLine(Context context)
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
        canvas.drawLine(50,100,600,600,paint);
    }
}
