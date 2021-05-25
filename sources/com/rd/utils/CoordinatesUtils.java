package com.rd.utils;

import a2.b.a.a.a;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
public class CoordinatesUtils {
    public static int a(@NonNull Indicator indicator, int i) {
        int count = indicator.getCount();
        int radius = indicator.getRadius();
        int stroke = indicator.getStroke();
        int padding = indicator.getPadding();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            int i4 = stroke / 2;
            int i5 = radius + i4 + i2;
            if (i == i3) {
                return i5;
            }
            i2 = a.G1(radius, padding, i4, i5);
        }
        return indicator.getAnimationType() == AnimationType.DROP ? i2 + (radius * 2) : i2;
    }

    public static int getCoordinate(@Nullable Indicator indicator, int i) {
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            return getXCoordinate(indicator, i);
        }
        return getYCoordinate(indicator, i);
    }

    public static int getPosition(@Nullable Indicator indicator, float f, float f2) {
        int i;
        if (indicator == null) {
            return -1;
        }
        Orientation orientation = indicator.getOrientation();
        Orientation orientation2 = Orientation.HORIZONTAL;
        if (orientation != orientation2) {
            f2 = f;
            f = f2;
        }
        int count = indicator.getCount();
        int radius = indicator.getRadius();
        int stroke = indicator.getStroke();
        int padding = indicator.getPadding();
        int height = indicator.getOrientation() == orientation2 ? indicator.getHeight() : indicator.getWidth();
        int i2 = 0;
        int i3 = 0;
        while (i2 < count) {
            if (i2 > 0) {
                i = padding;
            } else {
                i = padding / 2;
            }
            int i4 = (stroke / 2) + (radius * 2) + i + i3;
            boolean z = true;
            boolean z2 = f >= ((float) i3) && f <= ((float) i4);
            if (f2 < 0.0f || f2 > ((float) height)) {
                z = false;
            }
            if (z2 && z) {
                return i2;
            }
            i2++;
            i3 = i4;
        }
        return -1;
    }

    public static Pair<Integer, Float> getProgress(@NonNull Indicator indicator, int i, float f, boolean z) {
        int count = indicator.getCount();
        int selectedPosition = indicator.getSelectedPosition();
        if (z) {
            i = (count - 1) - i;
        }
        boolean z2 = false;
        if (i < 0) {
            i = 0;
        } else {
            int i2 = count - 1;
            if (i > i2) {
                i = i2;
            }
        }
        boolean z3 = i > selectedPosition;
        boolean z4 = !z ? i + 1 < selectedPosition : i + -1 < selectedPosition;
        if (z3 || z4) {
            indicator.setSelectedPosition(i);
            selectedPosition = i;
        }
        float f2 = 0.0f;
        if (selectedPosition == i && f != 0.0f) {
            z2 = true;
        }
        if (z2) {
            i = z ? i - 1 : i + 1;
        } else {
            f = 1.0f - f;
        }
        if (f > 1.0f) {
            f2 = 1.0f;
        } else if (f >= 0.0f) {
            f2 = f;
        }
        return new Pair<>(Integer.valueOf(i), Float.valueOf(f2));
    }

    public static int getXCoordinate(@Nullable Indicator indicator, int i) {
        int i2;
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            i2 = a(indicator, i);
        } else {
            i2 = indicator.getRadius();
            if (indicator.getAnimationType() == AnimationType.DROP) {
                i2 *= 3;
            }
        }
        return indicator.getPaddingLeft() + i2;
    }

    public static int getYCoordinate(@Nullable Indicator indicator, int i) {
        int i2;
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            i2 = indicator.getRadius();
            if (indicator.getAnimationType() == AnimationType.DROP) {
                i2 *= 3;
            }
        } else {
            i2 = a(indicator, i);
        }
        return indicator.getPaddingTop() + i2;
    }
}
