package com.avito.android.user_advert.advert.service;

import androidx.core.app.NotificationManagerCompat;
import com.avito.android.PublishIntentFactory;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class UserAdvertService_MembersInjector implements MembersInjector<UserAdvertService> {
    public final Provider<Analytics> a;
    public final Provider<UserAdvertIntentFactory> b;
    public final Provider<UserAdvertsIntentFactory> c;
    public final Provider<PublishIntentFactory> d;
    public final Provider<NotificationManagerCompat> e;
    public final Provider<UserAdvertInteractor> f;

    public UserAdvertService_MembersInjector(Provider<Analytics> provider, Provider<UserAdvertIntentFactory> provider2, Provider<UserAdvertsIntentFactory> provider3, Provider<PublishIntentFactory> provider4, Provider<NotificationManagerCompat> provider5, Provider<UserAdvertInteractor> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<UserAdvertService> create(Provider<Analytics> provider, Provider<UserAdvertIntentFactory> provider2, Provider<UserAdvertsIntentFactory> provider3, Provider<PublishIntentFactory> provider4, Provider<NotificationManagerCompat> provider5, Provider<UserAdvertInteractor> provider6) {
        return new UserAdvertService_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.service.UserAdvertService.analytics")
    public static void injectAnalytics(UserAdvertService userAdvertService, Analytics analytics) {
        userAdvertService.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.service.UserAdvertService.interactor")
    public static void injectInteractor(UserAdvertService userAdvertService, UserAdvertInteractor userAdvertInteractor) {
        userAdvertService.interactor = userAdvertInteractor;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.service.UserAdvertService.notificationManagerCompat")
    public static void injectNotificationManagerCompat(UserAdvertService userAdvertService, NotificationManagerCompat notificationManagerCompat) {
        userAdvertService.notificationManagerCompat = notificationManagerCompat;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.service.UserAdvertService.publishIntentFactory")
    public static void injectPublishIntentFactory(UserAdvertService userAdvertService, PublishIntentFactory publishIntentFactory) {
        userAdvertService.publishIntentFactory = publishIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.service.UserAdvertService.userAdvertIntentFactory")
    public static void injectUserAdvertIntentFactory(UserAdvertService userAdvertService, UserAdvertIntentFactory userAdvertIntentFactory) {
        userAdvertService.userAdvertIntentFactory = userAdvertIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.user_advert.advert.service.UserAdvertService.userAdvertsIntentFactory")
    public static void injectUserAdvertsIntentFactory(UserAdvertService userAdvertService, UserAdvertsIntentFactory userAdvertsIntentFactory) {
        userAdvertService.userAdvertsIntentFactory = userAdvertsIntentFactory;
    }

    public void injectMembers(UserAdvertService userAdvertService) {
        injectAnalytics(userAdvertService, this.a.get());
        injectUserAdvertIntentFactory(userAdvertService, this.b.get());
        injectUserAdvertsIntentFactory(userAdvertService, this.c.get());
        injectPublishIntentFactory(userAdvertService, this.d.get());
        injectNotificationManagerCompat(userAdvertService, this.e.get());
        injectInteractor(userAdvertService, this.f.get());
    }
}
