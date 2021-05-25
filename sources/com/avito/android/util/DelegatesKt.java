package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"R", "T", "initialValue", "Lkotlin/properties/ReadWriteProperty;", "backingField", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class DelegatesKt {
    @NotNull
    public static final <R, T> ReadWriteProperty<R, T> backingField(T t) {
        return new BackingField(t);
    }
}
