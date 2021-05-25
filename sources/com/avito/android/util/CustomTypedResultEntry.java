package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0002¢\u0006\u0004\b\u000f\u0010\u0010R)\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/CustomTypedResultEntry;", "", "", "", "Ljava/lang/Class;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getStatuses", "()Ljava/util/Map;", "statuses", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "type", "<init>", "(Ljava/lang/Class;Ljava/util/Map;)V", "gson"}, k = 1, mv = {1, 4, 2})
public final class CustomTypedResultEntry {
    @NotNull
    public final Class<?> a;
    @NotNull
    public final Map<String, Class<?>> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends java.lang.Class<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public CustomTypedResultEntry(@NotNull Class<?> cls, @NotNull Map<String, ? extends Class<?>> map) {
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(map, "statuses");
        this.a = cls;
        this.b = map;
    }

    @NotNull
    public final Map<String, Class<?>> getStatuses() {
        return this.b;
    }

    @NotNull
    public final Class<?> getType() {
        return this.a;
    }
}
