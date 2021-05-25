package com.avito.android.stories;

import com.avito.android.Features;
import com.avito.android.ab_tests.configs.AntifraudStartupBannerTestGroup;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocalStartupBannerInteractor_Factory implements Factory<LocalStartupBannerInteractor> {
    public final Provider<Preferences> a;
    public final Provider<ConnectivityProvider> b;
    public final Provider<AntifraudStartupBannerTestGroup> c;
    public final Provider<Features> d;

    public LocalStartupBannerInteractor_Factory(Provider<Preferences> provider, Provider<ConnectivityProvider> provider2, Provider<AntifraudStartupBannerTestGroup> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static LocalStartupBannerInteractor_Factory create(Provider<Preferences> provider, Provider<ConnectivityProvider> provider2, Provider<AntifraudStartupBannerTestGroup> provider3, Provider<Features> provider4) {
        return new LocalStartupBannerInteractor_Factory(provider, provider2, provider3, provider4);
    }

    public static LocalStartupBannerInteractor newInstance(Preferences preferences, ConnectivityProvider connectivityProvider, AntifraudStartupBannerTestGroup antifraudStartupBannerTestGroup, Features features) {
        return new LocalStartupBannerInteractor(preferences, connectivityProvider, antifraudStartupBannerTestGroup, features);
    }

    @Override // javax.inject.Provider
    public LocalStartupBannerInteractor get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
