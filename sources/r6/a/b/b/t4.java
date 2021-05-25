package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;
public final class t4<T> extends Solo<T> {
    public final Solo<T> b;
    public final Scheduler c;

    public static final class a<T> extends BasicFuseableSubscriber<T, T> implements Runnable {
        public final Scheduler a;

        public a(Subscriber<? super T> subscriber, Scheduler scheduler) {
            super(subscriber);
            this.a = scheduler;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            this.a.scheduleDirect(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            return this.qs.poll();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i);
            this.sourceMode = requestFusion;
            return requestFusion;
        }

        @Override // java.lang.Runnable
        public void run() {
            super.cancel();
        }
    }

    public t4(Solo<T> solo, Scheduler scheduler) {
        this.b = solo;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
