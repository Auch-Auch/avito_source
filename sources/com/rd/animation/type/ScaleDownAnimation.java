package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
public class ScaleDownAnimation extends ScaleAnimation {
    public ScaleDownAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @Override // com.rd.animation.type.ScaleAnimation
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
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i2, i);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }
}
