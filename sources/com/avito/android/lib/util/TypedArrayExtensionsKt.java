package com.avito.android.lib.util;

import android.content.res.TypedArray;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a>\u0010\t\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u001a<\u0010\f\u001a\u00020\u0004*\u00020\u00002\n\u0010\u0002\u001a\u00020\n\"\u00020\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"Landroid/content/res/TypedArray;", "", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "block", "set", "(Landroid/content/res/TypedArray;ILkotlin/jvm/functions/Function2;)V", "update", "", "Lkotlin/Function1;", "contains", "(Landroid/content/res/TypedArray;[ILkotlin/jvm/functions/Function1;)V", "components_release"}, k = 2, mv = {1, 4, 2})
public final class TypedArrayExtensionsKt {
    public static final void contains(@NotNull TypedArray typedArray, @NotNull int[] iArr, @NotNull Function1<? super TypedArray, Unit> function1) {
        Integer num;
        Intrinsics.checkNotNullParameter(typedArray, "$this$contains");
        Intrinsics.checkNotNullParameter(iArr, FirebaseAnalytics.Param.INDEX);
        Intrinsics.checkNotNullParameter(function1, "block");
        int length = iArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                num = null;
                break;
            }
            int i2 = iArr[i];
            if (typedArray.hasValue(i2)) {
                num = Integer.valueOf(i2);
                break;
            }
            i++;
        }
        if (num != null) {
            num.intValue();
            function1.invoke(typedArray);
        }
    }

    public static final void set(@NotNull TypedArray typedArray, int i, @NotNull Function2<? super TypedArray, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(typedArray, "$this$set");
        Intrinsics.checkNotNullParameter(function2, "block");
        function2.invoke(typedArray, Integer.valueOf(i));
    }

    public static final void update(@NotNull TypedArray typedArray, int i, @NotNull Function2<? super TypedArray, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(typedArray, "$this$update");
        Intrinsics.checkNotNullParameter(function2, "block");
        if (typedArray.hasValue(i)) {
            function2.invoke(typedArray, Integer.valueOf(i));
        }
    }
}
