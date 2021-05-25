package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.remote.interceptor.ApiAnalyticsInterceptor;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiInterceptorsModule_ProvideApiAnalyticsInterceptorFactory implements Factory<ApiAnalyticsInterceptor> {
    public final ApiInterceptorsModule a;
    public final Provider<RandomKeyProvider> b;
    public final Provider<Analytics> c;

    public ApiInterceptorsModule_ProvideApiAnalyticsInterceptorFactory(ApiInterceptorsModule apiInterceptorsModule, Provider<RandomKeyProvider> provider, Provider<Analytics> provider2) {
        this.a = apiInterceptorsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ApiInterceptorsModule_ProvideApiAnalyticsInterceptorFactory create(ApiInterceptorsModule apiInterceptorsModule, Provider<RandomKeyProvider> provider, Provider<Analytics> provider2) {
        return new ApiInterceptorsModule_ProvideApiAnalyticsInterceptorFactory(apiInterceptorsModule, provider, provider2);
    }

    public static ApiAnalyticsInterceptor provideApiAnalyticsInterceptor(ApiInterceptorsModule apiInterceptorsModule, RandomKeyProvider randomKeyProvider, Analytics analytics) {
        return (ApiAnalyticsInterceptor) Preconditions.checkNotNullFromProvides(apiInterceptorsModule.provideApiAnalyticsInterceptor(randomKeyProvider, analytics));
    }

    @Override // javax.inject.Provider
    public ApiAnalyticsInterceptor get() {
        return provideApiAnalyticsInterceptor(this.a, this.b.get(), this.c.get());
    }
}
