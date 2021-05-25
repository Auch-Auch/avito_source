package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class k1<T> extends Perhaps<T> implements Subscriber<T> {
    public static final a[] g = new a[0];
    public static final a[] h = new a[0];
    public final Perhaps<T> b;
    public final AtomicBoolean c = new AtomicBoolean();
    public final AtomicReference<a<T>[]> d = new AtomicReference<>(g);
    public T e;
    public Throwable f;

    public static final class a<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -44000898247441619L;
        public final AtomicReference<Object> a;

        public a(Subscriber<? super T> subscriber, k1<T> k1Var) {
            super(subscriber);
            this.a = new AtomicReference<>(k1Var);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            Object obj = this.a.get();
            if (obj != null && this.a.compareAndSet(obj, null)) {
                ((k1) obj).a(this);
            }
        }

        public void d() {
            this.actual.onComplete();
        }

        public void h(Throwable th) {
            this.actual.onError(th);
        }
    }

    public k1(Perhaps<T> perhaps) {
        this.b = perhaps;
    }

    public void a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.d.get();
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
                        aVarArr2 = g;
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
        } while (!this.d.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        T t = this.e;
        a<T>[] andSet = this.d.getAndSet(h);
        int i = 0;
        if (t != null) {
            int length = andSet.length;
            while (i < length) {
                andSet[i].complete(t);
                i++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i < length2) {
            andSet[i].d();
            i++;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f = th;
        for (a<T> aVar : this.d.getAndSet(h)) {
            aVar.h(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.e = t;
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        a<T> aVar = new a<>(subscriber, this);
        subscriber.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.d.get();
            if (aVarArr != h) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.d.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            if (aVar.isCancelled()) {
                a(aVar);
            }
            if (this.c.compareAndSet(false, true)) {
                this.b.subscribe(this);
            }
        } else if (!aVar.isCancelled()) {
            Throwable th = this.f;
            if (th != null) {
                aVar.h(th);
                return;
            }
            T t = this.e;
            if (t != null) {
                aVar.complete(t);
            } else {
                aVar.d();
            }
        }
    }
}
