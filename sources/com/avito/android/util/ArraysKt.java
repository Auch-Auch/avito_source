package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "", "", "unsafeCastToListOf", "([Ljava/lang/Object;)Ljava/util/List;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class ArraysKt {
    @NotNull
    public static final <T> List<T> unsafeCastToListOf(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "$this$unsafeCastToListOf");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }
}
