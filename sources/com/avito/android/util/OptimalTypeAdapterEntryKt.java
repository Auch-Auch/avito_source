package com.avito.android.util;

import com.google.gson.TypeAdapter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "T", "", "Lcom/avito/android/util/OptimalTypeAdapterEntry;", "Lcom/google/gson/TypeAdapter;", "adapter", "registerTypeAdapter", "(Ljava/util/Set;Lcom/google/gson/TypeAdapter;)Ljava/util/Set;", "gson"}, k = 2, mv = {1, 4, 2})
public final class OptimalTypeAdapterEntryKt {
    public static final /* synthetic */ <T> Set<OptimalTypeAdapterEntry> registerTypeAdapter(Set<OptimalTypeAdapterEntry> set, TypeAdapter<T> typeAdapter) {
        Intrinsics.checkNotNullParameter(set, "$this$registerTypeAdapter");
        Intrinsics.checkNotNullParameter(typeAdapter, "adapter");
        Intrinsics.reifiedOperationMarker(4, "T");
        set.add(new OptimalTypeAdapterEntry(Object.class, typeAdapter));
        return set;
    }
}
