package com.avito.android.shop_settings.blueprints.address;

import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsAddressItemPresenterImpl_Factory implements Factory<ShopSettingsAddressItemPresenterImpl> {
    public final Provider<PublishRelay<ShopSettingsAddressItem>> a;

    public ShopSettingsAddressItemPresenterImpl_Factory(Provider<PublishRelay<ShopSettingsAddressItem>> provider) {
        this.a = provider;
    }

    public static ShopSettingsAddressItemPresenterImpl_Factory create(Provider<PublishRelay<ShopSettingsAddressItem>> provider) {
        return new ShopSettingsAddressItemPresenterImpl_Factory(provider);
    }

    public static ShopSettingsAddressItemPresenterImpl newInstance(PublishRelay<ShopSettingsAddressItem> publishRelay) {
        return new ShopSettingsAddressItemPresenterImpl(publishRelay);
    }

    @Override // javax.inject.Provider
    public ShopSettingsAddressItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
