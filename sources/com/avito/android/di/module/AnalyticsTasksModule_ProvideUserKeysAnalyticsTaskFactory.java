package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.app.task.UserKeysAnalyticsTask;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.util.GooglePlayServicesInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideUserKeysAnalyticsTaskFactory implements Factory<UserKeysAnalyticsTask> {
    public final Provider<Analytics> a;
    public final Provider<FirebaseCrashlytics> b;
    public final Provider<DeviceIdProvider> c;
    public final Provider<GooglePlayServicesInfo> d;
    public final Provider<SchedulersFactory> e;

    public AnalyticsTasksModule_ProvideUserKeysAnalyticsTaskFactory(Provider<Analytics> provider, Provider<FirebaseCrashlytics> provider2, Provider<DeviceIdProvider> provider3, Provider<GooglePlayServicesInfo> provider4, Provider<SchedulersFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AnalyticsTasksModule_ProvideUserKeysAnalyticsTaskFactory create(Provider<Analytics> provider, Provider<FirebaseCrashlytics> provider2, Provider<DeviceIdProvider> provider3, Provider<GooglePlayServicesInfo> provider4, Provider<SchedulersFactory> provider5) {
        return new AnalyticsTasksModule_ProvideUserKeysAnalyticsTaskFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static UserKeysAnalyticsTask provideUserKeysAnalyticsTask(Analytics analytics, FirebaseCrashlytics firebaseCrashlytics, DeviceIdProvider deviceIdProvider, GooglePlayServicesInfo googlePlayServicesInfo, SchedulersFactory schedulersFactory) {
        return (UserKeysAnalyticsTask) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideUserKeysAnalyticsTask(analytics, firebaseCrashlytics, deviceIdProvider, googlePlayServicesInfo, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public UserKeysAnalyticsTask get() {
        return provideUserKeysAnalyticsTask(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
