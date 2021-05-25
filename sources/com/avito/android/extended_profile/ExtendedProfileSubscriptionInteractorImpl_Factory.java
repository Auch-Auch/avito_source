package com.avito.android.extended_profile;

import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileSubscriptionInteractorImpl_Factory implements Factory<ExtendedProfileSubscriptionInteractorImpl> {
    public final Provider<FavoriteSellersApi> a;
    public final Provider<NotificationManagerProvider> b;
    public final Provider<SchedulersFactory3> c;

    public ExtendedProfileSubscriptionInteractorImpl_Factory(Provider<FavoriteSellersApi> provider, Provider<NotificationManagerProvider> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ExtendedProfileSubscriptionInteractorImpl_Factory create(Provider<FavoriteSellersApi> provider, Provider<NotificationManagerProvider> provider2, Provider<SchedulersFactory3> provider3) {
        return new ExtendedProfileSubscriptionInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static ExtendedProfileSubscriptionInteractorImpl newInstance(FavoriteSellersApi favoriteSellersApi, NotificationManagerProvider notificationManagerProvider, SchedulersFactory3 schedulersFactory3) {
        return new ExtendedProfileSubscriptionInteractorImpl(favoriteSellersApi, notificationManagerProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ExtendedProfileSubscriptionInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
