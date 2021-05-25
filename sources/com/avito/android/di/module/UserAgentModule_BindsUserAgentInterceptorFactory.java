package com.avito.android.di.module;

import com.avito.android.remote.interceptor.UserAgentInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.Interceptor;
public final class UserAgentModule_BindsUserAgentInterceptorFactory implements Factory<Interceptor> {
    public final Provider<UserAgentInterceptor> a;

    public UserAgentModule_BindsUserAgentInterceptorFactory(Provider<UserAgentInterceptor> provider) {
        this.a = provider;
    }

    public static Interceptor bindsUserAgentInterceptor(UserAgentInterceptor userAgentInterceptor) {
        return (Interceptor) Preconditions.checkNotNullFromProvides(UserAgentModule.INSTANCE.bindsUserAgentInterceptor(userAgentInterceptor));
    }

    public static UserAgentModule_BindsUserAgentInterceptorFactory create(Provider<UserAgentInterceptor> provider) {
        return new UserAgentModule_BindsUserAgentInterceptorFactory(provider);
    }

    @Override // javax.inject.Provider
    public Interceptor get() {
        return bindsUserAgentInterceptor(this.a.get());
    }
}
