package com.avito.android;

import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Ldagger/Lazy;", "Lcom/avito/android/TypedLazy;", "typed", "(Ldagger/Lazy;)Lcom/avito/android/TypedLazy;", "dagger-scopes_release"}, k = 2, mv = {1, 4, 2})
public final class TypedLazyKt {
    public static final /* synthetic */ <T> TypedLazy<T> typed(Lazy<T> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "$this$typed");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new TypedLazy<>(Object.class, lazy);
    }
}
