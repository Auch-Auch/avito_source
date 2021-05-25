package n6.b;

import arrow.legacy.RightProjectionKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<X, Y> {
    public final /* synthetic */ RightProjectionKt.a a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(RightProjectionKt.a aVar, Object obj) {
        super(1);
        this.a = aVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Y invoke(X x) {
        return (Y) this.a.b.invoke(this.b, x);
    }
}
