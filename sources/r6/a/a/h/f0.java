package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class f0<T> extends Flowable<Flowable<T>> implements FlowableTransformer<T, Flowable<T>> {
    public final Publisher<T> b;
    public final Predicate<? super T> c;
    public final a d;
    public final int e;

    public enum a {
        BEFORE,
        AFTER,
        SPLIT
    }

    public static final class b<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2749959965593866309L;
        public final Subscriber<? super Flowable<T>> a;
        public final Predicate<? super T> b;
        public final a c;
        public final int d;
        public final AtomicBoolean e = new AtomicBoolean();
        public Subscription f;
        public UnicastProcessor<T> g;
        public final AtomicLong h;
        public final AtomicReference<UnicastProcessor<T>> i;

        public b(Subscriber<? super Flowable<T>> subscriber, Predicate<? super T> predicate, a aVar, int i2) {
            super(1);
            this.a = subscriber;
            this.b = predicate;
            this.c = aVar;
            this.d = i2;
            if (aVar == a.BEFORE) {
                this.h = new AtomicLong();
                this.i = new AtomicReference<>();
                return;
            }
            this.h = null;
            this.i = null;
        }

        public final void a() {
            UnicastProcessor<T> andSet;
            if (this.h.get() > 0 && (andSet = this.i.getAndSet(null)) != null) {
                getAndIncrement();
                this.h.getAndDecrement();
                this.a.onNext(andSet);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.e.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.g;
            if (unicastProcessor != null) {
                this.g = null;
                unicastProcessor.onComplete();
            }
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.g;
            if (unicastProcessor != null) {
                this.g = null;
                unicastProcessor.onError(th);
            }
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.f.request(1);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (this.c == a.BEFORE && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.h, j);
                a();
            }
            this.f.request(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f.cancel();
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            a aVar = a.BEFORE;
            UnicastProcessor<T> unicastProcessor = this.g;
            boolean z = true;
            if (unicastProcessor == null) {
                if (this.e.get()) {
                    return true;
                }
                unicastProcessor = UnicastProcessor.create(this.d, this);
                this.g = unicastProcessor;
                getAndIncrement();
                if (this.c == aVar) {
                    this.h.getAndDecrement();
                }
                this.a.onNext(unicastProcessor);
            }
            try {
                boolean test = this.b.test(t);
                a aVar2 = this.c;
                if (aVar2 != aVar) {
                    z = false;
                }
                boolean z2 = z ^ test;
                if (z2) {
                    if (aVar2 == a.AFTER) {
                        unicastProcessor.onNext(t);
                    }
                    unicastProcessor.onComplete();
                    if (this.c == aVar) {
                        UnicastProcessor<T> create = UnicastProcessor.create(this.d, this);
                        this.g = create;
                        create.onNext(t);
                        this.i.set(create);
                        a();
                    } else {
                        this.g = null;
                    }
                } else {
                    unicastProcessor.onNext(t);
                }
                return z2;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f.cancel();
                this.a.onError(th);
                unicastProcessor.onError(th);
                this.g = null;
                return true;
            }
        }
    }

    public f0(Publisher<T> publisher, Predicate<? super T> predicate, a aVar, int i) {
        this.b = publisher;
        this.c = predicate;
        this.d = aVar;
        this.e = i;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<Flowable<T>> apply(Flowable<T> flowable) {
        return new f0(flowable, this.c, this.d, this.e);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.b.subscribe(new b(subscriber, this.c, this.d, this.e));
    }
}
