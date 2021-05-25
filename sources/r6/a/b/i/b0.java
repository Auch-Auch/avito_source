package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class b0<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final long c;
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;

    public static final class a<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        public final Subscriber<? super T> a;
        public final AtomicLong b = new AtomicLong();
        public final AtomicLong c = new AtomicLong();
        public final AtomicReference<Subscription> d = new AtomicReference<>();
        public final AtomicReference<Disposable> e = new AtomicReference<>();
        public long f;
        public boolean g;

        public a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.d);
            DisposableHelper.dispose(this.e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.g) {
                this.g = true;
                this.a.onComplete();
                DisposableHelper.dispose(this.e);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.g) {
                this.g = true;
                this.a.onError(th);
                DisposableHelper.dispose(this.e);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.g) {
                long j = this.f;
                if (this.b.get() != j) {
                    this.f = j + 1;
                    this.a.onNext(t);
                    return;
                }
                this.g = true;
                cancel();
                this.a.onError(new MissingBackpressureException("Downstream is not ready to receive the next upstream item."));
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.d, this.c, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.b, j);
        }

        @Override // java.lang.Runnable
        public void run() {
            SubscriptionHelper.deferredRequest(this.d, this.c, 1);
        }
    }

    public b0(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = flowable;
        this.c = j;
        this.d = j2;
        this.e = timeUnit;
        this.f = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new b0(flowable, this.c, this.d, this.e, this.f);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        DisposableHelper.setOnce(aVar.e, this.f.schedulePeriodicallyDirect(aVar, this.c, this.d, this.e));
        this.b.subscribe((FlowableSubscriber) aVar);
    }
}
