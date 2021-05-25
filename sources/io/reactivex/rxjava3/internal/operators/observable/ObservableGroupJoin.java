package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends s6.a.e.d.c.c.a<TLeft, R> {
    public final ObservableSource<? extends TRight> a;
    public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> b;
    public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> c;
    public final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> d;

    public static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, b {
        public static final Integer n = 1;
        public static final Integer o = 2;
        public static final Integer p = 3;
        public static final Integer q = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        public final Observer<? super R> a;
        public final SpscLinkedArrayQueue<Object> b = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        public final CompositeDisposable c = new CompositeDisposable();
        public final Map<Integer, UnicastSubject<TRight>> d = new LinkedHashMap();
        public final Map<Integer, TRight> e = new LinkedHashMap();
        public final AtomicReference<Throwable> f = new AtomicReference<>();
        public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> g;
        public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> h;
        public final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> i;
        public final AtomicInteger j;
        public int k;
        public int l;
        public volatile boolean m;

        public a(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
            this.a = observer;
            this.g = function;
            this.h = function2;
            this.i = biFunction;
            this.j = new AtomicInteger(2);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.b
        public void a(Throwable th) {
            if (ExceptionHelper.addThrowable(this.f, th)) {
                this.j.decrementAndGet();
                h();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.b
        public void b(Throwable th) {
            if (ExceptionHelper.addThrowable(this.f, th)) {
                h();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.b
        public void c(boolean z, Object obj) {
            synchronized (this) {
                this.b.offer(z ? n : o, obj);
            }
            h();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.m) {
                this.m = true;
                this.c.dispose();
                if (getAndIncrement() == 0) {
                    this.b.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.b
        public void e(d dVar) {
            this.c.delete(dVar);
            this.j.decrementAndGet();
            h();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.b
        public void f(boolean z, c cVar) {
            synchronized (this) {
                this.b.offer(z ? p : q, cVar);
            }
            h();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v9, resolved type: java.util.Map<java.lang.Integer, TRight> */
        /* JADX WARN: Multi-variable type inference failed */
        public void h() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.b;
                Observer<? super R> observer = this.a;
                int i2 = 1;
                while (!this.m) {
                    if (this.f.get() != null) {
                        spscLinkedArrayQueue.clear();
                        this.c.dispose();
                        i(observer);
                        return;
                    }
                    boolean z = this.j.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        for (UnicastSubject<TRight> unicastSubject : this.d.values()) {
                            unicastSubject.onComplete();
                        }
                        this.d.clear();
                        this.e.clear();
                        this.c.dispose();
                        observer.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == n) {
                            UnicastSubject<TRight> create = UnicastSubject.create();
                            int i3 = this.k;
                            this.k = i3 + 1;
                            this.d.put(Integer.valueOf(i3), create);
                            try {
                                Object apply = this.g.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                c cVar = new c(this, true, i3);
                                this.c.add(cVar);
                                observableSource.subscribe(cVar);
                                if (this.f.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.c.dispose();
                                    i(observer);
                                    return;
                                }
                                try {
                                    Object obj = (Object) this.i.apply(poll, create);
                                    Objects.requireNonNull(obj, "The resultSelector returned a null value");
                                    observer.onNext(obj);
                                    for (TRight tright : this.e.values()) {
                                        create.onNext(tright);
                                    }
                                } catch (Throwable th) {
                                    j(th, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th2) {
                                j(th2, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == o) {
                            int i4 = this.l;
                            this.l = i4 + 1;
                            this.e.put(Integer.valueOf(i4), poll);
                            try {
                                Object apply2 = this.h.apply(poll);
                                Objects.requireNonNull(apply2, "The rightEnd returned a null ObservableSource");
                                ObservableSource observableSource2 = (ObservableSource) apply2;
                                c cVar2 = new c(this, false, i4);
                                this.c.add(cVar2);
                                observableSource2.subscribe(cVar2);
                                if (this.f.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.c.dispose();
                                    i(observer);
                                    return;
                                }
                                for (UnicastSubject<TRight> unicastSubject2 : this.d.values()) {
                                    unicastSubject2.onNext(poll);
                                }
                            } catch (Throwable th3) {
                                j(th3, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == p) {
                            c cVar3 = (c) poll;
                            UnicastSubject<TRight> remove = this.d.remove(Integer.valueOf(cVar3.c));
                            this.c.remove(cVar3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else {
                            c cVar4 = (c) poll;
                            this.e.remove(Integer.valueOf(cVar4.c));
                            this.c.remove(cVar4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void i(Observer<?> observer) {
            Throwable terminate = ExceptionHelper.terminate(this.f);
            for (UnicastSubject<TRight> unicastSubject : this.d.values()) {
                unicastSubject.onError(terminate);
            }
            this.d.clear();
            this.e.clear();
            observer.onError(terminate);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.m;
        }

        public void j(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.throwIfFatal(th);
            ExceptionHelper.addThrowable(this.f, th);
            spscLinkedArrayQueue.clear();
            this.c.dispose();
            i(observer);
        }
    }

    public interface b {
        void a(Throwable th);

        void b(Throwable th);

        void c(boolean z, Object obj);

        void e(d dVar);

        void f(boolean z, c cVar);
    }

    public static final class c extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        public final b a;
        public final boolean b;
        public final int c;

        public c(b bVar, boolean z, int i) {
            this.a = bVar;
            this.b = z;
            this.c = i;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.a.f(this.b, this);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.a.b(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.a.f(this.b, this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public static final class d extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        public final b a;
        public final boolean b;

        public d(b bVar, boolean z) {
            this.a = bVar;
            this.b = z;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.a.e(this);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            this.a.c(this.b, obj);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.a = observableSource2;
        this.b = function;
        this.c = function2;
        this.d = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        a aVar = new a(observer, this.b, this.c, this.d);
        observer.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.c.add(dVar);
        d dVar2 = new d(aVar, false);
        aVar.c.add(dVar2);
        this.source.subscribe(dVar);
        this.a.subscribe(dVar2);
    }
}
