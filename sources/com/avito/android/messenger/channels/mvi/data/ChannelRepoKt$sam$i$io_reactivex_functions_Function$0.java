package com.avito.android.messenger.channels.mvi.data;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
public final class ChannelRepoKt$sam$i$io_reactivex_functions_Function$0 implements Function {
    public final /* synthetic */ Function1 a;

    public ChannelRepoKt$sam$i$io_reactivex_functions_Function$0(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(@NonNull Object obj) {
        return this.a.invoke(obj);
    }
}
