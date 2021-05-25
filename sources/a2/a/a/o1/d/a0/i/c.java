package a2.a.a.o1.d.a0.i;

import java.util.concurrent.Callable;
import kotlin.Unit;
public final class c<V> implements Callable<Object> {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.a.a.a.f.getDispatchSyncLatestMessagesAction().invoke(this.a.a.a.c, this.a.a.a.d);
        return Unit.INSTANCE;
    }
}
