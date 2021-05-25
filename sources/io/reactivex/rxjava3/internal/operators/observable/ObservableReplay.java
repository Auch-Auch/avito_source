package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    public static final b e = new n();
    public final ObservableSource<T> a;
    public final AtomicReference<i<T>> b;
    public final b<T> c;
    public final ObservableSource<T> d;

    public static abstract class a<T> extends AtomicReference<f> implements g<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public f a;
        public int b;
        public final boolean c;

        public a(boolean z) {
            this.c = z;
            f fVar = new f(null);
            this.a = fVar;
            set(fVar);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.g
        public final void a(d<T> dVar) {
            if (dVar.getAndIncrement() == 0) {
                int i = 1;
                do {
                    f fVar = (f) dVar.c;
                    if (fVar == null) {
                        fVar = d();
                        dVar.c = fVar;
                    }
                    while (!dVar.d) {
                        f fVar2 = (f) fVar.get();
                        if (fVar2 == null) {
                            dVar.c = fVar;
                            i = dVar.addAndGet(-i);
                        } else if (NotificationLite.accept(e(fVar2.a), dVar.b)) {
                            dVar.c = null;
                            return;
                        } else {
                            fVar = fVar2;
                        }
                    }
                    dVar.c = null;
                    return;
                } while (i != 0);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.g
        public final void b(Throwable th) {
            f fVar = new f(c(NotificationLite.error(th)));
            this.a.set(fVar);
            this.a = fVar;
            this.b++;
            i();
        }

        public Object c(Object obj) {
            return obj;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.g
        public final void complete() {
            f fVar = new f(c(NotificationLite.complete()));
            this.a.set(fVar);
            this.a = fVar;
            this.b++;
            i();
        }

        public f d() {
            return (f) get();
        }

        public Object e(Object obj) {
            return obj;
        }

        public final void f(f fVar) {
            if (this.c) {
                f fVar2 = new f(null);
                fVar2.lazySet(fVar.get());
                fVar = fVar2;
            }
            set(fVar);
        }

        public abstract void h();

        public void i() {
            f fVar = (f) get();
            if (fVar.a != null) {
                f fVar2 = new f(null);
                fVar2.lazySet(fVar.get());
                set(fVar2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.g
        public final void next(T t) {
            f fVar = new f(c(NotificationLite.next(t)));
            this.a.set(fVar);
            this.a = fVar;
            this.b++;
            h();
        }
    }

    public interface b<T> {
        g<T> call();
    }

    public static final class c<R> implements Consumer<Disposable> {
        public final ObserverResourceWrapper<R> a;

        public c(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.a = observerResourceWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) throws Throwable {
            this.a.setResource(disposable);
        }
    }

    public static final class d<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2728361546769921047L;
        public final i<T> a;
        public final Observer<? super T> b;
        public Object c;
        public volatile boolean d;

        public d(i<T> iVar, Observer<? super T> observer) {
            this.a = iVar;
            this.b = observer;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.d) {
                this.d = true;
                this.a.a(this);
                this.c = null;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }
    }

    public static final class e<R, U> extends Observable<R> {
        public final Supplier<? extends ConnectableObservable<U>> a;
        public final Function<? super Observable<U>, ? extends ObservableSource<R>> b;

        public e(Supplier<? extends ConnectableObservable<U>> supplier, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.a = supplier;
            this.b = function;
        }

        @Override // io.reactivex.rxjava3.core.Observable
        public void subscribeActual(Observer<? super R> observer) {
            try {
                Object obj = this.a.get();
                Objects.requireNonNull(obj, "The connectableFactory returned a null ConnectableObservable");
                ConnectableObservable connectableObservable = (ConnectableObservable) obj;
                Object apply = this.b.apply(connectableObservable);
                Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.connect(new c(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
            }
        }
    }

    public static final class f extends AtomicReference<f> {
        private static final long serialVersionUID = 245354315435971818L;
        public final Object a;

        public f(Object obj) {
            this.a = obj;
        }
    }

    public interface g<T> {
        void a(d<T> dVar);

        void b(Throwable th);

        void complete();

        void next(T t);
    }

    public static final class h<T> implements b<T> {
        public final int a;
        public final boolean b;

        public h(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.b
        public g<T> call() {
            return new m(this.a, this.b);
        }
    }

    public static final class i<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static final d[] f = new d[0];
        public static final d[] g = new d[0];
        private static final long serialVersionUID = -533785617179540163L;
        public final g<T> a;
        public boolean b;
        public final AtomicReference<d[]> c = new AtomicReference<>(f);
        public final AtomicBoolean d = new AtomicBoolean();
        public final AtomicReference<i<T>> e;

        public i(g<T> gVar, AtomicReference<i<T>> atomicReference) {
            this.a = gVar;
            this.e = atomicReference;
        }

        public void a(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.c.get();
                int length = dVarArr.length;
                if (length != 0) {
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (dVarArr[i].equals(dVar)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            dVarArr2 = f;
                        } else {
                            d[] dVarArr3 = new d[(length - 1)];
                            System.arraycopy(dVarArr, 0, dVarArr3, 0, i);
                            System.arraycopy(dVarArr, i + 1, dVarArr3, i, (length - i) - 1);
                            dVarArr2 = dVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.c.compareAndSet(dVarArr, dVarArr2));
        }

        public void b() {
            for (d<T> dVar : this.c.get()) {
                this.a.a(dVar);
            }
        }

        public void c() {
            for (d<T> dVar : this.c.getAndSet(g)) {
                this.a.a(dVar);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.c.set(g);
            this.e.compareAndSet(this, null);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.get() == g;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.b) {
                this.b = true;
                this.a.complete();
                c();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (!this.b) {
                this.b = true;
                this.a.b(th);
                c();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.b) {
                this.a.next(t);
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                b();
            }
        }
    }

    public static final class j<T> implements ObservableSource<T> {
        public final AtomicReference<i<T>> a;
        public final b<T> b;

        public j(AtomicReference<i<T>> atomicReference, b<T> bVar) {
            this.a = atomicReference;
            this.b = bVar;
        }

        @Override // io.reactivex.rxjava3.core.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            i<T> iVar;
            d[] dVarArr;
            d[] dVarArr2;
            while (true) {
                iVar = this.a.get();
                if (iVar != null) {
                    break;
                }
                i<T> iVar2 = new i<>(this.b.call(), this.a);
                if (this.a.compareAndSet(null, iVar2)) {
                    iVar = iVar2;
                    break;
                }
            }
            d<T> dVar = new d<>(iVar, observer);
            observer.onSubscribe(dVar);
            do {
                dVarArr = iVar.c.get();
                if (dVarArr == i.g) {
                    break;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[(length + 1)];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!iVar.c.compareAndSet(dVarArr, dVarArr2));
            if (dVar.d) {
                iVar.a(dVar);
            } else {
                iVar.a.a(dVar);
            }
        }
    }

    public static final class k<T> implements b<T> {
        public final int a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final boolean e;

        public k(int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.a = i;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
            this.e = z;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.b
        public g<T> call() {
            return new l(this.a, this.b, this.c, this.d, this.e);
        }
    }

    public static final class l<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        public final Scheduler d;
        public final long e;
        public final TimeUnit f;
        public final int g;

        public l(int i, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            super(z);
            this.d = scheduler;
            this.g = i;
            this.e = j;
            this.f = timeUnit;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.a
        public Object c(Object obj) {
            return new Timed(obj, this.d.now(this.f), this.f);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.a
        public f d() {
            long now = this.d.now(this.f) - this.e;
            f fVar = (f) get();
            Object obj = fVar.get();
            while (true) {
                fVar = (f) obj;
                if (fVar != null) {
                    Timed timed = (Timed) fVar.a;
                    if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                        break;
                    }
                    obj = fVar.get();
                } else {
                    break;
                }
            }
            return fVar;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.a
        public Object e(Object obj) {
            return ((Timed) obj).value();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.a
        public void h() {
            long now = this.d.now(this.f) - this.e;
            f fVar = (f) get();
            f fVar2 = (f) fVar.get();
            int i = 0;
            while (true) {
                fVar = fVar2;
                int i2 = this.b;
                if (i2 > 1) {
                    if (i2 <= this.g) {
                        if (((Timed) fVar.a).time() > now) {
                            break;
                        }
                        i++;
                        this.b--;
                        fVar2 = (f) fVar.get();
                    } else {
                        i++;
                        this.b = i2 - 1;
                        fVar2 = (f) fVar.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                f(fVar);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.a
        public void i() {
            long now = this.d.now(this.f) - this.e;
            f fVar = (f) get();
            f fVar2 = (f) fVar.get();
            int i = 0;
            while (true) {
                fVar = fVar2;
                if (this.b <= 1 || ((Timed) fVar.a).time() > now) {
                    break;
                }
                i++;
                this.b--;
                fVar2 = (f) fVar.get();
            }
            if (i != 0) {
                f(fVar);
            }
        }
    }

    public static final class m<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int d;

        public m(int i, boolean z) {
            super(z);
            this.d = i;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.a
        public void h() {
            if (this.b > this.d) {
                this.b--;
                f((f) ((f) get()).get());
            }
        }
    }

    public static final class n implements b<Object> {
        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.b
        public g<Object> call() {
            return new o(16);
        }
    }

    public static final class o<T> extends ArrayList<Object> implements g<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int a;

        public o(int i) {
            super(i);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.g
        public void a(d<T> dVar) {
            if (dVar.getAndIncrement() == 0) {
                Observer<? super T> observer = dVar.b;
                int i = 1;
                while (!dVar.d) {
                    int i2 = this.a;
                    Integer num = (Integer) dVar.c;
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i2) {
                        if (!NotificationLite.accept(get(intValue), observer) && !dVar.d) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    dVar.c = Integer.valueOf(intValue);
                    i = dVar.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.g
        public void b(Throwable th) {
            add(NotificationLite.error(th));
            this.a++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.g
        public void complete() {
            add(NotificationLite.complete());
            this.a++;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.g
        public void next(T t) {
            add(NotificationLite.next(t));
            this.a++;
        }
    }

    public ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<i<T>> atomicReference, b<T> bVar) {
        this.d = observableSource;
        this.a = observableSource2;
        this.b = atomicReference;
        this.c = bVar;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, int i2, boolean z) {
        if (i2 == Integer.MAX_VALUE) {
            return createFrom(observableSource);
        }
        return e(observableSource, new h(i2, z));
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> observableSource) {
        return e(observableSource, e);
    }

    public static <T> ConnectableObservable<T> e(ObservableSource<T> observableSource, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservableReplay(new j(atomicReference, bVar), observableSource, atomicReference, bVar));
    }

    public static <U, R> Observable<R> multicastSelector(Supplier<? extends ConnectableObservable<U>> supplier, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.onAssembly(new e(supplier, function));
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        i<T> iVar;
        while (true) {
            iVar = this.b.get();
            if (iVar != null && !iVar.isDisposed()) {
                break;
            }
            i<T> iVar2 = new i<>(this.c.call(), this.b);
            if (this.b.compareAndSet(iVar, iVar2)) {
                iVar = iVar2;
                break;
            }
        }
        boolean z = !iVar.d.get() && iVar.d.compareAndSet(false, true);
        try {
            consumer.accept(iVar);
            if (z) {
                this.a.subscribe(iVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (z) {
                iVar.d.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void reset() {
        i<T> iVar = this.b.get();
        if (iVar != null && iVar.isDisposed()) {
            this.b.compareAndSet(iVar, null);
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.a;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.d.subscribe(observer);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return create(observableSource, j2, timeUnit, scheduler, Integer.MAX_VALUE, z);
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        return e(observableSource, new k(i2, j2, timeUnit, scheduler, z));
    }
}
