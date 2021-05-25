package com.avito.android.advert.item.price_discount;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PriceWithDiscountBlueprint_Factory implements Factory<PriceWithDiscountBlueprint> {
    public final Provider<PriceWithDiscountPresenter> a;

    public PriceWithDiscountBlueprint_Factory(Provider<PriceWithDiscountPresenter> provider) {
        this.a = provider;
    }

    public static PriceWithDiscountBlueprint_Factory create(Provider<PriceWithDiscountPresenter> provider) {
        return new PriceWithDiscountBlueprint_Factory(provider);
    }

    public static PriceWithDiscountBlueprint newInstance(PriceWithDiscountPresenter priceWithDiscountPresenter) {
        return new PriceWithDiscountBlueprint(priceWithDiscountPresenter);
    }

    @Override // javax.inject.Provider
    public PriceWithDiscountBlueprint get() {
        return newInstance(this.a.get());
    }
}
