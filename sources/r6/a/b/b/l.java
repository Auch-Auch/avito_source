package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class l<T> extends Flowable<T> {
    public final Nono b;
    public final Publisher<? extends T> c;

    public static final class a<T> extends AtomicReference<Subscription> implements Subscriber<Void>, Subscription {
        private static final long serialVersionUID = -1295251708496517979L;
        public final Subscriber<? super T> a;
        public final AtomicLong b = new AtomicLong();
        public final Publisher<? extends T> c;
        public Subscription d;

        /* renamed from: r6.a.b.b.l$a$a  reason: collision with other inner class name */
        public final class C0611a implements Subscriber<T> {
            public final Subscriber<? super T> a;

            public C0611a() {
                this.a = a.this.a;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                this.a.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                this.a.onNext(t);
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                a aVar = a.this;
                SubscriptionHelper.deferredSetOnce(aVar, aVar.b, subscription);
            }
        }

        public a(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.a = subscriber;
            this.c = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.c.subscribe(new C0611a());
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.b, j);
        }
    }

    public l(Nono nono, Publisher<? extends T> publisher) {
        this.b = nono;
        this.c = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
