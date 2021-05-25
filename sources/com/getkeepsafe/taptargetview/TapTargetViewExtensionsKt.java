package com.getkeepsafe.taptargetview;

import android.graphics.Color;
import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/getkeepsafe/taptargetview/TapTargetView;", "", "alpha", "setDimAlpha", "(Lcom/getkeepsafe/taptargetview/TapTargetView;F)Lcom/getkeepsafe/taptargetview/TapTargetView;", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class TapTargetViewExtensionsKt {
    @NotNull
    public static final TapTargetView setDimAlpha(@NotNull TapTargetView tapTargetView, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        Intrinsics.checkNotNullParameter(tapTargetView, "$this$setDimAlpha");
        int i = tapTargetView.b0;
        if (i != -1) {
            double d = (double) f;
            if (d >= 0.0d && d <= 1.0d) {
                tapTargetView.b0 = Color.argb((int) (((float) 255) * f), Color.red(i), Color.green(tapTargetView.b0), Color.blue(tapTargetView.b0));
            }
        }
        return tapTargetView;
    }
}
