package com.jakewharton.rxbinding3.internal;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/jakewharton/rxbinding3/internal/AlwaysTrue;", "Lkotlin/Function0;", "", "Lkotlin/Function1;", "", "invoke", "()Ljava/lang/Boolean;", "ignored", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "<init>", "()V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AlwaysTrue implements Function0<Boolean>, Function1<Object, Boolean> {
    public static final AlwaysTrue INSTANCE = new AlwaysTrue();

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public Boolean invoke() {
        return Boolean.TRUE;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public Boolean invoke(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "ignored");
        return Boolean.TRUE;
    }
}
