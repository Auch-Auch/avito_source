package com.avito.android.shop_settings.blueprints.save_button;

import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Unit;
public final class ShopSettingsSaveButtonItemPresenterImpl_Factory implements Factory<ShopSettingsSaveButtonItemPresenterImpl> {
    public final Provider<PublishRelay<Unit>> a;

    public ShopSettingsSaveButtonItemPresenterImpl_Factory(Provider<PublishRelay<Unit>> provider) {
        this.a = provider;
    }

    public static ShopSettingsSaveButtonItemPresenterImpl_Factory create(Provider<PublishRelay<Unit>> provider) {
        return new ShopSettingsSaveButtonItemPresenterImpl_Factory(provider);
    }

    public static ShopSettingsSaveButtonItemPresenterImpl newInstance(PublishRelay<Unit> publishRelay) {
        return new ShopSettingsSaveButtonItemPresenterImpl(publishRelay);
    }

    @Override // javax.inject.Provider
    public ShopSettingsSaveButtonItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
