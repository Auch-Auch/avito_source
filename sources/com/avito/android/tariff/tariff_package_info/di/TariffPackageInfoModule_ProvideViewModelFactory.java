package com.avito.android.tariff.tariff_package_info.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TariffPackageInfoModule_ProvideViewModelFactory implements Factory<TariffPackageInfoViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public TariffPackageInfoModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffPackageInfoModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new TariffPackageInfoModule_ProvideViewModelFactory(provider, provider2);
    }

    public static TariffPackageInfoViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (TariffPackageInfoViewModel) Preconditions.checkNotNullFromProvides(TariffPackageInfoModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public TariffPackageInfoViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
