package com.avito.android.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.TypeAdapter;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\f\b\u0002\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/util/OptimalTypeAdapterEntry;", "", "Ljava/lang/reflect/Type;", "component1", "()Ljava/lang/reflect/Type;", "Lcom/google/gson/TypeAdapter;", "component2", "()Lcom/google/gson/TypeAdapter;", "type", "typeAdapter", "copy", "(Ljava/lang/reflect/Type;Lcom/google/gson/TypeAdapter;)Lcom/avito/android/util/OptimalTypeAdapterEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/google/gson/TypeAdapter;", "getTypeAdapter", AuthSource.SEND_ABUSE, "Ljava/lang/reflect/Type;", "getType", "<init>", "(Ljava/lang/reflect/Type;Lcom/google/gson/TypeAdapter;)V", "gson"}, k = 1, mv = {1, 4, 2})
public final class OptimalTypeAdapterEntry {
    @NotNull
    public final Type a;
    @NotNull
    public final TypeAdapter<?> b;

    public OptimalTypeAdapterEntry(@NotNull Type type, @NotNull TypeAdapter<?> typeAdapter) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(typeAdapter, "typeAdapter");
        this.a = type;
        this.b = typeAdapter;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.util.OptimalTypeAdapterEntry */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OptimalTypeAdapterEntry copy$default(OptimalTypeAdapterEntry optimalTypeAdapterEntry, Type type, TypeAdapter typeAdapter, int i, Object obj) {
        if ((i & 1) != 0) {
            type = optimalTypeAdapterEntry.a;
        }
        if ((i & 2) != 0) {
            typeAdapter = optimalTypeAdapterEntry.b;
        }
        return optimalTypeAdapterEntry.copy(type, typeAdapter);
    }

    @NotNull
    public final Type component1() {
        return this.a;
    }

    @NotNull
    public final TypeAdapter<?> component2() {
        return this.b;
    }

    @NotNull
    public final OptimalTypeAdapterEntry copy(@NotNull Type type, @NotNull TypeAdapter<?> typeAdapter) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(typeAdapter, "typeAdapter");
        return new OptimalTypeAdapterEntry(type, typeAdapter);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptimalTypeAdapterEntry)) {
            return false;
        }
        OptimalTypeAdapterEntry optimalTypeAdapterEntry = (OptimalTypeAdapterEntry) obj;
        return Intrinsics.areEqual(this.a, optimalTypeAdapterEntry.a) && Intrinsics.areEqual(this.b, optimalTypeAdapterEntry.b);
    }

    @NotNull
    public final Type getType() {
        return this.a;
    }

    @NotNull
    public final TypeAdapter<?> getTypeAdapter() {
        return this.b;
    }

    public int hashCode() {
        Type type = this.a;
        int i = 0;
        int hashCode = (type != null ? type.hashCode() : 0) * 31;
        TypeAdapter<?> typeAdapter = this.b;
        if (typeAdapter != null) {
            i = typeAdapter.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OptimalTypeAdapterEntry(type=");
        L.append(this.a);
        L.append(", typeAdapter=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
