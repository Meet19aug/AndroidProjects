package com.example.bitmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.view.View;

public class DrawTriangle extends View {
    private Paint paint=new Paint();
    Path path=new Path();

    public DrawTriangle(Context context)
    {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        //clear canvas
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        Point a=new Point(350,50);
        Point b=new Point(350,300);
        Point c=new Point(550,300);

        //draw line
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);

        path.setFillType(Path.FillType.EVEN_ODD);
        path.lineTo(a.x,a.y);
        path.lineTo(b.x,b.y);
        path.lineTo(c.x,c.y);
        path.lineTo(a.x,a.y);

        canvas.drawPath(path,paint);

    }
}
