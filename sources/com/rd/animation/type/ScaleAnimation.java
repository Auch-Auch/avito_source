package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ScaleAnimationValue;
import java.util.Objects;
public class ScaleAnimation extends ColorAnimation {
    public static final float DEFAULT_SCALE_FACTOR = 0.7f;
    public static final float MAX_SCALE_FACTOR = 1.0f;
    public static final float MIN_SCALE_FACTOR = 0.3f;
    public int d;
    public float e;
    public ScaleAnimationValue f = new ScaleAnimationValue();

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScaleAnimation scaleAnimation = ScaleAnimation.this;
            Objects.requireNonNull(scaleAnimation);
            int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
            int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE")).intValue();
            int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE_REVERSE")).intValue();
            scaleAnimation.f.setColor(intValue);
            scaleAnimation.f.setColorReverse(intValue2);
            scaleAnimation.f.setRadius(intValue3);
            scaleAnimation.f.setRadiusReverse(intValue4);
            ValueController.UpdateListener updateListener = scaleAnimation.listener;
            if (updateListener != null) {
                updateListener.onValueUpdated(scaleAnimation.f);
            }
        }
    }

    public ScaleAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @NonNull
    public PropertyValuesHolder createScalePropertyHolder(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = this.d;
            i2 = (int) (((float) i) * this.e);
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i2 = this.d;
            i = (int) (((float) i2) * this.e);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    @NonNull
    public ScaleAnimation with(int i, int i2, int i3, float f2) {
        boolean z;
        if (this.animator != null) {
            if (this.b == i && this.c == i2 && this.d == i3 && this.e == f2) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.b = i;
                this.c = i2;
                this.d = i3;
                this.e = f2;
                ((ValueAnimator) this.animator).setValues(a(false), a(true), createScalePropertyHolder(false), createScalePropertyHolder(true));
            }
        }
        return this;
    }

    @Override // com.rd.animation.type.ColorAnimation, com.rd.animation.type.BaseAnimation
    @NonNull
    public ValueAnimator createAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new a());
        return valueAnimator;
    }
}
