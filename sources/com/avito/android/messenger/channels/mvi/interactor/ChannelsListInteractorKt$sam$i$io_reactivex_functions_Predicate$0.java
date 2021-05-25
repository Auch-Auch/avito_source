package com.avito.android.messenger.channels.mvi.interactor;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
public final class ChannelsListInteractorKt$sam$i$io_reactivex_functions_Predicate$0 implements Predicate {
    public final /* synthetic */ Function1 a;

    public ChannelsListInteractorKt$sam$i$io_reactivex_functions_Predicate$0(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.functions.Predicate
    public final /* synthetic */ boolean test(@NonNull Object obj) {
        Object invoke = this.a.invoke(obj);
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }
}
