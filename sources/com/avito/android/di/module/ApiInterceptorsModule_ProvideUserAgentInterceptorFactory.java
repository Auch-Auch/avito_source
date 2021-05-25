package com.avito.android.di.module;

import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ApiInterceptorsModule_ProvideUserAgentInterceptorFactory implements Factory<UserAgentInterceptor> {
    public final ApiInterceptorsModule a;
    public final Provider<UserAgentHeaderProvider> b;

    public ApiInterceptorsModule_ProvideUserAgentInterceptorFactory(ApiInterceptorsModule apiInterceptorsModule, Provider<UserAgentHeaderProvider> provider) {
        this.a = apiInterceptorsModule;
        this.b = provider;
    }

    public static ApiInterceptorsModule_ProvideUserAgentInterceptorFactory create(ApiInterceptorsModule apiInterceptorsModule, Provider<UserAgentHeaderProvider> provider) {
        return new ApiInterceptorsModule_ProvideUserAgentInterceptorFactory(apiInterceptorsModule, provider);
    }

    public static UserAgentInterceptor provideUserAgentInterceptor(ApiInterceptorsModule apiInterceptorsModule, UserAgentHeaderProvider userAgentHeaderProvider) {
        return (UserAgentInterceptor) Preconditions.checkNotNullFromProvides(apiInterceptorsModule.provideUserAgentInterceptor(userAgentHeaderProvider));
    }

    @Override // javax.inject.Provider
    public UserAgentInterceptor get() {
        return provideUserAgentInterceptor(this.a, this.b.get());
    }
}
