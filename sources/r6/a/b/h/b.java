package r6.a.b.h;

import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class b extends d<Number, Float> {

    public static final class a extends DeferredScalarSubscriber<Number, Float> {
        private static final long serialVersionUID = 600979972678601618L;
        public float a;
        public int b;

        public a(Subscriber<? super Float> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            int i = this.b;
            if (i != 0) {
                complete(Float.valueOf(this.a / ((float) i)));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.a = ((Number) obj).floatValue() + this.a;
            this.b++;
        }
    }

    public b(Publisher<Number> publisher) {
        super(publisher);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Float> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
