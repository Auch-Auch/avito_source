package com.avito.android.extended_profile_settings.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.extended_profile_settings.ExtendedProfileSettingsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExtendedProfileSettingsModule_ProvideViewModelFactory implements Factory<ExtendedProfileSettingsViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public ExtendedProfileSettingsModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ExtendedProfileSettingsModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ExtendedProfileSettingsModule_ProvideViewModelFactory(provider, provider2);
    }

    public static ExtendedProfileSettingsViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (ExtendedProfileSettingsViewModel) Preconditions.checkNotNullFromProvides(ExtendedProfileSettingsModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public ExtendedProfileSettingsViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
