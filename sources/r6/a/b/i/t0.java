package r6.a.b.i;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class t0<T> extends Observable<T> implements ObservableTransformer<T, T> {
    public final ObservableSource<T> a;
    public final Function<? super T, ? extends ObservableSource<Boolean>> b;
    public final int c;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -204261674817426393L;
        public final Observer<? super T> a;
        public final Function<? super T, ? extends ObservableSource<Boolean>> b;
        public final SpscLinkedArrayQueue<T> c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<Disposable> e = new AtomicReference<>();
        public Disposable f;
        public volatile boolean g;
        public volatile boolean h;
        public T i;
        public volatile int j;

        /* renamed from: r6.a.b.i.t0$a$a  reason: collision with other inner class name */
        public final class C0664a implements Observer<Boolean> {
            public boolean a;

            public C0664a() {
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                if (!this.a) {
                    a aVar = a.this;
                    aVar.j = 3;
                    DisposableHelper.replace(aVar.e, null);
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                if (!this.a) {
                    a aVar = a.this;
                    if (aVar.d.tryAddThrowableOrReport(th)) {
                        aVar.j = 3;
                        DisposableHelper.replace(aVar.e, null);
                        aVar.f.dispose();
                        aVar.a();
                        return;
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(Boolean bool) {
                Boolean bool2 = bool;
                if (!this.a) {
                    this.a = true;
                    a.this.e.get().dispose();
                    a aVar = a.this;
                    aVar.j = bool2.booleanValue() ? 2 : 3;
                    DisposableHelper.replace(aVar.e, null);
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(a.this.e, disposable);
            }
        }

        public a(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<Boolean>> function, int i2) {
            this.a = observer;
            this.b = function;
            this.c = new SpscLinkedArrayQueue<>(i2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (true) {
                    if (this.h) {
                        this.i = null;
                        this.c.clear();
                    } else if (this.d.get() != null) {
                        this.h = true;
                        this.d.tryTerminateConsumer(this.a);
                    } else {
                        int i3 = this.j;
                        boolean z = false;
                        if (i3 == 0) {
                            boolean z2 = this.g;
                            T poll = this.c.poll();
                            if (poll == null) {
                                z = true;
                            }
                            if (z2 && z) {
                                this.a.onComplete();
                            } else if (!z) {
                                this.i = poll;
                                try {
                                    ObservableSource observableSource = (ObservableSource) this.b.apply(poll);
                                    Objects.requireNonNull(observableSource, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource2 = observableSource;
                                    this.j = 1;
                                    observableSource2.subscribe(new C0664a());
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.h = true;
                                    this.f.dispose();
                                    this.d.tryAddThrowableOrReport(th);
                                    this.d.tryTerminateConsumer(this.a);
                                }
                            }
                        } else if (i3 == 2) {
                            T t = this.i;
                            this.i = null;
                            this.a.onNext(t);
                            this.j = 0;
                        } else if (i3 == 3) {
                            this.i = null;
                            this.j = 0;
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
            this.h = true;
            this.f.dispose();
            DisposableHelper.dispose(this.e);
            this.d.tryTerminateAndReport();
            a();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.h;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.g = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.e);
            if (this.d.tryAddThrowableOrReport(th)) {
                this.g = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.c.offer(t);
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public t0(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<Boolean>> function, int i) {
        this.a = observableSource;
        this.b = function;
        this.c = i;
    }

    @Override // io.reactivex.rxjava3.core.ObservableTransformer
    public ObservableSource<T> apply(Observable<T> observable) {
        return new t0(observable, this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new a(observer, this.b, this.c));
    }
}
