package com.avito.android.tariff.landing.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LandingModule_ProvideViewModelFactory implements Factory<TariffLandingViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public LandingModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LandingModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new LandingModule_ProvideViewModelFactory(provider, provider2);
    }

    public static TariffLandingViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (TariffLandingViewModel) Preconditions.checkNotNullFromProvides(LandingModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public TariffLandingViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
