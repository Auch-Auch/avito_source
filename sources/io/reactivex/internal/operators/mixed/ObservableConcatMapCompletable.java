package io.reactivex.internal.operators.mixed;

import androidx.appcompat.app.AppCompatDelegateImpl;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
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
        public final C0407a e = new C0407a(this);
        public final int f;
        public SimpleQueue<T> g;
        public Disposable h;
        public volatile boolean i;
        public volatile boolean j;
        public volatile boolean k;

        /* renamed from: io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$a$a  reason: collision with other inner class name */
        public static final class C0407a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            public final a<?> a;

            public C0407a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                a<?> aVar = this.a;
                aVar.i = false;
                aVar.a();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                if (!aVar.d.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                } else if (aVar.c == ErrorMode.IMMEDIATE) {
                    aVar.k = true;
                    aVar.h.dispose();
                    Throwable terminate = aVar.d.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        aVar.a.onError(terminate);
                    }
                    if (aVar.getAndIncrement() == 0) {
                        aVar.g.clear();
                    }
                } else {
                    aVar.i = false;
                    aVar.a();
                }
            }

            @Override // io.reactivex.CompletableObserver
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
                                    completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null CompletableSource");
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z2 && z) {
                                    this.k = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        this.a.onError(terminate);
                                        return;
                                    } else {
                                        this.a.onComplete();
                                        return;
                                    }
                                } else if (!z) {
                                    this.i = true;
                                    completableSource.subscribe(this.e);
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.k = true;
                                this.g.clear();
                                this.h.dispose();
                                atomicThrowable.addThrowable(th);
                                this.a.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            this.k = true;
                            this.g.clear();
                            this.a.onError(atomicThrowable.terminate());
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.k = true;
            this.h.dispose();
            C0407a aVar = this.e;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.k;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.c == ErrorMode.IMMEDIATE) {
                this.k = true;
                C0407a aVar = this.e;
                Objects.requireNonNull(aVar);
                DisposableHelper.dispose(aVar);
                Throwable terminate = this.d.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.a.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            } else {
                this.j = true;
                a();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (t != null) {
                this.g.offer(t);
            }
            a();
        }

        @Override // io.reactivex.Observer
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

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        if (!AppCompatDelegateImpl.i.d2(this.a, this.b, completableObserver)) {
            this.a.subscribe(new a(completableObserver, this.b, this.c, this.d));
        }
    }
}
