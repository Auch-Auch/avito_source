package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
public final class p4 extends Solo<Long> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;

    public static final class a extends DeferredScalarSubscription<Long> implements Runnable {
        private static final long serialVersionUID = -4937102843159363918L;
        public final AtomicReference<Disposable> a = new AtomicReference<>();

        public a(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        @Override // java.lang.Runnable
        public void run() {
            complete(0L);
        }
    }

    public p4(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        DisposableHelper.replace(aVar.a, this.d.scheduleDirect(aVar, this.b, this.c));
    }
}
