package com.rd.animation.type;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.animation.type.WormAnimation;
public class ThinWormAnimation extends WormAnimation {
    public ThinWormAnimationValue h = new ThinWormAnimationValue();

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ThinWormAnimation thinWormAnimation = ThinWormAnimation.this;
            thinWormAnimation.h.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            ValueController.UpdateListener updateListener = thinWormAnimation.listener;
            if (updateListener != null) {
                updateListener.onValueUpdated(thinWormAnimation.h);
            }
        }
    }

    public ThinWormAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    public final ValueAnimator d(int i, int i2, long j) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new a());
        return ofInt;
    }

    @Override // com.rd.animation.type.WormAnimation
    public WormAnimation with(int i, int i2, int i3, boolean z) {
        if (c(i, i2, i3, z)) {
            this.animator = createAnimator();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = z;
            int i4 = i3 * 2;
            int i5 = i - i3;
            this.e = i5;
            this.f = i + i3;
            this.h.setRectStart(i5);
            this.h.setRectEnd(this.f);
            this.h.setHeight(i4);
            WormAnimation.b a3 = a(z);
            long j = this.animationDuration;
            long j2 = (long) (((double) j) * 0.8d);
            long j3 = (long) (((double) j) * 0.2d);
            long j4 = (long) (((double) j) * 0.5d);
            long j5 = (long) (((double) j) * 0.5d);
            ValueAnimator b = b(a3.a, a3.b, j2, false, this.h);
            ValueAnimator b2 = b(a3.c, a3.d, j2, true, this.h);
            b2.setStartDelay(j3);
            ValueAnimator d = d(i4, i3, j4);
            ValueAnimator d2 = d(i3, i4, j4);
            d2.setStartDelay(j5);
            ((AnimatorSet) this.animator).playTogether(b, b2, d, d2);
        }
        return this;
    }

    @Override // com.rd.animation.type.WormAnimation, com.rd.animation.type.BaseAnimation
    public ThinWormAnimation duration(long j) {
        super.duration(j);
        return this;
    }

    @Override // com.rd.animation.type.WormAnimation, com.rd.animation.type.BaseAnimation
    public ThinWormAnimation progress(float f) {
        T t = this.animator;
        if (t != null) {
            long j = (long) (f * ((float) this.animationDuration));
            int size = ((AnimatorSet) t).getChildAnimations().size();
            for (int i = 0; i < size; i++) {
                ValueAnimator valueAnimator = (ValueAnimator) ((AnimatorSet) this.animator).getChildAnimations().get(i);
                long startDelay = j - valueAnimator.getStartDelay();
                long duration = valueAnimator.getDuration();
                if (startDelay > duration) {
                    startDelay = duration;
                } else if (startDelay < 0) {
                    startDelay = 0;
                }
                if ((i != size - 1 || startDelay > 0) && valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                    valueAnimator.setCurrentPlayTime(startDelay);
                }
            }
        }
        return this;
    }
}
