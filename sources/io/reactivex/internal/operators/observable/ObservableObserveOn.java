package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
public final class ObservableObserveOn<T> extends s6.a.c.b.c.a<T, T> {
    public final Scheduler a;
    public final boolean b;
    public final int c;

    public static final class a<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        public final Observer<? super T> a;
        public final Scheduler.Worker b;
        public final boolean c;
        public final int d;
        public SimpleQueue<T> e;
        public Disposable f;
        public Throwable g;
        public volatile boolean h;
        public volatile boolean i;
        public int j;
        public boolean k;

        public a(Observer<? super T> observer, Scheduler.Worker worker, boolean z, int i2) {
            this.a = observer;
            this.b = worker;
            this.c = z;
            this.d = i2;
        }

        public boolean a(boolean z, boolean z2, Observer<? super T> observer) {
            if (this.i) {
                this.e.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.g;
                if (this.c) {
                    if (!z2) {
                        return false;
                    }
                    this.i = true;
                    if (th != null) {
                        observer.onError(th);
                    } else {
                        observer.onComplete();
                    }
                    this.b.dispose();
                    return true;
                } else if (th != null) {
                    this.i = true;
                    this.e.clear();
                    observer.onError(th);
                    this.b.dispose();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    this.i = true;
                    observer.onComplete();
                    this.b.dispose();
                    return true;
                }
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                this.b.schedule(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.e.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.i) {
                this.i = true;
                this.f.dispose();
                this.b.dispose();
                if (!this.k && getAndIncrement() == 0) {
                    this.e.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.e.isEmpty();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.h) {
                this.h = true;
                b();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = th;
            this.h = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.h) {
                if (this.j != 2) {
                    this.e.offer(t);
                }
                b();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = queueDisposable;
                        this.h = true;
                        this.a.onSubscribe(this);
                        b();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new SpscLinkedArrayQueue(this.d);
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            return this.e.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.k = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k) {
                int i2 = 1;
                while (!this.i) {
                    boolean z = this.h;
                    Throwable th = this.g;
                    if (this.c || !z || th == null) {
                        this.a.onNext(null);
                        if (z) {
                            this.i = true;
                            Throwable th2 = this.g;
                            if (th2 != null) {
                                this.a.onError(th2);
                            } else {
                                this.a.onComplete();
                            }
                            this.b.dispose();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        this.i = true;
                        this.a.onError(this.g);
                        this.b.dispose();
                        return;
                    }
                }
                return;
            }
            SimpleQueue<T> simpleQueue = this.e;
            Observer<? super T> observer = this.a;
            int i3 = 1;
            while (!a(this.h, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z2 = this.h;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z3 = poll == null;
                        if (!a(z2, z3, observer)) {
                            if (z3) {
                                i3 = addAndGet(-i3);
                                if (i3 == 0) {
                                    return;
                                }
                            } else {
                                observer.onNext(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.i = true;
                        this.f.dispose();
                        simpleQueue.clear();
                        observer.onError(th3);
                        this.b.dispose();
                        return;
                    }
                }
            }
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z, int i) {
        super(observableSource);
        this.a = scheduler;
        this.b = z;
        this.c = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler = this.a;
        if (scheduler instanceof TrampolineScheduler) {
            this.source.subscribe(observer);
            return;
        }
        this.source.subscribe(new a(observer, scheduler.createWorker(), this.b, this.c));
    }
}
