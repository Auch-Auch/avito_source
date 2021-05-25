package a2.a.a.o1.d.a0.i;

import java.util.concurrent.Callable;
import kotlin.Unit;
public final class e<V> implements Callable<Object> {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.a.a.a.f.getDispatchSyncLatestMessagesAction().invoke(this.a.a.a.c, this.a.a.a.d);
        return Unit.INSTANCE;
    }
}
