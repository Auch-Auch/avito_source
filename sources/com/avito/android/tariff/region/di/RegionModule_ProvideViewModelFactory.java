package com.avito.android.tariff.region.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.tariff.region.viewmodel.RegionViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class RegionModule_ProvideViewModelFactory implements Factory<RegionViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public RegionModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static RegionModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new RegionModule_ProvideViewModelFactory(provider, provider2);
    }

    public static RegionViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (RegionViewModel) Preconditions.checkNotNullFromProvides(RegionModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public RegionViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
