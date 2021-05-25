package hu.akarnokd.rxjava3.basetypes;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import r6.a.b.b.b;
public final class NonoProcessor extends Nono implements Processor<Void, Void> {
    public static final a[] e = new a[0];
    public static final a[] f = new a[0];
    public Throwable b;
    public final AtomicReference<a[]> c = new AtomicReference<>(e);
    public final AtomicBoolean d = new AtomicBoolean();

    public static final class a extends b {
        private static final long serialVersionUID = 8377121611843740196L;
        public final Subscriber<? super Void> a;
        public final NonoProcessor b;

        public a(Subscriber<? super Void> subscriber, NonoProcessor nonoProcessor) {
            this.a = subscriber;
            this.b = nonoProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(0, 1)) {
                this.b.a(this);
            }
        }
    }

    public static NonoProcessor create() {
        return new NonoProcessor();
    }

    public void a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.c.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i >= aVarArr.length) {
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
                        aVarArr2 = e;
                    } else {
                        a[] aVarArr3 = new a[(length - 1)];
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
        } while (!this.c.compareAndSet(aVarArr, aVarArr2));
    }

    public Throwable getThrowable() {
        if (this.c.get() == f) {
            return this.b;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.c.get() == f && this.b == null;
    }

    public boolean hasSubscribers() {
        return this.c.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.c.get() == f && this.b != null;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.d.compareAndSet(false, true)) {
            a[] andSet = this.c.getAndSet(f);
            for (a aVar : andSet) {
                if (aVar.compareAndSet(0, 1)) {
                    aVar.a.onComplete();
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.d.compareAndSet(false, true)) {
            if (th == null) {
                th = new NullPointerException();
            }
            this.b = th;
            a[] andSet = this.c.getAndSet(f);
            for (a aVar : andSet) {
                if (aVar.compareAndSet(0, 1)) {
                    aVar.a.onError(th);
                }
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.c.get() == f) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        boolean z;
        a aVar = new a(subscriber, this);
        subscriber.onSubscribe(aVar);
        while (true) {
            a[] aVarArr = this.c.get();
            if (aVarArr != f) {
                int length = aVarArr.length;
                a[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.c.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            Throwable th = this.b;
            if (th != null) {
                if (aVar.compareAndSet(0, 1)) {
                    aVar.a.onError(th);
                }
            } else if (aVar.compareAndSet(0, 1)) {
                aVar.a.onComplete();
            }
        } else if (aVar.get() != 0) {
            a(aVar);
        }
    }

    public void onNext(Void r1) {
        throw null;
    }
}
