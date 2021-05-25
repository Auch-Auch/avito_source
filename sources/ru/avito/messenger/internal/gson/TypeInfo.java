package ru.avito.messenger.internal.gson;

import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lru/avito/messenger/internal/gson/TypeInfo;", "T", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "type", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getAdapter", "()Ljava/lang/Object;", "adapter", "<init>", "(Ljava/lang/Class;Ljava/lang/Object;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class TypeInfo<T> {
    @NotNull
    public final Class<T> a;
    @Nullable
    public final Object b;

    public TypeInfo(@NotNull Class<T> cls, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(cls, "type");
        this.a = cls;
        this.b = obj;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, TypeInfo.class)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type ru.avito.messenger.internal.gson.TypeInfo<*>");
        return !(Intrinsics.areEqual(this.a, ((TypeInfo) obj).a) ^ true);
    }

    @Nullable
    public final Object getAdapter() {
        return this.b;
    }

    @NotNull
    public final Class<T> getType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeInfo(Class cls, Object obj, int i, j jVar) {
        this(cls, (i & 2) != 0 ? null : obj);
    }
}
