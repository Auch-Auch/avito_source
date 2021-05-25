package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
public final class q4<T> extends Flowable<T> {
    public final Solo<T> b;

    public q4(Solo<T> solo) {
        this.b = solo;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(subscriber);
    }
}
