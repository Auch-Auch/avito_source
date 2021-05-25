package n6.a;

import arrow.core.PredefKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class g extends Lambda implements Function1<B, Z> {
    public final /* synthetic */ PredefKt.c a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(PredefKt.c cVar, Object obj) {
        super(1);
        this.a = cVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Z invoke(B b2) {
        return (Z) this.a.a.invoke(this.b, b2);
    }
}
