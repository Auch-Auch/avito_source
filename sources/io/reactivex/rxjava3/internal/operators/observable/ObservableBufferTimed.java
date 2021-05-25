package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.QueueDrainObserver;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends s6.a.e.d.c.c.a<T, U> {
    public final long a;
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final Supplier<U> e;
    public final int f;
    public final boolean g;

    public static final class a<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        public final Supplier<U> b;
        public final long c;
        public final TimeUnit d;
        public final int e;
        public final boolean f;
        public final Scheduler.Worker g;
        public U h;
        public Disposable i;
        public Disposable j;
        public long k;
        public long l;

        public a(Observer<? super U> observer, Supplier<U> supplier, long j2, TimeUnit timeUnit, int i2, boolean z, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.b = supplier;
            this.c = j2;
            this.d = timeUnit;
            this.e = i2;
            this.f = z;
            this.g = worker;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.rxjava3.core.Observer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.observers.QueueDrainObserver, io.reactivex.rxjava3.internal.util.ObservableQueueDrain
        public void accept(Observer observer, Object obj) {
            observer.onNext((Collection) obj);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.j.dispose();
                this.g.dispose();
                synchronized (this) {
                    this.h = null;
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            U u;
            this.g.dispose();
            synchronized (this) {
                u = this.h;
                this.h = null;
            }
            if (u != null) {
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this, this);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.h = null;
            }
            this.downstream.onError(th);
            this.g.dispose();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            U u;
            synchronized (this) {
                u = this.h;
                if (u != null) {
                    u.add(t);
                    if (u.size() >= this.e) {
                        this.h = null;
                        this.k++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.f) {
                this.i.dispose();
            }
            fastPathOrderedEmit(u, false, this);
            try {
                U u2 = this.b.get();
                Objects.requireNonNull(u2, "The buffer supplied is null");
                U u3 = u2;
                synchronized (this) {
                    this.h = u3;
                    this.l++;
                }
                if (this.f) {
                    Scheduler.Worker worker = this.g;
                    long j2 = this.c;
                    this.i = worker.schedulePeriodically(this, j2, j2, this.d);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
                dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.j, disposable)) {
                this.j = disposable;
                try {
                    U u = this.b.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    this.h = u;
                    this.downstream.onSubscribe(this);
                    Scheduler.Worker worker = this.g;
                    long j2 = this.c;
                    this.i = worker.schedulePeriodically(this, j2, j2, this.d);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.downstream);
                    this.g.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = this.b.get();
                Objects.requireNonNull(u, "The bufferSupplier returned a null buffer");
                U u2 = u;
                synchronized (this) {
                    U u3 = this.h;
                    if (u3 != null) {
                        if (this.k == this.l) {
                            this.h = u2;
                            fastPathOrderedEmit(u3, false, this);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.downstream.onError(th);
            }
        }
    }

    public static final class b<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        public final Supplier<U> b;
        public final long c;
        public final TimeUnit d;
        public final Scheduler e;
        public Disposable f;
        public U g;
        public final AtomicReference<Disposable> h = new AtomicReference<>();

        public b(Observer<? super U> observer, Supplier<U> supplier, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.b = supplier;
            this.c = j;
            this.d = timeUnit;
            this.e = scheduler;
        }

        @Override // io.reactivex.rxjava3.internal.observers.QueueDrainObserver, io.reactivex.rxjava3.internal.util.ObservableQueueDrain
        public void accept(Observer observer, Object obj) {
            this.downstream.onNext((Collection) obj);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.h);
            this.f.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.h.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.g;
                this.g = null;
            }
            if (u != null) {
                this.queue.offer(u);
                this.done = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.queue, this.downstream, false, null, this);
                }
            }
            DisposableHelper.dispose(this.h);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.g = null;
            }
            this.downstream.onError(th);
            DisposableHelper.dispose(this.h);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.g;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                try {
                    U u = this.b.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    this.g = u;
                    this.downstream.onSubscribe(this);
                    if (!DisposableHelper.isDisposed(this.h.get())) {
                        Scheduler scheduler = this.e;
                        long j = this.c;
                        DisposableHelper.set(this.h, scheduler.schedulePeriodicallyDirect(this, j, j, this.d));
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    EmptyDisposable.error(th, this.downstream);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = this.b.get();
                Objects.requireNonNull(u2, "The bufferSupplier returned a null buffer");
                U u3 = u2;
                synchronized (this) {
                    u = this.g;
                    if (u != null) {
                        this.g = u3;
                    }
                }
                if (u == null) {
                    DisposableHelper.dispose(this.h);
                } else {
                    fastPathEmit(u, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
                dispose();
            }
        }
    }

    public static final class c<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        public final Supplier<U> b;
        public final long c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public final List<U> g = new LinkedList();
        public Disposable h;

        /* JADX WARN: Field signature parse error: a */
        public final class a implements Runnable {
            public final Collection a;

            /* JADX WARN: Failed to parse method signature: (TU)V */
            public a(Collection collection) {
                this.a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.g.remove(this.a);
                }
                c cVar = c.this;
                cVar.fastPathOrderedEmit(this.a, false, cVar.f);
            }
        }

        /* JADX WARN: Field signature parse error: a */
        public final class b implements Runnable {
            public final Collection a;

            /* JADX WARN: Failed to parse method signature: (TU)V */
            public b(Collection collection) {
                this.a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.g.remove(this.a);
                }
                c cVar = c.this;
                cVar.fastPathOrderedEmit(this.a, false, cVar.f);
            }
        }

        public c(Observer<? super U> observer, Supplier<U> supplier, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.b = supplier;
            this.c = j;
            this.d = j2;
            this.e = timeUnit;
            this.f = worker;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.rxjava3.core.Observer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.internal.observers.QueueDrainObserver, io.reactivex.rxjava3.internal.util.ObservableQueueDrain
        public void accept(Observer observer, Object obj) {
            observer.onNext((Collection) obj);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                synchronized (this) {
                    this.g.clear();
                }
                this.h.dispose();
                this.f.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.g);
                this.g.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.queue.offer((Collection) it.next());
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this.f, this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.done = true;
            synchronized (this) {
                this.g.clear();
            }
            this.downstream.onError(th);
            this.f.dispose();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            synchronized (this) {
                for (U u : this.g) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                try {
                    U u = this.b.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    U u2 = u;
                    this.g.add(u2);
                    this.downstream.onSubscribe(this);
                    Scheduler.Worker worker = this.f;
                    long j = this.d;
                    worker.schedulePeriodically(this, j, j, this.e);
                    this.f.schedule(new b(u2), this.c, this.e);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.downstream);
                    this.f.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cancelled) {
                try {
                    U u = this.b.get();
                    Objects.requireNonNull(u, "The bufferSupplier returned a null buffer");
                    U u2 = u;
                    synchronized (this) {
                        if (!this.cancelled) {
                            this.g.add(u2);
                            this.f.schedule(new a(u2), this.c, this.e);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                    dispose();
                }
            }
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Supplier<U> supplier, int i, boolean z) {
        super(observableSource);
        this.a = j;
        this.b = j2;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = supplier;
        this.f = i;
        this.g = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (this.a == this.b && this.f == Integer.MAX_VALUE) {
            this.source.subscribe(new b(new SerializedObserver(observer), this.e, this.a, this.c, this.d));
            return;
        }
        Scheduler.Worker createWorker = this.d.createWorker();
        if (this.a == this.b) {
            this.source.subscribe(new a(new SerializedObserver(observer), this.e, this.a, this.c, this.f, this.g, createWorker));
        } else {
            this.source.subscribe(new c(new SerializedObserver(observer), this.e, this.a, this.b, this.c, createWorker));
        }
    }
}
