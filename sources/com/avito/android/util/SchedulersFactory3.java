package com.avito.android.util;

import com.avito.android.abuse.category.item.AbuseCategoryItemPresenterKt;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/avito/android/util/SchedulersFactory3;", "", "Lio/reactivex/rxjava3/core/Scheduler;", "trampoline", "()Lio/reactivex/rxjava3/core/Scheduler;", "newThread", "computation", "io", "test", "Ljava/util/concurrent/Executor;", "executor", "from", "(Ljava/util/concurrent/Executor;)Lio/reactivex/rxjava3/core/Scheduler;", "mainThread", AbuseCategoryItemPresenterKt.SINGLE_TAG, "schedulers-factory_release"}, k = 1, mv = {1, 4, 2})
public interface SchedulersFactory3 {
    @NotNull
    Scheduler computation();

    @NotNull
    Scheduler from(@NotNull Executor executor);

    @NotNull
    Scheduler io();

    @NotNull
    Scheduler mainThread();

    @NotNull
    Scheduler newThread();

    @NotNull
    Scheduler single();

    @NotNull
    Scheduler test();

    @NotNull
    Scheduler trampoline();
}
