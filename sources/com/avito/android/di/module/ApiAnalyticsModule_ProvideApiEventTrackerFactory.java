package com.avito.android.di.module;

import com.avito.android.analytics.provider.api.ApiEventTracker;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiAnalyticsModule_ProvideApiEventTrackerFactory implements Factory<ApiEventTracker> {
    public final Provider<SchedulersFactory> a;

    public ApiAnalyticsModule_ProvideApiEventTrackerFactory(Provider<SchedulersFactory> provider) {
        this.a = provider;
    }

    public static ApiAnalyticsModule_ProvideApiEventTrackerFactory create(Provider<SchedulersFactory> provider) {
        return new ApiAnalyticsModule_ProvideApiEventTrackerFactory(provider);
    }

    public static ApiEventTracker provideApiEventTracker(SchedulersFactory schedulersFactory) {
        return (ApiEventTracker) Preconditions.checkNotNullFromProvides(ApiAnalyticsModule.provideApiEventTracker(schedulersFactory));
    }

    @Override // javax.inject.Provider
    public ApiEventTracker get() {
        return provideApiEventTracker(this.a.get());
    }
}
