package com.avito.android.serp.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerPinItemBlueprint_Factory implements Factory<SellerPinItemBlueprint> {
    public final Provider<SellerPinItemPresenter> a;

    public SellerPinItemBlueprint_Factory(Provider<SellerPinItemPresenter> provider) {
        this.a = provider;
    }

    public static SellerPinItemBlueprint_Factory create(Provider<SellerPinItemPresenter> provider) {
        return new SellerPinItemBlueprint_Factory(provider);
    }

    public static SellerPinItemBlueprint newInstance(SellerPinItemPresenter sellerPinItemPresenter) {
        return new SellerPinItemBlueprint(sellerPinItemPresenter);
    }

    @Override // javax.inject.Provider
    public SellerPinItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
