package com.google.common.util.concurrent;

import a2.j.d.l.a.y;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public abstract class AbstractScheduledService implements Service {
    public static final Logger b = Logger.getLogger(AbstractScheduledService.class.getName());
    public final AbstractService a = new c(null);

    @Beta
    public static abstract class CustomScheduler extends Scheduler {

        @Beta
        public static final class Schedule {
            public final long a;
            public final TimeUnit b;

            public Schedule(long j, TimeUnit timeUnit) {
                this.a = j;
                this.b = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }
        }

        public class a extends ForwardingFuture<Void> implements Callable<Void> {
            public final Runnable a;
            public final ScheduledExecutorService b;
            public final AbstractService c;
            public final ReentrantLock d = new ReentrantLock();
            @NullableDecl
            @GuardedBy("lock")
            public Future<Void> e;

            public a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.a = runnable;
                this.b = scheduledExecutorService;
                this.c = abstractService;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                this.a.run();
                d();
                return null;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                this.d.lock();
                try {
                    return this.e.cancel(z);
                } finally {
                    this.d.unlock();
                }
            }

            public void d() {
                try {
                    Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                    Throwable th = null;
                    this.d.lock();
                    try {
                        Future<Void> future = this.e;
                        if (future == null || !future.isCancelled()) {
                            this.e = this.b.schedule(this, nextSchedule.a, nextSchedule.b);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    this.d.unlock();
                    if (th != null) {
                        this.c.notifyFailed(th);
                    }
                } catch (Throwable th3) {
                    this.c.notifyFailed(th3);
                }
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean isCancelled() {
                this.d.lock();
                try {
                    return this.e.isCancelled();
                } finally {
                    this.d.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
            /* renamed from: delegate */
            public Future<Void> mo147delegate() {
                throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
            }
        }

        public CustomScheduler() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        public final Future<?> a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            a aVar = new a(abstractService, scheduledExecutorService, runnable);
            aVar.d();
            return aVar;
        }

        public abstract Schedule getNextSchedule() throws Exception;
    }

    public static abstract class Scheduler {

        public static class a extends Scheduler {
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TimeUnit c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(long j, long j2, TimeUnit timeUnit) {
                super(null);
                this.a = j;
                this.b = j2;
                this.c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public Future<?> a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return scheduledExecutorService.scheduleWithFixedDelay(runnable, this.a, this.b, this.c);
            }
        }

        public static class b extends Scheduler {
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TimeUnit c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(long j, long j2, TimeUnit timeUnit) {
                super(null);
                this.a = j;
                this.b = j2;
                this.c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public Future<?> a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                return scheduledExecutorService.scheduleAtFixedRate(runnable, this.a, this.b, this.c);
            }
        }

        public Scheduler() {
        }

        public static Scheduler newFixedDelaySchedule(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "delay must be > 0, found %s", j2);
            return new a(j, j2, timeUnit);
        }

        public static Scheduler newFixedRateSchedule(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "period must be > 0, found %s", j2);
            return new b(j, j2, timeUnit);
        }

        public abstract Future<?> a(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public Scheduler(a aVar) {
        }
    }

    public class a extends Service.Listener {
        public final /* synthetic */ ScheduledExecutorService a;

        public a(AbstractScheduledService abstractScheduledService, ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State state, Throwable th) {
            this.a.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State state) {
            this.a.shutdown();
        }
    }

    public class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return MoreExecutors.c(AbstractScheduledService.this.serviceName(), runnable);
        }
    }

    public final class c extends AbstractService {
        @MonotonicNonNullDecl
        public volatile Future<?> p;
        @MonotonicNonNullDecl
        public volatile ScheduledExecutorService q;
        public final ReentrantLock r = new ReentrantLock();
        public final Runnable s = new d();

        public class a implements Supplier<String> {
            public a() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.google.common.base.Supplier
            public String get() {
                return AbstractScheduledService.this.serviceName() + " " + c.this.state();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                c.this.r.lock();
                try {
                    AbstractScheduledService.this.startUp();
                    c cVar2 = c.this;
                    Scheduler scheduler = AbstractScheduledService.this.scheduler();
                    c cVar3 = c.this;
                    cVar2.p = scheduler.a(AbstractScheduledService.this.a, cVar3.q, c.this.s);
                    c.this.notifyStarted();
                    cVar = c.this;
                } catch (Throwable th) {
                    c.this.r.unlock();
                    throw th;
                }
                cVar.r.unlock();
            }
        }

        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$c$c  reason: collision with other inner class name */
        public class RunnableC0299c implements Runnable {
            public RunnableC0299c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.r.lock();
                    try {
                        if (c.this.state() == Service.State.STOPPING) {
                            AbstractScheduledService.this.shutDown();
                            c.this.r.unlock();
                            c.this.notifyStopped();
                        }
                    } finally {
                        c.this.r.unlock();
                    }
                } catch (Throwable th) {
                    c.this.notifyFailed(th);
                }
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                c.this.r.lock();
                try {
                    if (c.this.p.isCancelled()) {
                        c.this.r.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                    cVar = c.this;
                    cVar.r.unlock();
                } catch (Throwable th) {
                    c.this.r.unlock();
                    throw th;
                }
            }
        }

        public c(a aVar) {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            ScheduledExecutorService executor = AbstractScheduledService.this.executor();
            a aVar = new a();
            Preconditions.checkNotNull(executor);
            Preconditions.checkNotNull(aVar);
            if (!MoreExecutors.b()) {
                executor = new y(executor, aVar);
            }
            this.q = executor;
            this.q.execute(new b());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            this.p.cancel(false);
            this.q.execute(new RunnableC0299c());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.a.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.a.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.a.awaitTerminated();
    }

    public ScheduledExecutorService executor() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new b());
        addListener(new a(this, newSingleThreadScheduledExecutor), MoreExecutors.directExecutor());
        return newSingleThreadScheduledExecutor;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.a.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.a.isRunning();
    }

    public abstract void runOneIteration() throws Exception;

    public abstract Scheduler scheduler();

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.a.startAsync();
        return this;
    }

    public void startUp() throws Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.a.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.a.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.a.awaitTerminated(j, timeUnit);
    }
}
