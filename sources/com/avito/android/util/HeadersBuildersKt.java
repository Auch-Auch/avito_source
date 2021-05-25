package com.avito.android.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lokhttp3/Headers$Builder;", "", "", "names", "removeAll", "(Lokhttp3/Headers$Builder;Ljava/lang/Iterable;)Lokhttp3/Headers$Builder;", "okhttp_release"}, k = 2, mv = {1, 4, 2})
public final class HeadersBuildersKt {
    @NotNull
    public static final Headers.Builder removeAll(@NotNull Headers.Builder builder, @NotNull Iterable<String> iterable) {
        Intrinsics.checkNotNullParameter(builder, "$this$removeAll");
        Intrinsics.checkNotNullParameter(iterable, "names");
        for (String str : iterable) {
            builder.removeAll(str);
        }
        return builder;
    }
}
