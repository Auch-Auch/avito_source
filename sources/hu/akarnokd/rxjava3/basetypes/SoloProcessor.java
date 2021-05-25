package hu.akarnokd.rxjava3.basetypes;

import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class SoloProcessor<T> extends Solo<T> implements Processor<T, T> {
    public static final a[] f = new a[0];
    public static final a[] g = new a[0];
    public final AtomicReference<a<T>[]> b = new AtomicReference<>(f);
    public final AtomicBoolean c = new AtomicBoolean();
    public T d;
    public Throwable e;

    public static final class a<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -8241863418761502064L;
        public final SoloProcessor<T> a;

        public a(Subscriber<? super T> subscriber, SoloProcessor<T> soloProcessor) {
            super(subscriber);
            this.a = soloProcessor;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.a.a(this);
        }
    }

    public static <T> SoloProcessor<T> create() {
        return new SoloProcessor<>();
    }

    public void a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.b.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i] == aVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        aVarArr2 = f;
                    } else {
                        a<T>[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.b.compareAndSet(aVarArr, aVarArr2));
    }

    public Throwable getThrowable() {
        if (this.b.get() == g) {
            return this.e;
        }
        return null;
    }

    public T getValue() {
        if (this.b.get() == g) {
            return this.d;
        }
        return null;
    }

    public boolean hasSubscribers() {
        return this.b.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.b.get() == g && this.e != null;
    }

    public boolean hasValue() {
        return this.b.get() == g && this.d != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.c.get()) {
            if (this.c.compareAndSet(false, true)) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                this.e = noSuchElementException;
                for (a<T> aVar : this.b.getAndSet(g)) {
                    aVar.downstream.onError(noSuchElementException);
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.c.compareAndSet(false, true)) {
            this.e = th;
            for (a<T> aVar : this.b.getAndSet(g)) {
                aVar.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.c.compareAndSet(false, true)) {
            this.d = t;
            for (a<T> aVar : this.b.getAndSet(g)) {
                aVar.complete(t);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.b.get() == g) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        a<T> aVar = new a<>(subscriber, this);
        subscriber.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.b.get();
            z = false;
            if (aVarArr != g) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.b.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            Throwable th = this.e;
            if (th != null) {
                aVar.downstream.onError(th);
            } else {
                aVar.complete(this.d);
            }
        } else if (aVar.isCancelled()) {
            a(aVar);
        }
    }
}
