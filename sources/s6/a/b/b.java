package s6.a.b;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
public final class b extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    public final boolean a;

    public b(Future<?> future, boolean z) {
        super(future);
        this.a = z;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future future = (Future) getAndSet(null);
        if (future != null) {
            future.cancel(this.a);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Future future = (Future) get();
        return future == null || future.isDone();
    }
}
