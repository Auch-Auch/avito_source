package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableDelay<T> extends s6.a.e.d.c.a.a<T, T> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final boolean e;

    public static final class a<T> implements FlowableSubscriber<T>, Subscription {
        public final Subscriber<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler.Worker d;
        public final boolean e;
        public Subscription f;

        /* renamed from: io.reactivex.rxjava3.internal.operators.flowable.FlowableDelay$a$a  reason: collision with other inner class name */
        public final class RunnableC0443a implements Runnable {
            public RunnableC0443a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onComplete();
                } finally {
                    a.this.d.dispose();
                }
            }
        }

        public final class b implements Runnable {
            public final Throwable a;

            public b(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onError(this.a);
                } finally {
                    a.this.d.dispose();
                }
            }
        }

        /* JADX WARN: Field signature parse error: a */
        public final class c implements Runnable {
            public final Object a;

            /* JADX WARN: Failed to parse method signature: (TT)V */
            public c(Object obj) {
                this.a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext((Object) this.a);
            }
        }

        public a(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
            this.e = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f.cancel();
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.d.schedule(new RunnableC0443a(), this.b, this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.d.schedule(new b(th), this.e ? this.b : 0, this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.d.schedule(new c(t), this.b, this.c);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f.request(j);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber;
        if (this.e) {
            serializedSubscriber = subscriber;
        } else {
            serializedSubscriber = new SerializedSubscriber(subscriber);
        }
        this.source.subscribe((FlowableSubscriber) new a(serializedSubscriber, this.b, this.c, this.d.createWorker(), this.e));
    }
}
