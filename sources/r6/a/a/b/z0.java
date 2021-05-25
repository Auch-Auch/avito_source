package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.Scheduler;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class z0 extends Nono {
    public final Nono b;
    public final Scheduler c;

    public static final class a extends e<Void, Subscription> implements Subscriber<Void>, Runnable {
        private static final long serialVersionUID = -6761773996344047676L;
        public final Subscriber<? super Void> a;
        public final SequentialDisposable b = new SequentialDisposable();
        public final Nono c;

        public a(Subscriber<? super Void> subscriber, Nono nono) {
            this.a = subscriber;
            this.c = nono;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
            this.b.dispose();
        }

        @Override // r6.a.a.b.e, io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // r6.a.a.b.e, io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
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
            SubscriptionHelper.setOnce(this, subscription);
        }

        @Override // r6.a.a.b.e, io.reactivex.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Exception {
            return null;
        }

        @Override // r6.a.a.b.e, org.reactivestreams.Subscription
        public void request(long j) {
        }

        @Override // r6.a.a.b.e, io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.subscribe(this);
        }
    }

    public z0(Nono nono, Scheduler scheduler) {
        this.b = nono;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        a aVar = new a(subscriber, this.b);
        subscriber.onSubscribe(aVar);
        aVar.b.replace(this.c.scheduleDirect(aVar));
    }
}
