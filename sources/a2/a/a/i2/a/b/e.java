package a2.a.a.i2.a.b;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Runnable a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Runnable runnable) {
        super(0);
        this.a = runnable;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.run();
        return Unit.INSTANCE;
    }
}
