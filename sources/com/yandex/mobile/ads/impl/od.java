package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
@SuppressLint({"ViewConstructor"})
public final class od extends View {
    @NonNull
    private final dv a;
    @NonNull
    private Paint b;
    @NonNull
    private Paint c;
    @NonNull
    private Paint d;
    private float e = 40.0f;
    private float f;
    private float g;
    private float h;

    public od(@NonNull Context context, @NonNull dv dvVar) {
        super(context);
        this.a = dvVar;
        this.f = (float) dv.a(context, 34.0f);
        this.g = (float) dv.a(context, 3.0f);
        this.h = (float) dv.a(context, 20.0f);
        Paint paint = new Paint();
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.g);
        this.c.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.d = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.d.setTextSize(this.h);
        this.d.setTextAlign(Paint.Align.CENTER);
        a();
    }

    private void a() {
        this.c.setColor(eg.a((int) SupportMenu.CATEGORY_MASK, this.e));
        this.b.setColor(eg.a(-1, this.e));
        this.d.setColor(eg.a((int) SupportMenu.CATEGORY_MASK, this.e));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.f / 2.0f;
        canvas.drawCircle(f2, f2, f2, this.b);
        canvas.drawCircle(f2, f2, f2 - (this.g / 2.0f), this.c);
        float f3 = this.f;
        canvas.drawText("!", f3 / 2.0f, (f3 / 2.0f) - ((this.d.ascent() + this.d.descent()) / 2.0f), this.d);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        float f2 = this.f;
        setMeasuredDimension((int) f2, (int) f2);
    }

    @Override // android.view.View
    public final void setSelected(boolean z) {
        super.setSelected(z);
        this.e = z ? 0.0f : 40.0f;
        a();
        invalidate();
    }
}
