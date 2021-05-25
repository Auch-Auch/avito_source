package com.google.android.material.animation;

import a2.b.a.a.a;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class MotionTiming {
    public long a = 0;
    public long b = 300;
    @Nullable
    public TimeInterpolator c = null;
    public int d = 0;
    public int e = 1;

    public MotionTiming(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public void apply(@NonNull Animator animator) {
        animator.setStartDelay(getDelay());
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(getRepeatCount());
            valueAnimator.setRepeatMode(getRepeatMode());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (getDelay() == motionTiming.getDelay() && getDuration() == motionTiming.getDuration() && getRepeatCount() == motionTiming.getRepeatCount() && getRepeatMode() == motionTiming.getRepeatMode()) {
            return getInterpolator().getClass().equals(motionTiming.getInterpolator().getClass());
        }
        return false;
    }

    public long getDelay() {
        return this.a;
    }

    public long getDuration() {
        return this.b;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public int getRepeatCount() {
        return this.d;
    }

    public int getRepeatMode() {
        return this.e;
    }

    public int hashCode() {
        int hashCode = getInterpolator().getClass().hashCode();
        int repeatCount = getRepeatCount();
        return getRepeatMode() + ((repeatCount + ((hashCode + (((((int) (getDelay() ^ (getDelay() >>> 32))) * 31) + ((int) (getDuration() ^ (getDuration() >>> 32)))) * 31)) * 31)) * 31);
    }

    @NonNull
    public String toString() {
        StringBuilder I = a.I('\n');
        I.append(getClass().getName());
        I.append('{');
        I.append(Integer.toHexString(System.identityHashCode(this)));
        I.append(" delay: ");
        I.append(getDelay());
        I.append(" duration: ");
        I.append(getDuration());
        I.append(" interpolator: ");
        I.append(getInterpolator().getClass());
        I.append(" repeatCount: ");
        I.append(getRepeatCount());
        I.append(" repeatMode: ");
        I.append(getRepeatMode());
        I.append("}\n");
        return I.toString();
    }

    public MotionTiming(long j, long j2, @NonNull TimeInterpolator timeInterpolator) {
        this.a = j;
        this.b = j2;
        this.c = timeInterpolator;
    }
}
