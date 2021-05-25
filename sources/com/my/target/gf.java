package com.my.target;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
public class gf extends View {
    @NonNull
    public final Paint a = new Paint();
    @NonNull
    public final Paint b = new Paint();
    @NonNull
    public final Paint c = new Paint();
    @NonNull
    public final io d;
    @NonNull
    public RectF e = new RectF();
    public long f = 0;
    public float g = 0.0f;
    public float h = 0.0f;
    public float i = 230.0f;
    public int j;

    public gf(@NonNull Context context) {
        super(context);
        this.d = io.af(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        super.onDraw(canvas);
        canvas.drawOval(this.e, this.b);
        if (this.g != this.h) {
            this.g = Math.min(this.g + ((((float) (SystemClock.uptimeMillis() - this.f)) / 1000.0f) * this.i), this.h);
            this.f = SystemClock.uptimeMillis();
            z = true;
        } else {
            z = false;
        }
        canvas.drawArc(this.e, -90.0f, isInEditMode() ? 360.0f : this.g, false, this.a);
        this.c.setColor(-1);
        this.c.setTextSize((float) this.d.L(12));
        this.c.setTextAlign(Paint.Align.CENTER);
        this.c.setAntiAlias(true);
        canvas.drawText(String.valueOf(this.j), (float) ((int) this.e.centerX()), (float) ((int) (this.e.centerY() - ((this.c.ascent() + this.c.descent()) / 2.0f))), this.c);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft() + this.d.L(28);
        int paddingBottom = getPaddingBottom() + getPaddingTop() + this.d.L(28);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            paddingRight = Math.min(paddingRight, size);
        } else if (mode == 1073741824) {
            paddingRight = size;
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingBottom = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingBottom = Math.min(paddingBottom, size2);
        }
        setMeasuredDimension(paddingRight, paddingBottom);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        this.e = new RectF((float) (this.d.L(1) + getPaddingLeft()), (float) (this.d.L(1) + paddingTop), (float) ((i2 - getPaddingRight()) - this.d.L(1)), (float) ((i3 - paddingBottom) - this.d.L(1)));
        this.a.setColor(-1);
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth((float) this.d.L(1));
        this.b.setColor(-2013265920);
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setStrokeWidth((float) this.d.L(4));
        invalidate();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            this.f = SystemClock.uptimeMillis();
        }
    }

    public void setDigit(int i2) {
        this.j = i2;
    }

    public void setMax(float f2) {
        if (f2 > 0.0f) {
            this.i = 360.0f / f2;
        }
    }

    public void setProgress(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = this.h;
        if (f2 != f3) {
            if (this.g == f3) {
                this.f = SystemClock.uptimeMillis();
            }
            this.h = Math.min(f2 * 360.0f, 360.0f);
            invalidate();
        }
    }
}
