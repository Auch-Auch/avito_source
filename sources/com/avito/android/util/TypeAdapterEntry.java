package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/util/TypeAdapterEntry;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getTypeAdapter", "()Ljava/lang/Object;", "typeAdapter", "Ljava/lang/reflect/Type;", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Type;", "getType", "()Ljava/lang/reflect/Type;", "type", "<init>", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)V", "gson"}, k = 1, mv = {1, 4, 2})
public final class TypeAdapterEntry {
    @NotNull
    public final Type a;
    @NotNull
    public final Object b;

    public TypeAdapterEntry(@NotNull Type type, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(obj, "typeAdapter");
        this.a = type;
        this.b = obj;
    }

    @NotNull
    public final Type getType() {
        return this.a;
    }

    @NotNull
    public final Object getTypeAdapter() {
        return this.b;
    }
}
