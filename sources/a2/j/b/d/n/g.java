package a2.j.b.d.n;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import java.util.ArrayList;
import java.util.List;
public abstract class g extends Drawable implements Animatable2Compat {
    public static final Property<g, Float> k = new a(Float.class, "growFraction");
    public final Context a;
    public final BaseProgressIndicatorSpec b;
    public AnimatorDurationScaleProvider c;
    public ValueAnimator d;
    public ValueAnimator e;
    public List<Animatable2Compat.AnimationCallback> f;
    public boolean g;
    public float h;
    public final Paint i = new Paint();
    public int j;

    public static class a extends Property<g, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(g gVar) {
            return Float.valueOf(gVar.c());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(g gVar, Float f) {
            g gVar2 = gVar;
            float floatValue = f.floatValue();
            if (gVar2.h != floatValue) {
                gVar2.h = floatValue;
                gVar2.invalidateSelf();
            }
        }
    }

    public g(@NonNull Context context, @NonNull BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.a = context;
        this.b = baseProgressIndicatorSpec;
        this.c = new AnimatorDurationScaleProvider();
        setAlpha(255);
    }

    public final void b(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z = this.g;
        this.g = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.g = z;
    }

    public float c() {
        if (this.b.isShowAnimationEnabled() || this.b.isHideAnimationEnabled()) {
            return this.h;
        }
        return 1.0f;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.f.clear();
        this.f = null;
    }

    public boolean d(boolean z, boolean z2, boolean z3) {
        if (this.d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, k, 0.0f, 1.0f);
            this.d = ofFloat;
            ofFloat.setDuration(500L);
            this.d.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            ValueAnimator valueAnimator = this.d;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                this.d = valueAnimator;
                valueAnimator.addListener(new e(this));
            } else {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
        }
        if (this.e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, k, 1.0f, 0.0f);
            this.e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.e.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            ValueAnimator valueAnimator2 = this.e;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                this.e = valueAnimator2;
                valueAnimator2.addListener(new f(this));
            } else {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
        }
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator3 = z ? this.d : this.e;
        if (!z3) {
            if (valueAnimator3.isRunning()) {
                valueAnimator3.end();
            } else {
                b(valueAnimator3);
            }
            return super.setVisible(z, false);
        } else if (z3 && valueAnimator3.isRunning()) {
            return false;
        } else {
            boolean z4 = !z || super.setVisible(z, false);
            if (!(z ? this.b.isShowAnimationEnabled() : this.b.isHideAnimationEnabled())) {
                b(valueAnimator3);
                return z4;
            }
            if (z2 || !valueAnimator3.isPaused()) {
                valueAnimator3.start();
            } else {
                valueAnimator3.resume();
            }
            return z4;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    public boolean isHiding() {
        ValueAnimator valueAnimator = this.e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isShowing() || isHiding();
    }

    public boolean isShowing() {
        ValueAnimator valueAnimator = this.d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        if (!this.f.contains(animationCallback)) {
            this.f.add(animationCallback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.j = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.i.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return setVisible(z, z2, true);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        d(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        d(false, true, false);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.f.remove(animationCallback);
        if (!this.f.isEmpty()) {
            return true;
        }
        this.f = null;
        return true;
    }

    public boolean setVisible(boolean z, boolean z2, boolean z3) {
        return d(z, z2, z3 && this.c.getSystemAnimatorDurationScale(this.a.getContentResolver()) > 0.0f);
    }
}
