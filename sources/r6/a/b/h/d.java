package r6.a.b.h;

import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
public abstract class d<T, R> extends Flowable<R> {
    public final Publisher<T> b;

    public d(Publisher<T> publisher) {
        this.b = publisher;
    }
}
