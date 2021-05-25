package com.avito.android.license.ui;

import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LicenseFragment_MembersInjector implements MembersInjector<LicenseFragment> {
    public final Provider<Analytics> a;

    public LicenseFragment_MembersInjector(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static MembersInjector<LicenseFragment> create(Provider<Analytics> provider) {
        return new LicenseFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.license.ui.LicenseFragment.analytics")
    public static void injectAnalytics(LicenseFragment licenseFragment, Analytics analytics) {
        licenseFragment.analytics = analytics;
    }

    public void injectMembers(LicenseFragment licenseFragment) {
        injectAnalytics(licenseFragment, this.a.get());
    }
}
