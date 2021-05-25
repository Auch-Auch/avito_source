package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import r6.a.b.b.f3;
public final class g3<T> extends Solo<T> {
    public final Iterable<? extends Solo<? extends T>> b;

    public g3(Iterable<? extends Solo<? extends T>> iterable) {
        this.b = iterable;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        f3.a aVar = new f3.a(subscriber);
        subscriber.onSubscribe(aVar);
        try {
            Iterator<? extends Solo<? extends T>> it = this.b.iterator();
            while (it.hasNext()) {
                Solo solo = (Solo) it.next();
                Objects.requireNonNull(solo, "One of the sources is null");
                solo.subscribe(aVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            aVar.onError(th);
        }
    }
}
