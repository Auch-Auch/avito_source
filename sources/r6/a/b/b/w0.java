package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import org.reactivestreams.Subscriber;
import r6.a.b.b.t0;
public final class w0 extends Nono {
    public final Nono b;
    public final long c;

    public static final class a extends t0.a {
        private static final long serialVersionUID = 3432411068139897716L;

        public a(Subscriber<? super Void> subscriber, long j, Nono nono) {
            super(subscriber, j, nono);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.e = false;
            d(th);
        }
    }

    public w0(Nono nono, long j) {
        this.b = nono;
        this.c = j;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.b));
    }
}
