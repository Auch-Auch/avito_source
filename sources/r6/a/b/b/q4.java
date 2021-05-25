package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Subscriber;
public final class q4<T> extends Flowable<T> {
    public final Solo<T> b;

    public q4(Solo<T> solo) {
        this.b = solo;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(subscriber);
    }
}
