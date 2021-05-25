package r6.a.a.e;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Map;
import java.util.concurrent.Callable;
public final class e<T, K> extends Observable<T> {
    public final Callable<? extends K> a;
    public final Map<? super K, ? extends ObservableSource<? extends T>> b;
    public final ObservableSource<? extends T> c;

    public e(Callable<? extends K> callable, Map<? super K, ? extends ObservableSource<? extends T>> map, ObservableSource<? extends T> observableSource) {
        this.a = callable;
        this.b = map;
        this.c = observableSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            ObservableSource<? extends T> observableSource = (ObservableSource) this.b.get(this.a.call());
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
