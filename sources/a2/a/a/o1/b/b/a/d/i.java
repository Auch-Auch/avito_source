package a2.a.a.o1.b.b.a.d;

import com.avito.android.messenger.channels.mvi.common.v4.ReducibleKt;
import com.avito.android.util.Logs;
import java.util.concurrent.Callable;
public final class i<V> implements Callable<S> {
    public final /* synthetic */ ReducibleKt.a a;
    public final /* synthetic */ Object b;

    public i(ReducibleKt.a aVar, Object obj) {
        this.a = aVar;
        this.b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final S call() {
        try {
            this.a.a.getBlock().invoke(this.b);
        } catch (Throwable th) {
            Logs.error("BaseMviEntityWithReducerQueue", this.a.a.getParams(), th);
        }
        return (S) this.b;
    }
}
