package com.avito.android.shop_settings.di;

import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ShopSettingsFragmentModule_ProvideAddressItemClickFactory implements Factory<PublishRelay<ShopSettingsAddressItem>> {

    public static final class a {
        public static final ShopSettingsFragmentModule_ProvideAddressItemClickFactory a = new ShopSettingsFragmentModule_ProvideAddressItemClickFactory();
    }

    public static ShopSettingsFragmentModule_ProvideAddressItemClickFactory create() {
        return a.a;
    }

    public static PublishRelay<ShopSettingsAddressItem> provideAddressItemClick() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(ShopSettingsFragmentModule.INSTANCE.provideAddressItemClick());
    }

    @Override // javax.inject.Provider
    public PublishRelay<ShopSettingsAddressItem> get() {
        return provideAddressItemClick();
    }
}
