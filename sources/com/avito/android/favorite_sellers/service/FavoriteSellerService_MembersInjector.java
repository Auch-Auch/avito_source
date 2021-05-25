package com.avito.android.favorite_sellers.service;

import androidx.core.app.NotificationManagerCompat;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FavoriteSellerService_MembersInjector implements MembersInjector<FavoriteSellerService> {
    public final Provider<Analytics> a;
    public final Provider<NotificationManagerCompat> b;
    public final Provider<FavoriteSellerInteractor> c;

    public FavoriteSellerService_MembersInjector(Provider<Analytics> provider, Provider<NotificationManagerCompat> provider2, Provider<FavoriteSellerInteractor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<FavoriteSellerService> create(Provider<Analytics> provider, Provider<NotificationManagerCompat> provider2, Provider<FavoriteSellerInteractor> provider3) {
        return new FavoriteSellerService_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.service.FavoriteSellerService.analytics")
    public static void injectAnalytics(FavoriteSellerService favoriteSellerService, Analytics analytics) {
        favoriteSellerService.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.service.FavoriteSellerService.interactor")
    public static void injectInteractor(FavoriteSellerService favoriteSellerService, FavoriteSellerInteractor favoriteSellerInteractor) {
        favoriteSellerService.interactor = favoriteSellerInteractor;
    }

    @InjectedFieldSignature("com.avito.android.favorite_sellers.service.FavoriteSellerService.notificationManagerCompat")
    public static void injectNotificationManagerCompat(FavoriteSellerService favoriteSellerService, NotificationManagerCompat notificationManagerCompat) {
        favoriteSellerService.notificationManagerCompat = notificationManagerCompat;
    }

    public void injectMembers(FavoriteSellerService favoriteSellerService) {
        injectAnalytics(favoriteSellerService, this.a.get());
        injectNotificationManagerCompat(favoriteSellerService, this.b.get());
        injectInteractor(favoriteSellerService, this.c.get());
    }
}
