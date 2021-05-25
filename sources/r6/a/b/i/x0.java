package r6.a.b.i;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class x0<T, U, R> extends Observable<R> implements ObservableTransformer<T, R> {
    public final ObservableSource<T> a;
    public final Function<? super T, ? extends ObservableSource<? extends U>> b;
    public final BiFunction<? super T, ? super U, ? extends R> c;
    public final int d;

    public static final class a<T, U, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -204261674817426393L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends U>> b;
        public final BiFunction<? super T, ? super U, ? extends R> c;
        public final SpscLinkedArrayQueue<T> d;
        public final AtomicThrowable e = new AtomicThrowable();
        public final AtomicReference<Disposable> f = new AtomicReference<>();
        public Disposable g;
        public volatile boolean h;
        public volatile boolean i;
        public T j;
        public volatile int k;
        public U l;

        /* renamed from: r6.a.b.i.x0$a$a  reason: collision with other inner class name */
        public final class C0667a implements Observer<U> {
            public boolean a;

            public C0667a() {
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                if (!this.a) {
                    a aVar = a.this;
                    aVar.k = 3;
                    DisposableHelper.replace(aVar.f, null);
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                if (!this.a) {
                    a aVar = a.this;
                    if (aVar.e.tryAddThrowableOrReport(th)) {
                        aVar.k = 3;
                        DisposableHelper.replace(aVar.f, null);
                        aVar.g.dispose();
                        aVar.a();
                        return;
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(U u) {
                if (!this.a) {
                    this.a = true;
                    a.this.f.get().dispose();
                    a aVar = a.this;
                    aVar.l = u;
                    aVar.k = 2;
                    DisposableHelper.replace(aVar.f, null);
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(a.this.f, disposable);
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i2) {
            this.a = observer;
            this.b = function;
            this.c = biFunction;
            this.d = new SpscLinkedArrayQueue<>(i2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (true) {
                    if (this.i) {
                        this.j = null;
                        this.l = null;
                        this.d.clear();
                    } else if (this.e.get() != null) {
                        this.i = true;
                        this.e.tryTerminateConsumer(this.a);
                    } else {
                        int i3 = this.k;
                        boolean z = false;
                        if (i3 == 0) {
                            boolean z2 = this.h;
                            T poll = this.d.poll();
                            if (poll == null) {
                                z = true;
                            }
                            if (z2 && z) {
                                this.a.onComplete();
                            } else if (!z) {
                                this.j = poll;
                                try {
                                    ObservableSource observableSource = (ObservableSource) this.b.apply(poll);
                                    Objects.requireNonNull(observableSource, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource2 = observableSource;
                                    this.k = 1;
                                    observableSource2.subscribe(new C0667a());
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.i = true;
                                    this.g.dispose();
                                    this.e.tryAddThrowableOrReport(th);
                                    this.e.tryTerminateConsumer(this.a);
                                }
                            }
                        } else if (i3 == 2) {
                            T t = this.j;
                            this.j = null;
                            U u = this.l;
                            this.l = null;
                            try {
                                Object apply = this.c.apply(t, u);
                                Objects.requireNonNull(apply, "The combiner returned a null value");
                                this.a.onNext(apply);
                                this.k = 0;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.i = true;
                                this.g.dispose();
                                this.e.tryAddThrowableOrReport(th2);
                                this.e.tryTerminateConsumer(this.a);
                            }
                        } else if (i3 == 3) {
                            this.j = null;
                            this.k = 0;
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.g.dispose();
            DisposableHelper.dispose(this.f);
            this.e.tryTerminateAndReport();
            a();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.f);
            if (this.e.tryAddThrowableOrReport(th)) {
                this.h = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.d.offer(t);
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public x0(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        this.a = observableSource;
        this.b = function;
        this.c = biFunction;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.core.ObservableTransformer
    public ObservableSource<R> apply(Observable<T> observable) {
        return new x0(observable, this.b, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new a(observer, this.b, this.c, this.d));
    }
}
