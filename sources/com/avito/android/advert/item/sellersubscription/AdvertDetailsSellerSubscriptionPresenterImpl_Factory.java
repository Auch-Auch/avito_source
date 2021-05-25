package com.avito.android.advert.item.sellersubscription;

import com.avito.android.advert.item.sellersubscription.action.SellerSubscriptionAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class AdvertDetailsSellerSubscriptionPresenterImpl_Factory implements Factory<AdvertDetailsSellerSubscriptionPresenterImpl> {
    public final Provider<Consumer<SellerSubscriptionAction>> a;

    public AdvertDetailsSellerSubscriptionPresenterImpl_Factory(Provider<Consumer<SellerSubscriptionAction>> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSellerSubscriptionPresenterImpl_Factory create(Provider<Consumer<SellerSubscriptionAction>> provider) {
        return new AdvertDetailsSellerSubscriptionPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsSellerSubscriptionPresenterImpl newInstance(Consumer<SellerSubscriptionAction> consumer) {
        return new AdvertDetailsSellerSubscriptionPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSellerSubscriptionPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
