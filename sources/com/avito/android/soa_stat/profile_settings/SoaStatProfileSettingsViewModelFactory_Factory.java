package com.avito.android.soa_stat.profile_settings;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SoaStatProfileSettingsViewModelFactory_Factory implements Factory<SoaStatProfileSettingsViewModelFactory> {
    public final Provider<SoaStatProfileSettingsInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<AttributedTextFormatter> c;
    public final Provider<Analytics> d;

    public SoaStatProfileSettingsViewModelFactory_Factory(Provider<SoaStatProfileSettingsInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AttributedTextFormatter> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SoaStatProfileSettingsViewModelFactory_Factory create(Provider<SoaStatProfileSettingsInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AttributedTextFormatter> provider3, Provider<Analytics> provider4) {
        return new SoaStatProfileSettingsViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static SoaStatProfileSettingsViewModelFactory newInstance(SoaStatProfileSettingsInteractor soaStatProfileSettingsInteractor, SchedulersFactory schedulersFactory, AttributedTextFormatter attributedTextFormatter, Analytics analytics) {
        return new SoaStatProfileSettingsViewModelFactory(soaStatProfileSettingsInteractor, schedulersFactory, attributedTextFormatter, analytics);
    }

    @Override // javax.inject.Provider
    public SoaStatProfileSettingsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
