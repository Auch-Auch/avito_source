package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class fy extends View {
    @NonNull
    public final Rect a = new Rect();
    @NonNull
    public final Paint b;
    @NonNull
    public final ColorFilter c = new LightingColorFilter(-3355444, 1);
    public final float d;
    public int e;
    @Nullable
    public Bitmap f;
    public int g;
    public int h;

    public fy(@NonNull Context context) {
        super(context);
        Paint paint = new Paint();
        this.b = paint;
        paint.setFilterBitmap(true);
        this.d = context.getResources().getDisplayMetrics().density;
        this.e = io.c(10, context);
    }

    public void a(@Nullable Bitmap bitmap, boolean z) {
        int i;
        this.f = bitmap;
        if (bitmap == null) {
            i = 0;
            this.h = 0;
        } else if (z) {
            float f2 = 1.0f;
            if (this.d > 1.0f) {
                f2 = 2.0f;
            }
            this.h = (int) ((((float) bitmap.getHeight()) / f2) * this.d);
            i = (int) ((((float) this.f.getWidth()) / f2) * this.d);
        } else {
            this.g = bitmap.getWidth();
            this.h = this.f.getHeight();
            requestLayout();
        }
        this.g = i;
        requestLayout();
    }

    public int getPadding() {
        return this.e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f != null) {
            Rect rect = this.a;
            int i = this.e;
            rect.left = i;
            rect.top = i;
            rect.right = getMeasuredWidth() - this.e;
            this.a.bottom = getMeasuredHeight() - this.e;
            canvas.drawBitmap(this.f, (Rect) null, this.a, this.b);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = this.e;
        int i6 = size - (i5 * 2);
        int i7 = size2 - (i5 * 2);
        if (this.f == null || (i3 = this.g) <= 0 || (i4 = this.h) <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        float f2 = ((float) i3) / ((float) i4);
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(i6, i7);
            return;
        }
        if (mode == 0 && mode2 == 0) {
            i6 = i3;
            i7 = i4;
        } else if (mode == 0) {
            i6 = (int) (((float) i7) * f2);
        } else {
            float f3 = (float) i6;
            if (mode2 != 0) {
                float f4 = f3 / ((float) i3);
                float f5 = (float) i7;
                if (Math.min(f4, f5 / ((float) i4)) != f4 || f2 <= 0.0f) {
                    i6 = (int) (f5 * f2);
                }
            }
            i7 = (int) (f3 / f2);
        }
        int i8 = this.e;
        setMeasuredDimension((i8 * 2) + i6, (i8 * 2) + i7);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Paint paint;
        ColorFilter colorFilter;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 3) {
                    return super.onTouchEvent(motionEvent);
                }
            } else if (motionEvent.getX() >= 0.0f && motionEvent.getX() <= ((float) getMeasuredWidth()) && motionEvent.getY() >= 0.0f && motionEvent.getY() <= ((float) getMeasuredHeight())) {
                performClick();
            }
            paint = this.b;
            colorFilter = null;
        } else {
            paint = this.b;
            colorFilter = this.c;
        }
        paint.setColorFilter(colorFilter);
        invalidate();
        return true;
    }

    public void setPadding(int i) {
        this.e = i;
    }
}
