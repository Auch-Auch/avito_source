package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import org.reactivestreams.Subscriber;
import r6.a.b.b.z3;
public final class g2<T> extends Perhaps<T> {
    public final Perhaps<T> b;

    public g2(Perhaps<T> perhaps) {
        this.b = perhaps;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new z3.a(subscriber));
    }
}
