package com.avito.android.public_profile.ui;

import com.avito.android.Features;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.tracker.PublicProfileTracker;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublicProfileInteractorImpl_Factory implements Factory<PublicProfileInteractorImpl> {
    public final Provider<PublicProfileApi> a;
    public final Provider<FavoriteSellersApi> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<NotificationManagerProvider> d;
    public final Provider<PublicProfileTracker> e;
    public final Provider<Features> f;

    public PublicProfileInteractorImpl_Factory(Provider<PublicProfileApi> provider, Provider<FavoriteSellersApi> provider2, Provider<SchedulersFactory3> provider3, Provider<NotificationManagerProvider> provider4, Provider<PublicProfileTracker> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static PublicProfileInteractorImpl_Factory create(Provider<PublicProfileApi> provider, Provider<FavoriteSellersApi> provider2, Provider<SchedulersFactory3> provider3, Provider<NotificationManagerProvider> provider4, Provider<PublicProfileTracker> provider5, Provider<Features> provider6) {
        return new PublicProfileInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PublicProfileInteractorImpl newInstance(PublicProfileApi publicProfileApi, FavoriteSellersApi favoriteSellersApi, SchedulersFactory3 schedulersFactory3, NotificationManagerProvider notificationManagerProvider, PublicProfileTracker publicProfileTracker, Features features) {
        return new PublicProfileInteractorImpl(publicProfileApi, favoriteSellersApi, schedulersFactory3, notificationManagerProvider, publicProfileTracker, features);
    }

    @Override // javax.inject.Provider
    public PublicProfileInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
