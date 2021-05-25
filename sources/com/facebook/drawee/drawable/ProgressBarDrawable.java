package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
public class ProgressBarDrawable extends Drawable implements CloneableDrawable {
    public final Paint a = new Paint(1);
    public final Path b = new Path();
    public final RectF c = new RectF();
    public int d = Integer.MIN_VALUE;
    public int e = -2147450625;
    public int f = 10;
    public int g = 20;
    public int h = 0;
    public int i = 0;
    public boolean j = false;
    public boolean k = false;

    public final void a(Canvas canvas, int i2) {
        this.a.setColor(i2);
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.reset();
        this.b.setFillType(Path.FillType.EVEN_ODD);
        this.b.addRoundRect(this.c, (float) Math.min(this.i, this.g / 2), (float) Math.min(this.i, this.g / 2), Path.Direction.CW);
        canvas.drawPath(this.b, this.a);
    }

    public final void b(Canvas canvas, int i2, int i3) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int i4 = this.f;
        int i5 = bounds.left + i4;
        int i6 = bounds.bottom - i4;
        int i7 = this.g;
        int i8 = i6 - i7;
        this.c.set((float) i5, (float) i8, (float) (i5 + (((width - (i4 * 2)) * i2) / 10000)), (float) (i8 + i7));
        a(canvas, i3);
    }

    public final void c(Canvas canvas, int i2, int i3) {
        Rect bounds = getBounds();
        int height = bounds.height();
        int i4 = this.f;
        int i5 = bounds.left + i4;
        int i6 = bounds.top + i4;
        this.c.set((float) i5, (float) i6, (float) (i5 + this.g), (float) (i6 + (((height - (i4 * 2)) * i2) / 10000)));
        a(canvas, i3);
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public Drawable cloneDrawable() {
        ProgressBarDrawable progressBarDrawable = new ProgressBarDrawable();
        progressBarDrawable.d = this.d;
        progressBarDrawable.e = this.e;
        progressBarDrawable.f = this.f;
        progressBarDrawable.g = this.g;
        progressBarDrawable.h = this.h;
        progressBarDrawable.i = this.i;
        progressBarDrawable.j = this.j;
        progressBarDrawable.k = this.k;
        return progressBarDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.j && this.h == 0) {
            return;
        }
        if (this.k) {
            c(canvas, 10000, this.d);
            c(canvas, this.h, this.e);
            return;
        }
        b(canvas, 10000, this.d);
        b(canvas, this.h, this.e);
    }

    public int getBackgroundColor() {
        return this.d;
    }

    public int getBarWidth() {
        return this.g;
    }

    public int getColor() {
        return this.e;
    }

    public boolean getHideWhenZero() {
        return this.j;
    }

    public boolean getIsVertical() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(this.a.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int i2 = this.f;
        rect.set(i2, i2, i2, i2);
        return this.f != 0;
    }

    public int getRadius() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        this.h = i2;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.setAlpha(i2);
    }

    public void setBackgroundColor(int i2) {
        if (this.d != i2) {
            this.d = i2;
            invalidateSelf();
        }
    }

    public void setBarWidth(int i2) {
        if (this.g != i2) {
            this.g = i2;
            invalidateSelf();
        }
    }

    public void setColor(int i2) {
        if (this.e != i2) {
            this.e = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public void setHideWhenZero(boolean z) {
        this.j = z;
    }

    public void setIsVertical(boolean z) {
        if (this.k != z) {
            this.k = z;
            invalidateSelf();
        }
    }

    public void setPadding(int i2) {
        if (this.f != i2) {
            this.f = i2;
            invalidateSelf();
        }
    }

    public void setRadius(int i2) {
        if (this.i != i2) {
            this.i = i2;
            invalidateSelf();
        }
    }
}
