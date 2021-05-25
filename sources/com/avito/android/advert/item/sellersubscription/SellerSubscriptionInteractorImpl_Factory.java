package com.avito.android.advert.item.sellersubscription;

import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerSubscriptionInteractorImpl_Factory implements Factory<SellerSubscriptionInteractorImpl> {
    public final Provider<FavoriteSellersApi> a;
    public final Provider<NotificationManagerProvider> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<FavoriteSellersRepository> d;
    public final Provider<Features> e;

    public SellerSubscriptionInteractorImpl_Factory(Provider<FavoriteSellersApi> provider, Provider<NotificationManagerProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<FavoriteSellersRepository> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SellerSubscriptionInteractorImpl_Factory create(Provider<FavoriteSellersApi> provider, Provider<NotificationManagerProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<FavoriteSellersRepository> provider4, Provider<Features> provider5) {
        return new SellerSubscriptionInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SellerSubscriptionInteractorImpl newInstance(FavoriteSellersApi favoriteSellersApi, NotificationManagerProvider notificationManagerProvider, SchedulersFactory3 schedulersFactory3, FavoriteSellersRepository favoriteSellersRepository, Features features) {
        return new SellerSubscriptionInteractorImpl(favoriteSellersApi, notificationManagerProvider, schedulersFactory3, favoriteSellersRepository, features);
    }

    @Override // javax.inject.Provider
    public SellerSubscriptionInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
