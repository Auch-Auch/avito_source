package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.ab_tests.AbTestsReloadTask;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.FetchABTestsConfigTask;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.GeoContract;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/di/module/AbTestsTasksModule;", "", "Ldagger/Lazy;", "Lcom/avito/android/app/task/FetchABTestsConfigTask;", "fetchABTestsConfigTask", "", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "provideBackgroundTasks", "(Ldagger/Lazy;)Ljava/util/List;", "Lcom/avito/android/ab_tests/AbTestsReloadTask;", "task", "Lcom/avito/android/account/AccountStateProvider;", GeoContract.PROVIDER, "Lcom/avito/android/util/BuildInfo;", "build", "provideLoadAbTestsConfigTask", "(Lcom/avito/android/ab_tests/AbTestsReloadTask;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/app/task/FetchABTestsConfigTask;", "<init>", "()V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AbTestsTasksModule {
    @NotNull
    public static final AbTestsTasksModule INSTANCE = new AbTestsTasksModule();

    @AbTestsTasks
    @Provides
    @NotNull
    public final List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(@NotNull Lazy<FetchABTestsConfigTask> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "fetchABTestsConfigTask");
        return d.listOf(new TypedLazy(FetchABTestsConfigTask.class, lazy));
    }

    @Provides
    @NotNull
    public final FetchABTestsConfigTask provideLoadAbTestsConfigTask(@NotNull AbTestsReloadTask abTestsReloadTask, @NotNull AccountStateProvider accountStateProvider, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(abTestsReloadTask, "task");
        Intrinsics.checkNotNullParameter(accountStateProvider, GeoContract.PROVIDER);
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        return new FetchABTestsConfigTask(abTestsReloadTask, accountStateProvider, buildInfo);
    }
}
