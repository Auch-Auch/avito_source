package com.avito.android.favorite_sellers.adapter.seller;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerItemBlueprint_Factory implements Factory<SellerItemBlueprint> {
    public final Provider<SellerItemPresenter> a;

    public SellerItemBlueprint_Factory(Provider<SellerItemPresenter> provider) {
        this.a = provider;
    }

    public static SellerItemBlueprint_Factory create(Provider<SellerItemPresenter> provider) {
        return new SellerItemBlueprint_Factory(provider);
    }

    public static SellerItemBlueprint newInstance(SellerItemPresenter sellerItemPresenter) {
        return new SellerItemBlueprint(sellerItemPresenter);
    }

    @Override // javax.inject.Provider
    public SellerItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
