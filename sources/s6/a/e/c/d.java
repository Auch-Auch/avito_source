package s6.a.e.c;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public abstract class d<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(T t) {
        super(t);
        Objects.requireNonNull(t, "value is null");
    }

    public abstract void a(@NonNull T t);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s6.a.e.c.d<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            a(andSet);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get() == null;
    }
}
