package r6.a.a.b;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
public abstract class b extends AtomicInteger implements QueueSubscription<Void> {
    private static final long serialVersionUID = -4226314340037668732L;

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        Void r2 = (Void) obj;
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public /* bridge */ /* synthetic */ Object poll() throws Exception {
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int i) {
        return i & 2;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj, Object obj2) {
        Void r1 = (Void) obj;
        Void r2 = (Void) obj2;
        throw new UnsupportedOperationException("Should not be called!");
    }
}
