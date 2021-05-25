package com.avito.android.util;

import com.avito.android.AppConfigurationToggles;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class UserAgentProviderImpl_Factory implements Factory<UserAgentProviderImpl> {
    public final Provider<BuildInfo> a;
    public final Provider<Locale> b;
    public final Provider<AppConfigurationToggles> c;

    public UserAgentProviderImpl_Factory(Provider<BuildInfo> provider, Provider<Locale> provider2, Provider<AppConfigurationToggles> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UserAgentProviderImpl_Factory create(Provider<BuildInfo> provider, Provider<Locale> provider2, Provider<AppConfigurationToggles> provider3) {
        return new UserAgentProviderImpl_Factory(provider, provider2, provider3);
    }

    public static UserAgentProviderImpl newInstance(BuildInfo buildInfo, Locale locale, AppConfigurationToggles appConfigurationToggles) {
        return new UserAgentProviderImpl(buildInfo, locale, appConfigurationToggles);
    }

    @Override // javax.inject.Provider
    public UserAgentProviderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
