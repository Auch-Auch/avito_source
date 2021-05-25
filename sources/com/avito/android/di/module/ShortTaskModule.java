package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.service.short_task.AndroidJobCreator;
import com.avito.android.service.short_task.AndroidJobDailyScheduler;
import com.avito.android.service.short_task.AndroidJobExactScheduler;
import com.avito.android.service.short_task.AndroidJobPeriodicScheduler;
import com.avito.android.service.short_task.RunJobFailedListener;
import com.avito.android.service.short_task.SendAnalyticsRunJobFailedListener;
import com.avito.android.service.short_task.ShortTaskDailyScheduler;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.service.short_task.ShortTaskFactory;
import com.avito.android.service.short_task.ShortTaskFactoryImpl;
import com.avito.android.service.short_task.ShortTaskPeriodicScheduler;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0017¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/di/module/ShortTaskModule;", "", "Lcom/avito/android/service/short_task/ShortTaskFactory;", "provideShortTaskCreator", "()Lcom/avito/android/service/short_task/ShortTaskFactory;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Ldagger/Lazy;", "Lcom/avito/android/service/short_task/AndroidJobCreator;", "jobCreator", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "provideShortTaskExactScheduler", "(Landroid/app/Application;Ldagger/Lazy;)Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "Lcom/avito/android/service/short_task/ShortTaskPeriodicScheduler;", "provideShortTaskPeriodicScheduler", "()Lcom/avito/android/service/short_task/ShortTaskPeriodicScheduler;", "Lcom/avito/android/service/short_task/ShortTaskDailyScheduler;", "provideShortTaskDailyScheduler", "()Lcom/avito/android/service/short_task/ShortTaskDailyScheduler;", "shortTaskFactory", "Lcom/avito/android/service/short_task/RunJobFailedListener;", "runJobFailedListener", "provideAndroidJobCreator", "(Lcom/avito/android/service/short_task/ShortTaskFactory;Lcom/avito/android/service/short_task/RunJobFailedListener;)Lcom/avito/android/service/short_task/AndroidJobCreator;", "Lcom/avito/android/analytics/Analytics;", "analytics", "provideRunJobFailedListener", "(Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/service/short_task/RunJobFailedListener;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public class ShortTaskModule {
    @Provides
    @Singleton
    @NotNull
    public AndroidJobCreator provideAndroidJobCreator(@NotNull ShortTaskFactory shortTaskFactory, @NotNull RunJobFailedListener runJobFailedListener) {
        Intrinsics.checkNotNullParameter(shortTaskFactory, "shortTaskFactory");
        Intrinsics.checkNotNullParameter(runJobFailedListener, "runJobFailedListener");
        return new AndroidJobCreator(shortTaskFactory, runJobFailedListener);
    }

    @Provides
    @Singleton
    @NotNull
    public RunJobFailedListener provideRunJobFailedListener(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SendAnalyticsRunJobFailedListener(analytics);
    }

    @Provides
    @Singleton
    @NotNull
    public ShortTaskFactory provideShortTaskCreator() {
        return new ShortTaskFactoryImpl();
    }

    @Provides
    @Singleton
    @NotNull
    public ShortTaskDailyScheduler provideShortTaskDailyScheduler() {
        return new AndroidJobDailyScheduler();
    }

    @Provides
    @NotNull
    @Singleton
    public ShortTaskExactScheduler provideShortTaskExactScheduler(@NotNull Application application, @NotNull Lazy<AndroidJobCreator> lazy) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(lazy, "jobCreator");
        return new AndroidJobExactScheduler(application, lazy);
    }

    @Provides
    @Singleton
    @NotNull
    public ShortTaskPeriodicScheduler provideShortTaskPeriodicScheduler() {
        return new AndroidJobPeriodicScheduler();
    }
}
