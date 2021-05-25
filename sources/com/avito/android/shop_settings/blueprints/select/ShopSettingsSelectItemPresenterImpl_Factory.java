package com.avito.android.shop_settings.blueprints.select;

import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopSettingsSelectItemPresenterImpl_Factory implements Factory<ShopSettingsSelectItemPresenterImpl> {
    public final Provider<PublishRelay<ShopSettingsSelectItem>> a;

    public ShopSettingsSelectItemPresenterImpl_Factory(Provider<PublishRelay<ShopSettingsSelectItem>> provider) {
        this.a = provider;
    }

    public static ShopSettingsSelectItemPresenterImpl_Factory create(Provider<PublishRelay<ShopSettingsSelectItem>> provider) {
        return new ShopSettingsSelectItemPresenterImpl_Factory(provider);
    }

    public static ShopSettingsSelectItemPresenterImpl newInstance(PublishRelay<ShopSettingsSelectItem> publishRelay) {
        return new ShopSettingsSelectItemPresenterImpl(publishRelay);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSelectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
