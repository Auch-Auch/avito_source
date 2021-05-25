package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
public final class ObservableWindowTimed<T> extends s6.a.e.d.c.c.a<T, Observable<T>> {
    public final long a;
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final long e;
    public final int f;
    public final boolean g;

    public static abstract class a<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5724293814035355511L;
        public final Observer<? super Observable<T>> a;
        public final SimplePlainQueue<Object> b = new MpscLinkedQueue();
        public final long c;
        public final TimeUnit d;
        public final int e;
        public long f;
        public volatile boolean g;
        public Throwable h;
        public Disposable i;
        public final AtomicBoolean j;
        public volatile boolean k;
        public final AtomicInteger l;

        public a(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, int i2) {
            this.a = observer;
            this.c = j2;
            this.d = timeUnit;
            this.e = i2;
            this.j = new AtomicBoolean();
            this.l = new AtomicInteger(1);
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public final void dispose() {
            if (this.j.compareAndSet(false, true)) {
                e();
            }
        }

        public final void e() {
            if (this.l.decrementAndGet() == 0) {
                a();
                this.i.dispose();
                this.k = true;
                c();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public final boolean isDisposed() {
            return this.j.get();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onComplete() {
            this.g = true;
            c();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onError(Throwable th) {
            this.h = th;
            this.g = true;
            c();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onNext(T t) {
            this.b.offer(t);
            c();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.a.onSubscribe(this);
                b();
            }
        }
    }

    public static final class b<T> extends a<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        public final Scheduler m;
        public final boolean n;
        public final long o;
        public final Scheduler.Worker p;
        public long q;
        public UnicastSubject<T> r;
        public final SequentialDisposable s;

        public static final class a implements Runnable {
            public final b<?> a;
            public final long b;

            public a(b<?> bVar, long j) {
                this.a = bVar;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b<?> bVar = this.a;
                bVar.b.offer(this);
                bVar.c();
            }
        }

        public b(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(observer, j, timeUnit, i);
            this.m = scheduler;
            this.o = j2;
            this.n = z;
            if (z) {
                this.p = scheduler.createWorker();
            } else {
                this.p = null;
            }
            this.s = new SequentialDisposable();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void a() {
            this.s.dispose();
            Scheduler.Worker worker = this.p;
            if (worker != null) {
                worker.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void b() {
            if (!this.j.get()) {
                this.f = 1;
                this.l.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.e, this);
                this.r = create;
                s6.a.e.d.c.c.b bVar = new s6.a.e.d.c.c.b(create);
                this.a.onNext(bVar);
                a aVar = new a(this, 1);
                if (this.n) {
                    SequentialDisposable sequentialDisposable = this.s;
                    Scheduler.Worker worker = this.p;
                    long j = this.c;
                    sequentialDisposable.replace(worker.schedulePeriodically(aVar, j, j, this.d));
                } else {
                    SequentialDisposable sequentialDisposable2 = this.s;
                    Scheduler scheduler = this.m;
                    long j2 = this.c;
                    sequentialDisposable2.replace(scheduler.schedulePeriodicallyDirect(aVar, j2, j2, this.d));
                }
                if (bVar.e()) {
                    this.r.onComplete();
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x000f */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x007c */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x000f */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.rxjava3.subjects.UnicastSubject<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.subjects.UnicastSubject<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: io.reactivex.rxjava3.subjects.UnicastSubject<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: io.reactivex.rxjava3.subjects.UnicastSubject<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: io.reactivex.rxjava3.subjects.UnicastSubject<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: io.reactivex.rxjava3.subjects.UnicastSubject<T> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: io.reactivex.rxjava3.subjects.UnicastSubject<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.b;
                Observer<? super Observable<T>> observer = this.a;
                UnicastSubject<T> unicastSubject = this.r;
                int i = 1;
                while (true) {
                    if (this.k) {
                        simplePlainQueue.clear();
                        this.r = null;
                        unicastSubject = null;
                    } else {
                        boolean z = this.g;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.h;
                            if (th != null) {
                                if (unicastSubject != 0) {
                                    unicastSubject.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                if (unicastSubject != 0) {
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                            }
                            a();
                            this.k = true;
                        } else if (!z2) {
                            if (poll instanceof a) {
                                if (((a) poll).b == this.f || !this.n) {
                                    this.q = 0;
                                    unicastSubject = f(unicastSubject);
                                }
                            } else if (unicastSubject != null) {
                                unicastSubject.onNext(poll);
                                long j = this.q + 1;
                                if (j == this.o) {
                                    this.q = 0;
                                    unicastSubject = f(unicastSubject);
                                } else {
                                    this.q = j;
                                }
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public UnicastSubject<T> f(UnicastSubject<T> unicastSubject) {
            if (unicastSubject != null) {
                unicastSubject.onComplete();
                unicastSubject = null;
            }
            if (this.j.get()) {
                a();
            } else {
                long j = this.f + 1;
                this.f = j;
                this.l.getAndIncrement();
                unicastSubject = UnicastSubject.create(this.e, this);
                this.r = unicastSubject;
                s6.a.e.d.c.c.b bVar = new s6.a.e.d.c.c.b(unicastSubject);
                this.a.onNext(bVar);
                if (this.n) {
                    SequentialDisposable sequentialDisposable = this.s;
                    Scheduler.Worker worker = this.p;
                    a aVar = new a(this, j);
                    long j2 = this.c;
                    sequentialDisposable.update(worker.schedulePeriodically(aVar, j2, j2, this.d));
                }
                if (bVar.e()) {
                    unicastSubject.onComplete();
                }
            }
            return unicastSubject;
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
        }
    }

    public static final class c<T> extends a<T> implements Runnable {
        public static final Object q = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        public final Scheduler m;
        public UnicastSubject<T> n;
        public final SequentialDisposable o = new SequentialDisposable();
        public final Runnable p = new a();

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e();
            }
        }

        public c(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(observer, j, timeUnit, i);
            this.m = scheduler;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void a() {
            this.o.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void b() {
            if (!this.j.get()) {
                this.l.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.e, this.p);
                this.n = create;
                this.f = 1;
                s6.a.e.d.c.c.b bVar = new s6.a.e.d.c.c.b(create);
                this.a.onNext(bVar);
                SequentialDisposable sequentialDisposable = this.o;
                Scheduler scheduler = this.m;
                long j = this.c;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.d));
                if (bVar.e()) {
                    this.n.onComplete();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: io.reactivex.rxjava3.subjects.UnicastSubject */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.b;
                Observer<? super Observable<T>> observer = this.a;
                UnicastSubject<T> unicastSubject = this.n;
                int i = 1;
                while (true) {
                    if (this.k) {
                        simplePlainQueue.clear();
                        this.n = null;
                        unicastSubject = (UnicastSubject<T>) null;
                    } else {
                        boolean z = this.g;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.h;
                            if (th != null) {
                                if (unicastSubject != null) {
                                    unicastSubject.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                            }
                            this.o.dispose();
                            this.k = true;
                        } else if (!z2) {
                            if (poll == q) {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                    this.n = null;
                                    unicastSubject = (UnicastSubject<T>) null;
                                }
                                if (this.j.get()) {
                                    this.o.dispose();
                                } else {
                                    this.f++;
                                    this.l.getAndIncrement();
                                    unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.e, this.p);
                                    this.n = unicastSubject;
                                    s6.a.e.d.c.c.b bVar = new s6.a.e.d.c.c.b(unicastSubject);
                                    observer.onNext(bVar);
                                    if (bVar.e()) {
                                        unicastSubject.onComplete();
                                    }
                                }
                            } else if (unicastSubject != null) {
                                unicastSubject.onNext(poll);
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.offer(q);
            c();
        }
    }

    public static final class d<T> extends a<T> implements Runnable {
        public static final Object p = new Object();
        public static final Object q = new Object();
        private static final long serialVersionUID = -7852870764194095894L;
        public final long m;
        public final Scheduler.Worker n;
        public final List<UnicastSubject<T>> o = new LinkedList();

        public static final class a implements Runnable {
            public final d<?> a;
            public final boolean b;

            public a(d<?> dVar, boolean z) {
                this.a = dVar;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                d<?> dVar = this.a;
                dVar.b.offer(this.b ? d.p : d.q);
                dVar.c();
            }
        }

        public d(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(observer, j, timeUnit, i);
            this.m = j2;
            this.n = worker;
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void a() {
            this.n.dispose();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void b() {
            if (!this.j.get()) {
                this.f = 1;
                this.l.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.e, this);
                this.o.add(create);
                s6.a.e.d.c.c.b bVar = new s6.a.e.d.c.c.b(create);
                this.a.onNext(bVar);
                this.n.schedule(new a(this, false), this.c, this.d);
                Scheduler.Worker worker = this.n;
                a aVar = new a(this, true);
                long j = this.m;
                worker.schedulePeriodically(aVar, j, j, this.d);
                if (bVar.e()) {
                    create.onComplete();
                    this.o.remove(create);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed.a
        public void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.b;
                Observer<? super Observable<T>> observer = this.a;
                List<UnicastSubject<T>> list = this.o;
                int i = 1;
                while (true) {
                    if (this.k) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.g;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.h;
                            if (th != null) {
                                for (UnicastSubject<T> unicastSubject : list) {
                                    unicastSubject.onError(th);
                                }
                                observer.onError(th);
                            } else {
                                for (UnicastSubject<T> unicastSubject2 : list) {
                                    unicastSubject2.onComplete();
                                }
                                observer.onComplete();
                            }
                            this.n.dispose();
                            this.k = true;
                        } else if (!z2) {
                            if (poll == p) {
                                if (!this.j.get()) {
                                    this.f++;
                                    this.l.getAndIncrement();
                                    UnicastSubject<T> create = UnicastSubject.create(this.e, this);
                                    list.add(create);
                                    s6.a.e.d.c.c.b bVar = new s6.a.e.d.c.c.b(create);
                                    observer.onNext(bVar);
                                    this.n.schedule(new a(this, false), this.c, this.d);
                                    if (bVar.e()) {
                                        create.onComplete();
                                    }
                                }
                            } else if (poll != q) {
                                for (UnicastSubject<T> unicastSubject3 : list) {
                                    unicastSubject3.onNext(poll);
                                }
                            } else if (!list.isEmpty()) {
                                list.remove(0).onComplete();
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
        }
    }

    public ObservableWindowTimed(Observable<T> observable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(observable);
        this.a = j;
        this.b = j2;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = j3;
        this.f = i;
        this.g = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.a != this.b) {
            this.source.subscribe(new d(observer, this.a, this.b, this.c, this.d.createWorker(), this.f));
        } else if (this.e == Long.MAX_VALUE) {
            this.source.subscribe(new c(observer, this.a, this.c, this.d, this.f));
        } else {
            this.source.subscribe(new b(observer, this.a, this.c, this.d, this.f, this.e, this.g));
        }
    }
}
