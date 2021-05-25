package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
public final class u extends Nono {
    public final Nono b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;

    public static final class a extends d<Disposable> implements Runnable {
        private static final long serialVersionUID = -7575632829277450540L;
        public final long c;
        public final TimeUnit d;
        public final Scheduler e;
        public Throwable f;

        public a(Subscriber<? super Void> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber);
            this.c = j;
            this.d = timeUnit;
            this.e = scheduler;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.b.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.replace(this, this.e.scheduleDirect(this, this.c, this.d));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f = th;
            DisposableHelper.replace(this, this.e.scheduleDirect(this, this.c, this.d));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f;
            if (th != null) {
                this.f = null;
                this.a.onError(th);
                return;
            }
            this.a.onComplete();
        }
    }

    public u(Nono nono, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = nono;
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e));
    }
}
