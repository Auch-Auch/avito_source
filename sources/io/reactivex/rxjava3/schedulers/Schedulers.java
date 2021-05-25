package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Executor;
public final class Schedulers {
    @NonNull
    public static final Scheduler a = RxJavaPlugins.initSingleScheduler(new h());
    @NonNull
    public static final Scheduler b = RxJavaPlugins.initComputationScheduler(new b());
    @NonNull
    public static final Scheduler c = RxJavaPlugins.initIoScheduler(new c());
    @NonNull
    public static final Scheduler d = TrampolineScheduler.instance();
    @NonNull
    public static final Scheduler e = RxJavaPlugins.initNewThreadScheduler(new f());

    public static final class a {
        public static final Scheduler a = new ComputationScheduler();
    }

    public static final class b implements Supplier<Scheduler> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Scheduler get() throws Throwable {
            return a.a;
        }
    }

    public static final class c implements Supplier<Scheduler> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Scheduler get() throws Throwable {
            return d.a;
        }
    }

    public static final class d {
        public static final Scheduler a = new IoScheduler();
    }

    public static final class e {
        public static final Scheduler a = new NewThreadScheduler();
    }

    public static final class f implements Supplier<Scheduler> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Scheduler get() throws Throwable {
            return e.a;
        }
    }

    public static final class g {
        public static final Scheduler a = new SingleScheduler();
    }

    public static final class h implements Supplier<Scheduler> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Scheduler get() throws Throwable {
            return g.a;
        }
    }

    public Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(b);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor) {
        return new ExecutorScheduler(executor, false, false);
    }

    @NonNull
    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(c);
    }

    @NonNull
    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(e);
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        SchedulerPoolFactory.shutdown();
    }

    @NonNull
    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(a);
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        SchedulerPoolFactory.start();
    }

    @NonNull
    public static Scheduler trampoline() {
        return d;
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor, boolean z) {
        return new ExecutorScheduler(executor, z, false);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor, boolean z, boolean z2) {
        return new ExecutorScheduler(executor, z, z2);
    }
}
