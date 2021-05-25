package com.rd.animation.type;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ColorAnimationValue;
import java.util.Objects;
public class ColorAnimation extends BaseAnimation<ValueAnimator> {
    public static final String DEFAULT_SELECTED_COLOR = "#ffffff";
    public static final String DEFAULT_UNSELECTED_COLOR = "#33ffffff";
    public ColorAnimationValue a = new ColorAnimationValue();
    public int b;
    public int c;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ColorAnimation colorAnimation = ColorAnimation.this;
            Objects.requireNonNull(colorAnimation);
            int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
            colorAnimation.a.setColor(intValue);
            colorAnimation.a.setColorReverse(intValue2);
            ValueController.UpdateListener updateListener = colorAnimation.listener;
            if (updateListener != null) {
                updateListener.onValueUpdated(colorAnimation.a);
            }
        }
    }

    public ColorAnimation(@Nullable ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    public PropertyValuesHolder a(boolean z) {
        int i;
        String str;
        int i2;
        if (z) {
            i = this.c;
            i2 = this.b;
            str = "ANIMATION_COLOR_REVERSE";
        } else {
            i = this.b;
            i2 = this.c;
            str = "ANIMATION_COLOR";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    @NonNull
    public ColorAnimation with(int i, int i2) {
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
                ((ValueAnimator) this.animator).setValues(a(false), a(true));
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
    public ColorAnimation progress(float f) {
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
