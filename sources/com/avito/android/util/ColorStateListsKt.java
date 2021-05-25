package com.avito.android.util;

import android.content.res.ColorStateList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/content/res/ColorStateList;", "", "getRippleColor", "(Landroid/content/res/ColorStateList;)Ljava/lang/Integer;", "rippleColor", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ColorStateListsKt {
    @Nullable
    public static final Integer getRippleColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "$this$rippleColor");
        boolean z = false;
        Integer valueOf = Integer.valueOf(colorStateList.getColorForState(new int[]{16842910, 16842919, R.attr.state_ripple}, 0));
        if (valueOf.intValue() != 0) {
            z = true;
        }
        if (z) {
            return valueOf;
        }
        return null;
    }
}
