package com.avito.android.shop_settings_select.di;

import dagger.internal.Factory;
public final class ShopSettingsSelectFragmentModule_ProvideDetectMovesFactory implements Factory<Boolean> {

    public static final class a {
        public static final ShopSettingsSelectFragmentModule_ProvideDetectMovesFactory a = new ShopSettingsSelectFragmentModule_ProvideDetectMovesFactory();
    }

    public static ShopSettingsSelectFragmentModule_ProvideDetectMovesFactory create() {
        return a.a;
    }

    public static boolean provideDetectMoves() {
        return ShopSettingsSelectFragmentModule.INSTANCE.provideDetectMoves();
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provideDetectMoves());
    }
}
