package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.yandex.mobile.ads.impl.el;
@SuppressLint({"ViewConstructor"})
public final class ob extends FrameLayout {
    @NonNull
    private final dv a;
    @NonNull
    private final Paint b;
    @NonNull
    private final el c = new ek();
    private int d;

    public ob(@NonNull Context context, @NonNull dv dvVar) {
        super(context);
        this.a = dvVar;
        Paint paint = new Paint();
        this.b = paint;
        int a3 = dv.a(context, 1.0f);
        this.d = dv.a(context, 0.5f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) a3);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        setClickable(false);
        setFocusable(false);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.d;
        canvas.drawRect((float) i, (float) i, (float) (getWidth() - this.d), (float) (getHeight() - this.d), this.b);
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewParent parent = getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            setLeft(0);
            setTop(0);
            setRight(measuredWidth);
            setBottom(measuredHeight);
            super.onLayout(z, 0, 0, measuredWidth, measuredHeight);
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        el.a a3 = this.c.a(i, i2);
        super.onMeasure(a3.a, a3.b);
    }

    public final void setColor(int i) {
        if (this.b.getColor() != i) {
            this.b.setColor(i);
            requestLayout();
        }
    }
}
