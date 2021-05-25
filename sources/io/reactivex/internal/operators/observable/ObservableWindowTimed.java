package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public final class ObservableWindowTimed<T> extends s6.a.c.b.c.a<T, Observable<T>> {
    public final long a;
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final long e;
    public final int f;
    public final boolean g;

    public static final class a<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final int e;
        public final boolean f;
        public final long g;
        public final Scheduler.Worker h;
        public long i;
        public long j;
        public Disposable k;
        public UnicastSubject<T> l;
        public volatile boolean m;
        public final SequentialDisposable n = new SequentialDisposable();

        /* renamed from: io.reactivex.internal.operators.observable.ObservableWindowTimed$a$a  reason: collision with other inner class name */
        public static final class RunnableC0430a implements Runnable {
            public final long a;
            public final a<?> b;

            public RunnableC0430a(long j, a<?> aVar) {
                this.a = j;
                this.b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.b;
                if (!aVar.cancelled) {
                    aVar.queue.offer(this);
                } else {
                    aVar.m = true;
                }
                if (aVar.enter()) {
                    aVar.a();
                }
            }
        }

        public a(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, long j3, boolean z) {
            super(observer, new MpscLinkedQueue());
            this.b = j2;
            this.c = timeUnit;
            this.d = scheduler;
            this.e = i2;
            this.g = j3;
            this.f = z;
            if (z) {
                this.h = scheduler.createWorker();
            } else {
                this.h = null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: io.reactivex.subjects.UnicastSubject */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.downstream;
            UnicastSubject<T> unicastSubject = this.l;
            int i2 = 1;
            while (!this.m) {
                boolean z = this.done;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof RunnableC0430a;
                if (z && (z2 || z3)) {
                    this.l = null;
                    mpscLinkedQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        unicastSubject.onError(th);
                    } else {
                        unicastSubject.onComplete();
                    }
                    DisposableHelper.dispose(this.n);
                    Scheduler.Worker worker = this.h;
                    if (worker != null) {
                        worker.dispose();
                        return;
                    }
                    return;
                } else if (z2) {
                    i2 = leave(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    RunnableC0430a aVar = (RunnableC0430a) poll;
                    if (!this.f || this.j == aVar.a) {
                        unicastSubject.onComplete();
                        this.i = 0;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.e);
                        this.l = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j2 = this.i + 1;
                    if (j2 >= this.g) {
                        this.j++;
                        this.i = 0;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.e);
                        this.l = unicastSubject;
                        this.downstream.onNext(unicastSubject);
                        if (this.f) {
                            Disposable disposable = (Disposable) this.n.get();
                            disposable.dispose();
                            Scheduler.Worker worker2 = this.h;
                            RunnableC0430a aVar2 = new RunnableC0430a(this.j, this);
                            long j3 = this.b;
                            Disposable schedulePeriodically = worker2.schedulePeriodically(aVar2, j3, j3, this.c);
                            if (!this.n.compareAndSet(disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.i = j2;
                    }
                }
            }
            this.k.dispose();
            mpscLinkedQueue.clear();
            DisposableHelper.dispose(this.n);
            Scheduler.Worker worker3 = this.h;
            if (worker3 != null) {
                worker3.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.m) {
                if (fastEnter()) {
                    UnicastSubject<T> unicastSubject = this.l;
                    unicastSubject.onNext(t);
                    long j2 = this.i + 1;
                    if (j2 >= this.g) {
                        this.j++;
                        this.i = 0;
                        unicastSubject.onComplete();
                        UnicastSubject<T> create = UnicastSubject.create(this.e);
                        this.l = create;
                        this.downstream.onNext(create);
                        if (this.f) {
                            ((Disposable) this.n.get()).dispose();
                            Scheduler.Worker worker = this.h;
                            RunnableC0430a aVar = new RunnableC0430a(this.j, this);
                            long j3 = this.b;
                            DisposableHelper.replace(this.n, worker.schedulePeriodically(aVar, j3, j3, this.c));
                        }
                    } else {
                        this.i = j2;
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer((U) NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                a();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Disposable disposable2;
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                Observer<? super V> observer = this.downstream;
                observer.onSubscribe(this);
                if (!this.cancelled) {
                    UnicastSubject<T> create = UnicastSubject.create(this.e);
                    this.l = create;
                    observer.onNext(create);
                    RunnableC0430a aVar = new RunnableC0430a(this.j, this);
                    if (this.f) {
                        Scheduler.Worker worker = this.h;
                        long j2 = this.b;
                        disposable2 = worker.schedulePeriodically(aVar, j2, j2, this.c);
                    } else {
                        Scheduler scheduler = this.d;
                        long j3 = this.b;
                        disposable2 = scheduler.schedulePeriodicallyDirect(aVar, j3, j3, this.c);
                    }
                    this.n.replace(disposable2);
                }
            }
        }
    }

    public static final class b<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        public static final Object j = new Object();
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final int e;
        public Disposable f;
        public UnicastSubject<T> g;
        public final SequentialDisposable h = new SequentialDisposable();
        public volatile boolean i;

        public b(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
            super(observer, new MpscLinkedQueue());
            this.b = j2;
            this.c = timeUnit;
            this.d = scheduler;
            this.e = i2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: io.reactivex.subjects.UnicastSubject */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.downstream;
            UnicastSubject<T> unicastSubject = this.g;
            int i2 = 1;
            while (true) {
                boolean z = this.i;
                boolean z2 = this.done;
                Object poll = mpscLinkedQueue.poll();
                if (!z2 || !(poll == null || poll == j)) {
                    if (poll == null) {
                        i2 = leave(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (poll == j) {
                        unicastSubject.onComplete();
                        if (!z) {
                            unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.e);
                            this.g = unicastSubject;
                            observer.onNext(unicastSubject);
                        } else {
                            this.f.dispose();
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.g = null;
            mpscLinkedQueue.clear();
            Throwable th = this.error;
            if (th != null) {
                unicastSubject.onError(th);
            } else {
                unicastSubject.onComplete();
            }
            this.h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.i) {
                if (fastEnter()) {
                    this.g.onNext(t);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer((U) NotificationLite.next(t));
                    if (!enter()) {
                        return;
                    }
                }
                a();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.g = UnicastSubject.create(this.e);
                Observer<? super V> observer = this.downstream;
                observer.onSubscribe(this);
                observer.onNext(this.g);
                if (!this.cancelled) {
                    Scheduler scheduler = this.d;
                    long j2 = this.b;
                    this.h.replace(scheduler.schedulePeriodicallyDirect(this, j2, j2, this.c));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.i = true;
            }
            this.queue.offer((U) j);
            if (enter()) {
                a();
            }
        }
    }

    public static final class c<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        public final long b;
        public final long c;
        public final TimeUnit d;
        public final Scheduler.Worker e;
        public final int f;
        public final List<UnicastSubject<T>> g = new LinkedList();
        public Disposable h;
        public volatile boolean i;

        public final class a implements Runnable {
            public final UnicastSubject<T> a;

            public a(UnicastSubject<T> unicastSubject) {
                this.a = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.queue.offer((U) new b(this.a, false));
                if (cVar.enter()) {
                    cVar.a();
                }
            }
        }

        public static final class b<T> {
            public final UnicastSubject<T> a;
            public final boolean b;

            public b(UnicastSubject<T> unicastSubject, boolean z) {
                this.a = unicastSubject;
                this.b = z;
            }
        }

        public c(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i2) {
            super(observer, new MpscLinkedQueue());
            this.b = j;
            this.c = j2;
            this.d = timeUnit;
            this.e = worker;
            this.f = i2;
        }

        public void a() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.downstream;
            List<UnicastSubject<T>> list = this.g;
            int i2 = 1;
            while (!this.i) {
                boolean z = this.done;
                T t = (T) mpscLinkedQueue.poll();
                boolean z2 = t == null;
                boolean z3 = t instanceof b;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastSubject<T> unicastSubject : list) {
                            unicastSubject.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> unicastSubject2 : list) {
                            unicastSubject2.onComplete();
                        }
                    }
                    list.clear();
                    this.e.dispose();
                    return;
                } else if (z2) {
                    i2 = leave(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    T t2 = t;
                    if (!t2.b) {
                        list.remove(t2.a);
                        t2.a.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.i = true;
                        }
                    } else if (!this.cancelled) {
                        UnicastSubject<T> create = UnicastSubject.create(this.f);
                        list.add(create);
                        observer.onNext(create);
                        this.e.schedule(new a(create), this.b, this.d);
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject3 : list) {
                        unicastSubject3.onNext(t);
                    }
                }
            }
            this.h.dispose();
            mpscLinkedQueue.clear();
            list.clear();
            this.e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (fastEnter()) {
                for (UnicastSubject<T> unicastSubject : this.g) {
                    unicastSubject.onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    UnicastSubject<T> create = UnicastSubject.create(this.f);
                    this.g.add(create);
                    this.downstream.onNext(create);
                    this.e.schedule(new a(create), this.b, this.d);
                    Scheduler.Worker worker = this.e;
                    long j = this.c;
                    worker.schedulePeriodically(this, j, j, this.d);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(UnicastSubject.create(this.f), true);
            if (!this.cancelled) {
                this.queue.offer(bVar);
            }
            if (enter()) {
                a();
            }
        }
    }

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(observableSource);
        this.a = j;
        this.b = j2;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = j3;
        this.f = i;
        this.g = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        long j = this.a;
        long j2 = this.b;
        if (j == j2) {
            long j3 = this.e;
            if (j3 == Long.MAX_VALUE) {
                this.source.subscribe(new b(serializedObserver, this.a, this.c, this.d, this.f));
            } else {
                this.source.subscribe(new a(serializedObserver, j, this.c, this.d, this.f, j3, this.g));
            }
        } else {
            this.source.subscribe(new c(serializedObserver, j, j2, this.c, this.d.createWorker(), this.f));
        }
    }
}
