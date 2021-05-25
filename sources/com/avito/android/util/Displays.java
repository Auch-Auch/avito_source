package com.avito.android.util;

import android.graphics.Point;
import android.view.Display;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/view/Display;", "Landroid/graphics/Point;", "getSizePoint", "(Landroid/view/Display;)Landroid/graphics/Point;", "getRealSizePoint", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Displays")
public final class Displays {
    @NotNull
    public static final Point getRealSizePoint(@NotNull Display display) {
        Intrinsics.checkNotNullParameter(display, "$this$getRealSizePoint");
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }

    @NotNull
    public static final Point getSizePoint(@NotNull Display display) {
        Intrinsics.checkNotNullParameter(display, "$this$getSizePoint");
        Point point = new Point();
        display.getSize(point);
        return point;
    }
}
