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
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableConcatMapSingle<T, R> extends Observable<R> {
    public final Observable<T> a;
    public final Function<? super T, ? extends SingleSource<? extends R>> b;
    public final ErrorMode c;
    public final int d;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends SingleSource<? extends R>> b;
        public final AtomicThrowable c = new AtomicThrowable();
        public final C0409a<R> d = new C0409a<>(this);
        public final SimplePlainQueue<T> e;
        public final ErrorMode f;
        public Disposable g;
        public volatile boolean h;
        public volatile boolean i;
        public R j;
        public volatile int k;

        /* renamed from: io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$a$a  reason: collision with other inner class name */
        public static final class C0409a<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final a<?, R> a;

            public C0409a(a<?, R> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                a<?, R> aVar = this.a;
                if (aVar.c.addThrowable(th)) {
                    if (aVar.f != ErrorMode.END) {
                        aVar.g.dispose();
                    }
                    aVar.k = 0;
                    aVar.a();
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                a<?, R> aVar = this.a;
                aVar.j = r;
                aVar.k = 2;
                aVar.a();
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.a = observer;
            this.b = function;
            this.f = errorMode;
            this.e = new SpscLinkedArrayQueue(i2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.a;
                ErrorMode errorMode = this.f;
                SimplePlainQueue<T> simplePlainQueue = this.e;
                AtomicThrowable atomicThrowable = this.c;
                int i2 = 1;
                while (true) {
                    if (this.i) {
                        simplePlainQueue.clear();
                        this.j = null;
                    } else {
                        int i3 = this.k;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i3 == 0))) {
                            boolean z = false;
                            if (i3 == 0) {
                                boolean z2 = this.h;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z = true;
                                }
                                if (z2 && z) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        observer.onComplete();
                                        return;
                                    } else {
                                        observer.onError(terminate);
                                        return;
                                    }
                                } else if (!z) {
                                    try {
                                        SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null SingleSource");
                                        this.k = 1;
                                        singleSource.subscribe(this.d);
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.g.dispose();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th);
                                        observer.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                R r = this.j;
                                this.j = null;
                                observer.onNext(r);
                                this.k = 0;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.j = null;
                observer.onError(atomicThrowable.terminate());
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.g.dispose();
            C0409a<R> aVar = this.d;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            if (getAndIncrement() == 0) {
                this.e.clear();
                this.j = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.c.addThrowable(th)) {
                if (this.f == ErrorMode.IMMEDIATE) {
                    C0409a<R> aVar = this.d;
                    Objects.requireNonNull(aVar);
                    DisposableHelper.dispose(aVar);
                }
                this.h = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.e.offer(t);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.a = observable;
        this.b = function;
        this.c = errorMode;
        this.d = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (!AppCompatDelegateImpl.i.h2(this.a, this.b, observer)) {
            this.a.subscribe(new a(observer, this.b, this.d, this.c));
        }
    }
}
