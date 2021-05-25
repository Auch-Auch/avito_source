package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import org.reactivestreams.Subscriber;
import r6.a.b.b.z3;
public final class i0 extends Nono {
    public final Nono b;

    public i0(Nono nono) {
        this.b = nono;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new z3.a(subscriber));
    }
}
