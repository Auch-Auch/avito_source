package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
public class gb extends View {
    public static final Paint a;
    public static final Path b = new Path();

    static {
        Paint paint = new Paint();
        a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
    }

    public gb(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        Path path = b;
        path.reset();
        path.setFillType(Path.FillType.EVEN_ODD);
        float f = 0.45f * measuredHeight;
        double d = (double) measuredHeight;
        float f2 = measuredHeight * 2.0f;
        path.moveTo((float) a.a(0.0d, d, d), f2 - ((float) ((Math.cos(0.0d) * d) + d)));
        double d2 = (double) f;
        path.lineTo((float) a.a(0.6283185307179586d, d2, d), f2 - ((float) ((Math.cos(0.6283185307179586d) * d2) + d)));
        for (int i = 1; i < 5; i++) {
            Path path2 = b;
            double d3 = ((double) i) * 1.2566370614359172d;
            path2.lineTo((float) a.a(d3, d, d), f2 - ((float) ((Math.cos(d3) * d) + d)));
            double d4 = d3 + 0.6283185307179586d;
            path2.lineTo((float) a.a(d4, d2, d), f2 - ((float) ((Math.cos(d4) * d2) + d)));
        }
        Path path3 = b;
        path3.close();
        canvas.drawPath(path3, a);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (size != 0 && size2 != 0) {
            size = Math.min(size, size2);
        } else if (size == 0) {
            size = size2;
        }
        setMeasuredDimension(size, size);
    }

    public void setColor(int i) {
        a.setColor(i);
        invalidate();
    }
}
