package a2.a.a.a1.d0;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends LinearSmoothScroller {
    public int l = Integer.MAX_VALUE;
    public int m = Integer.MAX_VALUE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        int R1 = a2.b.a.a.a.R1(i4, i3, 2, i3) - (((i2 - i) / 2) + i);
        if (R1 > 0) {
            int i6 = this.l;
            return i6 < R1 ? i6 : R1;
        }
        int i7 = this.m - i2;
        return i7 < Math.abs(R1) ? -i7 : R1;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        return 100.0f / ((float) displayMetrics.densityDpi);
    }
}
