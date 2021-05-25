package com.avito.android.tariff.fees_methods.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeeMethodsModule_ProvideViewModelFactory implements Factory<FeeMethodsViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public FeeMethodsModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FeeMethodsModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new FeeMethodsModule_ProvideViewModelFactory(provider, provider2);
    }

    public static FeeMethodsViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (FeeMethodsViewModel) Preconditions.checkNotNullFromProvides(FeeMethodsModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public FeeMethodsViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
