package com.avito.android.basket.checkout.item.price;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PriceItemBlueprint_Factory implements Factory<PriceItemBlueprint> {
    public final Provider<PriceItemPresenter> a;

    public PriceItemBlueprint_Factory(Provider<PriceItemPresenter> provider) {
        this.a = provider;
    }

    public static PriceItemBlueprint_Factory create(Provider<PriceItemPresenter> provider) {
        return new PriceItemBlueprint_Factory(provider);
    }

    public static PriceItemBlueprint newInstance(PriceItemPresenter priceItemPresenter) {
        return new PriceItemBlueprint(priceItemPresenter);
    }

    @Override // javax.inject.Provider
    public PriceItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
