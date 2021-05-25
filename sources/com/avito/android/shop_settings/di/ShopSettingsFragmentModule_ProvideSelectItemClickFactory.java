package com.avito.android.shop_settings.di;

import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ShopSettingsFragmentModule_ProvideSelectItemClickFactory implements Factory<PublishRelay<ShopSettingsSelectItem>> {

    public static final class a {
        public static final ShopSettingsFragmentModule_ProvideSelectItemClickFactory a = new ShopSettingsFragmentModule_ProvideSelectItemClickFactory();
    }

    public static ShopSettingsFragmentModule_ProvideSelectItemClickFactory create() {
        return a.a;
    }

    public static PublishRelay<ShopSettingsSelectItem> provideSelectItemClick() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(ShopSettingsFragmentModule.INSTANCE.provideSelectItemClick());
    }

    @Override // javax.inject.Provider
    public PublishRelay<ShopSettingsSelectItem> get() {
        return provideSelectItemClick();
    }
}
