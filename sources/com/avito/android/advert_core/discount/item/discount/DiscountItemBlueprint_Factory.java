package com.avito.android.advert_core.discount.item.discount;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DiscountItemBlueprint_Factory implements Factory<DiscountItemBlueprint> {
    public final Provider<DiscountItemPresenter> a;

    public DiscountItemBlueprint_Factory(Provider<DiscountItemPresenter> provider) {
        this.a = provider;
    }

    public static DiscountItemBlueprint_Factory create(Provider<DiscountItemPresenter> provider) {
        return new DiscountItemBlueprint_Factory(provider);
    }

    public static DiscountItemBlueprint newInstance(DiscountItemPresenter discountItemPresenter) {
        return new DiscountItemBlueprint(discountItemPresenter);
    }

    @Override // javax.inject.Provider
    public DiscountItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
