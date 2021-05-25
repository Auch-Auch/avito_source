package r6.a.a.b;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class g<T> extends CountDownLatch implements Subscriber<T> {
    public volatile boolean a;
    public Subscription b;
    public T c;
    public Throwable d;

    public g() {
        super(1);
    }

    public void a(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                d();
                consumer2.accept(e);
                return;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(e, th));
                return;
            }
        }
        Throwable th2 = this.d;
        if (th2 != null) {
            try {
                consumer2.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th2, th3));
            }
        } else {
            T t = this.c;
            if (t != null) {
                try {
                    consumer.accept(t);
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    RxJavaPlugins.onError(new CompositeException(th, th4));
                    return;
                }
            }
            try {
                action.run();
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                RxJavaPlugins.onError(th5);
            }
        }
    }

    public T b() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                d();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.d;
        if (th == null) {
            return this.c;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public T c(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                if (!await(j, timeUnit)) {
                    d();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException());
                }
            } catch (InterruptedException e) {
                d();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.d;
        if (th == null) {
            return this.c;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public void d() {
        this.a = true;
        Subscription subscription = this.b;
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.d = th;
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.c = t;
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.b, subscription)) {
            this.b = subscription;
            if (this.a) {
                subscription.cancel();
            } else {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }
}
