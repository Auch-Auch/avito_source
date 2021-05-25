package r6.a.b.f;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Map;
public final class i<T, K> extends Observable<T> {
    public final Supplier<? extends K> a;
    public final Map<? super K, ? extends ObservableSource<? extends T>> b;
    public final ObservableSource<? extends T> c;

    public i(Supplier<? extends K> supplier, Map<? super K, ? extends ObservableSource<? extends T>> map, ObservableSource<? extends T> observableSource) {
        this.a = supplier;
        this.b = map;
        this.c = observableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            ObservableSource<? extends T> observableSource = (ObservableSource) this.b.get(this.a.get());
            if (observableSource == null) {
                observableSource = this.c;
            }
            observableSource.subscribe(observer);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
