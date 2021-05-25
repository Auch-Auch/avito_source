package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/CustomTypeAdapterEntry;", "", "Ljava/lang/reflect/Type;", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Type;", "getType", "()Ljava/lang/reflect/Type;", "type", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getStatuses", "()Ljava/util/Map;", "statuses", "<init>", "(Ljava/lang/reflect/Type;Ljava/util/Map;)V", "gson"}, k = 1, mv = {1, 4, 2})
public final class CustomTypeAdapterEntry {
    @NotNull
    public final Type a;
    @NotNull
    public final Map<String, Type> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends java.lang.reflect.Type> */
    /* JADX WARN: Multi-variable type inference failed */
    public CustomTypeAdapterEntry(@NotNull Type type, @NotNull Map<String, ? extends Type> map) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(map, "statuses");
        this.a = type;
        this.b = map;
    }

    @NotNull
    public final Map<String, Type> getStatuses() {
        return this.b;
    }

    @NotNull
    public final Type getType() {
        return this.a;
    }
}
