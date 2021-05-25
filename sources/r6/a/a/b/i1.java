package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import r6.a.a.b.f3;
public final class i1<T> extends Perhaps<T> {
    public final Iterable<? extends Perhaps<? extends T>> b;

    public i1(Iterable<? extends Perhaps<? extends T>> iterable) {
        this.b = iterable;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        f3.a aVar = new f3.a(subscriber);
        subscriber.onSubscribe(aVar);
        try {
            Iterator<? extends Perhaps<? extends T>> it = this.b.iterator();
            while (it.hasNext()) {
                ((Perhaps) ObjectHelper.requireNonNull((Perhaps) it.next(), "One of the sources is null")).subscribe(aVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            aVar.onError(th);
        }
    }
}
