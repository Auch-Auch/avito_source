package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import org.reactivestreams.Subscriber;
public final class r0 extends Nono {
    public final Nono b;

    public static final class a extends c {
        public a(Subscriber<? super Void> subscriber) {
            super(subscriber);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onComplete();
        }
    }

    public r0(Nono nono) {
        this.b = nono;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
