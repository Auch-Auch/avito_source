package io.reactivex.internal.operators.mixed;

import androidx.appcompat.app.AppCompatDelegateImpl;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {
    public final Observable<T> a;
    public final Function<? super T, ? extends SingleSource<? extends R>> b;
    public final boolean c;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final C0412a<Object> i = new C0412a<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends SingleSource<? extends R>> b;
        public final boolean c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<C0412a<R>> e = new AtomicReference<>();
        public Disposable f;
        public volatile boolean g;
        public volatile boolean h;

        /* renamed from: io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$a$a  reason: collision with other inner class name */
        public static final class C0412a<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public final a<?, R> a;
            public volatile R b;

            public C0412a(a<?, R> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                a<?, R> aVar = this.a;
                if (!aVar.e.compareAndSet(this, null) || !aVar.d.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                if (!aVar.c) {
                    aVar.f.dispose();
                    aVar.a();
                }
                aVar.b();
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$a$a<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            C0412a<Object> aVar = i;
            C0412a<Object> aVar2 = (C0412a) this.e.getAndSet(aVar);
            if (aVar2 != null && aVar2 != aVar) {
                DisposableHelper.dispose(aVar2);
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.a;
                AtomicThrowable atomicThrowable = this.d;
                AtomicReference<C0412a<R>> atomicReference = this.e;
                int i2 = 1;
                while (!this.h) {
                    if (atomicThrowable.get() == null || this.c) {
                        boolean z = this.g;
                        C0412a<R> aVar = atomicReference.get();
                        boolean z2 = aVar == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                observer.onError(terminate);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
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
                        observer.onError(atomicThrowable.terminate());
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.h = true;
            this.f.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.h;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.g = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d.addThrowable(th)) {
                if (!this.c) {
                    a();
                }
                this.g = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$a$a<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            C0412a<R> aVar;
            C0412a<R> aVar2 = this.e.get();
            if (aVar2 != null) {
                DisposableHelper.dispose(aVar2);
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null SingleSource");
                C0412a<R> aVar3 = new C0412a<>(this);
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

        @Override // io.reactivex.Observer
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

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (!AppCompatDelegateImpl.i.h2(this.a, this.b, observer)) {
            this.a.subscribe(new a(observer, this.b, this.c));
        }
    }
}
