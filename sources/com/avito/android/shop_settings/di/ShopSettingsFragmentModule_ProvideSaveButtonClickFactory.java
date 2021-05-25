package com.avito.android.shop_settings.di;

import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.Unit;
public final class ShopSettingsFragmentModule_ProvideSaveButtonClickFactory implements Factory<PublishRelay<Unit>> {

    public static final class a {
        public static final ShopSettingsFragmentModule_ProvideSaveButtonClickFactory a = new ShopSettingsFragmentModule_ProvideSaveButtonClickFactory();
    }

    public static ShopSettingsFragmentModule_ProvideSaveButtonClickFactory create() {
        return a.a;
    }

    public static PublishRelay<Unit> provideSaveButtonClick() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(ShopSettingsFragmentModule.INSTANCE.provideSaveButtonClick());
    }

    @Override // javax.inject.Provider
    public PublishRelay<Unit> get() {
        return provideSaveButtonClick();
    }
}
