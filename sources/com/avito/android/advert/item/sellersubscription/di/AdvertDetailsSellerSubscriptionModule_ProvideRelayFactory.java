package com.avito.android.advert.item.sellersubscription.di;

import com.avito.android.advert.item.sellersubscription.action.SellerSubscriptionAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AdvertDetailsSellerSubscriptionModule_ProvideRelayFactory implements Factory<PublishRelay<SellerSubscriptionAction>> {

    public static final class a {
        public static final AdvertDetailsSellerSubscriptionModule_ProvideRelayFactory a = new AdvertDetailsSellerSubscriptionModule_ProvideRelayFactory();
    }

    public static AdvertDetailsSellerSubscriptionModule_ProvideRelayFactory create() {
        return a.a;
    }

    public static PublishRelay<SellerSubscriptionAction> provideRelay() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(AdvertDetailsSellerSubscriptionModule.provideRelay());
    }

    @Override // javax.inject.Provider
    public PublishRelay<SellerSubscriptionAction> get() {
        return provideRelay();
    }
}
