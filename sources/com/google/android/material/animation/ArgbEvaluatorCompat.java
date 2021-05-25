package com.google.android.material.animation;

import a2.b.a.a.a;
import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;
public class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    public static final ArgbEvaluatorCompat a = new ArgbEvaluatorCompat();

    @NonNull
    public static ArgbEvaluatorCompat getInstance() {
        return a;
    }

    @NonNull
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f2 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float b = a.b(((float) ((intValue2 >> 24) & 255)) / 255.0f, f2, f, f2);
        float b2 = a.b(pow4, pow, f, pow);
        float b3 = a.b((float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d), pow2, f, pow2);
        float b4 = a.b((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d), pow3, f, pow3);
        int round = Math.round(((float) Math.pow((double) b2, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow((double) b4, 0.45454545454545453d)) * 255.0f) | round | (Math.round(b * 255.0f) << 24) | (Math.round(((float) Math.pow((double) b3, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
