package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class k extends Nono {
    public final Nono b;
    public final Nono c;

    public static final class a extends e<Void, Subscription> implements Subscriber<Void> {
        private static final long serialVersionUID = 5073982210916423158L;
        public final Subscriber<? super Void> a;
        public final Nono b;

        /* renamed from: r6.a.b.b.k$a$a  reason: collision with other inner class name */
        public final class C0609a implements Subscriber<Void> {
            public C0609a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.a.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.a.onError(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // org.reactivestreams.Subscriber
            public void onNext(Void r1) {
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                SubscriptionHelper.replace(aVar, subscription);
            }
        }

        public a(Subscriber<? super Void> subscriber, Nono nono) {
            this.a = subscriber;
            this.b = nono;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.b.subscribe(new C0609a());
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
            if (SubscriptionHelper.setOnce(this, subscription)) {
                this.a.onSubscribe(this);
            }
        }
    }

    public k(Nono nono, Nono nono2) {
        this.b = nono;
        this.c = nono2;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
