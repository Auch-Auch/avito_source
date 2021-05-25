package com.avito.android.messenger.blacklist.mvi;

import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
public final class BlacklistInteractorImpl$inlined$sam$i$io_reactivex_functions_Action$0 implements Action {
    public final /* synthetic */ Function0 a;

    public BlacklistInteractorImpl$inlined$sam$i$io_reactivex_functions_Action$0(Function0 function0) {
        this.a = function0;
    }

    @Override // io.reactivex.functions.Action
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(), "invoke(...)");
    }
}
