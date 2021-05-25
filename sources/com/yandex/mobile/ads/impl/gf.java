package com.yandex.mobile.ads.impl;

import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
public final class gf {
    @NonNull
    private final gg a = new gg();

    public static /* synthetic */ Point a(Display display) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    @Nullable
    private static Point b(@NonNull Display display) {
        try {
            return new Point(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(display, new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(display, new Object[0])).intValue());
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    private static Point c(@NonNull Display display) {
        return new Point(display.getWidth(), display.getHeight());
    }
}
