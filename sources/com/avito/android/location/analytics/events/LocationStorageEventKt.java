package com.avito.android.location.analytics.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "nullIfEmpty", "(Ljava/lang/String;)Ljava/lang/String;", "user-location_release"}, k = 2, mv = {1, 4, 2})
public final class LocationStorageEventKt {
    @Nullable
    public static final String nullIfEmpty(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$nullIfEmpty");
        if (str.length() == 0) {
            return null;
        }
        return str;
    }
}
