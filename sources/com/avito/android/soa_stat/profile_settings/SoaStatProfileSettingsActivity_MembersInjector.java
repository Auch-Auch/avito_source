package com.avito.android.soa_stat.profile_settings;

import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SoaStatProfileSettingsActivity_MembersInjector implements MembersInjector<SoaStatProfileSettingsActivity> {
    public final Provider<SoaStatProfileSettingsViewModelFactory> a;
    public final Provider<Analytics> b;

    public SoaStatProfileSettingsActivity_MembersInjector(Provider<SoaStatProfileSettingsViewModelFactory> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<SoaStatProfileSettingsActivity> create(Provider<SoaStatProfileSettingsViewModelFactory> provider, Provider<Analytics> provider2) {
        return new SoaStatProfileSettingsActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsActivity.analytics")
    public static void injectAnalytics(SoaStatProfileSettingsActivity soaStatProfileSettingsActivity, Analytics analytics) {
        soaStatProfileSettingsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.soa_stat.profile_settings.SoaStatProfileSettingsActivity.viewModelFactory")
    public static void injectViewModelFactory(SoaStatProfileSettingsActivity soaStatProfileSettingsActivity, SoaStatProfileSettingsViewModelFactory soaStatProfileSettingsViewModelFactory) {
        soaStatProfileSettingsActivity.viewModelFactory = soaStatProfileSettingsViewModelFactory;
    }

    public void injectMembers(SoaStatProfileSettingsActivity soaStatProfileSettingsActivity) {
        injectViewModelFactory(soaStatProfileSettingsActivity, this.a.get());
        injectAnalytics(soaStatProfileSettingsActivity, this.b.get());
    }
}
