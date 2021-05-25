package r6.a.a.g;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
public abstract class k<T, R> extends Observable<R> {
    public final ObservableSource<T> source;

    public k(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }
}
