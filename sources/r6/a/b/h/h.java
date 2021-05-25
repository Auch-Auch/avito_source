package r6.a.b.h;

import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class h extends d<Long, Long> {

    public static final class a extends DeferredScalarSubscriber<Long, Long> {
        private static final long serialVersionUID = 600979972678601618L;
        public long a;

        public a(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.hasValue) {
                complete(Long.valueOf(this.a));
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Long l = (Long) obj;
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.a = l.longValue() + this.a;
        }
    }

    public h(Publisher<Long> publisher) {
        super(publisher);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
