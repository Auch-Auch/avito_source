package com.avito.android.util.rx3;

import hu.akarnokd.rxjava3.schedulers.SharedScheduler;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s6.a.e.c.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\b¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\u000b\u001a\u00020\u0007*\u00020\u0007H\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\b¢\u0006\u0004\b\u000b\u0010\u000f¨\u0006\u0010"}, d2 = {"", "threadName", "", "keepAliveTime", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Lkotlin/Pair;", "Lio/reactivex/rxjava3/core/Scheduler;", "Lio/reactivex/rxjava3/disposables/Disposable;", "singleThreadSchedulerWithAutoShutdown", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)Lkotlin/Pair;", "toShared", "(Lio/reactivex/rxjava3/core/Scheduler;)Lio/reactivex/rxjava3/core/Scheduler;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", "(Lio/reactivex/rxjava3/core/Scheduler;Lio/reactivex/rxjava3/disposables/CompositeDisposable;)Lio/reactivex/rxjava3/core/Scheduler;", "rx"}, k = 2, mv = {1, 4, 2})
public final class SchedulersKt {
    @NotNull
    public static final Pair<Scheduler, Disposable> singleThreadSchedulerWithAutoShutdown(@NotNull String str, long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(str, "threadName");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, j, timeUnit, new LinkedBlockingQueue(), new SchedulersKt$singleThreadSchedulerWithAutoShutdown$executor$1(str));
        return TuplesKt.to(Schedulers.from(threadPoolExecutor), new SchedulersKt$singleThreadSchedulerWithAutoShutdown$disposable$1(threadPoolExecutor));
    }

    public static /* synthetic */ Pair singleThreadSchedulerWithAutoShutdown$default(String str, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 10;
        }
        if ((i & 4) != 0) {
            timeUnit = TimeUnit.MINUTES;
        }
        Intrinsics.checkNotNullParameter(str, "threadName");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, j, timeUnit, new LinkedBlockingQueue(), new SchedulersKt$singleThreadSchedulerWithAutoShutdown$executor$1(str));
        return TuplesKt.to(Schedulers.from(threadPoolExecutor), new SchedulersKt$singleThreadSchedulerWithAutoShutdown$disposable$1(threadPoolExecutor));
    }

    @NotNull
    public static final Scheduler toShared(@NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(scheduler, "$this$toShared");
        return new SharedScheduler(scheduler);
    }

    @NotNull
    public static final Scheduler toShared(@NotNull Scheduler scheduler, @NotNull CompositeDisposable compositeDisposable) {
        Intrinsics.checkNotNullParameter(scheduler, "$this$toShared");
        Intrinsics.checkNotNullParameter(compositeDisposable, "disposable");
        SharedScheduler sharedScheduler = new SharedScheduler(scheduler);
        compositeDisposable.add(new a(new Action() { // from class: com.avito.android.util.rx3.SchedulersKt$sam$i$io_reactivex_rxjava3_functions_Action$0
            @Override // io.reactivex.rxjava3.functions.Action
            public final /* synthetic */ void run() {
                Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
            }
        }));
        return sharedScheduler;
    }
}
