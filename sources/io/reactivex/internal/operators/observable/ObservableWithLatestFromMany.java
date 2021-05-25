package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
public final class ObservableWithLatestFromMany<T, R> extends s6.a.c.b.c.a<T, R> {
    @Nullable
    public final ObservableSource<?>[] a;
    @Nullable
    public final Iterable<? extends ObservableSource<?>> b;
    @NonNull
    public final Function<? super Object[], R> c;

    public final class a implements Function<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public R apply(T r4) throws java.lang.Exception {
            /*
                r3 = this;
                io.reactivex.internal.operators.observable.ObservableWithLatestFromMany r0 = io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.this
                io.reactivex.functions.Function<? super java.lang.Object[], R> r0 = r0.c
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                r1[r2] = r4
                java.lang.Object r4 = r0.apply(r1)
                java.lang.String r0 = "The combiner returned a null value"
                java.lang.Object r4 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r4, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWithLatestFromMany.a.apply(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        public final Observer<? super R> a;
        public final Function<? super Object[], R> b;
        public final c[] c;
        public final AtomicReferenceArray<Object> d;
        public final AtomicReference<Disposable> e;
        public final AtomicThrowable f;
        public volatile boolean g;

        public b(Observer<? super R> observer, Function<? super Object[], R> function, int i) {
            this.a = observer;
            this.b = function;
            c[] cVarArr = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                cVarArr[i2] = new c(this, i2);
            }
            this.c = cVarArr;
            this.d = new AtomicReferenceArray<>(i);
            this.e = new AtomicReference<>();
            this.f = new AtomicThrowable();
        }

        public void a(int i) {
            c[] cVarArr = this.c;
            for (int i2 = 0; i2 < cVarArr.length; i2++) {
                if (i2 != i) {
                    c cVar = cVarArr[i2];
                    Objects.requireNonNull(cVar);
                    DisposableHelper.dispose(cVar);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.e);
            c[] cVarArr = this.c;
            for (c cVar : cVarArr) {
                Objects.requireNonNull(cVar);
                DisposableHelper.dispose(cVar);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.e.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.g) {
                this.g = true;
                a(-1);
                HalfSerializer.onComplete(this.a, this, this.f);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = true;
            a(-1);
            HalfSerializer.onError(this.a, th, this, this.f);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.g) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.d;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[(length + 1)];
                int i = 0;
                objArr[0] = t;
                while (i < length) {
                    Object obj = atomicReferenceArray.get(i);
                    if (obj != null) {
                        i++;
                        objArr[i] = obj;
                    } else {
                        return;
                    }
                }
                try {
                    HalfSerializer.onNext(this.a, ObjectHelper.requireNonNull(this.b.apply(objArr), "combiner returned a null value"), this, this.f);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.e, disposable);
        }
    }

    public static final class c extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        public final b<?, ?> a;
        public final int b;
        public boolean c;

        public c(b<?, ?> bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            b<?, ?> bVar = this.a;
            int i = this.b;
            boolean z = this.c;
            Objects.requireNonNull(bVar);
            if (!z) {
                bVar.g = true;
                bVar.a(i);
                HalfSerializer.onComplete(bVar.a, bVar, bVar.f);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            b<?, ?> bVar = this.a;
            int i = this.b;
            bVar.g = true;
            DisposableHelper.dispose(bVar.e);
            bVar.a(i);
            HalfSerializer.onError(bVar.a, th, bVar, bVar.f);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (!this.c) {
                this.c = true;
            }
            b<?, ?> bVar = this.a;
            bVar.d.set(this.b, obj);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull ObservableSource<?>[] observableSourceArr, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.a = observableSourceArr;
        this.b = null;
        this.c = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int i;
        ObservableSource<?>[] observableSourceArr = this.a;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i = 0;
                for (ObservableSource<?> observableSource : this.b) {
                    if (i == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (i >> 1) + i);
                    }
                    int i2 = i + 1;
                    observableSourceArr[i] = observableSource;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            new ObservableMap(this.source, new a()).subscribeActual(observer);
            return;
        }
        b bVar = new b(observer, this.c, i);
        observer.onSubscribe(bVar);
        c[] cVarArr = bVar.c;
        AtomicReference<Disposable> atomicReference = bVar.e;
        for (int i3 = 0; i3 < i && !DisposableHelper.isDisposed(atomicReference.get()) && !bVar.g; i3++) {
            observableSourceArr[i3].subscribe(cVarArr[i3]);
        }
        this.source.subscribe(bVar);
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull Iterable<? extends ObservableSource<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.a = null;
        this.b = iterable;
        this.c = function;
    }
}
