package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.WormAnimationValue;
import java.util.Iterator;
import java.util.Objects;
public class WormAnimation extends BaseAnimation<AnimatorSet> {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public WormAnimationValue g = new WormAnimationValue();

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ WormAnimationValue a;
        public final /* synthetic */ boolean b;

        public a(WormAnimationValue wormAnimationValue, boolean z) {
            this.a = wormAnimationValue;
            this.b = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WormAnimation wormAnimation = WormAnimation.this;
            WormAnimationValue wormAnimationValue = this.a;
            boolean z = this.b;
            Objects.requireNonNull(wormAnimation);
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (wormAnimation.d) {
                if (!z) {
                    wormAnimationValue.setRectEnd(intValue);
                } else {
                    wormAnimationValue.setRectStart(intValue);
                }
            } else if (!z) {
                wormAnimationValue.setRectStart(intValue);
            } else {
                wormAnimationValue.setRectEnd(intValue);
            }
            ValueController.UpdateListener updateListener = wormAnimation.listener;
            if (updateListener != null) {
                updateListener.onValueUpdated(wormAnimationValue);
            }
        }
    }

    public class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public b(WormAnimation wormAnimation, int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public WormAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @NonNull
    public b a(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.a;
            int i6 = this.c;
            i4 = i5 + i6;
            int i7 = this.b;
            i2 = i7 + i6;
            i = i5 - i6;
            i3 = i7 - i6;
        } else {
            int i8 = this.a;
            int i9 = this.c;
            i4 = i8 - i9;
            int i10 = this.b;
            i2 = i10 - i9;
            i = i8 + i9;
            i3 = i10 + i9;
        }
        return new b(this, i4, i2, i, i3);
    }

    public ValueAnimator b(int i, int i2, long j, boolean z, WormAnimationValue wormAnimationValue) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new a(wormAnimationValue, z));
        return ofInt;
    }

    public boolean c(int i, int i2, int i3, boolean z) {
        if (this.a == i && this.b == i2 && this.c == i3 && this.d == z) {
            return false;
        }
        return true;
    }

    public WormAnimation with(int i, int i2, int i3, boolean z) {
        if (c(i, i2, i3, z)) {
            this.animator = createAnimator();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = z;
            int i4 = i - i3;
            this.e = i4;
            this.f = i + i3;
            this.g.setRectStart(i4);
            this.g.setRectEnd(this.f);
            b a3 = a(z);
            long j = this.animationDuration / 2;
            ((AnimatorSet) this.animator).playSequentially(b(a3.a, a3.b, j, false, this.g), b(a3.c, a3.d, j, true, this.g));
        }
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    @NonNull
    public AnimatorSet createAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public WormAnimation duration(long j) {
        super.duration(j);
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public WormAnimation progress(float f2) {
        T t = this.animator;
        if (t == null) {
            return this;
        }
        long j = (long) (f2 * ((float) this.animationDuration));
        Iterator<Animator> it = ((AnimatorSet) t).getChildAnimations().iterator();
        while (it.hasNext()) {
            ValueAnimator valueAnimator = (ValueAnimator) it.next();
            long duration = valueAnimator.getDuration();
            if (j <= duration) {
                duration = j;
            }
            valueAnimator.setCurrentPlayTime(duration);
            j -= duration;
        }
        return this;
    }
}
