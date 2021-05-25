package com.avito.android.di.module;

import android.content.SharedPreferences;
import com.avito.android.preferences.ActivityAnalyticsStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ActivityAnalyticsStorageFactory implements Factory<ActivityAnalyticsStorage> {
    public final Provider<SharedPreferences> a;

    public AnalyticsTasksModule_ActivityAnalyticsStorageFactory(Provider<SharedPreferences> provider) {
        this.a = provider;
    }

    public static ActivityAnalyticsStorage activityAnalyticsStorage(SharedPreferences sharedPreferences) {
        return (ActivityAnalyticsStorage) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.activityAnalyticsStorage(sharedPreferences));
    }

    public static AnalyticsTasksModule_ActivityAnalyticsStorageFactory create(Provider<SharedPreferences> provider) {
        return new AnalyticsTasksModule_ActivityAnalyticsStorageFactory(provider);
    }

    @Override // javax.inject.Provider
    public ActivityAnalyticsStorage get() {
        return activityAnalyticsStorage(this.a.get());
    }
}
