package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
public final class ObservableTakeLastTimed<T> extends s6.a.e.d.c.c.a<T, T> {
    public final long a;
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final int e;
    public final boolean f;

    public static final class a<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        public final Observer<? super T> a;
        public final long b;
        public final long c;
        public final TimeUnit d;
        public final Scheduler e;
        public final SpscLinkedArrayQueue<Object> f;
        public final boolean g;
        public Disposable h;
        public volatile boolean i;
        public Throwable j;

        public a(Observer<? super T> observer, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.a = observer;
            this.b = j2;
            this.c = j3;
            this.d = timeUnit;
            this.e = scheduler;
            this.f = new SpscLinkedArrayQueue<>(i2);
            this.g = z;
        }

        public void a() {
            Throwable th;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.a;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f;
                boolean z = this.g;
                long now = this.e.now(this.d) - this.c;
                while (!this.i) {
                    if (z || (th = this.j) == null) {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            Throwable th2 = this.j;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = spscLinkedArrayQueue.poll();
                            if (((Long) poll).longValue() >= now) {
                                observer.onNext(poll2);
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.i) {
                this.i = true;
                this.h.dispose();
                if (compareAndSet(false, true)) {
                    this.f.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.j = th;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f;
            long now = this.e.now(this.d);
            long j2 = this.c;
            long j3 = this.b;
            boolean z = j3 == Long.MAX_VALUE;
            spscLinkedArrayQueue.offer(Long.valueOf(now), t);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() <= now - j2 || (!z && ((long) (spscLinkedArrayQueue.size() >> 1)) > j3)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
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

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.a = j;
        this.b = j2;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = i;
        this.f = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a, this.b, this.c, this.d, this.e, this.f));
    }
}
