package com.avito.android.basket.checkout.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CheckoutModule_ProvideViewModelFactory implements Factory<CheckoutViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public CheckoutModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CheckoutModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new CheckoutModule_ProvideViewModelFactory(provider, provider2);
    }

    public static CheckoutViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (CheckoutViewModel) Preconditions.checkNotNullFromProvides(CheckoutModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public CheckoutViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
