package r6.a.b.i;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class a1<T> extends Observable<T> implements ObservableTransformer<T, T> {
    public final Observable<? extends T> a;
    public final ObservableSource<Boolean> b;
    public final boolean c;
    public final int d;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -2233734924340471378L;
        public final Observer<? super T> a;
        public final AtomicReference<Disposable> b = new AtomicReference<>();
        public final SimplePlainQueue<T> c;
        public final a<T>.C0642a d = new C0642a();
        public final AtomicThrowable e = new AtomicThrowable();
        public volatile boolean f;
        public volatile boolean g;
        public volatile boolean h;

        /* renamed from: r6.a.b.i.a1$a$a  reason: collision with other inner class name */
        public final class C0642a extends AtomicReference<Disposable> implements Observer<Boolean> {
            private static final long serialVersionUID = -3076915855750118155L;

            public C0642a() {
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (aVar.e.tryAddThrowableOrReport(new IllegalStateException("The valve source completed unexpectedly."))) {
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                a aVar = a.this;
                if (aVar.e.tryAddThrowableOrReport(th)) {
                    aVar.a();
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(Boolean bool) {
                a aVar = a.this;
                boolean booleanValue = bool.booleanValue();
                aVar.g = booleanValue;
                if (booleanValue) {
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(Observer<? super T> observer, int i, boolean z) {
            this.a = observer;
            this.c = new SpscLinkedArrayQueue(i);
            this.g = z;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.c;
                Observer<? super T> observer = this.a;
                AtomicThrowable atomicThrowable = this.e;
                int i = 1;
                while (!this.h) {
                    if (atomicThrowable.get() != null) {
                        simplePlainQueue.clear();
                        DisposableHelper.dispose(this.b);
                        DisposableHelper.dispose(this.d);
                        atomicThrowable.tryTerminateConsumer(observer);
                        return;
                    }
                    if (this.g) {
                        boolean z = this.f;
                        T poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            DisposableHelper.dispose(this.d);
                            observer.onComplete();
                            return;
                        } else if (!z2) {
                            observer.onNext(poll);
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.h = true;
            DisposableHelper.dispose(this.b);
            DisposableHelper.dispose(this.d);
            this.e.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.h;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.f = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.e.tryAddThrowableOrReport(th)) {
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
            DisposableHelper.setOnce(this.b, disposable);
        }
    }

    public a1(Observable<? extends T> observable, ObservableSource<Boolean> observableSource, boolean z, int i) {
        this.a = observable;
        this.b = observableSource;
        this.c = z;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.core.ObservableTransformer
    public ObservableSource apply(Observable observable) {
        return new a1(observable, this.b, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer, this.d, this.c);
        observer.onSubscribe(aVar);
        this.b.subscribe(aVar.d);
        this.a.subscribe(aVar);
    }
}
