package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.SingleSource;
import org.reactivestreams.Subscriber;
import r6.a.a.b.y3;
public final class f2<T> extends Perhaps<T> {
    public final SingleSource<T> b;

    public f2(SingleSource<T> singleSource) {
        this.b = singleSource;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new y3.a(subscriber));
    }
}
