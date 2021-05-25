package com.avito.android.basket_legacy.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BasketItemBlueprint_Factory implements Factory<BasketItemBlueprint> {
    public final Provider<BasketItemPresenter> a;

    public BasketItemBlueprint_Factory(Provider<BasketItemPresenter> provider) {
        this.a = provider;
    }

    public static BasketItemBlueprint_Factory create(Provider<BasketItemPresenter> provider) {
        return new BasketItemBlueprint_Factory(provider);
    }

    public static BasketItemBlueprint newInstance(BasketItemPresenter basketItemPresenter) {
        return new BasketItemBlueprint(basketItemPresenter);
    }

    @Override // javax.inject.Provider
    public BasketItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
