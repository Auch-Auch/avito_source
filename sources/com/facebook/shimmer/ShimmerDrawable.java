package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class ShimmerDrawable extends Drawable {
    public final ValueAnimator.AnimatorUpdateListener a = new a();
    public final Paint b;
    public final Rect c;
    public final Matrix d;
    @Nullable
    public ValueAnimator e;
    @Nullable
    public Shimmer f;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerDrawable.this.invalidateSelf();
        }
    }

    public ShimmerDrawable() {
        Paint paint = new Paint();
        this.b = paint;
        this.c = new Rect();
        this.d = new Matrix();
        paint.setAntiAlias(true);
    }

    public void a() {
        Shimmer shimmer;
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null && !valueAnimator.isStarted() && (shimmer = this.f) != null && shimmer.o && getCallback() != null) {
            this.e.start();
        }
    }

    public final float b(float f2, float f3, float f4) {
        return a2.b.a.a.a.b(f3, f2, f4, f2);
    }

    public final void c() {
        Shimmer shimmer;
        Shader shader;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width != 0 && height != 0 && (shimmer = this.f) != null) {
            int i = shimmer.g;
            if (i <= 0) {
                i = Math.round(shimmer.i * ((float) width));
            }
            Shimmer shimmer2 = this.f;
            int i2 = shimmer2.h;
            if (i2 <= 0) {
                i2 = Math.round(shimmer2.j * ((float) height));
            }
            Shimmer shimmer3 = this.f;
            boolean z = true;
            if (shimmer3.f != 1) {
                int i3 = shimmer3.c;
                if (!(i3 == 1 || i3 == 3)) {
                    z = false;
                }
                if (z) {
                    i = 0;
                }
                if (!z) {
                    i2 = 0;
                }
                Shimmer shimmer4 = this.f;
                shader = new LinearGradient(0.0f, 0.0f, (float) i, (float) i2, shimmer4.b, shimmer4.a, Shader.TileMode.CLAMP);
            } else {
                Shimmer shimmer5 = this.f;
                shader = new RadialGradient(((float) i) / 2.0f, ((float) i2) / 2.0f, (float) (((double) Math.max(i, i2)) / Math.sqrt(2.0d)), shimmer5.b, shimmer5.a, Shader.TileMode.CLAMP);
            }
            this.b.setShader(shader);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f2;
        float b2;
        if (this.f != null && this.b.getShader() != null) {
            float tan = (float) Math.tan(Math.toRadians((double) this.f.m));
            float width = (((float) this.c.width()) * tan) + ((float) this.c.height());
            float height = (tan * ((float) this.c.height())) + ((float) this.c.width());
            ValueAnimator valueAnimator = this.e;
            float f3 = 0.0f;
            float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
            int i = this.f.c;
            if (i != 1) {
                if (i == 2) {
                    b2 = b(height, -height, animatedFraction);
                } else if (i != 3) {
                    b2 = b(-height, height, animatedFraction);
                } else {
                    f2 = b(width, -width, animatedFraction);
                }
                f3 = b2;
                f2 = 0.0f;
            } else {
                f2 = b(-width, width, animatedFraction);
            }
            this.d.reset();
            this.d.setRotate(this.f.m, ((float) this.c.width()) / 2.0f, ((float) this.c.height()) / 2.0f);
            this.d.postTranslate(f3, f2);
            this.b.getShader().setLocalMatrix(this.d);
            canvas.drawRect(this.c, this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Shimmer shimmer = this.f;
        return (shimmer == null || (!shimmer.n && !shimmer.p)) ? -1 : -3;
    }

    public boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.e;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.c.set(0, 0, rect.width(), rect.height());
        c();
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void setShimmer(@Nullable Shimmer shimmer) {
        boolean z;
        this.f = shimmer;
        if (shimmer != null) {
            this.b.setXfermode(new PorterDuffXfermode(this.f.p ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        c();
        if (this.f != null) {
            ValueAnimator valueAnimator = this.e;
            if (valueAnimator != null) {
                z = valueAnimator.isStarted();
                this.e.cancel();
                this.e.removeAllUpdateListeners();
            } else {
                z = false;
            }
            Shimmer shimmer2 = this.f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (shimmer2.t / shimmer2.s)) + 1.0f);
            this.e = ofFloat;
            ofFloat.setRepeatMode(this.f.r);
            this.e.setRepeatCount(this.f.q);
            ValueAnimator valueAnimator2 = this.e;
            Shimmer shimmer3 = this.f;
            valueAnimator2.setDuration(shimmer3.s + shimmer3.t);
            this.e.addUpdateListener(this.a);
            if (z) {
                this.e.start();
            }
        }
        invalidateSelf();
    }

    public void startShimmer() {
        if (this.e != null && !isShimmerStarted() && getCallback() != null) {
            this.e.start();
        }
    }

    public void stopShimmer() {
        if (this.e != null && isShimmerStarted()) {
            this.e.cancel();
        }
    }
}
