package com.avito.android.tariff.change.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.tariff.change.viewmodel.TariffChangeViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TariffChangeModule_ProvideViewModelFactory implements Factory<TariffChangeViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public TariffChangeModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffChangeModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new TariffChangeModule_ProvideViewModelFactory(provider, provider2);
    }

    public static TariffChangeViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (TariffChangeViewModel) Preconditions.checkNotNullFromProvides(TariffChangeModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public TariffChangeViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
