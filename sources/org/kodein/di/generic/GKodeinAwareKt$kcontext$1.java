package org.kodein.di.generic;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"C", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GKodeinAwareKt$kcontext$1 extends Lambda implements Function0<C> {
    public final /* synthetic */ Function0 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GKodeinAwareKt$kcontext$1(Function0 function0) {
        super(0);
        this.a = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final C invoke() {
        return (C) this.a.invoke();
    }
}
