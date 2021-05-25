package s6.a.b;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;
public abstract class c<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    public c(T t) {
        super(ObjectHelper.requireNonNull(t, "value is null"));
    }

    public abstract void a(@NonNull T t);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: s6.a.b.c<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            a(andSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return get() == null;
    }
}
