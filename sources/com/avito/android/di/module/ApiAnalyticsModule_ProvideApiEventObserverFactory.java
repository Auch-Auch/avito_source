package com.avito.android.di.module;

import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.provider.api.ApiEventTracker;
import com.avito.android.analytics.remote.AnalyticsApi;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiAnalyticsModule_ProvideApiEventObserverFactory implements Factory<EventObserver> {
    public final Provider<ApiEventTracker> a;
    public final Provider<AnalyticsApi> b;

    public ApiAnalyticsModule_ProvideApiEventObserverFactory(Provider<ApiEventTracker> provider, Provider<AnalyticsApi> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ApiAnalyticsModule_ProvideApiEventObserverFactory create(Provider<ApiEventTracker> provider, Provider<AnalyticsApi> provider2) {
        return new ApiAnalyticsModule_ProvideApiEventObserverFactory(provider, provider2);
    }

    public static EventObserver provideApiEventObserver(ApiEventTracker apiEventTracker, Lazy<AnalyticsApi> lazy) {
        return (EventObserver) Preconditions.checkNotNullFromProvides(ApiAnalyticsModule.provideApiEventObserver(apiEventTracker, lazy));
    }

    @Override // javax.inject.Provider
    public EventObserver get() {
        return provideApiEventObserver(this.a.get(), DoubleCheck.lazy(this.b));
    }
}
