package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class e<T, R> extends Flowable<R> implements FlowableTransformer<T, R> {
    public final Flowable<T> b;
    public final FlowableTransformer<T, R> c;

    public static final class a<T, R> extends Flowable<T> implements FlowableSubscriber<T>, Subscription {
        public final Flowable<T> b;
        public final AtomicReference<Subscriber<? super T>> c = new AtomicReference<>();
        public final a<T, R>.C0588a d;
        public Subscription e;

        /* renamed from: r6.a.a.h.e$a$a  reason: collision with other inner class name */
        public final class C0588a extends AtomicReference<Throwable> implements FlowableSubscriber<R>, Subscription {
            private static final long serialVersionUID = -5718512540714037078L;
            public final Subscriber<? super R> a;
            public Subscription b;

            public C0588a(a aVar, Subscriber<? super R> subscriber) {
                this.a = subscriber;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                this.b.cancel();
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                Throwable th = (Throwable) get();
                if (th != null) {
                    this.a.onError(th);
                } else {
                    this.a.onComplete();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                Throwable th2 = (Throwable) get();
                if (th2 != null) {
                    th = new CompositeException(th2, th);
                }
                this.a.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(R r) {
                this.a.onNext(r);
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                this.b = subscription;
                this.a.onSubscribe(this);
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j) {
                this.b.request(j);
            }
        }

        public a(Flowable<T> flowable, Subscriber<? super R> subscriber) {
            this.b = flowable;
            this.d = new C0588a(this, subscriber);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.c.get().onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.d.set(th);
            this.c.get().onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.c.get().onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.e = subscription;
            this.c.get().onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.e.request(j);
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super T> subscriber) {
            if (this.c.compareAndSet(null, subscriber)) {
                this.b.subscribe((FlowableSubscriber) this);
            } else {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed"), subscriber);
            }
        }
    }

    public e(Flowable<T> flowable, FlowableTransformer<T, R> flowableTransformer) {
        this.b = flowable;
        this.c = flowableTransformer;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new e(flowable, this.c);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        a aVar = new a(this.b, subscriber);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.c.apply(aVar), "The transformer returned a null Publisher")).subscribe(aVar.d);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
