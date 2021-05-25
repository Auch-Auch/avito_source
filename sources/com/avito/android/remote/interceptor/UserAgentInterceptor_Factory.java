package com.avito.android.remote.interceptor;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAgentInterceptor_Factory implements Factory<UserAgentInterceptor> {
    public final Provider<UserAgentHeaderProvider> a;

    public UserAgentInterceptor_Factory(Provider<UserAgentHeaderProvider> provider) {
        this.a = provider;
    }

    public static UserAgentInterceptor_Factory create(Provider<UserAgentHeaderProvider> provider) {
        return new UserAgentInterceptor_Factory(provider);
    }

    public static UserAgentInterceptor newInstance(UserAgentHeaderProvider userAgentHeaderProvider) {
        return new UserAgentInterceptor(userAgentHeaderProvider);
    }

    @Override // javax.inject.Provider
    public UserAgentInterceptor get() {
        return newInstance(this.a.get());
    }
}
