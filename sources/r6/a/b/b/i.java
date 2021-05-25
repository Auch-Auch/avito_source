package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.exceptions.Exceptions;
import org.reactivestreams.Subscriber;
import r6.a.b.b.j;
public final class i extends Nono {
    public final Nono[] b;

    public i(Nono[] nonoArr) {
        this.b = nonoArr;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        j.a aVar = new j.a(subscriber);
        subscriber.onSubscribe(aVar);
        try {
            Nono[] nonoArr = this.b;
            for (Nono nono : nonoArr) {
                if (aVar.get() == 0) {
                    nono.subscribe(aVar);
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            aVar.onError(th);
        }
    }
}
