package com.avito.android.version_conflict.di.module;

import android.content.Context;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.remote.ConfigApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.version_conflict.CheckConfigTask;
import com.avito.android.version_conflict.ConfigUpdatedRouter;
import com.avito.android.version_conflict.ConfigUpdatedRouterImpl;
import com.avito.android.version_conflict.MutableConfigStorage;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00162\u0006\u0010\u0015\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/version_conflict/di/module/VersionConflictTasksModule;", "", "Lcom/avito/android/remote/ConfigApi;", "api", "Lcom/avito/android/version_conflict/MutableConfigStorage;", "configStorage", "Lcom/avito/android/version_conflict/ConfigUpdatedRouter;", "configUpdatedRouter", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/version_conflict/CheckConfigTask;", "provideCheckConfigTask", "(Lcom/avito/android/remote/ConfigApi;Lcom/avito/android/version_conflict/MutableConfigStorage;Lcom/avito/android/version_conflict/ConfigUpdatedRouter;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/version_conflict/CheckConfigTask;", "Landroid/content/Context;", "context", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "provideConfigUpdatedRouter", "(Landroid/content/Context;Lcom/avito/android/ActivityIntentFactory;)Lcom/avito/android/version_conflict/ConfigUpdatedRouter;", "checkConfigTask", "", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "provideForegroundTasks", "(Lcom/avito/android/version_conflict/CheckConfigTask;)Ljava/util/List;", "<init>", "()V", "version-conflict_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class VersionConflictTasksModule {
    @NotNull
    public static final VersionConflictTasksModule INSTANCE = new VersionConflictTasksModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final CheckConfigTask provideCheckConfigTask(@NotNull ConfigApi configApi, @NotNull MutableConfigStorage mutableConfigStorage, @NotNull ConfigUpdatedRouter configUpdatedRouter, @NotNull BuildInfo buildInfo, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(configApi, "api");
        Intrinsics.checkNotNullParameter(mutableConfigStorage, "configStorage");
        Intrinsics.checkNotNullParameter(configUpdatedRouter, "configUpdatedRouter");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new CheckConfigTask(configApi, mutableConfigStorage, configUpdatedRouter, buildInfo, schedulersFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ConfigUpdatedRouter provideConfigUpdatedRouter(@NotNull Context context, @NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "intentFactory");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        return new ConfigUpdatedRouterImpl(applicationContext, activityIntentFactory);
    }

    @VersionConflictTasks
    @Provides
    @NotNull
    public final List<ApplicationForegroundStartupTask> provideForegroundTasks(@NotNull CheckConfigTask checkConfigTask) {
        Intrinsics.checkNotNullParameter(checkConfigTask, "checkConfigTask");
        return d.listOf(checkConfigTask);
    }
}
