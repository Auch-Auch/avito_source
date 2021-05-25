package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, ObservablePublishClassic<T> {
    public final ObservableSource<T> a;
    public final AtomicReference<b<T>> b;
    public final ObservableSource<T> c;

    public static final class a<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        public final Observer<? super T> a;

        public a(Observer<? super T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((b) andSet).a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == this;
        }
    }

    public static final class b<T> implements Observer<T>, Disposable {
        public static final a[] e = new a[0];
        public static final a[] f = new a[0];
        public final AtomicReference<b<T>> a;
        public final AtomicReference<a<T>[]> b = new AtomicReference<>(e);
        public final AtomicBoolean c;
        public final AtomicReference<Disposable> d = new AtomicReference<>();

        public b(AtomicReference<b<T>> atomicReference) {
            this.a = atomicReference;
            this.c = new AtomicBoolean();
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
                        } else if (aVarArr[i].equals(aVar)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            aVarArr2 = e;
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.b;
            a<T>[] aVarArr = f;
            if (atomicReference.getAndSet(aVarArr) != aVarArr) {
                this.a.compareAndSet(this, null);
                DisposableHelper.dispose(this.d);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.get() == f;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.compareAndSet(this, null);
            for (a<T> aVar : this.b.getAndSet(f)) {
                aVar.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.compareAndSet(this, null);
            a<T>[] andSet = this.b.getAndSet(f);
            if (andSet.length != 0) {
                for (a<T> aVar : andSet) {
                    aVar.a.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            for (a<T> aVar : this.b.get()) {
                aVar.a.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public static final class c<T> implements ObservableSource<T> {
        public final AtomicReference<b<T>> a;

        public c(AtomicReference<b<T>> atomicReference) {
            this.a = atomicReference;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[EDGE_INSN: B:19:0x004c->B:14:0x004c ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0008 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[EDGE_INSN: B:23:0x004a->B:13:0x004a ?: BREAK  , SYNTHETIC] */
        @Override // io.reactivex.ObservableSource
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(io.reactivex.Observer<? super T> r6) {
            /*
                r5 = this;
                io.reactivex.internal.operators.observable.ObservablePublish$a r0 = new io.reactivex.internal.operators.observable.ObservablePublish$a
                r0.<init>(r6)
                r6.onSubscribe(r0)
            L_0x0008:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$b<T>> r6 = r5.a
                java.lang.Object r6 = r6.get()
                io.reactivex.internal.operators.observable.ObservablePublish$b r6 = (io.reactivex.internal.operators.observable.ObservablePublish.b) r6
                if (r6 == 0) goto L_0x0018
                boolean r1 = r6.isDisposed()
                if (r1 == 0) goto L_0x0029
            L_0x0018:
                io.reactivex.internal.operators.observable.ObservablePublish$b r1 = new io.reactivex.internal.operators.observable.ObservablePublish$b
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$b<T>> r2 = r5.a
                r1.<init>(r2)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$b<T>> r2 = r5.a
                boolean r6 = r2.compareAndSet(r6, r1)
                if (r6 != 0) goto L_0x0028
                goto L_0x0008
            L_0x0028:
                r6 = r1
            L_0x0029:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$a<T>[]> r1 = r6.b
                java.lang.Object r1 = r1.get()
                io.reactivex.internal.operators.observable.ObservablePublish$a[] r1 = (io.reactivex.internal.operators.observable.ObservablePublish.a[]) r1
                io.reactivex.internal.operators.observable.ObservablePublish$a[] r2 = io.reactivex.internal.operators.observable.ObservablePublish.b.f
                r3 = 0
                if (r1 != r2) goto L_0x0037
                goto L_0x004a
            L_0x0037:
                int r2 = r1.length
                int r4 = r2 + 1
                io.reactivex.internal.operators.observable.ObservablePublish$a[] r4 = new io.reactivex.internal.operators.observable.ObservablePublish.a[r4]
                java.lang.System.arraycopy(r1, r3, r4, r3, r2)
                r4[r2] = r0
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$a<T>[]> r2 = r6.b
                boolean r1 = r2.compareAndSet(r1, r4)
                if (r1 == 0) goto L_0x0029
                r3 = 1
            L_0x004a:
                if (r3 == 0) goto L_0x0008
                r1 = 0
                boolean r1 = r0.compareAndSet(r1, r6)
                if (r1 != 0) goto L_0x0056
                r6.a(r0)
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.c.subscribe(io.reactivex.Observer):void");
        }
    }

    public ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<b<T>> atomicReference) {
        this.c = observableSource;
        this.a = observableSource2;
        this.b = atomicReference;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservablePublish(new c(atomicReference), observableSource, atomicReference));
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        b<T> bVar;
        while (true) {
            bVar = this.b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.b);
            if (this.b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = true;
        if (bVar.c.get() || !bVar.c.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(bVar);
            if (z) {
                this.a.subscribe(bVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.operators.observable.ObservablePublishClassic
    public ObservableSource<T> publishSource() {
        return this.a;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.a;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.c.subscribe(observer);
    }
}
