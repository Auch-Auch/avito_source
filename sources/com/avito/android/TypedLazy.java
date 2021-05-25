package com.avito.android;

import com.avito.android.remote.auth.AuthSource;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R!\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/TypedLazy;", "T", "Ldagger/Lazy;", "get", "()Ljava/lang/Object;", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "type", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "delegate", "<init>", "(Ljava/lang/Class;Ldagger/Lazy;)V", "dagger-scopes_release"}, k = 1, mv = {1, 4, 2})
public final class TypedLazy<T> implements Lazy<T> {
    @NotNull
    public final Class<? extends T> a;
    public final Lazy<T> b;

    public TypedLazy(@NotNull Class<? extends T> cls, @NotNull Lazy<T> lazy) {
        Intrinsics.checkNotNullParameter(cls, "type");
        Intrinsics.checkNotNullParameter(lazy, "delegate");
        this.a = cls;
        this.b = lazy;
    }

    @Override // dagger.Lazy
    public T get() {
        return this.b.get();
    }

    @NotNull
    public final Class<? extends T> getType() {
        return this.a;
    }
}
