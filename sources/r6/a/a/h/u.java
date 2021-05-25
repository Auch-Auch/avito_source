package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class u<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final Scheduler c;

    public static final class a<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 3167152788131496136L;
        public final Subscriber<? super T> a;
        public final Scheduler.Worker b;
        public final Runnable c = new RunnableC0595a();
        public Subscription d;
        public volatile T e;
        public Throwable f;
        public volatile boolean g;
        public long h;
        public boolean i;

        /* renamed from: r6.a.a.h.u$a$a  reason: collision with other inner class name */
        public class RunnableC0595a implements Runnable {
            public RunnableC0595a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d.request(1);
            }
        }

        public a(Subscriber<? super T> subscriber, Scheduler.Worker worker) {
            this.a = subscriber;
            this.b = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
            this.b.dispose();
            this.e = null;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.g = true;
            this.b.schedule(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f = th;
            this.g = true;
            this.b.schedule(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.e = t;
            this.b.schedule(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.d = subscription;
            this.a.onSubscribe(this);
            this.b.schedule(this.c);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this, j);
            this.b.schedule(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.i) {
                while (true) {
                    boolean z = this.g;
                    T t = this.e;
                    boolean z2 = t == null;
                    if (!z || !z2) {
                        long j = this.h;
                        if (!z2 && j != get()) {
                            this.e = null;
                            this.a.onNext(t);
                            this.h = j + 1;
                            this.b.schedule(this.c);
                        } else {
                            return;
                        }
                    } else {
                        Throwable th = this.f;
                        if (th != null) {
                            this.a.onError(th);
                        } else {
                            this.a.onComplete();
                        }
                        this.b.dispose();
                        this.i = true;
                        return;
                    }
                }
            }
        }
    }

    public u(Flowable<T> flowable, Scheduler scheduler) {
        this.b = flowable;
        this.c = scheduler;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new u(flowable, this.c);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c.createWorker()));
    }
}
