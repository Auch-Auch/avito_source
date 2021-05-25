package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class n extends Nono implements Subscriber<Void> {
    public static final a[] f = new a[0];
    public static final a[] g = new a[0];
    public final Nono b;
    public final AtomicBoolean c = new AtomicBoolean();
    public final AtomicReference<a[]> d = new AtomicReference<>(f);
    public Throwable e;

    public final class a extends b {
        private static final long serialVersionUID = -5746624477415417500L;
        public final Subscriber<? super Void> a;

        public a(Subscriber<? super Void> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(0, 1)) {
                n.this.a(this);
            }
        }
    }

    public n(Nono nono) {
        this.b = nono;
    }

    public void a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
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
                        aVarArr2 = f;
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
        } while (!this.d.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        a[] andSet = this.d.getAndSet(g);
        for (a aVar : andSet) {
            if (aVar.get() == 0) {
                aVar.a.onComplete();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.e = th;
        a[] andSet = this.d.getAndSet(g);
        for (a aVar : andSet) {
            if (aVar.get() == 0) {
                aVar.a.onError(th);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // org.reactivestreams.Subscriber
    public void onNext(Void r1) {
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        boolean z;
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        while (true) {
            a[] aVarArr = this.d.get();
            if (aVarArr != g) {
                int length = aVarArr.length;
                a[] aVarArr2 = new a[(length + 1)];
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
            if (aVar.get() != 0) {
                a(aVar);
            }
            if (this.c.compareAndSet(false, true)) {
                this.b.subscribe(this);
            }
        } else if (aVar.get() == 0) {
            Throwable th = this.e;
            if (th != null) {
                aVar.a.onError(th);
            } else {
                aVar.a.onComplete();
            }
        }
    }
}
