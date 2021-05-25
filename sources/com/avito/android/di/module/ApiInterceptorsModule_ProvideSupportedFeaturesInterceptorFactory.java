package com.avito.android.di.module;

import com.avito.android.remote.SupportFeaturesHeaderProvider;
import com.avito.android.remote.interceptor.SupportedFeaturesInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiInterceptorsModule_ProvideSupportedFeaturesInterceptorFactory implements Factory<SupportedFeaturesInterceptor> {
    public final ApiInterceptorsModule a;
    public final Provider<SupportFeaturesHeaderProvider> b;

    public ApiInterceptorsModule_ProvideSupportedFeaturesInterceptorFactory(ApiInterceptorsModule apiInterceptorsModule, Provider<SupportFeaturesHeaderProvider> provider) {
        this.a = apiInterceptorsModule;
        this.b = provider;
    }

    public static ApiInterceptorsModule_ProvideSupportedFeaturesInterceptorFactory create(ApiInterceptorsModule apiInterceptorsModule, Provider<SupportFeaturesHeaderProvider> provider) {
        return new ApiInterceptorsModule_ProvideSupportedFeaturesInterceptorFactory(apiInterceptorsModule, provider);
    }

    public static SupportedFeaturesInterceptor provideSupportedFeaturesInterceptor(ApiInterceptorsModule apiInterceptorsModule, SupportFeaturesHeaderProvider supportFeaturesHeaderProvider) {
        return (SupportedFeaturesInterceptor) Preconditions.checkNotNullFromProvides(apiInterceptorsModule.provideSupportedFeaturesInterceptor(supportFeaturesHeaderProvider));
    }

    @Override // javax.inject.Provider
    public SupportedFeaturesInterceptor get() {
        return provideSupportedFeaturesInterceptor(this.a, this.b.get());
    }
}
