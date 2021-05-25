package com.avito.android.tariff.info.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TariffInfoModule_ProvideViewModelFactory implements Factory<TariffInfoViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public TariffInfoModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffInfoModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new TariffInfoModule_ProvideViewModelFactory(provider, provider2);
    }

    public static TariffInfoViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (TariffInfoViewModel) Preconditions.checkNotNullFromProvides(TariffInfoModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public TariffInfoViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
