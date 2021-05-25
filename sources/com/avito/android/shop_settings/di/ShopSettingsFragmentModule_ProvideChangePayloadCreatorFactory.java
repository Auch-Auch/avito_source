package com.avito.android.shop_settings.di;

import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
public final class ShopSettingsFragmentModule_ProvideChangePayloadCreatorFactory implements Factory<ChangePayloadCreator> {

    public static final class a {
        public static final ShopSettingsFragmentModule_ProvideChangePayloadCreatorFactory a = new ShopSettingsFragmentModule_ProvideChangePayloadCreatorFactory();
    }

    public static ShopSettingsFragmentModule_ProvideChangePayloadCreatorFactory create() {
        return a.a;
    }

    @Nullable
    public static ChangePayloadCreator provideChangePayloadCreator() {
        return ShopSettingsFragmentModule.INSTANCE.provideChangePayloadCreator();
    }

    @Override // javax.inject.Provider
    @Nullable
    public ChangePayloadCreator get() {
        return provideChangePayloadCreator();
    }
}
