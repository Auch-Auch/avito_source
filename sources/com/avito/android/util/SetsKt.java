package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "newItem", "removeAndAddToTheEnd", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class SetsKt {
    @NotNull
    public static final <T> Set<T> removeAndAddToTheEnd(@NotNull Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "$this$removeAndAddToTheEnd");
        Set<T> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(set);
        mutableSet.remove(t);
        mutableSet.add(t);
        return mutableSet;
    }
}
