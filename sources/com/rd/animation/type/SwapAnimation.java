package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.SwapAnimationValue;
import java.util.Objects;
public class SwapAnimation extends BaseAnimation<ValueAnimator> {
    public int a = -1;
    public int b = -1;
    public SwapAnimationValue c = new SwapAnimationValue();

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwapAnimation swapAnimation = SwapAnimation.this;
            Objects.requireNonNull(swapAnimation);
            int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE_REVERSE")).intValue();
            swapAnimation.c.setCoordinate(intValue);
            swapAnimation.c.setCoordinateReverse(intValue2);
            ValueController.UpdateListener updateListener = swapAnimation.listener;
            if (updateListener != null) {
                updateListener.onValueUpdated(swapAnimation.c);
            }
        }
    }

    public SwapAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    public final PropertyValuesHolder a(String str, int i, int i2) {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    @NonNull
    public SwapAnimation with(int i, int i2) {
        boolean z;
        if (this.animator != null) {
            if (this.a == i && this.b == i2) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.a = i;
                this.b = i2;
                ((ValueAnimator) this.animator).setValues(a("ANIMATION_COORDINATE", i, i2), a("ANIMATION_COORDINATE_REVERSE", i2, i));
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
    public SwapAnimation progress(float f) {
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
