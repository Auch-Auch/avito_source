package com.avito.android.shop_settings.di;

import dagger.internal.Factory;
public final class ShopSettingsFragmentModule_ProvideDetectMovesFactory implements Factory<Boolean> {

    public static final class a {
        public static final ShopSettingsFragmentModule_ProvideDetectMovesFactory a = new ShopSettingsFragmentModule_ProvideDetectMovesFactory();
    }

    public static ShopSettingsFragmentModule_ProvideDetectMovesFactory create() {
        return a.a;
    }

    public static boolean provideDetectMoves() {
        return ShopSettingsFragmentModule.INSTANCE.provideDetectMoves();
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provideDetectMoves());
    }
}
