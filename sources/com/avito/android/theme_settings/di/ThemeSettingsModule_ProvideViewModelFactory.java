package com.avito.android.theme_settings.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ThemeSettingsModule_ProvideViewModelFactory implements Factory<ThemeSettingsViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public ThemeSettingsModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ThemeSettingsModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ThemeSettingsModule_ProvideViewModelFactory(provider, provider2);
    }

    public static ThemeSettingsViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (ThemeSettingsViewModel) Preconditions.checkNotNullFromProvides(ThemeSettingsModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public ThemeSettingsViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
