package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import r6.a.b.b.f3;
public final class i1<T> extends Perhaps<T> {
    public final Iterable<? extends Perhaps<? extends T>> b;

    public i1(Iterable<? extends Perhaps<? extends T>> iterable) {
        this.b = iterable;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        f3.a aVar = new f3.a(subscriber);
        subscriber.onSubscribe(aVar);
        try {
            Iterator<? extends Perhaps<? extends T>> it = this.b.iterator();
            while (it.hasNext()) {
                Perhaps perhaps = (Perhaps) it.next();
                Objects.requireNonNull(perhaps, "One of the sources is null");
                perhaps.subscribe(aVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            aVar.onError(th);
        }
    }
}
