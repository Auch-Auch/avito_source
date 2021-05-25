package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class m4<T> extends Solo<T> {
    public final Solo<T> b;
    public final Scheduler c;

    public static final class a<T> extends AtomicReference<Subscription> implements Subscriber<T>, Runnable, Subscription {
        private static final long serialVersionUID = 2047863608816341143L;
        public final Subscriber<? super T> a;
        public final Scheduler.Worker b;
        public final AtomicReference<Disposable> c = new AtomicReference<>();
        public final Publisher<T> d;
        public final AtomicBoolean e = new AtomicBoolean();

        /* renamed from: r6.a.b.b.m4$a$a  reason: collision with other inner class name */
        public class RunnableC0615a implements Runnable {
            public RunnableC0615a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((Subscription) a.this.get()).request(Long.MAX_VALUE);
            }
        }

        public a(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher) {
            this.a = subscriber;
            this.b = worker;
            this.d = publisher;
        }

        public void a() {
            this.b.schedule(new RunnableC0615a());
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
            DisposableHelper.dispose(this.c);
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription) && this.e.getAndSet(false)) {
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!SubscriptionHelper.validate(j)) {
                return;
            }
            if (((Subscription) get()) != null) {
                a();
                return;
            }
            this.e.set(true);
            if (((Subscription) get()) != null && this.e.getAndSet(false)) {
                a();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d.subscribe(this);
        }
    }

    public m4(Solo<T> solo, Scheduler scheduler) {
        this.b = solo;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.c.createWorker();
        a aVar = new a(subscriber, createWorker, this.b);
        subscriber.onSubscribe(aVar);
        DisposableHelper.replace(aVar.c, createWorker.schedule(aVar));
    }
}
