package com.avito.android.di.module;

import com.avito.android.app.task.ActivityExitAnalyticsTask;
import com.avito.android.app.task.AnalyticsWarmUpTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.FpsMeasurerTask;
import com.avito.android.app.task.InHouseWatchDogStartupTask;
import com.avito.android.app.task.InitLogErrorsToAnalyticsTask;
import com.avito.android.app.task.RegisterAnalyticsActivityListenerTask;
import com.avito.android.app.task.ScheduleMetricSendingTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideBlockingTasksFactory implements Factory<List<ApplicationBlockingStartupTask>> {
    public final Provider<AnalyticsWarmUpTask> a;
    public final Provider<InHouseWatchDogStartupTask> b;
    public final Provider<RegisterAnalyticsActivityListenerTask> c;
    public final Provider<ActivityExitAnalyticsTask> d;
    public final Provider<InitLogErrorsToAnalyticsTask> e;
    public final Provider<ScheduleMetricSendingTask> f;
    public final Provider<FpsMeasurerTask> g;

    public AnalyticsTasksModule_ProvideBlockingTasksFactory(Provider<AnalyticsWarmUpTask> provider, Provider<InHouseWatchDogStartupTask> provider2, Provider<RegisterAnalyticsActivityListenerTask> provider3, Provider<ActivityExitAnalyticsTask> provider4, Provider<InitLogErrorsToAnalyticsTask> provider5, Provider<ScheduleMetricSendingTask> provider6, Provider<FpsMeasurerTask> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static AnalyticsTasksModule_ProvideBlockingTasksFactory create(Provider<AnalyticsWarmUpTask> provider, Provider<InHouseWatchDogStartupTask> provider2, Provider<RegisterAnalyticsActivityListenerTask> provider3, Provider<ActivityExitAnalyticsTask> provider4, Provider<InitLogErrorsToAnalyticsTask> provider5, Provider<ScheduleMetricSendingTask> provider6, Provider<FpsMeasurerTask> provider7) {
        return new AnalyticsTasksModule_ProvideBlockingTasksFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static List<ApplicationBlockingStartupTask> provideBlockingTasks(AnalyticsWarmUpTask analyticsWarmUpTask, InHouseWatchDogStartupTask inHouseWatchDogStartupTask, RegisterAnalyticsActivityListenerTask registerAnalyticsActivityListenerTask, ActivityExitAnalyticsTask activityExitAnalyticsTask, InitLogErrorsToAnalyticsTask initLogErrorsToAnalyticsTask, ScheduleMetricSendingTask scheduleMetricSendingTask, FpsMeasurerTask fpsMeasurerTask) {
        return (List) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideBlockingTasks(analyticsWarmUpTask, inHouseWatchDogStartupTask, registerAnalyticsActivityListenerTask, activityExitAnalyticsTask, initLogErrorsToAnalyticsTask, scheduleMetricSendingTask, fpsMeasurerTask));
    }

    @Override // javax.inject.Provider
    public List<ApplicationBlockingStartupTask> get() {
        return provideBlockingTasks(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
