package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class v extends Nono {
    public final Nono b;
    public final Publisher<?> c;

    public static final class a extends e<Object, Subscription> implements Subscriber<Object> {
        private static final long serialVersionUID = 7914910659996431449L;
        public final Subscriber<? super Void> a;
        public final Nono b;
        public boolean c;

        /* renamed from: r6.a.a.b.v$a$a  reason: collision with other inner class name */
        public final class C0577a implements Subscriber<Void> {
            public C0577a() {
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
            if (!this.c) {
                this.c = true;
                this.b.subscribe(new C0577a());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (!this.c) {
                ((Subscription) get()).cancel();
                onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public v(Nono nono, Publisher<?> publisher) {
        this.b = nono;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.c.subscribe(new a(subscriber, this.b));
    }
}
