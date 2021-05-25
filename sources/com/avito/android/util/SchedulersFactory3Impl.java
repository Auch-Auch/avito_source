package com.avito.android.util;

import android.os.Looper;
import com.avito.android.abuse.category.item.AbuseCategoryItemPresenterKt;
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.TestScheduler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/SchedulersFactory3Impl;", "Lcom/avito/android/util/SchedulersFactory3;", "Lio/reactivex/rxjava3/core/Scheduler;", AbuseCategoryItemPresenterKt.SINGLE_TAG, "()Lio/reactivex/rxjava3/core/Scheduler;", "trampoline", "newThread", "computation", "io", "test", "Ljava/util/concurrent/Executor;", "executor", "from", "(Ljava/util/concurrent/Executor;)Lio/reactivex/rxjava3/core/Scheduler;", "mainThread", "<init>", "()V", "schedulers-factory_release"}, k = 1, mv = {1, 4, 2})
public final class SchedulersFactory3Impl implements SchedulersFactory3 {

    public static final class a<T, R> implements Function<Scheduler, Scheduler> {
        public final /* synthetic */ Scheduler a;

        public a(Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Scheduler apply(Scheduler scheduler) {
            return this.a;
        }
    }

    public SchedulersFactory3Impl() {
        RxAndroidPlugins.setMainThreadSchedulerHandler(new a(AndroidSchedulers.from(Looper.getMainLooper(), true)));
    }

    @Override // com.avito.android.util.SchedulersFactory3
    @NotNull
    public Scheduler computation() {
        Scheduler computation = Schedulers.computation();
        Intrinsics.checkNotNullExpressionValue(computation, "Schedulers.computation()");
        return computation;
    }

    @Override // com.avito.android.util.SchedulersFactory3
    @NotNull
    public Scheduler from(@NotNull Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Scheduler from = Schedulers.from(executor);
        Intrinsics.checkNotNullExpressionValue(from, "Schedulers.from(executor)");
        return from;
    }

    @Override // com.avito.android.util.SchedulersFactory3
    @NotNull
    public Scheduler io() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "Schedulers.io()");
        return io2;
    }

    @Override // com.avito.android.util.SchedulersFactory3
    @NotNull
    public Scheduler mainThread() {
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "AndroidSchedulers.mainThread()");
        return mainThread;
    }

    @Override // com.avito.android.util.SchedulersFactory3
    @NotNull
    public Scheduler newThread() {
        Scheduler newThread = Schedulers.newThread();
        Intrinsics.checkNotNullExpressionValue(newThread, "Schedulers.newThread()");
        return newThread;
    }

    @Override // com.avito.android.util.SchedulersFactory3
    @NotNull
    public Scheduler single() {
        Scheduler single = Schedulers.single();
        Intrinsics.checkNotNullExpressionValue(single, "Schedulers.single()");
        return single;
    }

    @Override // com.avito.android.util.SchedulersFactory3
    @NotNull
    public Scheduler test() {
        return new TestScheduler();
    }

    @Override // com.avito.android.util.SchedulersFactory3
    @NotNull
    public Scheduler trampoline() {
        Scheduler trampoline = Schedulers.trampoline();
        Intrinsics.checkNotNullExpressionValue(trampoline, "Schedulers.trampoline()");
        return trampoline;
    }
}
