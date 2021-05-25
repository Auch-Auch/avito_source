package com.avito.android.ab_tests.models;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u00028\u00008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/ab_tests/models/SimpleAbTestGroup;", "T", "Lcom/avito/android/ab_tests/models/AbTestGroup;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getTestGroup", "()Ljava/lang/Object;", "testGroup", "Lkotlin/Function0;", "producer", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleAbTestGroup<T> implements AbTestGroup<T> {
    public final T a;

    public SimpleAbTestGroup(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "producer");
        this.a = (T) function0.invoke();
    }

    @Override // com.avito.android.ab_tests.models.AbTestGroup
    public T getTestGroup() {
        return this.a;
    }
}
