package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import javax.annotation.Nullable;
public class ImageMetaData {
    @Nullable
    public final Pair<Integer, Integer> a;
    @Nullable
    public final ColorSpace b;

    public ImageMetaData(int i, int i2, @Nullable ColorSpace colorSpace) {
        this.a = (i == -1 || i2 == -1) ? null : new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        this.b = colorSpace;
    }

    @Nullable
    public ColorSpace getColorSpace() {
        return this.b;
    }

    @Nullable
    public Pair<Integer, Integer> getDimensions() {
        return this.a;
    }
}
