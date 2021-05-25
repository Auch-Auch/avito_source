package com.avito.android.shop_settings_select.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.shop_settings_select.ShopSettingsSelectViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopSettingsSelectFragmentModule_ProvideViewModelFactory implements Factory<ShopSettingsSelectViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public ShopSettingsSelectFragmentModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShopSettingsSelectFragmentModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ShopSettingsSelectFragmentModule_ProvideViewModelFactory(provider, provider2);
    }

    public static ShopSettingsSelectViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (ShopSettingsSelectViewModel) Preconditions.checkNotNullFromProvides(ShopSettingsSelectFragmentModule.INSTANCE.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public ShopSettingsSelectViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
