package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableSwitchMap<T, R> extends s6.a.e.d.c.c.a<T, R> {
    public final Function<? super T, ? extends ObservableSource<? extends R>> a;
    public final int b;
    public final boolean c;

    public static final class a<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        public final b<T, R> a;
        public final long b;
        public final int c;
        public volatile SimpleQueue<R> d;
        public volatile boolean e;

        public a(b<T, R> bVar, long j, int i) {
            this.a = bVar;
            this.b = j;
            this.c = i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.b == this.a.j) {
                this.e = true;
                this.a.b();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            b<T, R> bVar = this.a;
            Objects.requireNonNull(bVar);
            if (this.b != bVar.j || !bVar.e.tryAddThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!bVar.d) {
                bVar.h.dispose();
                bVar.f = true;
            }
            this.e = true;
            bVar.b();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(R r) {
            if (this.b == this.a.j) {
                if (r != null) {
                    this.d.offer(r);
                }
                this.a.b();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.d = queueDisposable;
                        this.e = true;
                        this.a.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.d = queueDisposable;
                        return;
                    }
                }
                this.d = new SpscLinkedArrayQueue(this.c);
            }
        }
    }

    public static final class b<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final a<Object, Object> k;
        private static final long serialVersionUID = -3491074160481096299L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final int c;
        public final boolean d;
        public final AtomicThrowable e;
        public volatile boolean f;
        public volatile boolean g;
        public Disposable h;
        public final AtomicReference<a<T, R>> i = new AtomicReference<>();
        public volatile long j;

        static {
            a<Object, Object> aVar = new a<>(null, -1, 1);
            k = aVar;
            DisposableHelper.dispose(aVar);
        }

        public b(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = i2;
            this.d = z;
            this.e = new AtomicThrowable();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$a<T, R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            a aVar = (a) this.i.getAndSet(k);
            if (aVar != null) {
                DisposableHelper.dispose(aVar);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:70:0x00b7 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x000f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.rxjava3.core.Observer<? super R> r0 = r13.a
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$a<T, R>> r1 = r13.i
                boolean r2 = r13.d
                r3 = 1
                r4 = 1
            L_0x000f:
                boolean r5 = r13.g
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                boolean r5 = r13.f
                r6 = 0
                if (r5 == 0) goto L_0x004e
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L_0x0021
                r5 = 1
                goto L_0x0022
            L_0x0021:
                r5 = 0
            L_0x0022:
                if (r2 == 0) goto L_0x0038
                if (r5 == 0) goto L_0x004e
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.e
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0034
                r0.onError(r1)
                goto L_0x0037
            L_0x0034:
                r0.onComplete()
            L_0x0037:
                return
            L_0x0038:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r7 = r13.e
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x0048
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.e
                r1.tryTerminateConsumer(r0)
                return
            L_0x0048:
                if (r5 == 0) goto L_0x004e
                r0.onComplete()
                return
            L_0x004e:
                java.lang.Object r5 = r1.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$a r5 = (io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap.a) r5
                if (r5 == 0) goto L_0x00b7
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<R> r7 = r5.d
                if (r7 == 0) goto L_0x00b7
                r8 = 0
            L_0x005b:
                boolean r9 = r13.g
                if (r9 == 0) goto L_0x0060
                return
            L_0x0060:
                java.lang.Object r9 = r1.get()
                if (r5 == r9) goto L_0x0068
            L_0x0066:
                r8 = 1
                goto L_0x00af
            L_0x0068:
                if (r2 != 0) goto L_0x007a
                io.reactivex.rxjava3.internal.util.AtomicThrowable r9 = r13.e
                java.lang.Object r9 = r9.get()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                if (r9 == 0) goto L_0x007a
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.e
                r1.tryTerminateConsumer(r0)
                return
            L_0x007a:
                boolean r9 = r5.e
                r10 = 0
                java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x0082 }
                goto L_0x00a0
            L_0x0082:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8)
                io.reactivex.rxjava3.internal.util.AtomicThrowable r11 = r13.e
                r11.tryAddThrowableOrReport(r8)
                r1.compareAndSet(r5, r10)
                if (r2 != 0) goto L_0x009b
                r13.a()
                io.reactivex.rxjava3.disposables.Disposable r8 = r13.h
                r8.dispose()
                r13.f = r3
                goto L_0x009e
            L_0x009b:
                io.reactivex.rxjava3.internal.disposables.DisposableHelper.dispose(r5)
            L_0x009e:
                r11 = r10
                r8 = 1
            L_0x00a0:
                if (r11 != 0) goto L_0x00a4
                r12 = 1
                goto L_0x00a5
            L_0x00a4:
                r12 = 0
            L_0x00a5:
                if (r9 == 0) goto L_0x00ad
                if (r12 == 0) goto L_0x00ad
                r1.compareAndSet(r5, r10)
                goto L_0x0066
            L_0x00ad:
                if (r12 == 0) goto L_0x00b3
            L_0x00af:
                if (r8 == 0) goto L_0x00b7
                goto L_0x000f
            L_0x00b3:
                r0.onNext(r11)
                goto L_0x005b
            L_0x00b7:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap.b.b():void");
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.g) {
                this.g = true;
                this.h.dispose();
                a();
                this.e.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.f) {
                this.f = true;
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.f || !this.e.tryAddThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.d) {
                a();
            }
            this.f = true;
            b();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            a<T, R> aVar;
            long j2 = this.j + 1;
            this.j = j2;
            a<T, R> aVar2 = this.i.get();
            if (aVar2 != null) {
                DisposableHelper.dispose(aVar2);
            }
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The ObservableSource returned is null");
                ObservableSource observableSource = (ObservableSource) apply;
                a<T, R> aVar3 = new a<>(this, j2, this.c);
                do {
                    aVar = this.i.get();
                    if (aVar == k) {
                        return;
                    }
                } while (!this.i.compareAndSet(aVar, aVar3));
                observableSource.subscribe(aVar3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
        super(observableSource);
        this.a = function;
        this.b = i;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.a)) {
            this.source.subscribe(new b(observer, this.a, this.b, this.c));
        }
    }
}
