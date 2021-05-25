package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class c0<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Publisher<T> b;
    public final long c;
    public final long d;
    public final Scheduler e;
    public final boolean f;
    public final int g;

    public static final class a<T> implements Subscriber<T>, Subscription, Runnable {
        public final Subscriber<? super T> a;
        public final long b;
        public final long c;
        public final Scheduler.Worker d;
        public final boolean e;
        public final SimplePlainQueue<T> f;
        public long g = -1;
        public Subscription h;
        public volatile Object i;

        public a(Subscriber<? super T> subscriber, long j, long j2, Scheduler.Worker worker, boolean z, int i2) {
            this.a = subscriber;
            this.b = j;
            this.c = j2;
            this.d = worker;
            this.e = z;
            this.f = new SpscLinkedArrayQueue(i2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.dispose();
            this.h.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.i = this;
            Scheduler.Worker worker = this.d;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            this.d.schedule(this, (this.g - worker.now(timeUnit)) - this.c, timeUnit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.i = th;
            if (this.e) {
                Scheduler.Worker worker = this.d;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                this.d.schedule(this, (this.g - worker.now(timeUnit)) - this.c, timeUnit);
                return;
            }
            this.d.schedule(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f.offer(t);
            Scheduler.Worker worker = this.d;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long now = worker.now(timeUnit);
            long j = this.g;
            long j2 = this.c;
            if (j == -1) {
                long j3 = this.b;
                this.g = now + j2 + j3;
                this.d.schedule(this, j3, timeUnit);
            } else if (j < now) {
                this.g = now + j2;
                this.d.schedule(this);
            } else {
                this.g = j2 + j;
                this.d.schedule(this, j - now, timeUnit);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.h.request(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.i;
            if (obj == null || obj == this || this.e) {
                T poll = this.f.poll();
                boolean z = poll == null;
                if (obj != null && z) {
                    if (obj == this) {
                        this.a.onComplete();
                    } else {
                        this.a.onError((Throwable) obj);
                    }
                    this.d.dispose();
                } else if (!z) {
                    this.a.onNext(poll);
                }
            } else {
                this.f.clear();
                this.a.onError((Throwable) obj);
                this.d.dispose();
            }
        }
    }

    public c0(Publisher<T> publisher, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        this.b = publisher;
        this.c = timeUnit.toNanos(j);
        this.d = timeUnit.toNanos(j2);
        this.e = scheduler;
        this.f = z;
        this.g = i;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new c0(flowable, this.c, this.d, TimeUnit.NANOSECONDS, this.e, this.f, this.g);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e.createWorker(), this.f, this.g));
    }
}
