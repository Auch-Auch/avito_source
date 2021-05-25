package s6.a.c.b.c;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
public abstract class a<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {
    public final ObservableSource<T> source;

    public a(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public final ObservableSource<T> source() {
        return this.source;
    }
}
