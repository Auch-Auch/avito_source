package com.avito.android.serp.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "uniqueId", "", "stringId", "getUniqueId", "(JLjava/lang/String;)J", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class SerpElementUtilsKt {
    public static final long getUniqueId(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        return j != 0 ? j : (long) str.hashCode();
    }
}
