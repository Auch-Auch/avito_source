package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    public final ObservableSource<T> a;
    public final AtomicReference<b<T>> b = new AtomicReference<>();

    public static final class a<T> extends AtomicReference<b<T>> implements Disposable {
        private static final long serialVersionUID = 7463222674719692880L;
        public final Observer<? super T> a;

        public a(Observer<? super T> observer, b<T> bVar) {
            this.a = observer;
            lazySet(bVar);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            b bVar = (b) getAndSet(null);
            if (bVar != null) {
                bVar.a(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public static final class b<T> extends AtomicReference<a<T>[]> implements Observer<T>, Disposable {
        public static final a[] e = new a[0];
        public static final a[] f = new a[0];
        private static final long serialVersionUID = -3251430252873581268L;
        public final AtomicBoolean a = new AtomicBoolean();
        public final AtomicReference<b<T>> b;
        public final AtomicReference<Disposable> c;
        public Throwable d;

        public b(AtomicReference<b<T>> atomicReference) {
            this.b = atomicReference;
            this.c = new AtomicReference<>();
            lazySet(e);
        }

        public void a(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) get();
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
                        aVarArr2 = e;
                        if (length != 1) {
                            aVarArr2 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, i);
                            System.arraycopy(aVarArr, i + 1, aVarArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            getAndSet(f);
            this.b.compareAndSet(this, null);
            DisposableHelper.dispose(this.c);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == f;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.c.lazySet(DisposableHelper.DISPOSED);
            for (a aVar : (a[]) getAndSet(f)) {
                aVar.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            Disposable disposable = this.c.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.d = th;
                this.c.lazySet(disposableHelper);
                for (a aVar : (a[]) getAndSet(f)) {
                    aVar.a.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            for (a aVar : (a[]) get()) {
                aVar.a.onNext(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.c, disposable);
        }
    }

    public ObservablePublish(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
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
        if (bVar.a.get() || !bVar.a.compareAndSet(false, true)) {
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

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void reset() {
        b<T> bVar = this.b.get();
        if (bVar != null && bVar.isDisposed()) {
            this.b.compareAndSet(bVar, null);
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.a;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        b<T> bVar;
        boolean z;
        while (true) {
            bVar = this.b.get();
            if (bVar != null) {
                break;
            }
            b<T> bVar2 = new b<>(this.b);
            if (this.b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        a<T> aVar = new a<>(observer, bVar);
        observer.onSubscribe(aVar);
        while (true) {
            a[] aVarArr = (a[]) bVar.get();
            z = false;
            if (aVarArr != b.f) {
                int length = aVarArr.length;
                a[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (bVar.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            Throwable th = bVar.d;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        } else if (aVar.isDisposed()) {
            bVar.a(aVar);
        }
    }
}
