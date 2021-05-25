package r6.a.b.h;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
public abstract class k<T, R> extends Observable<R> {
    public final ObservableSource<T> source;

    public k(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }
}
