package r6.a.a.g;

import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class g extends d<Integer, Integer> {

    public static final class a extends DeferredScalarSubscriber<Integer, Integer> {
        private static final long serialVersionUID = 600979972678601618L;
        public int a;

        public a(Subscriber<? super Integer> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.hasValue) {
                complete(Integer.valueOf(this.a));
            } else {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Integer num = (Integer) obj;
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.a = num.intValue() + this.a;
        }
    }

    public g(Publisher<Integer> publisher) {
        super(publisher);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
