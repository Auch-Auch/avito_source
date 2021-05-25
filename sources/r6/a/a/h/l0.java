package r6.a.a.h;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class l0<T> extends Observable<T> implements ObservableTransformer<T, T> {
    public final Observable<T> a;
    public final Scheduler b;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final Object h = new Object();
        private static final long serialVersionUID = -11696478502477044L;
        public final Observer<? super T> a;
        public final Scheduler.Worker b;
        public final AtomicReference<Object> c = new AtomicReference<>();
        public Disposable d;
        public volatile boolean e;
        public volatile boolean f;
        public Throwable g;

        public a(Observer<? super T> observer, Scheduler.Worker worker) {
            this.a = observer;
            this.b = worker;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                this.b.schedule(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.e = true;
            this.d.dispose();
            this.b.dispose();
            if (getAndIncrement() == 0) {
                this.c.lazySet(h);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.g = th;
            this.f = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.c.compareAndSet(null, t)) {
                a();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Observer<? super T> observer = this.a;
            int i = 1;
            while (!this.e) {
                boolean z = this.f;
                boolean z2 = this.c.get() == null;
                if (z && z2) {
                    Throwable th = this.g;
                    if (th == null) {
                        observer.onComplete();
                    } else {
                        observer.onError(th);
                    }
                    this.b.dispose();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observer.onNext(this.c.getAndSet(h));
                    this.c.set(null);
                }
            }
            this.c.lazySet(h);
        }
    }

    public l0(Observable<T> observable, Scheduler scheduler) {
        this.a = observable;
        this.b = scheduler;
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<T> apply(Observable<T> observable) {
        return new l0(observable, this.b);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new a(observer, this.b.createWorker()));
    }
}
