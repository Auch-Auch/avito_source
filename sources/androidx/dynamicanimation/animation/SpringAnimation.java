package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.Objects;
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    public SpringForce m = null;
    public float n = Float.MAX_VALUE;
    public boolean o = false;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
    }

    public void animateToFinalPosition(float f) {
        if (isRunning()) {
            this.n = f;
            return;
        }
        if (this.m == null) {
            this.m = new SpringForce(f);
        }
        this.m.setFinalPosition(f);
        start();
    }

    public boolean canSkipToEnd() {
        return this.m.b > 0.0d;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void e(float f) {
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean f(long j) {
        if (this.o) {
            float f = this.n;
            if (f != Float.MAX_VALUE) {
                this.m.setFinalPosition(f);
                this.n = Float.MAX_VALUE;
            }
            this.b = this.m.getFinalPosition();
            this.a = 0.0f;
            this.o = false;
            return true;
        }
        if (this.n != Float.MAX_VALUE) {
            this.m.getFinalPosition();
            long j2 = j / 2;
            DynamicAnimation.p a = this.m.a((double) this.b, (double) this.a, j2);
            this.m.setFinalPosition(this.n);
            this.n = Float.MAX_VALUE;
            DynamicAnimation.p a3 = this.m.a((double) a.a, (double) a.b, j2);
            this.b = a3.a;
            this.a = a3.b;
        } else {
            DynamicAnimation.p a4 = this.m.a((double) this.b, (double) this.a, j);
            this.b = a4.a;
            this.a = a4.b;
        }
        float max = Math.max(this.b, this.h);
        this.b = max;
        float min = Math.min(max, this.g);
        this.b = min;
        if (!this.m.isAtEquilibrium(min, this.a)) {
            return false;
        }
        this.b = this.m.getFinalPosition();
        this.a = 0.0f;
        return true;
    }

    public SpringForce getSpring() {
        return this.m;
    }

    public SpringAnimation setSpring(SpringForce springForce) {
        this.m = springForce;
        return this;
    }

    public void skipToEnd() {
        if (!canSkipToEnd()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f) {
            this.o = true;
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void start() {
        SpringForce springForce = this.m;
        if (springForce != null) {
            double finalPosition = (double) springForce.getFinalPosition();
            if (finalPosition > ((double) this.g)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (finalPosition >= ((double) this.h)) {
                SpringForce springForce2 = this.m;
                Objects.requireNonNull(springForce2);
                double abs = Math.abs((double) b());
                springForce2.d = abs;
                springForce2.e = abs * 62.5d;
                super.start();
            } else {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
    }

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat, float f) {
        super(k, floatPropertyCompat);
        this.m = new SpringForce(f);
    }
}
