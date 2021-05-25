package com.avito.android.shop_settings_select.di;

import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
public final class ShopSettingsSelectFragmentModule_ProvideChangePayloadCreatorFactory implements Factory<ChangePayloadCreator> {

    public static final class a {
        public static final ShopSettingsSelectFragmentModule_ProvideChangePayloadCreatorFactory a = new ShopSettingsSelectFragmentModule_ProvideChangePayloadCreatorFactory();
    }

    public static ShopSettingsSelectFragmentModule_ProvideChangePayloadCreatorFactory create() {
        return a.a;
    }

    @Nullable
    public static ChangePayloadCreator provideChangePayloadCreator() {
        return ShopSettingsSelectFragmentModule.INSTANCE.provideChangePayloadCreator();
    }

    @Override // javax.inject.Provider
    @Nullable
    public ChangePayloadCreator get() {
        return provideChangePayloadCreator();
    }
}
