package com.avito.android.tariff.count.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.tariff.count.viewmodel.TariffCountViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TariffCountModule_ProvideViewModelFactory implements Factory<TariffCountViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public TariffCountModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffCountModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new TariffCountModule_ProvideViewModelFactory(provider, provider2);
    }

    public static TariffCountViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (TariffCountViewModel) Preconditions.checkNotNullFromProvides(TariffCountModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public TariffCountViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
