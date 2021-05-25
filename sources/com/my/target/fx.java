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
public class fx extends View {
    @NonNull
    public final Rect a = new Rect();
    @NonNull
    public final Paint b;
    @NonNull
    public final ColorFilter c = new LightingColorFilter(-3355444, 1);
    public final float d;
    public final int e;
    @Nullable
    public Bitmap f;
    public int g;
    public int h;

    public fx(@NonNull Context context) {
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
            int i2 = this.g;
            int i3 = this.e;
            setMeasuredDimension((i3 * 2) + i2, (i3 * 2) + this.h);
            requestLayout();
        }
        this.g = i;
        int i2 = this.g;
        int i3 = this.e;
        setMeasuredDimension((i3 * 2) + i2, (i3 * 2) + this.h);
        requestLayout();
    }

    public int getPadding() {
        return this.e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            Rect rect = this.a;
            int i = this.e;
            rect.left = i;
            rect.top = i;
            rect.right = this.g + i;
            rect.bottom = this.h + i;
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.b);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
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
}
