package com.avito.android.shop_settings.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.shop_settings.ShopSettingsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopSettingsFragmentModule_ProvideViewModelFactory implements Factory<ShopSettingsViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public ShopSettingsFragmentModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopSettingsFragmentModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ShopSettingsFragmentModule_ProvideViewModelFactory(provider, provider2);
    }

    public static ShopSettingsViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (ShopSettingsViewModel) Preconditions.checkNotNullFromProvides(ShopSettingsFragmentModule.INSTANCE.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public ShopSettingsViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
