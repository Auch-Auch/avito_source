package com.avito.android.util;

import android.content.Context;
import com.avito.android.lib.design.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/content/Context;", "", "getPullRefreshColorScheme", "(Landroid/content/Context;)[I", "pullRefreshColorScheme", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class ContextsKt {
    @NotNull
    public static final int[] getPullRefreshColorScheme(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$pullRefreshColorScheme");
        List<Number> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.attr.blue), Integer.valueOf(R.attr.violet), Integer.valueOf(R.attr.green), Integer.valueOf(R.attr.red)});
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(listOf, 10));
        for (Number number : listOf) {
            arrayList.add(Integer.valueOf(Contexts.getColorByAttr(context, number.intValue())));
        }
        return CollectionsKt___CollectionsKt.toIntArray(arrayList);
    }
}
