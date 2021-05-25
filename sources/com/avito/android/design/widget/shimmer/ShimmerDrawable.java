package com.avito.android.design.widget.shimmer;

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
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.GlobalAnimationsKt;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001c\u0010\bJ'\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\bR\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010&R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010,\u001a\u00020+8F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/avito/android/design/widget/shimmer/ShimmerDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/design/widget/shimmer/Shimmer;", "newShimmer", "", "setShimmer", "(Lcom/avito/android/design/widget/shimmer/Shimmer;)V", "startShimmer", "()V", "stopShimmer", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "(Landroid/graphics/Rect;)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "", "alpha", "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getOpacity", "()I", "maybeStartShimmer$ui_components_release", "maybeStartShimmer", "", Tracker.Events.CREATIVE_START, "end", "percent", AuthSource.SEND_ABUSE, "(FFF)F", AuthSource.BOOKING_ORDER, "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mShimmerPaint", "c", "Landroid/graphics/Rect;", "mDrawRect", "", "isShimmerStarted", "()Z", "Landroid/graphics/Matrix;", "d", "Landroid/graphics/Matrix;", "mShaderMatrix", "Landroid/animation/ValueAnimator;", "e", "Landroid/animation/ValueAnimator;", "mValueAnimator", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mUpdateListener", "f", "Lcom/avito/android/design/widget/shimmer/Shimmer;", "mShimmer", "<init>", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShimmerDrawable extends Drawable {
    public final ValueAnimator.AnimatorUpdateListener a = new a(this);
    public final Paint b;
    public final Rect c;
    public final Matrix d;
    public ValueAnimator e;
    public Shimmer f;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ShimmerDrawable a;

        public a(ShimmerDrawable shimmerDrawable) {
            this.a = shimmerDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidateSelf();
        }
    }

    public ShimmerDrawable() {
        Paint paint = new Paint();
        this.b = paint;
        this.c = new Rect();
        this.d = new Matrix();
        paint.setAntiAlias(true);
    }

    public final float a(float f2, float f3, float f4) {
        return a2.b.a.a.a.b(f3, f2, f4, f2);
    }

    public final void b() {
        Shader shader;
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        int width = bounds.width();
        int height = bounds.height();
        Shimmer shimmer = this.f;
        if (width != 0 && height != 0 && shimmer != null) {
            int width$ui_components_release = shimmer.width$ui_components_release(width);
            int height$ui_components_release = shimmer.height$ui_components_release(height);
            int shape$ui_components_release = shimmer.getShape$ui_components_release();
            boolean z = true;
            if (shape$ui_components_release == 0) {
                if (!(shimmer.getDirection$ui_components_release() == 1 || shimmer.getDirection$ui_components_release() == 3)) {
                    z = false;
                }
                if (z) {
                    width$ui_components_release = 0;
                }
                if (!z) {
                    height$ui_components_release = 0;
                }
                shader = new LinearGradient(0.0f, 0.0f, (float) width$ui_components_release, (float) height$ui_components_release, shimmer.getColors$ui_components_release(), shimmer.getPositions$ui_components_release(), Shader.TileMode.CLAMP);
            } else if (shape$ui_components_release != 1) {
                if (!(shimmer.getDirection$ui_components_release() == 1 || shimmer.getDirection$ui_components_release() == 3)) {
                    z = false;
                }
                if (z) {
                    width$ui_components_release = 0;
                }
                if (!z) {
                    height$ui_components_release = 0;
                }
                shader = new LinearGradient(0.0f, 0.0f, (float) width$ui_components_release, (float) height$ui_components_release, shimmer.getColors$ui_components_release(), shimmer.getPositions$ui_components_release(), Shader.TileMode.CLAMP);
            } else {
                shader = new RadialGradient(((float) width$ui_components_release) / 2.0f, ((float) height$ui_components_release) / 2.0f, (float) (((double) Math.max(width$ui_components_release, height$ui_components_release)) / Math.sqrt(2.0d)), shimmer.getColors$ui_components_release(), shimmer.getPositions$ui_components_release(), Shader.TileMode.CLAMP);
            }
            this.b.setShader(shader);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Shimmer shimmer = this.f;
        if (shimmer != null && this.b.getShader() != null) {
            float tan = (float) Math.tan(Math.toRadians((double) shimmer.getTilt$ui_components_release()));
            float width = (((float) this.c.width()) * tan) + ((float) this.c.height());
            float height = (tan * ((float) this.c.height())) + ((float) this.c.width());
            ValueAnimator valueAnimator = this.e;
            float f4 = 0.0f;
            float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
            int direction$ui_components_release = shimmer.getDirection$ui_components_release();
            if (direction$ui_components_release != 0) {
                if (direction$ui_components_release == 1) {
                    f2 = a(-width, width, animatedFraction);
                } else if (direction$ui_components_release == 2) {
                    f3 = a(height, -height, animatedFraction);
                } else if (direction$ui_components_release != 3) {
                    f3 = a(-height, height, animatedFraction);
                } else {
                    f2 = a(width, -width, animatedFraction);
                }
                this.d.reset();
                this.d.setRotate(shimmer.getTilt$ui_components_release(), ((float) this.c.width()) / 2.0f, ((float) this.c.height()) / 2.0f);
                this.d.postTranslate(f4, f2);
                this.b.getShader().setLocalMatrix(this.d);
                canvas.drawRect(this.c, this.b);
            }
            f3 = a(-height, height, animatedFraction);
            f4 = f3;
            f2 = 0.0f;
            this.d.reset();
            this.d.setRotate(shimmer.getTilt$ui_components_release(), ((float) this.c.width()) / 2.0f, ((float) this.c.height()) / 2.0f);
            this.d.postTranslate(f4, f2);
            this.b.getShader().setLocalMatrix(this.d);
            canvas.drawRect(this.c, this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Shimmer shimmer = this.f;
        return (shimmer == null || (!shimmer.getClipToChildren$ui_components_release() && !shimmer.getAlphaShimmer$ui_components_release())) ? -1 : -3;
    }

    public final boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.e;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public final void maybeStartShimmer$ui_components_release() {
        ValueAnimator valueAnimator = this.e;
        Shimmer shimmer = this.f;
        if (valueAnimator != null && !valueAnimator.isStarted() && shimmer != null && shimmer.getAutoStart$ui_components_release() && getCallback() != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        super.onBoundsChange(rect);
        this.c.set(0, 0, rect.width(), rect.height());
        b();
        maybeStartShimmer$ui_components_release();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public final void setShimmer(@Nullable Shimmer shimmer) {
        boolean z;
        if (shimmer != null) {
            this.b.setXfermode(new PorterDuffXfermode(shimmer.getAlphaShimmer$ui_components_release() ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        this.f = shimmer;
        b();
        Shimmer shimmer2 = this.f;
        if (shimmer2 != null) {
            ValueAnimator valueAnimator = this.e;
            if (valueAnimator != null) {
                z = valueAnimator.isStarted();
                valueAnimator.cancel();
                valueAnimator.removeAllUpdateListeners();
            } else {
                z = false;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (shimmer2.getRepeatDelay$ui_components_release() / shimmer2.getAnimationDuration$ui_components_release())) + 1.0f);
            this.e = ofFloat;
            Intrinsics.checkNotNullExpressionValue(ofFloat, "valueAnimator");
            ofFloat.setRepeatMode(shimmer2.getRepeatMode$ui_components_release());
            GlobalAnimationsKt.setSafeRepeatCount(ofFloat, shimmer2.getRepeatCount$ui_components_release());
            ofFloat.setDuration(shimmer2.getRepeatDelay$ui_components_release() + shimmer2.getAnimationDuration$ui_components_release());
            ofFloat.addUpdateListener(this.a);
            if (z) {
                ofFloat.start();
            }
        }
        invalidateSelf();
    }

    public final void startShimmer() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null && !isShimmerStarted() && getCallback() != null) {
            valueAnimator.start();
        }
    }

    public final void stopShimmer() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null && isShimmerStarted()) {
            valueAnimator.cancel();
        }
    }
}
