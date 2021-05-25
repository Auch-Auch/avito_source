package com.avito.android.messenger.conversation.mvi.context;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0 implements Consumer {
    public final /* synthetic */ Function1 a;

    public ChannelContextInteractorImpl$sam$i$io_reactivex_functions_Consumer$0(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object obj) {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(obj), "invoke(...)");
    }
}
