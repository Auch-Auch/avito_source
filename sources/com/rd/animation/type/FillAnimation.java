package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.FillAnimationValue;
import java.util.Objects;
public class FillAnimation extends ColorAnimation {
    public static final int DEFAULT_STROKE_DP = 1;
    public FillAnimationValue d = new FillAnimationValue();
    public int e;
    public int f;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FillAnimation fillAnimation = FillAnimation.this;
            Objects.requireNonNull(fillAnimation);
            int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
            int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS")).intValue();
            int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS_REVERSE")).intValue();
            int intValue5 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE")).intValue();
            int intValue6 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE_REVERSE")).intValue();
            fillAnimation.d.setColor(intValue);
            fillAnimation.d.setColorReverse(intValue2);
            fillAnimation.d.setRadius(intValue3);
            fillAnimation.d.setRadiusReverse(intValue4);
            fillAnimation.d.setStroke(intValue5);
            fillAnimation.d.setStrokeReverse(intValue6);
            ValueController.UpdateListener updateListener = fillAnimation.listener;
            if (updateListener != null) {
                updateListener.onValueUpdated(fillAnimation.d);
            }
        }
    }

    public FillAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @NonNull
    public final PropertyValuesHolder b(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = this.e;
            i2 = i / 2;
            str = "ANIMATION_RADIUS_REVERSE";
        } else {
            i2 = this.e;
            i = i2 / 2;
            str = "ANIMATION_RADIUS";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    @NonNull
    public final PropertyValuesHolder c(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = this.e;
            str = "ANIMATION_STROKE_REVERSE";
            i2 = 0;
        } else {
            str = "ANIMATION_STROKE";
            i2 = this.e;
            i = 0;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    @NonNull
    public FillAnimation with(int i, int i2, int i3, int i4) {
        boolean z;
        if (this.animator != null) {
            if (this.b == i && this.c == i2 && this.e == i3 && this.f == i4) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.b = i;
                this.c = i2;
                this.e = i3;
                this.f = i4;
                ((ValueAnimator) this.animator).setValues(a(false), a(true), b(false), b(true), c(false), c(true));
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
