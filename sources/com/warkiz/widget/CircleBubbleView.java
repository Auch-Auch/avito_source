package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
public class CircleBubbleView extends View {
    public int a;
    public int b;
    public float c;
    public Context d;
    public Path e;
    public Paint f;
    public float g;
    public float h;
    public float i;
    public String j;

    public CircleBubbleView(Context context, float f2, int i2, int i3, String str) {
        super(context, null, 0);
        this.d = context;
        this.c = f2;
        this.a = i2;
        this.b = i3;
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.f.setStrokeWidth(1.0f);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setTextSize(this.c);
        Rect rect = new Rect();
        this.f.getTextBounds(str, 0, str.length(), rect);
        this.g = (float) (SizeUtils.dp2px(this.d, 4.0f) + rect.width());
        float dp2px = (float) SizeUtils.dp2px(this.d, 36.0f);
        if (this.g < dp2px) {
            this.g = dp2px;
        }
        this.i = (float) rect.height();
        this.h = this.g * 1.2f;
        this.e = new Path();
        float f3 = this.g;
        this.e.arcTo(new RectF(0.0f, 0.0f, f3, f3), 135.0f, 270.0f);
        this.e.lineTo(this.g / 2.0f, this.h);
        this.e.close();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f.setColor(this.b);
        canvas.drawPath(this.e, this.f);
        this.f.setColor(this.a);
        canvas.drawText(this.j, this.g / 2.0f, (this.i / 4.0f) + (this.h / 2.0f), this.f);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension((int) this.g, (int) this.h);
    }

    public void setProgress(String str) {
        this.j = str;
        invalidate();
    }
}
