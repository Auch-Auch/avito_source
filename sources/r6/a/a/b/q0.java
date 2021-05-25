package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
public final class q0 extends Nono {
    public final Nono b;
    public final Scheduler c;

    public static final class a extends d<Disposable> implements Runnable {
        private static final long serialVersionUID = -7575632829277450540L;
        public final Scheduler c;
        public Throwable d;

        public a(Subscriber<? super Void> subscriber, Scheduler scheduler) {
            super(subscriber);
            this.c = scheduler;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.b.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.replace(this, this.c.scheduleDirect(this));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.d = th;
            DisposableHelper.replace(this, this.c.scheduleDirect(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.d;
            if (th != null) {
                this.d = null;
                this.a.onError(th);
                return;
            }
            this.a.onComplete();
        }
    }

    public q0(Nono nono, Scheduler scheduler) {
        this.b = nono;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
