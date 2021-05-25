package hu.akarnokd.rxjava3.subjects;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class UnicastWorkSubject<T> extends Subject<T> implements Disposable {
    public final SimplePlainQueue<T> a;
    public final boolean b;
    public final AtomicInteger c = new AtomicInteger();
    public final AtomicReference<Disposable> d = new AtomicReference<>();
    public final AtomicReference<Throwable> e = new AtomicReference<>();
    public final AtomicReference<UnicastWorkSubject<T>.a> f = new AtomicReference<>();

    public final class a extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = -3574708954225968389L;
        public final Observer<? super T> a;

        public a(Observer<? super T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                UnicastWorkSubject.this.f.compareAndSet(this, null);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public UnicastWorkSubject(int i, boolean z) {
        this.a = new SpscLinkedArrayQueue(i);
        this.b = z;
    }

    public static <T> UnicastWorkSubject<T> create() {
        return create(Flowable.bufferSize(), true);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.d);
        if (this.e.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            e();
        }
    }

    public void e() {
        if (this.c.getAndIncrement() == 0) {
            AtomicReference<Throwable> atomicReference = this.e;
            AtomicReference<UnicastWorkSubject<T>.a> atomicReference2 = this.f;
            boolean z = this.b;
            int i = 1;
            while (true) {
                UnicastWorkSubject<T>.a aVar = atomicReference2.get();
                if (aVar != null) {
                    Throwable th = atomicReference.get();
                    boolean z2 = false;
                    boolean z3 = th != null;
                    if (!z3 || z || th == ExceptionHelper.TERMINATED) {
                        T poll = this.a.poll();
                        if (poll == null) {
                            z2 = true;
                        }
                        if (!z3 || !z2) {
                            if (!z2) {
                                if (aVar == atomicReference2.get()) {
                                    aVar.a.onNext(poll);
                                }
                            }
                        } else if (th != ExceptionHelper.TERMINATED) {
                            if (atomicReference2.compareAndSet(aVar, null)) {
                                aVar.a.onError(th);
                            }
                        } else if (atomicReference2.compareAndSet(aVar, null)) {
                            aVar.a.onComplete();
                        }
                    } else {
                        this.a.clear();
                        if (atomicReference2.compareAndSet(aVar, null)) {
                            aVar.a.onError(th);
                        }
                    }
                }
                i = this.c.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public Throwable getThrowable() {
        Throwable th = this.e.get();
        if (th != ExceptionHelper.TERMINATED) {
            return th;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasComplete() {
        return this.e.get() == ExceptionHelper.TERMINATED;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasObservers() {
        return this.f.get() != null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    public boolean hasThrowable() {
        Throwable th = this.e.get();
        return (th == null || th == ExceptionHelper.TERMINATED) ? false : true;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.d.get());
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (this.e.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            e();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        Objects.requireNonNull(th, "e is null");
        if (this.e.compareAndSet(null, th)) {
            e();
        } else {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        Objects.requireNonNull(t, "t is null");
        if (this.e.get() == null) {
            this.a.offer(t);
            e();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.d, disposable);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        UnicastWorkSubject<T>.a aVar = new a(observer);
        observer.onSubscribe(aVar);
        if (!this.f.compareAndSet(null, aVar)) {
            observer.onError(new IllegalStateException("Only one Observer allowed at a time"));
        } else if (aVar.get()) {
            this.f.compareAndSet(aVar, null);
        } else {
            e();
        }
    }

    public static <T> UnicastWorkSubject<T> create(int i) {
        return create(i, true);
    }

    public static <T> UnicastWorkSubject<T> create(boolean z) {
        return create(Flowable.bufferSize(), z);
    }

    public static <T> UnicastWorkSubject<T> create(int i, boolean z) {
        return new UnicastWorkSubject<>(i, z);
    }
}
