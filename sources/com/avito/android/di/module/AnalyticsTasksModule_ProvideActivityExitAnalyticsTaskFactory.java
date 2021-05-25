package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.ActivityExitAnalyticsTask;
import com.avito.android.preferences.ActivityAnalyticsStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideActivityExitAnalyticsTaskFactory implements Factory<ActivityExitAnalyticsTask> {
    public final Provider<Analytics> a;
    public final Provider<ActivityAnalyticsStorage> b;

    public AnalyticsTasksModule_ProvideActivityExitAnalyticsTaskFactory(Provider<Analytics> provider, Provider<ActivityAnalyticsStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AnalyticsTasksModule_ProvideActivityExitAnalyticsTaskFactory create(Provider<Analytics> provider, Provider<ActivityAnalyticsStorage> provider2) {
        return new AnalyticsTasksModule_ProvideActivityExitAnalyticsTaskFactory(provider, provider2);
    }

    public static ActivityExitAnalyticsTask provideActivityExitAnalyticsTask(Analytics analytics, ActivityAnalyticsStorage activityAnalyticsStorage) {
        return (ActivityExitAnalyticsTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideActivityExitAnalyticsTask(analytics, activityAnalyticsStorage));
    }

    @Override // javax.inject.Provider
    public ActivityExitAnalyticsTask get() {
        return provideActivityExitAnalyticsTask(this.a.get(), this.b.get());
    }
}
