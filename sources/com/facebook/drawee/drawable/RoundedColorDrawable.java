package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
public class RoundedColorDrawable extends Drawable implements Rounded {
    public final float[] a;
    @VisibleForTesting
    public final float[] b;
    @VisibleForTesting
    @Nullable
    public float[] c;
    @VisibleForTesting
    public final Paint d;
    public boolean e;
    public float f;
    public float g;
    public int h;
    public boolean i;
    public boolean j;
    @VisibleForTesting
    public final Path k;
    @VisibleForTesting
    public final Path l;
    public int m;
    public final RectF n;
    public int o;

    public RoundedColorDrawable(int i2) {
        this.a = new float[8];
        this.b = new float[8];
        this.d = new Paint(1);
        this.e = false;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.k = new Path();
        this.l = new Path();
        this.m = 0;
        this.n = new RectF();
        this.o = 255;
        setColor(i2);
    }

    @TargetApi(11)
    public static RoundedColorDrawable fromColorDrawable(ColorDrawable colorDrawable) {
        return new RoundedColorDrawable(colorDrawable.getColor());
    }

    public final void a() {
        float[] fArr;
        float[] fArr2;
        this.k.reset();
        this.l.reset();
        this.n.set(getBounds());
        RectF rectF = this.n;
        float f2 = this.f;
        rectF.inset(f2 / 2.0f, f2 / 2.0f);
        int i2 = 0;
        if (this.e) {
            this.l.addCircle(this.n.centerX(), this.n.centerY(), Math.min(this.n.width(), this.n.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i3 = 0;
            while (true) {
                fArr2 = this.b;
                if (i3 >= fArr2.length) {
                    break;
                }
                fArr2[i3] = (this.a[i3] + this.g) - (this.f / 2.0f);
                i3++;
            }
            this.l.addRoundRect(this.n, fArr2, Path.Direction.CW);
        }
        RectF rectF2 = this.n;
        float f3 = this.f;
        rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
        float f4 = this.g + (this.i ? this.f : 0.0f);
        this.n.inset(f4, f4);
        if (this.e) {
            this.k.addCircle(this.n.centerX(), this.n.centerY(), Math.min(this.n.width(), this.n.height()) / 2.0f, Path.Direction.CW);
        } else if (this.i) {
            if (this.c == null) {
                this.c = new float[8];
            }
            while (true) {
                fArr = this.c;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = this.a[i2] - this.f;
                i2++;
            }
            this.k.addRoundRect(this.n, fArr, Path.Direction.CW);
        } else {
            this.k.addRoundRect(this.n, this.a, Path.Direction.CW);
        }
        float f5 = -f4;
        this.n.inset(f5, f5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.d.setColor(DrawableUtils.multiplyColorAlpha(this.m, this.o));
        this.d.setStyle(Paint.Style.FILL);
        this.d.setFilterBitmap(getPaintFilterBitmap());
        canvas.drawPath(this.k, this.d);
        if (this.f != 0.0f) {
            this.d.setColor(DrawableUtils.multiplyColorAlpha(this.h, this.o));
            this.d.setStyle(Paint.Style.STROKE);
            this.d.setStrokeWidth(this.f);
            canvas.drawPath(this.l, this.d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.o;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.h;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.f;
    }

    public int getColor() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(DrawableUtils.multiplyColorAlpha(this.m, this.o));
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.g;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getPaintFilterBitmap() {
        return this.j;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.a;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.i;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.o) {
            this.o = i2;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i2, float f2) {
        if (this.h != i2) {
            this.h = i2;
            invalidateSelf();
        }
        if (this.f != f2) {
            this.f = f2;
            a();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.e = z;
        a();
        invalidateSelf();
    }

    public void setColor(int i2) {
        if (this.m != i2) {
            this.m = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f2) {
        if (this.g != f2) {
            this.g = f2;
            a();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPaintFilterBitmap(boolean z) {
        if (this.j != z) {
            this.j = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.a, 0.0f);
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.a, 0, 8);
        }
        a();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f2) {
        Preconditions.checkArgument(f2 >= 0.0f, "radius should be non negative");
        Arrays.fill(this.a, f2);
        a();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        if (this.i != z) {
            this.i = z;
            a();
            invalidateSelf();
        }
    }

    public RoundedColorDrawable(float[] fArr, int i2) {
        this(i2);
        setRadii(fArr);
    }

    public RoundedColorDrawable(float f2, int i2) {
        this(i2);
        setRadius(f2);
    }
}
