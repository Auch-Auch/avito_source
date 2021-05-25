package a2.a.a.i2.a.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ d a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(0);
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a.getViewModel().loadData();
        return Unit.INSTANCE;
    }
}
