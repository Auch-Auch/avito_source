package hu.akarnokd.rxjava3.subjects;

import hu.akarnokd.rxjava3.util.SpmcLinkedArrayQueue;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class DispatchWorkSubject<T> extends Subject<T> implements Disposable {
    public static final a[] g = new a[0];
    public static final a[] h = new a[0];
    public final SimplePlainQueue<T> a;
    public final AtomicReference<Disposable> b = new AtomicReference<>();
    public final AtomicReference<Throwable> c = new AtomicReference<>();
    public final boolean d;
    public final AtomicReference<a<T>[]> e = new AtomicReference<>(g);
    public final Scheduler f;

    public static final class a<T> extends AtomicInteger implements Disposable, Runnable {
        private static final long serialVersionUID = 7597704795244221647L;
        public final Observer<? super T> a;
        public final DispatchWorkSubject<T> b;
        public final Scheduler.Worker c;
        public final boolean d;
        public volatile boolean e;

        public a(Observer<? super T> observer, DispatchWorkSubject<T> dispatchWorkSubject, Scheduler.Worker worker, boolean z) {
            this.a = observer;
            this.b = dispatchWorkSubject;
            this.c = worker;
            this.d = z;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                this.c.schedule(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.e = true;
            this.b.e(this);
            this.c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // java.lang.Runnable
        public void run() {
            DispatchWorkSubject<T> dispatchWorkSubject = this.b;
            SimplePlainQueue<T> simplePlainQueue = dispatchWorkSubject.a;
            Observer<? super T> observer = this.a;
            AtomicReference<Throwable> atomicReference = dispatchWorkSubject.c;
            boolean z = this.d;
            int i = 1;
            while (!this.e) {
                Throwable th = atomicReference.get();
                boolean z2 = false;
                boolean z3 = th != null;
                if (!z3 || z || th == ExceptionHelper.TERMINATED) {
                    T poll = simplePlainQueue.poll();
                    if (poll == null) {
                        z2 = true;
                    }
                    if (z3 && z2) {
                        if (th == ExceptionHelper.TERMINATED) {
                            observer.onComplete();
                        } else {
                            observer.onError(th);
                        }
                        this.c.dispose();
                        return;
                    } else if (z2) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(poll);
                    }
                } else {
                    simplePlainQueue.clear();
                    observer.onError(th);
                    this.c.dispose();
                    return;
                }
            }
        }
    }

    public DispatchWorkSubject(int i, boolean z, Scheduler scheduler) {
        this.a = new SpmcLinkedArrayQueue(i);
        this.d = z;
        new AtomicInteger();
        this.f = scheduler;
    }

    public static <T> DispatchWorkSubject<T> create(Scheduler scheduler) {
        return create(scheduler, Flowable.bufferSize(), true);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.b);
    }

    public void e(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.e.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i] == aVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        aVarArr2 = g;
                    } else {
                        a<T>[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.e.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public Throwable getThrowable() {
        Throwable th = this.c.get();
        if (th != ExceptionHelper.TERMINATED) {
            return th;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasComplete() {
        return this.c.get() == ExceptionHelper.TERMINATED;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasObservers() {
        return this.e.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasThrowable() {
        Throwable th = this.c.get();
        return (th == null || th == ExceptionHelper.TERMINATED) ? false : true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.b.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.c.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            for (a<T> aVar : this.e.getAndSet(h)) {
                aVar.a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        Objects.requireNonNull(th, "e is null");
        if (this.c.compareAndSet(null, th)) {
            for (a<T> aVar : this.e.getAndSet(h)) {
                aVar.a();
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        if (this.c.get() == null) {
            this.a.offer(t);
            for (a<T> aVar : this.e.get()) {
                aVar.a();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.b, disposable);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        boolean z;
        a<T> aVar = new a<>(observer, this, this.f.createWorker(), this.d);
        observer.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.e.get();
            z = false;
            if (aVarArr != h) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.e.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z || !aVar.e) {
            aVar.a();
        } else {
            e(aVar);
        }
    }

    public static <T> DispatchWorkSubject<T> create(Scheduler scheduler, int i) {
        return create(scheduler, i, true);
    }

    public static <T> DispatchWorkSubject<T> create(Scheduler scheduler, boolean z) {
        return create(scheduler, Flowable.bufferSize(), z);
    }

    public static <T> DispatchWorkSubject<T> create(Scheduler scheduler, int i, boolean z) {
        return new DispatchWorkSubject<>(i, z, scheduler);
    }
}
