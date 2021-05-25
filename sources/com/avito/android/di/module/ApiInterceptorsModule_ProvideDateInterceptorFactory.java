package com.avito.android.di.module;

import com.avito.android.remote.interceptor.DateHeaderProvider;
import com.avito.android.remote.interceptor.DateInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiInterceptorsModule_ProvideDateInterceptorFactory implements Factory<DateInterceptor> {
    public final ApiInterceptorsModule a;
    public final Provider<DateHeaderProvider> b;

    public ApiInterceptorsModule_ProvideDateInterceptorFactory(ApiInterceptorsModule apiInterceptorsModule, Provider<DateHeaderProvider> provider) {
        this.a = apiInterceptorsModule;
        this.b = provider;
    }

    public static ApiInterceptorsModule_ProvideDateInterceptorFactory create(ApiInterceptorsModule apiInterceptorsModule, Provider<DateHeaderProvider> provider) {
        return new ApiInterceptorsModule_ProvideDateInterceptorFactory(apiInterceptorsModule, provider);
    }

    public static DateInterceptor provideDateInterceptor(ApiInterceptorsModule apiInterceptorsModule, DateHeaderProvider dateHeaderProvider) {
        return (DateInterceptor) Preconditions.checkNotNullFromProvides(apiInterceptorsModule.provideDateInterceptor(dateHeaderProvider));
    }

    @Override // javax.inject.Provider
    public DateInterceptor get() {
        return provideDateInterceptor(this.a, this.b.get());
    }
}
