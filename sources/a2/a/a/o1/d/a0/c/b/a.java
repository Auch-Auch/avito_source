package a2.a.a.o1.d.a0.c.b;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Ref.ObjectRef a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Ref.ObjectRef objectRef) {
        super(0);
        this.a = objectRef;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        T t = this.a.element;
        if (t != null) {
            t.dismiss();
        }
        return Unit.INSTANCE;
    }
}
