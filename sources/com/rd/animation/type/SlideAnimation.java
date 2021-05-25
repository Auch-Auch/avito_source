package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.SlideAnimationValue;
import java.util.Objects;
public class SlideAnimation extends BaseAnimation<ValueAnimator> {
    public SlideAnimationValue a = new SlideAnimationValue();
    public int b = -1;
    public int c = -1;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SlideAnimation slideAnimation = SlideAnimation.this;
            Objects.requireNonNull(slideAnimation);
            slideAnimation.a.setCoordinate(((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue());
            ValueController.UpdateListener updateListener = slideAnimation.listener;
            if (updateListener != null) {
                updateListener.onValueUpdated(slideAnimation.a);
            }
        }
    }

    public SlideAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @NonNull
    public SlideAnimation with(int i, int i2) {
        boolean z;
        if (this.animator != null) {
            if (this.b == i && this.c == i2) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.b = i;
                this.c = i2;
                PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE", i, i2);
                ofInt.setEvaluator(new IntEvaluator());
                ((ValueAnimator) this.animator).setValues(ofInt);
            }
        }
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    @NonNull
    public ValueAnimator createAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new a());
        return valueAnimator;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public SlideAnimation progress(float f) {
        T t = this.animator;
        if (t != null) {
            long j = (long) (f * ((float) this.animationDuration));
            if (((ValueAnimator) t).getValues() != null && ((ValueAnimator) this.animator).getValues().length > 0) {
                ((ValueAnimator) this.animator).setCurrentPlayTime(j);
            }
        }
        return this;
    }
}
