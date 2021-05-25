package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.appcompat.app.AppCompatDelegateImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableConcatMapCompletable<T> extends Completable {
    public final Observable<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final ErrorMode c;
    public final int d;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        public final CompletableObserver a;
        public final Function<? super T, ? extends CompletableSource> b;
        public final ErrorMode c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final C0471a e = new C0471a(this);
        public final int f;
        public SimpleQueue<T> g;
        public Disposable h;
        public volatile boolean i;
        public volatile boolean j;
        public volatile boolean k;

        /* renamed from: io.reactivex.rxjava3.internal.operators.mixed.ObservableConcatMapCompletable$a$a  reason: collision with other inner class name */
        public static final class C0471a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            public final a<?> a;

            public C0471a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                a<?> aVar = this.a;
                aVar.i = false;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                if (!aVar.d.tryAddThrowableOrReport(th)) {
                    return;
                }
                if (aVar.c == ErrorMode.IMMEDIATE) {
                    aVar.k = true;
                    aVar.h.dispose();
                    aVar.d.tryTerminateConsumer(aVar.a);
                    if (aVar.getAndIncrement() == 0) {
                        aVar.g.clear();
                        return;
                    }
                    return;
                }
                aVar.i = false;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
            this.a = completableObserver;
            this.b = function;
            this.c = errorMode;
            this.f = i2;
        }

        public void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.d;
                ErrorMode errorMode = this.c;
                while (!this.k) {
                    if (!this.i) {
                        if (errorMode != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                            boolean z2 = this.j;
                            CompletableSource completableSource = null;
                            try {
                                T poll = this.g.poll();
                                if (poll != null) {
                                    Object apply = this.b.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                                    completableSource = (CompletableSource) apply;
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z2 && z) {
                                    this.k = true;
                                    atomicThrowable.tryTerminateConsumer(this.a);
                                    return;
                                } else if (!z) {
                                    this.i = true;
                                    completableSource.subscribe(this.e);
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.k = true;
                                this.g.clear();
                                this.h.dispose();
                                atomicThrowable.tryAddThrowableOrReport(th);
                                atomicThrowable.tryTerminateConsumer(this.a);
                                return;
                            }
                        } else {
                            this.k = true;
                            this.g.clear();
                            atomicThrowable.tryTerminateConsumer(this.a);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.g.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.k = true;
            this.h.dispose();
            C0471a aVar = this.e;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            this.d.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.k;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (!this.d.tryAddThrowableOrReport(th)) {
                return;
            }
            if (this.c == ErrorMode.IMMEDIATE) {
                this.k = true;
                C0471a aVar = this.e;
                Objects.requireNonNull(aVar);
                DisposableHelper.dispose(aVar);
                this.d.tryTerminateConsumer(this.a);
                if (getAndIncrement() == 0) {
                    this.g.clear();
                    return;
                }
                return;
            }
            this.j = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (t != null) {
                this.g.offer(t);
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.g = queueDisposable;
                        this.j = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.g = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.g = new SpscLinkedArrayQueue(this.f);
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
        this.a = observable;
        this.b = function;
        this.c = errorMode;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        if (!AppCompatDelegateImpl.i.e2(this.a, this.b, completableObserver)) {
            this.a.subscribe(new a(completableObserver, this.b, this.c, this.d));
        }
    }
}
