package com.avito.android.util;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0006\"\u0017\u0010\u0003\u001a\u00020\u0000*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0017\u0010\u0005\u001a\u00020\u0000*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0002¨\u0006\u0006"}, d2 = {"", "getPx", "(I)I", "px", "getDp", "dp", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ViewSizeKt {
    public static final int getDp(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) (((float) i) * system.getDisplayMetrics().density);
    }

    public static final int getPx(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) (((float) i) / system.getDisplayMetrics().density);
    }
}
