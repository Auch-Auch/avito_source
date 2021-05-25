package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
public class ArrowView extends View {
    public final int a;
    public final int b;
    public final Path c;
    public final Paint d;

    public ArrowView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawPath(this.c, this.d);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.a, this.b);
    }

    public void setColor(int i) {
        this.d.setColor(i);
        invalidate();
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int dp2px = SizeUtils.dp2px(context, 12.0f);
        this.a = dp2px;
        int dp2px2 = SizeUtils.dp2px(context, 7.0f);
        this.b = dp2px2;
        Path path = new Path();
        this.c = path;
        path.moveTo(0.0f, 0.0f);
        path.lineTo((float) dp2px, 0.0f);
        path.lineTo(((float) dp2px) / 2.0f, (float) dp2px2);
        path.close();
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
    }
}
