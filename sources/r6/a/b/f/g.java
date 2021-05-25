package r6.a.b.f;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Map;
public final class g<T, K> extends Maybe<T> {
    public final Supplier<? extends K> a;
    public final Map<? super K, ? extends MaybeSource<? extends T>> b;
    public final MaybeSource<? extends T> c;

    public g(Supplier<? extends K> supplier, Map<? super K, ? extends MaybeSource<? extends T>> map, MaybeSource<? extends T> maybeSource) {
        this.a = supplier;
        this.b = map;
        this.c = maybeSource;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            MaybeSource<? extends T> maybeSource = (MaybeSource) this.b.get(this.a.get());
            if (maybeSource == null) {
                maybeSource = this.c;
            }
            maybeSource.subscribe(maybeObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, maybeObserver);
        }
    }
}
