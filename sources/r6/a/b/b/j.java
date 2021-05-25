package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import hu.akarnokd.rxjava3.util.CompositeSubscription;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class j extends Nono {
    public final Iterable<? extends Nono> b;

    public static final class a extends BasicIntQueueSubscription<Void> implements Subscriber<Void> {
        private static final long serialVersionUID = 3576466667528056758L;
        public final Subscriber<? super Void> a;
        public final CompositeSubscription b = new CompositeSubscription();

        public a(Subscriber<? super Void> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(0, 1)) {
                this.b.cancel();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(0, 1)) {
                this.b.cancel();
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (compareAndSet(0, 1)) {
                this.b.cancel();
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.b.add(subscription);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Throwable {
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 2;
        }
    }

    public j(Iterable<? extends Nono> iterable) {
        this.b = iterable;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        try {
            for (Nono nono : this.b) {
                if (aVar.get() == 0) {
                    nono.subscribe(aVar);
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            aVar.onError(th);
        }
    }
}
