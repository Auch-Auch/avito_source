package com.avito.android.help_center;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class HelpCenterUrlInterceptorImpl_Factory implements Factory<HelpCenterUrlInterceptorImpl> {
    public final Provider<HelpCenterUrlProvider> a;

    public HelpCenterUrlInterceptorImpl_Factory(Provider<HelpCenterUrlProvider> provider) {
        this.a = provider;
    }

    public static HelpCenterUrlInterceptorImpl_Factory create(Provider<HelpCenterUrlProvider> provider) {
        return new HelpCenterUrlInterceptorImpl_Factory(provider);
    }

    public static HelpCenterUrlInterceptorImpl newInstance(HelpCenterUrlProvider helpCenterUrlProvider) {
        return new HelpCenterUrlInterceptorImpl(helpCenterUrlProvider);
    }

    @Override // javax.inject.Provider
    public HelpCenterUrlInterceptorImpl get() {
        return newInstance(this.a.get());
    }
}
