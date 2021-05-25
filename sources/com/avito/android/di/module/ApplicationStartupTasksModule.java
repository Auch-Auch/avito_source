package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTasksExecutor;
import com.avito.android.app.task.MutableApplicationStartupTasksRegistry;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JU\u0010\u0010\u001a\u00020\u000f2\u0011\u0010\u0005\u001a\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u00022\u0019\u0010\b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0002\b\u00040\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/di/module/ApplicationStartupTasksModule;", "", "", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Lkotlin/jvm/JvmSuppressWildcards;", "blockingTasks", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "backgroundTasks", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "tasksRegistry", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/app/task/ApplicationStartupTasksExecutor;", "provideApplicationStartupTasksExecutor", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;Lcom/avito/android/analytics/task/StartupAnalyticsTracker;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/app/task/ApplicationStartupTasksExecutor;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ApplicationStartupTasksModule {
    @NotNull
    public static final ApplicationStartupTasksModule INSTANCE = new ApplicationStartupTasksModule();

    @Provides
    @NotNull
    public final ApplicationStartupTasksExecutor provideApplicationStartupTasksExecutor(@NotNull List<ApplicationBlockingStartupTask> list, @NotNull List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list2, @NotNull MutableApplicationStartupTasksRegistry mutableApplicationStartupTasksRegistry, @NotNull StartupAnalyticsTracker startupAnalyticsTracker, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(list, "blockingTasks");
        Intrinsics.checkNotNullParameter(list2, "backgroundTasks");
        Intrinsics.checkNotNullParameter(mutableApplicationStartupTasksRegistry, "tasksRegistry");
        Intrinsics.checkNotNullParameter(startupAnalyticsTracker, "tracker");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new ApplicationStartupTasksExecutor(list, list2, mutableApplicationStartupTasksRegistry, schedulersFactory3, startupAnalyticsTracker, false, 32, null);
    }
}
