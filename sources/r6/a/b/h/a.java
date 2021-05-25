package r6.a.b.h;

import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class a extends d<Number, Double> {

    /* renamed from: r6.a.b.h.a$a  reason: collision with other inner class name */
    public static final class C0638a extends DeferredScalarSubscriber<Number, Double> {
        private static final long serialVersionUID = 600979972678601618L;
        public double a;
        public long b;

        public C0638a(Subscriber<? super Double> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            long j = this.b;
            if (j != 0) {
                complete(Double.valueOf(this.a / ((double) j)));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.a = ((Number) obj).doubleValue() + this.a;
            this.b++;
        }
    }

    public a(Publisher<Number> publisher) {
        super(publisher);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Double> subscriber) {
        this.b.subscribe(new C0638a(subscriber));
    }
}
