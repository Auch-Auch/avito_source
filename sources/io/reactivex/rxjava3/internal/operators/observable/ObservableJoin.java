package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends s6.a.e.d.c.c.a<TLeft, R> {
    public final ObservableSource<? extends TRight> a;
    public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> b;
    public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> c;
    public final BiFunction<? super TLeft, ? super TRight, ? extends R> d;

    public static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.b {
        public static final Integer n = 1;
        public static final Integer o = 2;
        public static final Integer p = 3;
        public static final Integer q = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        public final Observer<? super R> a;
        public final SpscLinkedArrayQueue<Object> b = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        public final CompositeDisposable c = new CompositeDisposable();
        public final Map<Integer, TLeft> d = new LinkedHashMap();
        public final Map<Integer, TRight> e = new LinkedHashMap();
        public final AtomicReference<Throwable> f = new AtomicReference<>();
        public final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> g;
        public final Function<? super TRight, ? extends ObservableSource<TRightEnd>> h;
        public final BiFunction<? super TLeft, ? super TRight, ? extends R> i;
        public final AtomicInteger j;
        public int k;
        public int l;
        public volatile boolean m;

        public a(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
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
        public void e(ObservableGroupJoin.d dVar) {
            this.c.delete(dVar);
            this.j.decrementAndGet();
            h();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.b
        public void f(boolean z, ObservableGroupJoin.c cVar) {
            synchronized (this) {
                this.b.offer(z ? p : q, cVar);
            }
            h();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.util.Map<java.lang.Integer, TLeft> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: java.util.Map<java.lang.Integer, TRight> */
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
                            int i3 = this.k;
                            this.k = i3 + 1;
                            this.d.put(Integer.valueOf(i3), poll);
                            try {
                                Object apply = this.g.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                ObservableGroupJoin.c cVar = new ObservableGroupJoin.c(this, true, i3);
                                this.c.add(cVar);
                                observableSource.subscribe(cVar);
                                if (this.f.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.c.dispose();
                                    i(observer);
                                    return;
                                }
                                for (TRight tright : this.e.values()) {
                                    try {
                                        Object obj = (Object) this.i.apply(poll, tright);
                                        Objects.requireNonNull(obj, "The resultSelector returned a null value");
                                        observer.onNext(obj);
                                    } catch (Throwable th) {
                                        j(th, observer, spscLinkedArrayQueue);
                                        return;
                                    }
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
                                ObservableGroupJoin.c cVar2 = new ObservableGroupJoin.c(this, false, i4);
                                this.c.add(cVar2);
                                observableSource2.subscribe(cVar2);
                                if (this.f.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    this.c.dispose();
                                    i(observer);
                                    return;
                                }
                                for (TLeft tleft : this.d.values()) {
                                    try {
                                        Object obj2 = (Object) this.i.apply(tleft, poll);
                                        Objects.requireNonNull(obj2, "The resultSelector returned a null value");
                                        observer.onNext(obj2);
                                    } catch (Throwable th3) {
                                        j(th3, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                j(th4, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == p) {
                            ObservableGroupJoin.c cVar3 = (ObservableGroupJoin.c) poll;
                            this.d.remove(Integer.valueOf(cVar3.c));
                            this.c.remove(cVar3);
                        } else {
                            ObservableGroupJoin.c cVar4 = (ObservableGroupJoin.c) poll;
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

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
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
        ObservableGroupJoin.d dVar = new ObservableGroupJoin.d(aVar, true);
        aVar.c.add(dVar);
        ObservableGroupJoin.d dVar2 = new ObservableGroupJoin.d(aVar, false);
        aVar.c.add(dVar2);
        this.source.subscribe(dVar);
        this.a.subscribe(dVar2);
    }
}
