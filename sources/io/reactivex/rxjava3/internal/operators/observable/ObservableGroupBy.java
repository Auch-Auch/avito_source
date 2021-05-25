package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableGroupBy<T, K, V> extends s6.a.e.d.c.c.a<T, GroupedObservable<K, V>> {
    public final Function<? super T, ? extends K> a;
    public final Function<? super T, ? extends V> b;
    public final int c;
    public final boolean d;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        public static final Object i = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        public final Observer<? super GroupedObservable<K, V>> a;
        public final Function<? super T, ? extends K> b;
        public final Function<? super T, ? extends V> c;
        public final int d;
        public final boolean e;
        public final Map<Object, a<K, V>> f;
        public Disposable g;
        public final AtomicBoolean h = new AtomicBoolean();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = function2;
            this.d = i2;
            this.e = z;
            this.f = new ConcurrentHashMap();
            lazySet(1);
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) i;
            }
            this.f.remove(k);
            if (decrementAndGet() == 0) {
                this.g.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.h.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.g.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.h.get();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.f.values());
            this.f.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b<T, K> bVar = ((a) it.next()).b;
                bVar.e = true;
                bVar.a();
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.f.values());
            this.f.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b<T, K> bVar = ((a) it.next()).b;
                bVar.f = th;
                bVar.e = true;
                bVar.a();
            }
            this.a.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: io.reactivex.rxjava3.internal.operators.observable.ObservableGroupBy$GroupByObserver<T, K, V> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            Object obj;
            boolean z;
            try {
                Object apply = this.b.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = i;
                }
                a<K, V> aVar = this.f.get(obj);
                boolean z2 = false;
                if (aVar != null) {
                    z = false;
                } else if (!this.h.get()) {
                    aVar = new a<>(apply, new b(this.d, this, apply, this.e));
                    this.f.put(obj, aVar);
                    getAndIncrement();
                    z = true;
                } else {
                    return;
                }
                try {
                    Object apply2 = this.c.apply(t);
                    Objects.requireNonNull(apply2, "The value supplied is null");
                    b<T, K> bVar = aVar.b;
                    bVar.b.offer(apply2);
                    bVar.a();
                    if (z) {
                        this.a.onNext(aVar);
                        b<T, K> bVar2 = aVar.b;
                        if (bVar2.i.get() == 0 && bVar2.i.compareAndSet(0, 2)) {
                            z2 = true;
                        }
                        if (z2) {
                            cancel(apply);
                            b<T, K> bVar3 = aVar.b;
                            bVar3.e = true;
                            bVar3.a();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.g.dispose();
                    if (z) {
                        this.a.onNext(aVar);
                    }
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.g.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public static final class a<K, T> extends GroupedObservable<K, T> {
        public final b<T, K> b;

        public a(K k, b<T, K> bVar) {
            super(k);
            this.b = bVar;
        }

        @Override // io.reactivex.rxjava3.core.Observable
        public void subscribeActual(Observer<? super T> observer) {
            this.b.subscribe(observer);
        }
    }

    public static final class b<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final K a;
        public final SpscLinkedArrayQueue<T> b;
        public final GroupByObserver<?, K, T> c;
        public final boolean d;
        public volatile boolean e;
        public Throwable f;
        public final AtomicBoolean g = new AtomicBoolean();
        public final AtomicReference<Observer<? super T>> h = new AtomicReference<>();
        public final AtomicInteger i = new AtomicInteger();

        public b(int i2, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.b = new SpscLinkedArrayQueue<>(i2);
            this.c = groupByObserver;
            this.a = k;
            this.d = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x007f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r11 = this;
                int r0 = r11.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<T> r0 = r11.b
                boolean r1 = r11.d
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.core.Observer<? super T>> r2 = r11.h
                java.lang.Object r2 = r2.get()
                io.reactivex.rxjava3.core.Observer r2 = (io.reactivex.rxjava3.core.Observer) r2
                r3 = 1
                r4 = 1
            L_0x0015:
                if (r2 == 0) goto L_0x0087
            L_0x0017:
                boolean r5 = r11.e
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r6 != 0) goto L_0x0022
                r8 = 1
                goto L_0x0023
            L_0x0022:
                r8 = 0
            L_0x0023:
                java.util.concurrent.atomic.AtomicBoolean r9 = r11.g
                boolean r9 = r9.get()
                r10 = 0
                if (r9 == 0) goto L_0x0049
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<T> r5 = r11.b
                r5.clear()
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.core.Observer<? super T>> r5 = r11.h
                r5.lazySet(r10)
                java.util.concurrent.atomic.AtomicInteger r5 = r11.i
                int r5 = r5.get()
                r5 = r5 & 2
                if (r5 != 0) goto L_0x0047
                io.reactivex.rxjava3.internal.operators.observable.ObservableGroupBy$GroupByObserver<?, K, T> r5 = r11.c
                K r7 = r11.a
                r5.cancel(r7)
            L_0x0047:
                r7 = 1
                goto L_0x007d
            L_0x0049:
                if (r5 == 0) goto L_0x007d
                if (r1 == 0) goto L_0x0060
                if (r8 == 0) goto L_0x007d
                java.lang.Throwable r5 = r11.f
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.core.Observer<? super T>> r7 = r11.h
                r7.lazySet(r10)
                if (r5 == 0) goto L_0x005c
                r2.onError(r5)
                goto L_0x0047
            L_0x005c:
                r2.onComplete()
                goto L_0x0047
            L_0x0060:
                java.lang.Throwable r5 = r11.f
                if (r5 == 0) goto L_0x0072
                io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<T> r7 = r11.b
                r7.clear()
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.core.Observer<? super T>> r7 = r11.h
                r7.lazySet(r10)
                r2.onError(r5)
                goto L_0x0047
            L_0x0072:
                if (r8 == 0) goto L_0x007d
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.core.Observer<? super T>> r5 = r11.h
                r5.lazySet(r10)
                r2.onComplete()
                goto L_0x0047
            L_0x007d:
                if (r7 == 0) goto L_0x0080
                return
            L_0x0080:
                if (r8 == 0) goto L_0x0083
                goto L_0x0087
            L_0x0083:
                r2.onNext(r6)
                goto L_0x0017
            L_0x0087:
                int r4 = -r4
                int r4 = r11.addAndGet(r4)
                if (r4 != 0) goto L_0x008f
                return
            L_0x008f:
                if (r2 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.core.Observer<? super T>> r2 = r11.h
                java.lang.Object r2 = r2.get()
                io.reactivex.rxjava3.core.Observer r2 = (io.reactivex.rxjava3.core.Observer) r2
                goto L_0x0015
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableGroupBy.b.a():void");
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.g.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.h.lazySet(null);
                if ((this.i.get() & 2) == 0) {
                    this.c.cancel(this.a);
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.g.get();
        }

        @Override // io.reactivex.rxjava3.core.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            int i2;
            do {
                i2 = this.i.get();
                if ((i2 & 1) != 0) {
                    EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
                    return;
                }
            } while (!this.i.compareAndSet(i2, i2 | 1));
            observer.onSubscribe(this);
            this.h.lazySet(observer);
            if (this.g.get()) {
                this.h.lazySet(null);
            } else {
                a();
            }
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
        super(observableSource);
        this.a = function;
        this.b = function2;
        this.c = i;
        this.d = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.a, this.b, this.c, this.d));
    }
}
