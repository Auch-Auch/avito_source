package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0005\u001a\u00020\u00042\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/Objects;", "", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "equals", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", "value", "", "toString", "(Ljava/lang/Long;)Ljava/lang/String;", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "<init>", "()V", VKApiConst.LANG}, k = 1, mv = {1, 4, 2})
public final class Objects {
    @NotNull
    public static final Objects INSTANCE = new Objects();

    public final boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return Intrinsics.areEqual(obj, obj2);
    }

    @NotNull
    public final String toString(@Nullable Long l) {
        String valueOf;
        return (l == null || (valueOf = String.valueOf(l.longValue())) == null) ? "" : valueOf;
    }

    @NotNull
    public final String toString(@Nullable Integer num) {
        String valueOf;
        return (num == null || (valueOf = String.valueOf(num.intValue())) == null) ? "" : valueOf;
    }
}
