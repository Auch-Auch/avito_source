package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import r6.a.a.b.f3;
public final class g3<T> extends Solo<T> {
    public final Iterable<? extends Solo<? extends T>> b;

    public g3(Iterable<? extends Solo<? extends T>> iterable) {
        this.b = iterable;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        f3.a aVar = new f3.a(subscriber);
        subscriber.onSubscribe(aVar);
        try {
            Iterator<? extends Solo<? extends T>> it = this.b.iterator();
            while (it.hasNext()) {
                ((Solo) ObjectHelper.requireNonNull((Solo) it.next(), "One of the sources is null")).subscribe(aVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            aVar.onError(th);
        }
    }
}
