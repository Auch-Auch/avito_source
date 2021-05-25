package r6.a.b.h;

import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class f extends d<Float, Float> {

    public static final class a extends DeferredScalarSubscriber<Float, Float> {
        private static final long serialVersionUID = 600979972678601618L;
        public float a;

        public a(Subscriber<? super Float> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.hasValue) {
                complete(Float.valueOf(this.a));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Float f = (Float) obj;
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.a = f.floatValue() + this.a;
        }
    }

    public f(Publisher<Float> publisher) {
        super(publisher);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Float> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
