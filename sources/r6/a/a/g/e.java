package r6.a.a.g;

import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class e extends d<Double, Double> {

    public static final class a extends DeferredScalarSubscriber<Double, Double> {
        private static final long serialVersionUID = 600979972678601618L;
        public double a;

        public a(Subscriber<? super Double> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.hasValue) {
                complete(Double.valueOf(this.a));
            } else {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Double d = (Double) obj;
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.a = d.doubleValue() + this.a;
        }
    }

    public e(Publisher<Double> publisher) {
        super(publisher);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Double> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
