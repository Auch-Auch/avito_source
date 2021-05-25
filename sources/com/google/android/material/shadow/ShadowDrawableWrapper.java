package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapper {
    public static final double q = Math.cos(Math.toRadians(45.0d));
    @NonNull
    public final Paint b;
    @NonNull
    public final Paint c;
    @NonNull
    public final RectF d;
    public float e;
    public Path f;
    public float g;
    public float h;
    public float i;
    public boolean j = true;
    public final int k;
    public final int l;
    public final int m;
    public boolean n = true;
    public float o;
    public boolean p = false;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f2, float f3, float f4) {
        super(drawable);
        this.k = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.l = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.m = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e = (float) Math.round(f2);
        this.d = new RectF();
        Paint paint2 = new Paint(paint);
        this.c = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f3, f4);
    }

    public static float calculateHorizontalPadding(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        return (float) (((1.0d - q) * ((double) f3)) + ((double) f2));
    }

    public static float calculateVerticalPadding(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        return (float) (((1.0d - q) * ((double) f3)) + ((double) (f2 * 1.5f)));
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        boolean z;
        int i2;
        int i3;
        if (this.j) {
            Rect bounds = getBounds();
            float f2 = this.g;
            float f3 = 1.5f * f2;
            this.d.set(((float) bounds.left) + f2, ((float) bounds.top) + f3, ((float) bounds.right) - f2, ((float) bounds.bottom) - f3);
            Drawable wrappedDrawable = getWrappedDrawable();
            RectF rectF = this.d;
            wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            float f4 = this.e;
            float f5 = -f4;
            RectF rectF2 = new RectF(f5, f5, f4, f4);
            RectF rectF3 = new RectF(rectF2);
            float f6 = -this.h;
            rectF3.inset(f6, f6);
            Path path = this.f;
            if (path == null) {
                this.f = new Path();
            } else {
                path.reset();
            }
            this.f.setFillType(Path.FillType.EVEN_ODD);
            this.f.moveTo(-this.e, 0.0f);
            this.f.rLineTo(-this.h, 0.0f);
            this.f.arcTo(rectF3, 180.0f, 90.0f, false);
            this.f.arcTo(rectF2, 270.0f, -90.0f, false);
            this.f.close();
            float f7 = -rectF3.top;
            if (f7 > 0.0f) {
                float f8 = this.e / f7;
                this.b.setShader(new RadialGradient(0.0f, 0.0f, f7, new int[]{0, this.k, this.l, this.m}, new float[]{0.0f, f8, ((1.0f - f8) / 2.0f) + f8, 1.0f}, Shader.TileMode.CLAMP));
            }
            z = true;
            this.c.setShader(new LinearGradient(0.0f, rectF2.top, 0.0f, rectF3.top, new int[]{this.k, this.l, this.m}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.c.setAntiAlias(false);
            this.j = false;
        } else {
            z = true;
        }
        int save = canvas.save();
        canvas.rotate(this.o, this.d.centerX(), this.d.centerY());
        float f9 = this.e;
        float f10 = (-f9) - this.h;
        float f11 = f9 * 2.0f;
        boolean z2 = this.d.width() - f11 > 0.0f;
        if (this.d.height() - f11 <= 0.0f) {
            z = false;
        }
        float f12 = this.i;
        float f13 = f9 / ((f12 - (0.5f * f12)) + f9);
        float f14 = f9 / ((f12 - (0.25f * f12)) + f9);
        float f15 = f9 / ((f12 - (f12 * 1.0f)) + f9);
        int save2 = canvas.save();
        RectF rectF4 = this.d;
        canvas.translate(rectF4.left + f9, rectF4.top + f9);
        canvas.scale(f13, f14);
        canvas.drawPath(this.f, this.b);
        if (z2) {
            canvas.scale(1.0f / f13, 1.0f);
            i2 = save;
            i3 = save2;
            canvas.drawRect(0.0f, f10, this.d.width() - f11, -this.e, this.c);
        } else {
            i2 = save;
            i3 = save2;
        }
        canvas.restoreToCount(i3);
        int save3 = canvas.save();
        RectF rectF5 = this.d;
        canvas.translate(rectF5.right - f9, rectF5.bottom - f9);
        canvas.scale(f13, f15);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f, this.b);
        if (z2) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f10, this.d.width() - f11, (-this.e) + this.h, this.c);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF6 = this.d;
        canvas.translate(rectF6.left + f9, rectF6.bottom - f9);
        canvas.scale(f13, f15);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f, this.b);
        if (z) {
            canvas.scale(1.0f / f15, 1.0f);
            canvas.drawRect(0.0f, f10, this.d.height() - f11, -this.e, this.c);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF7 = this.d;
        canvas.translate(rectF7.right - f9, rectF7.top + f9);
        canvas.scale(f13, f14);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f, this.b);
        if (z) {
            canvas.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f10, this.d.height() - f11, -this.e, this.c);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(i2);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.e;
    }

    public float getMaxShadowSize() {
        return this.g;
    }

    public float getMinHeight() {
        float f2 = this.g;
        float f3 = (f2 * 1.5f) / 2.0f;
        return (this.g * 1.5f * 2.0f) + (Math.max(f2, f3 + this.e) * 2.0f);
    }

    public float getMinWidth() {
        float f2 = this.g;
        float f3 = f2 / 2.0f;
        return (this.g * 2.0f) + (Math.max(f2, f3 + this.e) * 2.0f);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.g, this.e, this.n));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.g, this.e, this.n));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.i;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.j = true;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.n = z;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        super.setAlpha(i2);
        this.b.setAlpha(i2);
        this.c.setAlpha(i2);
    }

    public void setCornerRadius(float f2) {
        float round = (float) Math.round(f2);
        if (this.e != round) {
            this.e = round;
            this.j = true;
            invalidateSelf();
        }
    }

    public void setMaxShadowSize(float f2) {
        setShadowSize(this.i, f2);
    }

    public final void setRotation(float f2) {
        if (this.o != f2) {
            this.o = f2;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f2, float f3) {
        if (f2 < 0.0f || f3 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        int round = Math.round(f2);
        if (round % 2 == 1) {
            round--;
        }
        float f4 = (float) round;
        int round2 = Math.round(f3);
        if (round2 % 2 == 1) {
            round2--;
        }
        float f5 = (float) round2;
        if (f4 > f5) {
            if (!this.p) {
                this.p = true;
            }
            f4 = f5;
        }
        if (this.i != f4 || this.g != f5) {
            this.i = f4;
            this.g = f5;
            this.h = (float) Math.round(f4 * 1.5f);
            this.j = true;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f2) {
        setShadowSize(f2, this.g);
    }
}
