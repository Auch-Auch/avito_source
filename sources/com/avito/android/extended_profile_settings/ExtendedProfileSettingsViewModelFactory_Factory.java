package com.avito.android.extended_profile_settings;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileSettingsViewModelFactory_Factory implements Factory<ExtendedProfileSettingsViewModelFactory> {
    public final Provider<ExtendedProfileSettingsInteractor> a;

    public ExtendedProfileSettingsViewModelFactory_Factory(Provider<ExtendedProfileSettingsInteractor> provider) {
        this.a = provider;
    }

    public static ExtendedProfileSettingsViewModelFactory_Factory create(Provider<ExtendedProfileSettingsInteractor> provider) {
        return new ExtendedProfileSettingsViewModelFactory_Factory(provider);
    }

    public static ExtendedProfileSettingsViewModelFactory newInstance(ExtendedProfileSettingsInteractor extendedProfileSettingsInteractor) {
        return new ExtendedProfileSettingsViewModelFactory(extendedProfileSettingsInteractor);
    }

    @Override // javax.inject.Provider
    public ExtendedProfileSettingsViewModelFactory get() {
        return newInstance(this.a.get());
    }
}
