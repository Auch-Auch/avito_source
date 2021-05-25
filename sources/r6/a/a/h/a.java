package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class a<T, C extends Collection<? super T>> extends Flowable<C> implements FlowableTransformer<T, C> {
    public final Publisher<T> b;
    public final Predicate<? super T> c;
    public final b d;
    public final Callable<C> e;

    /* renamed from: r6.a.a.h.a$a  reason: collision with other inner class name */
    public static final class C0587a<T, C extends Collection<? super T>> implements ConditionalSubscriber<T>, Subscription {
        public final Subscriber<? super C> a;
        public final Predicate<? super T> b;
        public final b c;
        public final Callable<C> d;
        public C e;
        public Subscription f;
        public int g;

        public C0587a(Subscriber<? super C> subscriber, C c2, Predicate<? super T> predicate, b bVar, Callable<C> callable) {
            this.a = subscriber;
            this.b = predicate;
            this.c = bVar;
            this.e = c2;
            this.d = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            C c2 = this.e;
            if (c2 != null) {
                this.e = null;
                if (this.g != 0) {
                    this.a.onNext(c2);
                }
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e != null) {
                this.e = null;
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
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
            this.f.request(j);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            C c2 = this.e;
            if (c2 != null) {
                try {
                    boolean test = this.b.test(t);
                    int ordinal = this.c.ordinal();
                    if (ordinal != 0) {
                        if (ordinal == 1) {
                            c2.add(t);
                            if (test) {
                                this.a.onNext(c2);
                                try {
                                    this.e = this.d.call();
                                    this.g = 0;
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.f.cancel();
                                    onError(th);
                                    return true;
                                }
                            } else {
                                this.g++;
                                return false;
                            }
                        } else if (test) {
                            this.a.onNext(c2);
                            try {
                                this.e = this.d.call();
                                this.g = 0;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f.cancel();
                                onError(th2);
                                return true;
                            }
                        } else {
                            c2.add(t);
                            this.g++;
                            return false;
                        }
                    } else if (test) {
                        c2.add(t);
                        this.g++;
                        return false;
                    } else {
                        this.a.onNext(c2);
                        try {
                            C call = this.d.call();
                            call.add(t);
                            this.e = call;
                            this.g = 1;
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f.cancel();
                            onError(th3);
                            return true;
                        }
                    }
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    this.f.cancel();
                    this.e = null;
                    this.a.onError(th4);
                }
            }
            return true;
        }
    }

    public enum b {
        BEFORE,
        AFTER,
        SPLIT
    }

    public a(Publisher<T> publisher, Predicate<? super T> predicate, b bVar, Callable<C> callable) {
        this.b = publisher;
        this.c = predicate;
        this.d = bVar;
        this.e = callable;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<C> apply(Flowable<T> flowable) {
        return new a(flowable, this.c, this.d, this.e);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super C> subscriber) {
        try {
            this.b.subscribe(new C0587a(subscriber, (Collection) ObjectHelper.requireNonNull(this.e.call(), "The bufferSupplier returned a null buffer"), this.c, this.d, this.e));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
