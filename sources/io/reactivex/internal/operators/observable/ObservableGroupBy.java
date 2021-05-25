package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableGroupBy<T, K, V> extends s6.a.c.b.c.a<T, GroupedObservable<K, V>> {
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.h.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.g.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.h.get();
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
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

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Object obj;
            try {
                Object apply = this.b.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = i;
                }
                a<K, V> aVar = this.f.get(obj);
                if (aVar == null) {
                    if (!this.h.get()) {
                        aVar = new a<>(apply, new b(this.d, this, apply, this.e));
                        this.f.put(obj, aVar);
                        getAndIncrement();
                        this.a.onNext(aVar);
                    } else {
                        return;
                    }
                }
                try {
                    Object requireNonNull = ObjectHelper.requireNonNull(this.c.apply(t), "The value supplied is null");
                    b<T, K> bVar = aVar.b;
                    bVar.b.offer(requireNonNull);
                    bVar.a();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.g.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.g.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observable
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
        public final AtomicBoolean h = new AtomicBoolean();
        public final AtomicReference<Observer<? super T>> i = new AtomicReference<>();

        public b(int i2, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.b = new SpscLinkedArrayQueue<>(i2);
            this.c = groupByObserver;
            this.a = k;
            this.d = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0075 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r11 = this;
                int r0 = r11.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.internal.queue.SpscLinkedArrayQueue<T> r0 = r11.b
                boolean r1 = r11.d
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r2 = r11.i
                java.lang.Object r2 = r2.get()
                io.reactivex.Observer r2 = (io.reactivex.Observer) r2
                r3 = 1
                r4 = 1
            L_0x0015:
                if (r2 == 0) goto L_0x007d
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
                if (r9 == 0) goto L_0x003f
                io.reactivex.internal.queue.SpscLinkedArrayQueue<T> r5 = r11.b
                r5.clear()
                io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver<?, K, T> r5 = r11.c
                K r7 = r11.a
                r5.cancel(r7)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r5 = r11.i
                r5.lazySet(r10)
            L_0x003d:
                r7 = 1
                goto L_0x0073
            L_0x003f:
                if (r5 == 0) goto L_0x0073
                if (r1 == 0) goto L_0x0056
                if (r8 == 0) goto L_0x0073
                java.lang.Throwable r5 = r11.f
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r7 = r11.i
                r7.lazySet(r10)
                if (r5 == 0) goto L_0x0052
                r2.onError(r5)
                goto L_0x003d
            L_0x0052:
                r2.onComplete()
                goto L_0x003d
            L_0x0056:
                java.lang.Throwable r5 = r11.f
                if (r5 == 0) goto L_0x0068
                io.reactivex.internal.queue.SpscLinkedArrayQueue<T> r7 = r11.b
                r7.clear()
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r7 = r11.i
                r7.lazySet(r10)
                r2.onError(r5)
                goto L_0x003d
            L_0x0068:
                if (r8 == 0) goto L_0x0073
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r5 = r11.i
                r5.lazySet(r10)
                r2.onComplete()
                goto L_0x003d
            L_0x0073:
                if (r7 == 0) goto L_0x0076
                return
            L_0x0076:
                if (r8 == 0) goto L_0x0079
                goto L_0x007d
            L_0x0079:
                r2.onNext(r6)
                goto L_0x0017
            L_0x007d:
                int r4 = -r4
                int r4 = r11.addAndGet(r4)
                if (r4 != 0) goto L_0x0085
                return
            L_0x0085:
                if (r2 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r2 = r11.i
                java.lang.Object r2 = r2.get()
                io.reactivex.Observer r2 = (io.reactivex.Observer) r2
                goto L_0x0015
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableGroupBy.b.a():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.g.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.i.lazySet(null);
                this.c.cancel(this.a);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g.get();
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            if (this.h.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.i.lazySet(observer);
                if (this.g.get()) {
                    this.i.lazySet(null);
                } else {
                    a();
                }
            } else {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
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

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.a, this.b, this.c, this.d));
    }
}
