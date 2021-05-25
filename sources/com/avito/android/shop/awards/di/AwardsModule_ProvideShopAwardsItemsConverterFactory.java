package com.avito.android.shop.awards.di;

import com.avito.android.shop.awards.ShopAwardsItemsConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AwardsModule_ProvideShopAwardsItemsConverterFactory implements Factory<ShopAwardsItemsConverter> {

    public static final class a {
        public static final AwardsModule_ProvideShopAwardsItemsConverterFactory a = new AwardsModule_ProvideShopAwardsItemsConverterFactory();
    }

    public static AwardsModule_ProvideShopAwardsItemsConverterFactory create() {
        return a.a;
    }

    public static ShopAwardsItemsConverter provideShopAwardsItemsConverter() {
        return (ShopAwardsItemsConverter) Preconditions.checkNotNullFromProvides(AwardsModule.provideShopAwardsItemsConverter());
    }

    @Override // javax.inject.Provider
    public ShopAwardsItemsConverter get() {
        return provideShopAwardsItemsConverter();
    }
}
