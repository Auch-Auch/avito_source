package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Arrays;
public abstract class RoundedDrawable extends Drawable implements Rounded, TransformAwareDrawable {
    public final Drawable a;
    public final float[] b = new float[8];
    @VisibleForTesting
    public final float[] c = new float[8];
    @Nullable
    @VisibleForTesting
    public float[] d;
    @VisibleForTesting
    public final RectF e = new RectF();
    @VisibleForTesting
    public final RectF f = new RectF();
    @VisibleForTesting
    public final RectF g = new RectF();
    @VisibleForTesting
    public final RectF h = new RectF();
    @Nullable
    @VisibleForTesting
    public RectF i;
    @VisibleForTesting
    public final Matrix j = new Matrix();
    @VisibleForTesting
    public final Matrix k = new Matrix();
    @VisibleForTesting
    public final Matrix l = new Matrix();
    @VisibleForTesting
    public final Matrix m = new Matrix();
    public int mBorderColor = 0;
    public final Path mBorderPath = new Path();
    public float mBorderWidth = 0.0f;
    public boolean mIsCircle = false;
    public boolean mIsShaderTransformDirty = true;
    public final Path mPath = new Path();
    public boolean mRadiiNonZero = false;
    @VisibleForTesting
    public final Matrix n = new Matrix();
    @Nullable
    @VisibleForTesting
    public Matrix o;
    @Nullable
    @VisibleForTesting
    public Matrix p;
    @VisibleForTesting
    public final Matrix q = new Matrix();
    public float r = 0.0f;
    public boolean s = false;
    public boolean t = false;
    public boolean u = true;
    @Nullable
    public TransformCallback v;

    public RoundedDrawable(Drawable drawable) {
        this.a = drawable;
    }

    @VisibleForTesting
    public boolean a() {
        return this.mIsCircle || this.mRadiiNonZero || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.a.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("RoundedDrawable#draw");
        }
        this.a.draw(canvas);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.a.getAlpha();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.a.getOpacity();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.r;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getPaintFilterBitmap() {
        return this.t;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.b;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.s;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.mIsCircle;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.setAlpha(i2);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i2, float f2) {
        if (this.mBorderColor != i2 || this.mBorderWidth != f2) {
            this.mBorderColor = i2;
            this.mBorderWidth = f2;
            this.u = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.mIsCircle = z;
        this.u = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i2, @NonNull PorterDuff.Mode mode) {
        this.a.setColorFilter(i2, mode);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f2) {
        if (this.r != f2) {
            this.r = f2;
            this.u = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPaintFilterBitmap(boolean z) {
        if (this.t != z) {
            this.t = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.b, 0.0f);
            this.mRadiiNonZero = false;
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.b, 0, 8);
            this.mRadiiNonZero = false;
            for (int i2 = 0; i2 < 8; i2++) {
                this.mRadiiNonZero |= fArr[i2] > 0.0f;
            }
        }
        this.u = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f2) {
        boolean z = false;
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        Preconditions.checkState(i2 >= 0);
        Arrays.fill(this.b, f2);
        if (i2 != 0) {
            z = true;
        }
        this.mRadiiNonZero = z;
        this.u = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        if (this.s != z) {
            this.s = z;
            this.u = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(@Nullable TransformCallback transformCallback) {
        this.v = transformCallback;
    }

    public void updatePath() {
        float[] fArr;
        if (this.u) {
            this.mBorderPath.reset();
            RectF rectF = this.e;
            float f2 = this.mBorderWidth;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            if (this.mIsCircle) {
                this.mBorderPath.addCircle(this.e.centerX(), this.e.centerY(), Math.min(this.e.width(), this.e.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i2 = 0;
                while (true) {
                    fArr = this.c;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = (this.b[i2] + this.r) - (this.mBorderWidth / 2.0f);
                    i2++;
                }
                this.mBorderPath.addRoundRect(this.e, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.e;
            float f3 = this.mBorderWidth;
            rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
            this.mPath.reset();
            float f4 = this.r + (this.s ? this.mBorderWidth : 0.0f);
            this.e.inset(f4, f4);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.e.centerX(), this.e.centerY(), Math.min(this.e.width(), this.e.height()) / 2.0f, Path.Direction.CW);
            } else if (this.s) {
                if (this.d == null) {
                    this.d = new float[8];
                }
                for (int i3 = 0; i3 < this.c.length; i3++) {
                    this.d[i3] = this.b[i3] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.e, this.d, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.e, this.b, Path.Direction.CW);
            }
            float f5 = -f4;
            this.e.inset(f5, f5);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.u = false;
        }
    }

    public void updateTransform() {
        Matrix matrix;
        TransformCallback transformCallback = this.v;
        if (transformCallback != null) {
            transformCallback.getTransform(this.l);
            this.v.getRootBounds(this.e);
        } else {
            this.l.reset();
            this.e.set(getBounds());
        }
        this.g.set(0.0f, 0.0f, (float) getIntrinsicWidth(), (float) getIntrinsicHeight());
        this.h.set(this.a.getBounds());
        this.j.setRectToRect(this.g, this.h, Matrix.ScaleToFit.FILL);
        if (this.s) {
            RectF rectF = this.i;
            if (rectF == null) {
                this.i = new RectF(this.e);
            } else {
                rectF.set(this.e);
            }
            RectF rectF2 = this.i;
            float f2 = this.mBorderWidth;
            rectF2.inset(f2, f2);
            if (this.o == null) {
                this.o = new Matrix();
            }
            this.o.setRectToRect(this.e, this.i, Matrix.ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.o;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.l.equals(this.m) || !this.j.equals(this.k) || ((matrix = this.o) != null && !matrix.equals(this.p))) {
            this.mIsShaderTransformDirty = true;
            this.l.invert(this.n);
            this.q.set(this.l);
            if (this.s) {
                this.q.postConcat(this.o);
            }
            this.q.preConcat(this.j);
            this.m.set(this.l);
            this.k.set(this.j);
            if (this.s) {
                Matrix matrix3 = this.p;
                if (matrix3 == null) {
                    this.p = new Matrix(this.o);
                } else {
                    matrix3.set(this.o);
                }
            } else {
                Matrix matrix4 = this.p;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (!this.e.equals(this.f)) {
            this.u = true;
            this.f.set(this.e);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
