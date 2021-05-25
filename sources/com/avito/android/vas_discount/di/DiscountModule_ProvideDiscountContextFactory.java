package com.avito.android.vas_discount.di;

import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;
public final class DiscountModule_ProvideDiscountContextFactory implements Factory<String> {
    public final DiscountModule a;

    public DiscountModule_ProvideDiscountContextFactory(DiscountModule discountModule) {
        this.a = discountModule;
    }

    public static DiscountModule_ProvideDiscountContextFactory create(DiscountModule discountModule) {
        return new DiscountModule_ProvideDiscountContextFactory(discountModule);
    }

    @Nullable
    public static String provideDiscountContext(DiscountModule discountModule) {
        return discountModule.provideDiscountContext();
    }

    @Override // javax.inject.Provider
    @Nullable
    public String get() {
        return provideDiscountContext(this.a);
    }
}
