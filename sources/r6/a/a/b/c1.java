package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
public final class c1 extends Nono {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;

    public static final class a extends e<Void, Disposable> implements Runnable {
        private static final long serialVersionUID = 3940118717227297027L;
        public final Subscriber<? super Void> a;

        public a(Subscriber<? super Void> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // r6.a.a.b.e, io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // r6.a.a.b.e, io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
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
            this.a.onComplete();
        }
    }

    public c1(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        DisposableHelper.replace(aVar, this.d.scheduleDirect(aVar, this.b, this.c));
    }
}
