package hu.akarnokd.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public final class BlockingScheduler extends Scheduler {
    public static final Action j = new a();
    public final ConcurrentLinkedQueue<Action> b = new ConcurrentLinkedQueue<>();
    public final AtomicLong c;
    public final Lock d;
    public final Condition e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final Scheduler h;
    public volatile Thread i;

    public class a implements Action {
        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws Exception {
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ SequentialDisposable a;
        public final /* synthetic */ c b;

        public b(SequentialDisposable sequentialDisposable, c cVar) {
            this.a = sequentialDisposable;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.replace(this.b);
            BlockingScheduler.this.b(this.b);
        }
    }

    public final class c extends AtomicInteger implements Action, Disposable {
        private static final long serialVersionUID = -9165914884456950194L;
        public final Runnable a;

        public c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            do {
                int i = get();
                if (i < 2) {
                    if (i == 0 && compareAndSet(0, 5)) {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(1, 2));
            Thread thread = BlockingScheduler.this.i;
            if (thread != null) {
                thread.interrupt();
            }
            set(3);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() >= 2;
        }

        /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
            java.lang.StackOverflowError
            	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
            	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
            	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
            */
        @Override // io.reactivex.rxjava3.functions.Action
        public void run() throws java.lang.Exception {
            /*
                r5 = this;
                r0 = 0
                r1 = 3
                r2 = 2
                r3 = 1
                boolean r0 = r5.compareAndSet(r0, r3)     // Catch:{ all -> 0x002a }
                if (r0 == 0) goto L_0x0019
                r0 = 4
                java.lang.Runnable r4 = r5.a     // Catch:{ all -> 0x0014 }
                r4.run()     // Catch:{ all -> 0x0014 }
                r5.compareAndSet(r3, r0)
                goto L_0x0019
            L_0x0014:
                r4 = move-exception
                r5.compareAndSet(r3, r0)
                throw r4
            L_0x0019:
                int r0 = r5.get()
                if (r0 != r2) goto L_0x0020
                goto L_0x0019
            L_0x0020:
                int r0 = r5.get()
                if (r0 != r1) goto L_0x0029
                java.lang.Thread.interrupted()
            L_0x0029:
                return
            L_0x002a:
                r0 = move-exception
            L_0x002b:
                int r3 = r5.get()
                if (r3 != r2) goto L_0x0032
                goto L_0x002b
            L_0x0032:
                int r2 = r5.get()
                if (r2 != r1) goto L_0x003b
                java.lang.Thread.interrupted()
            L_0x003b:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: hu.akarnokd.rxjava3.schedulers.BlockingScheduler.c.run():void");
        }
    }

    public final class d extends Scheduler.Worker {
        public final CompositeDisposable a = new CompositeDisposable();

        public class a implements Runnable {
            public final /* synthetic */ SequentialDisposable a;
            public final /* synthetic */ b b;

            public a(SequentialDisposable sequentialDisposable, b bVar) {
                this.a = sequentialDisposable;
                this.b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.replace(this.b);
                BlockingScheduler.this.b(this.b);
            }
        }

        public final class b extends AtomicInteger implements Action, Disposable {
            private static final long serialVersionUID = -9165914884456950194L;
            public final Runnable a;

            public b(Runnable runnable) {
                this.a = runnable;
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i < 2) {
                        if (i == 0 && compareAndSet(0, 5)) {
                            break;
                        } else if (compareAndSet(1, 2)) {
                            Thread thread = BlockingScheduler.this.i;
                            if (thread != null) {
                                thread.interrupt();
                            }
                            set(3);
                        }
                    } else {
                        return;
                    }
                }
                d.this.a.remove(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get() >= 2;
            }

            /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
                java.lang.StackOverflowError
                	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
                	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
                	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
                	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
                */
            @Override // io.reactivex.rxjava3.functions.Action
            public void run() throws java.lang.Exception {
                /*
                    r5 = this;
                    r0 = 0
                    r1 = 3
                    r2 = 2
                    r3 = 1
                    boolean r0 = r5.compareAndSet(r0, r3)     // Catch:{ all -> 0x0038 }
                    if (r0 == 0) goto L_0x0027
                    r0 = 4
                    java.lang.Runnable r4 = r5.a     // Catch:{ all -> 0x001b }
                    r4.run()     // Catch:{ all -> 0x001b }
                    r5.compareAndSet(r3, r0)
                    hu.akarnokd.rxjava3.schedulers.BlockingScheduler$d r0 = hu.akarnokd.rxjava3.schedulers.BlockingScheduler.d.this
                    io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r0.a
                    r0.remove(r5)
                    goto L_0x0027
                L_0x001b:
                    r4 = move-exception
                    r5.compareAndSet(r3, r0)
                    hu.akarnokd.rxjava3.schedulers.BlockingScheduler$d r0 = hu.akarnokd.rxjava3.schedulers.BlockingScheduler.d.this
                    io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r0.a
                    r0.remove(r5)
                    throw r4
                L_0x0027:
                    int r0 = r5.get()
                    if (r0 != r2) goto L_0x002e
                    goto L_0x0027
                L_0x002e:
                    int r0 = r5.get()
                    if (r0 != r1) goto L_0x0037
                    java.lang.Thread.interrupted()
                L_0x0037:
                    return
                L_0x0038:
                    r0 = move-exception
                L_0x0039:
                    int r3 = r5.get()
                    if (r3 != r2) goto L_0x0040
                    goto L_0x0039
                L_0x0040:
                    int r2 = r5.get()
                    if (r2 != r1) goto L_0x0049
                    java.lang.Thread.interrupted()
                L_0x0049:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: hu.akarnokd.rxjava3.schedulers.BlockingScheduler.d.b.run():void");
            }
        }

        public d() {
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.a.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.a.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run is null");
            Objects.requireNonNull(timeUnit, "unit is null");
            if (BlockingScheduler.this.g.get() || isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable);
            this.a.add(bVar);
            if (j == 0) {
                BlockingScheduler.this.b(bVar);
                return bVar;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Disposable scheduleDirect = BlockingScheduler.this.h.scheduleDirect(new a(sequentialDisposable2, bVar), j, timeUnit);
            if (scheduleDirect == EmptyDisposable.INSTANCE) {
                return scheduleDirect;
            }
            sequentialDisposable.replace(scheduleDirect);
            return sequentialDisposable2;
        }
    }

    public BlockingScheduler() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.d = reentrantLock;
        this.e = reentrantLock.newCondition();
        this.f = new AtomicBoolean();
        this.g = new AtomicBoolean();
        this.c = new AtomicLong();
        this.h = Schedulers.single();
    }

    public void a() {
        ConcurrentLinkedQueue<Action> concurrentLinkedQueue = this.b;
        while (true) {
            Action poll = concurrentLinkedQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof Disposable) {
                ((Disposable) poll).dispose();
            }
        }
    }

    public void b(Action action) {
        this.b.offer(action);
        if (this.c.getAndIncrement() == 0) {
            this.d.lock();
            try {
                this.e.signal();
            } finally {
                this.d.unlock();
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new d();
    }

    public void execute() {
        execute(Functions.EMPTY_ACTION);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j2, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        if (this.g.get()) {
            return EmptyDisposable.INSTANCE;
        }
        c cVar = new c(runnable);
        if (j2 == 0) {
            b(cVar);
            return cVar;
        }
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
        Disposable scheduleDirect = this.h.scheduleDirect(new b(sequentialDisposable2, cVar), j2, timeUnit);
        if (scheduleDirect == EmptyDisposable.INSTANCE) {
            return scheduleDirect;
        }
        sequentialDisposable.replace(scheduleDirect);
        return sequentialDisposable2;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void shutdown() {
        if (this.g.compareAndSet(false, true)) {
            b(j);
        }
    }

    public void execute(Action action) {
        Objects.requireNonNull(action, "action is null");
        if (!this.f.get() && this.f.compareAndSet(false, true)) {
            this.i = Thread.currentThread();
            this.b.offer(action);
            this.c.getAndIncrement();
            AtomicBoolean atomicBoolean = this.g;
            AtomicLong atomicLong = this.c;
            while (!atomicBoolean.get()) {
                do {
                    Action poll = this.b.poll();
                    if (poll == j) {
                        a();
                        return;
                    }
                    try {
                        poll.run();
                    } catch (Throwable th) {
                        RxJavaPlugins.onError(th);
                    }
                } while (atomicLong.decrementAndGet() != 0);
                if (atomicLong.get() == 0 && !atomicBoolean.get()) {
                    this.d.lock();
                    while (atomicLong.get() == 0 && !atomicBoolean.get()) {
                        try {
                            this.e.await();
                        } catch (InterruptedException unused) {
                        } catch (Throwable th2) {
                            this.d.unlock();
                            throw th2;
                        }
                    }
                    this.d.unlock();
                }
            }
            a();
        }
    }
}
