package com.avito.android.di.module;

import com.google.gson.TypeAdapterFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ShopSettingsJsonModule_ProvideShopSettingsTypeAdapterFactoriesFactory implements Factory<Set<TypeAdapterFactory>> {

    public static final class a {
        public static final ShopSettingsJsonModule_ProvideShopSettingsTypeAdapterFactoriesFactory a = new ShopSettingsJsonModule_ProvideShopSettingsTypeAdapterFactoriesFactory();
    }

    public static ShopSettingsJsonModule_ProvideShopSettingsTypeAdapterFactoriesFactory create() {
        return a.a;
    }

    public static Set<TypeAdapterFactory> provideShopSettingsTypeAdapterFactories() {
        return (Set) Preconditions.checkNotNullFromProvides(ShopSettingsJsonModule.provideShopSettingsTypeAdapterFactories());
    }

    @Override // javax.inject.Provider
    public Set<TypeAdapterFactory> get() {
        return provideShopSettingsTypeAdapterFactories();
    }
}
