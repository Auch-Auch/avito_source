package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
public final class ObservableWindow<T> extends s6.a.c.b.c.a<T, Observable<T>> {
    public final long a;
    public final long b;
    public final int c;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        public final Observer<? super Observable<T>> a;
        public final long b;
        public final int c;
        public long d;
        public Disposable e;
        public UnicastSubject<T> f;
        public volatile boolean g;

        public a(Observer<? super Observable<T>> observer, long j, int i) {
            this.a = observer;
            this.b = j;
            this.c = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.f;
            if (unicastSubject != null) {
                this.f = null;
                unicastSubject.onComplete();
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.f;
            if (unicastSubject != null) {
                this.f = null;
                unicastSubject.onError(th);
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            UnicastSubject<T> unicastSubject = this.f;
            if (unicastSubject == null && !this.g) {
                unicastSubject = UnicastSubject.create(this.c, this);
                this.f = unicastSubject;
                this.a.onNext(unicastSubject);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
                long j = this.d + 1;
                this.d = j;
                if (j >= this.b) {
                    this.d = 0;
                    this.f = null;
                    unicastSubject.onComplete();
                    if (this.g) {
                        this.e.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.g) {
                this.e.dispose();
            }
        }
    }

    public static final class b<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        public final Observer<? super Observable<T>> a;
        public final long b;
        public final long c;
        public final int d;
        public final ArrayDeque<UnicastSubject<T>> e;
        public long f;
        public volatile boolean g;
        public long h;
        public Disposable i;
        public final AtomicInteger j = new AtomicInteger();

        public b(Observer<? super Observable<T>> observer, long j2, long j3, int i2) {
            this.a = observer;
            this.b = j2;
            this.c = j3;
            this.d = i2;
            this.e = new ArrayDeque<>();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            long j2 = this.f;
            long j3 = this.c;
            if (j2 % j3 == 0 && !this.g) {
                this.j.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.d, this);
                arrayDeque.offer(create);
                this.a.onNext(create);
            }
            long j4 = this.h + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j4 >= this.b) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.g) {
                    this.h = j4 - j3;
                } else {
                    this.i.dispose();
                    return;
                }
            } else {
                this.h = j4;
            }
            this.f = j2 + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.j.decrementAndGet() == 0 && this.g) {
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

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.a == this.b) {
            this.source.subscribe(new a(observer, this.a, this.c));
        } else {
            this.source.subscribe(new b(observer, this.a, this.b, this.c));
        }
    }
}
