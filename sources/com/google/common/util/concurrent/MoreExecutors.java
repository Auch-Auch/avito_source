package com.google.common.util.concurrent;

import a2.j.d.l.a.a0;
import a2.j.d.l.a.g0;
import a2.j.d.l.a.k;
import a2.j.d.l.a.n;
import a2.j.d.l.a.x;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@GwtCompatible(emulated = true)
public final class MoreExecutors {

    public static class a implements Executor {
        public final /* synthetic */ Executor a;
        public final /* synthetic */ Supplier b;

        public a(Executor executor, Supplier supplier) {
            this.a = executor;
            this.b = supplier;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Executor executor = this.a;
            Supplier supplier = this.b;
            Preconditions.checkNotNull(supplier);
            Preconditions.checkNotNull(runnable);
            executor.execute(new k(supplier, runnable));
        }
    }

    public static class b implements Executor {
        public boolean a = true;
        public final /* synthetic */ Executor b;
        public final /* synthetic */ AbstractFuture c;

        public class a implements Runnable {
            public final /* synthetic */ Runnable a;

            public a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a = false;
                this.a.run();
            }
        }

        public b(Executor executor, AbstractFuture abstractFuture) {
            this.b = executor;
            this.c = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.b.execute(new a(runnable));
            } catch (RejectedExecutionException e) {
                if (this.a) {
                    this.c.setException(e);
                }
            }
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    public static class c {

        public class a implements Runnable {
            public final /* synthetic */ ExecutorService a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TimeUnit c;

            public a(c cVar, ExecutorService executorService, long j, TimeUnit timeUnit) {
                this.a = executorService;
                this.b = j;
                this.c = timeUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.a.shutdown();
                    this.a.awaitTermination(this.b, this.c);
                } catch (InterruptedException unused) {
                }
            }
        }

        public final void a(ExecutorService executorService, long j, TimeUnit timeUnit) {
            Preconditions.checkNotNull(executorService);
            Preconditions.checkNotNull(timeUnit);
            Runtime.getRuntime().addShutdownHook(MoreExecutors.c("DelayedShutdownHook-for-" + executorService, new a(this, executorService, j, timeUnit)));
        }
    }

    @GwtIncompatible
    public static final class d extends AbstractListeningExecutorService {
        public final Object a = new Object();
        @GuardedBy("lock")
        public int b = 0;
        @GuardedBy("lock")
        public boolean c = false;

        public d(x xVar) {
        }

        public final void a() {
            synchronized (this.a) {
                int i = this.b - 1;
                this.b = i;
                if (i == 0) {
                    this.a.notifyAll();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j);
            synchronized (this.a) {
                while (true) {
                    if (this.c && this.b == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long nanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.a, nanos);
                    nanos -= System.nanoTime() - nanoTime;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            synchronized (this.a) {
                if (!this.c) {
                    this.b++;
                } else {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
            }
            try {
                runnable.run();
            } finally {
                a();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            boolean z;
            synchronized (this.a) {
                z = this.c;
            }
            return z;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            boolean z;
            synchronized (this.a) {
                z = this.c && this.b == 0;
            }
            return z;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            synchronized (this.a) {
                this.c = true;
                if (this.b == 0) {
                    this.a.notifyAll();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }
    }

    @GwtIncompatible
    public static class e extends AbstractListeningExecutorService {
        public final ExecutorService a;

        public e(ExecutorService executorService) {
            this.a = (ExecutorService) Preconditions.checkNotNull(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.a.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.a.shutdownNow();
        }
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }

    @Beta
    @GwtIncompatible
    public static void addDelayedShutdownHook(ExecutorService executorService, long j, TimeUnit timeUnit) {
        new c().a(executorService, j, timeUnit);
    }

    @GwtIncompatible
    public static boolean b() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @GwtIncompatible
    public static Thread c(String str, Runnable runnable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(runnable);
        Thread newThread = platformThreadFactory().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    public static Executor d(Executor executor, AbstractFuture<?> abstractFuture) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(abstractFuture);
        if (executor == directExecutor()) {
            return executor;
        }
        return new b(executor, abstractFuture);
    }

    public static Executor directExecutor() {
        return n.INSTANCE;
    }

    @GwtIncompatible
    public static Executor e(Executor executor, Supplier<String> supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        if (b()) {
            return executor;
        }
        return new a(executor, supplier);
    }

    @Beta
    @GwtIncompatible
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
        c cVar = new c();
        a(threadPoolExecutor);
        ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
        cVar.a(threadPoolExecutor, j, timeUnit);
        return unconfigurableExecutorService;
    }

    @Beta
    @GwtIncompatible
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
        c cVar = new c();
        a(scheduledThreadPoolExecutor);
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
        cVar.a(scheduledThreadPoolExecutor, j, timeUnit);
        return unconfigurableScheduledExecutorService;
    }

    @GwtIncompatible
    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new f((ScheduledExecutorService) executorService) : new e(executorService);
    }

    @GwtIncompatible
    public static ListeningExecutorService newDirectExecutorService() {
        return new d(null);
    }

    @Beta
    @GwtIncompatible
    public static Executor newSequentialExecutor(Executor executor) {
        return new a0(executor);
    }

    @Beta
    @GwtIncompatible
    public static ThreadFactory platformThreadFactory() {
        if (!b()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e4);
        } catch (InvocationTargetException e5) {
            throw Throwables.propagate(e5.getCause());
        }
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j) / 2;
        executorService.shutdown();
        try {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    @GwtIncompatible
    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) scheduledExecutorService : new f(scheduledExecutorService);
    }

    @GwtIncompatible
    public static final class f extends e implements ListeningScheduledExecutorService {
        public final ScheduledExecutorService b;

        public static final class a<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            public final ScheduledFuture<?> b;

            public a(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.b = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.b.cancel(z);
                }
                return cancel;
            }

            @Override // java.lang.Comparable
            public int compareTo(Object obj) {
                return this.b.compareTo((Delayed) obj);
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.b.getDelay(timeUnit);
            }
        }

        @GwtIncompatible
        public static final class b extends AbstractFuture.j<Void> implements Runnable {
            public final Runnable h;

            public b(Runnable runnable) {
                this.h = (Runnable) Preconditions.checkNotNull(runnable);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.h.run();
                } catch (Throwable th) {
                    setException(th);
                    throw Throwables.propagate(th);
                }
            }
        }

        public f(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.b = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* renamed from: schedule */
        public <V> ListenableScheduledFuture<V> mo149schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            g0 g0Var = new g0(callable);
            return new a(g0Var, this.b.schedule(g0Var, j, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* renamed from: scheduleAtFixedRate */
        public ListenableScheduledFuture<?> mo150scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.b.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* renamed from: scheduleWithFixedDelay */
        public ListenableScheduledFuture<?> mo151scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.b.scheduleWithFixedDelay(bVar, j, j2, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* renamed from: schedule  reason: collision with other method in class */
        public ScheduledFuture mo149schedule(Callable callable, long j, TimeUnit timeUnit) {
            g0 g0Var = new g0(callable);
            return new a(g0Var, this.b.schedule(g0Var, j, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* renamed from: scheduleAtFixedRate  reason: collision with other method in class */
        public ScheduledFuture mo150scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.b.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* renamed from: scheduleWithFixedDelay  reason: collision with other method in class */
        public ScheduledFuture mo151scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.b.scheduleWithFixedDelay(bVar, j, j2, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* renamed from: schedule */
        public ListenableScheduledFuture<?> mo148schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            g0 g0Var = new g0(Executors.callable(runnable, null));
            return new a(g0Var, this.b.schedule(g0Var, j, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* renamed from: schedule  reason: collision with other method in class */
        public ScheduledFuture mo148schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            g0 g0Var = new g0(Executors.callable(runnable, null));
            return new a(g0Var, this.b.schedule(g0Var, j, timeUnit));
        }
    }

    @Beta
    @GwtIncompatible
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        c cVar = new c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a(threadPoolExecutor);
        ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
        cVar.a(threadPoolExecutor, 120, timeUnit);
        return unconfigurableExecutorService;
    }

    @Beta
    @GwtIncompatible
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        c cVar = new c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a(scheduledThreadPoolExecutor);
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
        cVar.a(scheduledThreadPoolExecutor, 120, timeUnit);
        return unconfigurableScheduledExecutorService;
    }
}
