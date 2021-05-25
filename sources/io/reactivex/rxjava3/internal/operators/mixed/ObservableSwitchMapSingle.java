package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.appcompat.app.AppCompatDelegateImpl;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {
    public final Observable<T> a;
    public final Function<? super T, ? extends SingleSource<? extends R>> b;
    public final boolean c;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final C0476a<Object> i = new C0476a<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends SingleSource<? extends R>> b;
        public final boolean c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<C0476a<R>> e = new AtomicReference<>();
        public Disposable f;
        public volatile boolean g;
        public volatile boolean h;

        /* renamed from: io.reactivex.rxjava3.internal.operators.mixed.ObservableSwitchMapSingle$a$a  reason: collision with other inner class name */
        public static final class C0476a<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public final a<?, R> a;
            public volatile R b;

            public C0476a(a<?, R> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                a<?, R> aVar = this.a;
                if (!aVar.e.compareAndSet(this, null)) {
                    RxJavaPlugins.onError(th);
                } else if (aVar.d.tryAddThrowableOrReport(th)) {
                    if (!aVar.c) {
                        aVar.f.dispose();
                        aVar.a();
                    }
                    aVar.b();
                }
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R r) {
                this.b = r;
                this.a.b();
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.mixed.ObservableSwitchMapSingle$a$a<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            C0476a<Object> aVar = i;
            C0476a<Object> aVar2 = (C0476a) this.e.getAndSet(aVar);
            if (aVar2 != null && aVar2 != aVar) {
                DisposableHelper.dispose(aVar2);
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.a;
                AtomicThrowable atomicThrowable = this.d;
                AtomicReference<C0476a<R>> atomicReference = this.e;
                int i2 = 1;
                while (!this.h) {
                    if (atomicThrowable.get() == null || this.c) {
                        boolean z = this.g;
                        C0476a<R> aVar = atomicReference.get();
                        boolean z2 = aVar == null;
                        if (z && z2) {
                            atomicThrowable.tryTerminateConsumer(observer);
                            return;
                        } else if (z2 || aVar.b == null) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            atomicReference.compareAndSet(aVar, null);
                            observer.onNext(aVar.b);
                        }
                    } else {
                        atomicThrowable.tryTerminateConsumer(observer);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.h = true;
            this.f.dispose();
            a();
            this.d.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.h;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.g = true;
            b();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                if (!this.c) {
                    a();
                }
                this.g = true;
                b();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.mixed.ObservableSwitchMapSingle$a$a<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            C0476a<R> aVar;
            C0476a<R> aVar2 = this.e.get();
            if (aVar2 != null) {
                DisposableHelper.dispose(aVar2);
            }
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                C0476a<R> aVar3 = new C0476a<>(this);
                do {
                    aVar = this.e.get();
                    if (aVar == i) {
                        return;
                    }
                } while (!this.e.compareAndSet(aVar, aVar3));
                singleSource.subscribe(aVar3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f.dispose();
                this.e.getAndSet(i);
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.a = observable;
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (!AppCompatDelegateImpl.i.i2(this.a, this.b, observer)) {
            this.a.subscribe(new a(observer, this.b, this.c));
        }
    }
}
