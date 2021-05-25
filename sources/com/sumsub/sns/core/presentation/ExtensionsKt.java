package com.sumsub.sns.core.presentation;

import android.content.res.TypedArray;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleableRes;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a'\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/content/res/TypedArray;", "", FirebaseAnalytics.Param.INDEX, "default", "getStyledColor", "(Landroid/content/res/TypedArray;II)I", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class ExtensionsKt {
    @ColorInt
    public static final int getStyledColor(@NotNull TypedArray typedArray, @StyleableRes int i, @ColorInt int i2) {
        Intrinsics.checkNotNullParameter(typedArray, "$this$getStyledColor");
        if (typedArray.hasValue(i)) {
            if (typedArray.peekValue(i).type != 2) {
                return typedArray.getColor(i, i2);
            }
            int resourceId = typedArray.getResourceId(i, -1);
            if (resourceId != -1) {
                return typedArray.getColor(resourceId, i2);
            }
        }
        return i2;
    }
}
