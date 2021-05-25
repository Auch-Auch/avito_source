package com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel;

import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class SellerCarouselItemPresenterImpl_Factory implements Factory<SellerCarouselItemPresenterImpl> {
    public final Provider<Consumer<FavoriteSellersItemAction>> a;

    public SellerCarouselItemPresenterImpl_Factory(Provider<Consumer<FavoriteSellersItemAction>> provider) {
        this.a = provider;
    }

    public static SellerCarouselItemPresenterImpl_Factory create(Provider<Consumer<FavoriteSellersItemAction>> provider) {
        return new SellerCarouselItemPresenterImpl_Factory(provider);
    }

    public static SellerCarouselItemPresenterImpl newInstance(Consumer<FavoriteSellersItemAction> consumer) {
        return new SellerCarouselItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public SellerCarouselItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
