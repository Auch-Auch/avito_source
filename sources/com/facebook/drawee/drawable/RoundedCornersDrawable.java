package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    @VisibleForTesting
    public Type d = Type.OVERLAY_COLOR;
    public final RectF e = new RectF();
    @Nullable
    public RectF f;
    @Nullable
    public Matrix g;
    public final float[] h = new float[8];
    @VisibleForTesting
    public final float[] i = new float[8];
    @VisibleForTesting
    public final Paint j = new Paint(1);
    public boolean k = false;
    public float l = 0.0f;
    public int m = 0;
    public int n = 0;
    public float o = 0.0f;
    public boolean p = false;
    public boolean q = false;
    public final Path r = new Path();
    public final Path s = new Path();
    public final RectF t = new RectF();

    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) Preconditions.checkNotNull(drawable));
    }

    public final void a() {
        float[] fArr;
        this.r.reset();
        this.s.reset();
        this.t.set(getBounds());
        RectF rectF = this.t;
        float f2 = this.o;
        rectF.inset(f2, f2);
        if (this.d == Type.OVERLAY_COLOR) {
            this.r.addRect(this.t, Path.Direction.CW);
        }
        if (this.k) {
            this.r.addCircle(this.t.centerX(), this.t.centerY(), Math.min(this.t.width(), this.t.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.r.addRoundRect(this.t, this.h, Path.Direction.CW);
        }
        RectF rectF2 = this.t;
        float f3 = this.o;
        rectF2.inset(-f3, -f3);
        RectF rectF3 = this.t;
        float f4 = this.l;
        rectF3.inset(f4 / 2.0f, f4 / 2.0f);
        if (this.k) {
            this.s.addCircle(this.t.centerX(), this.t.centerY(), Math.min(this.t.width(), this.t.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.i;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (this.h[i2] + this.o) - (this.l / 2.0f);
                i2++;
            }
            this.s.addRoundRect(this.t, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.t;
        float f5 = this.l;
        rectF4.inset((-f5) / 2.0f, (-f5) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.e.set(getBounds());
        int ordinal = this.d.ordinal();
        if (ordinal == 0) {
            if (this.p) {
                RectF rectF = this.f;
                if (rectF == null) {
                    this.f = new RectF(this.e);
                    this.g = new Matrix();
                } else {
                    rectF.set(this.e);
                }
                RectF rectF2 = this.f;
                float f2 = this.l;
                rectF2.inset(f2, f2);
                this.g.setRectToRect(this.e, this.f, Matrix.ScaleToFit.FILL);
                int save = canvas.save();
                canvas.clipRect(this.e);
                canvas.concat(this.g);
                super.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                super.draw(canvas);
            }
            this.j.setStyle(Paint.Style.FILL);
            this.j.setColor(this.n);
            this.j.setStrokeWidth(0.0f);
            this.j.setFilterBitmap(getPaintFilterBitmap());
            this.r.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.r, this.j);
            if (this.k) {
                float width = ((this.e.width() - this.e.height()) + this.l) / 2.0f;
                float height = ((this.e.height() - this.e.width()) + this.l) / 2.0f;
                if (width > 0.0f) {
                    RectF rectF3 = this.e;
                    float f3 = rectF3.left;
                    canvas.drawRect(f3, rectF3.top, f3 + width, rectF3.bottom, this.j);
                    RectF rectF4 = this.e;
                    float f4 = rectF4.right;
                    canvas.drawRect(f4 - width, rectF4.top, f4, rectF4.bottom, this.j);
                }
                if (height > 0.0f) {
                    RectF rectF5 = this.e;
                    float f5 = rectF5.left;
                    float f6 = rectF5.top;
                    canvas.drawRect(f5, f6, rectF5.right, f6 + height, this.j);
                    RectF rectF6 = this.e;
                    float f7 = rectF6.left;
                    float f8 = rectF6.bottom;
                    canvas.drawRect(f7, f8 - height, rectF6.right, f8, this.j);
                }
            }
        } else if (ordinal == 1) {
            int save2 = canvas.save();
            canvas.clipPath(this.r);
            super.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (this.m != 0) {
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setColor(this.m);
            this.j.setStrokeWidth(this.l);
            this.r.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.s, this.j);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.m;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.l;
    }

    public int getOverlayColor() {
        return this.n;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.o;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getPaintFilterBitmap() {
        return this.q;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.h;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.p;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.k;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i2, float f2) {
        this.m = i2;
        this.l = f2;
        a();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.k = z;
        a();
        invalidateSelf();
    }

    public void setOverlayColor(int i2) {
        this.n = i2;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f2) {
        this.o = f2;
        a();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPaintFilterBitmap(boolean z) {
        if (this.q != z) {
            this.q = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.h, 0.0f);
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.h, 0, 8);
        }
        a();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f2) {
        Arrays.fill(this.h, f2);
        a();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        this.p = z;
        a();
        invalidateSelf();
    }

    public void setType(Type type) {
        this.d = type;
        a();
        invalidateSelf();
    }
}
