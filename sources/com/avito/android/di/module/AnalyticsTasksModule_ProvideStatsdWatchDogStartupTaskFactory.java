package com.avito.android.di.module;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsWatchDog;
import com.avito.android.app.task.InHouseWatchDogStartupTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideStatsdWatchDogStartupTaskFactory implements Factory<InHouseWatchDogStartupTask> {
    public final Provider<InHouseAnalyticsWatchDog> a;

    public AnalyticsTasksModule_ProvideStatsdWatchDogStartupTaskFactory(Provider<InHouseAnalyticsWatchDog> provider) {
        this.a = provider;
    }

    public static AnalyticsTasksModule_ProvideStatsdWatchDogStartupTaskFactory create(Provider<InHouseAnalyticsWatchDog> provider) {
        return new AnalyticsTasksModule_ProvideStatsdWatchDogStartupTaskFactory(provider);
    }

    public static InHouseWatchDogStartupTask provideStatsdWatchDogStartupTask(InHouseAnalyticsWatchDog inHouseAnalyticsWatchDog) {
        return (InHouseWatchDogStartupTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.provideStatsdWatchDogStartupTask(inHouseAnalyticsWatchDog));
    }

    @Override // javax.inject.Provider
    public InHouseWatchDogStartupTask get() {
        return provideStatsdWatchDogStartupTask(this.a.get());
    }
}
