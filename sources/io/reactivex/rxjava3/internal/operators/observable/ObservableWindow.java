package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
public final class ObservableWindow<T> extends s6.a.e.d.c.c.a<T, Observable<T>> {
    public final long a;
    public final long b;
    public final int c;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        public final Observer<? super Observable<T>> a;
        public final long b;
        public final int c;
        public final AtomicBoolean d = new AtomicBoolean();
        public long e;
        public Disposable f;
        public UnicastSubject<T> g;

        public a(Observer<? super Observable<T>> observer, long j, int i) {
            this.a = observer;
            this.b = j;
            this.c = i;
            lazySet(1);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.d.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.d.get();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.g;
            if (unicastSubject != null) {
                this.g = null;
                unicastSubject.onComplete();
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.g;
            if (unicastSubject != null) {
                this.g = null;
                unicastSubject.onError(th);
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            s6.a.e.d.c.c.b bVar;
            UnicastSubject<T> unicastSubject = this.g;
            if (unicastSubject != null || this.d.get()) {
                bVar = null;
            } else {
                getAndIncrement();
                unicastSubject = UnicastSubject.create(this.c, this);
                this.g = unicastSubject;
                bVar = new s6.a.e.d.c.c.b(unicastSubject);
                this.a.onNext(bVar);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
                long j = this.e + 1;
                this.e = j;
                if (j >= this.b) {
                    this.e = 0;
                    this.g = null;
                    unicastSubject.onComplete();
                }
                if (bVar != null && bVar.e()) {
                    this.g = null;
                    unicastSubject.onComplete();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f.dispose();
            }
        }
    }

    public static final class b<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        public final Observer<? super Observable<T>> a;
        public final long b;
        public final long c;
        public final int d;
        public final ArrayDeque<UnicastSubject<T>> e = new ArrayDeque<>();
        public final AtomicBoolean f = new AtomicBoolean();
        public long g;
        public long h;
        public Disposable i;

        public b(Observer<? super Observable<T>> observer, long j, long j2, int i2) {
            this.a = observer;
            this.b = j;
            this.c = j2;
            this.d = i2;
            lazySet(1);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.f.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.f.get();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            s6.a.e.d.c.c.b bVar;
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            long j = this.g;
            long j2 = this.c;
            if (j % j2 != 0 || this.f.get()) {
                bVar = null;
            } else {
                getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.d, this);
                bVar = new s6.a.e.d.c.c.b(create);
                arrayDeque.offer(create);
                this.a.onNext(bVar);
            }
            long j3 = this.h + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j3 >= this.b) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.f.get()) {
                    this.h = j3 - j2;
                } else {
                    return;
                }
            } else {
                this.h = j3;
            }
            this.g = j + 1;
            if (bVar != null && bVar.e()) {
                bVar.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.i.dispose();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j, long j2, int i) {
        super(observableSource);
        this.a = j;
        this.b = j2;
        this.c = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.a == this.b) {
            this.source.subscribe(new a(observer, this.a, this.c));
        } else {
            this.source.subscribe(new b(observer, this.a, this.b, this.c));
        }
    }
}
