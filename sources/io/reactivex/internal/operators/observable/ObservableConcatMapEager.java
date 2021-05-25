package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
public final class ObservableConcatMapEager<T, R> extends s6.a.c.b.c.a<T, R> {
    public final Function<? super T, ? extends ObservableSource<? extends R>> a;
    public final ErrorMode b;
    public final int c;
    public final int d;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final int c;
        public final int d;
        public final ErrorMode e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final ArrayDeque<InnerQueuedObserver<R>> g = new ArrayDeque<>();
        public SimpleQueue<T> h;
        public Disposable i;
        public volatile boolean j;
        public int k;
        public volatile boolean l;
        public InnerQueuedObserver<R> m;
        public int n;

        public a(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
            this.a = observer;
            this.b = function;
            this.c = i2;
            this.d = i3;
            this.e = errorMode;
        }

        public void a() {
            InnerQueuedObserver<R> innerQueuedObserver = this.m;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> poll = this.g.poll();
                if (poll != null) {
                    poll.dispose();
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.l) {
                this.l = true;
                this.i.dispose();
                if (getAndIncrement() == 0) {
                    do {
                        this.h.clear();
                        a();
                    } while (decrementAndGet() != 0);
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void drain() {
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.h;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.g;
                Observer<? super R> observer = this.a;
                ErrorMode errorMode = this.e;
                int i2 = 1;
                while (true) {
                    int i3 = this.n;
                    while (true) {
                        if (i3 == this.c) {
                            break;
                        } else if (this.l) {
                            simpleQueue.clear();
                            a();
                            return;
                        } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f.get()) == null) {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    break;
                                }
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null ObservableSource");
                                InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.d);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.subscribe(innerQueuedObserver);
                                i3++;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.i.dispose();
                                simpleQueue.clear();
                                a();
                                this.f.addThrowable(th);
                                observer.onError(this.f.terminate());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            a();
                            observer.onError(this.f.terminate());
                            return;
                        }
                    }
                    this.n = i3;
                    if (this.l) {
                        simpleQueue.clear();
                        a();
                        return;
                    } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f.get()) == null) {
                        InnerQueuedObserver<R> innerQueuedObserver2 = this.m;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode != ErrorMode.BOUNDARY || ((Throwable) this.f.get()) == null) {
                                boolean z = this.j;
                                InnerQueuedObserver<R> poll2 = arrayDeque.poll();
                                boolean z2 = poll2 == null;
                                if (!z || !z2) {
                                    if (!z2) {
                                        this.m = poll2;
                                    }
                                    innerQueuedObserver2 = poll2;
                                } else if (((Throwable) this.f.get()) != null) {
                                    simpleQueue.clear();
                                    a();
                                    observer.onError(this.f.terminate());
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else {
                                simpleQueue.clear();
                                a();
                                observer.onError(this.f.terminate());
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            SimpleQueue<R> queue = innerQueuedObserver2.queue();
                            while (!this.l) {
                                boolean isDone = innerQueuedObserver2.isDone();
                                if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f.get()) == null) {
                                    try {
                                        R poll3 = queue.poll();
                                        boolean z3 = poll3 == null;
                                        if (isDone && z3) {
                                            this.m = null;
                                            this.n--;
                                        } else if (!z3) {
                                            observer.onNext(poll3);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.f.addThrowable(th2);
                                        this.m = null;
                                        this.n--;
                                    }
                                } else {
                                    simpleQueue.clear();
                                    a();
                                    observer.onError(this.f.terminate());
                                    return;
                                }
                            }
                            simpleQueue.clear();
                            a();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        a();
                        observer.onError(this.f.terminate());
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (this.f.addThrowable(th)) {
                if (this.e == ErrorMode.IMMEDIATE) {
                    this.i.dispose();
                }
                innerQueuedObserver.setDone();
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.queue().offer(r);
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.l;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.j = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f.addThrowable(th)) {
                this.j = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.k == 0) {
                this.h.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.k = requestFusion;
                        this.h = queueDisposable;
                        this.j = true;
                        this.a.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.k = requestFusion;
                        this.h = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.h = new SpscLinkedArrayQueue(this.d);
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i, int i2) {
        super(observableSource);
        this.a = function;
        this.b = errorMode;
        this.c = i;
        this.d = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new a(observer, this.a, this.c, this.d, this.b));
    }
}
