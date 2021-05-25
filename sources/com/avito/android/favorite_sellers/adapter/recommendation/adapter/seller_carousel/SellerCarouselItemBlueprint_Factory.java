package com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerCarouselItemBlueprint_Factory implements Factory<SellerCarouselItemBlueprint> {
    public final Provider<SellerCarouselItemPresenter> a;

    public SellerCarouselItemBlueprint_Factory(Provider<SellerCarouselItemPresenter> provider) {
        this.a = provider;
    }

    public static SellerCarouselItemBlueprint_Factory create(Provider<SellerCarouselItemPresenter> provider) {
        return new SellerCarouselItemBlueprint_Factory(provider);
    }

    public static SellerCarouselItemBlueprint newInstance(SellerCarouselItemPresenter sellerCarouselItemPresenter) {
        return new SellerCarouselItemBlueprint(sellerCarouselItemPresenter);
    }

    @Override // javax.inject.Provider
    public SellerCarouselItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
