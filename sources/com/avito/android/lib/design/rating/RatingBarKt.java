package com.avito.android.lib.design.rating;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"components_release"}, k = 2, mv = {1, 4, 2})
public final class RatingBarKt {
    public static final ColorFilter access$colorFilter(int i) {
        return new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    public static final ColorFilter access$multiplyColorFilter(int i, int i2) {
        if (!(i2 == -1 || i2 == 0)) {
            i = Color.rgb((int) (((float) (Color.red(i2) * Color.red(i))) / 255.0f), (int) (((float) (Color.green(i2) * Color.green(i))) / 255.0f), (int) (((float) (Color.blue(i2) * Color.blue(i))) / 255.0f));
        }
        return new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }
}
