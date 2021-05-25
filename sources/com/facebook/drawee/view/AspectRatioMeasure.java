package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
public class AspectRatioMeasure {

    public static class Spec {
        public int height;
        public int width;
    }

    public static void updateMeasureSpec(Spec spec, float f, @Nullable ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            int i3 = layoutParams.height;
            boolean z = true;
            if (i3 == 0 || i3 == -2) {
                spec.height = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (View.MeasureSpec.getSize(spec.width) - i)) / f) + ((float) i2)), spec.height), 1073741824);
                return;
            }
            int i4 = layoutParams.width;
            if (!(i4 == 0 || i4 == -2)) {
                z = false;
            }
            if (z) {
                spec.width = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (View.MeasureSpec.getSize(spec.height) - i2)) * f) + ((float) i)), spec.width), 1073741824);
            }
        }
    }
}
