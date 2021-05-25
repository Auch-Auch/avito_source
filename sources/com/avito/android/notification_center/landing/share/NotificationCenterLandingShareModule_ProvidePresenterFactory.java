package com.avito.android.notification_center.landing.share;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationCenterLandingShareModule_ProvidePresenterFactory implements Factory<NotificationCenterLandingSharePresenter> {
    public final NotificationCenterLandingShareModule a;
    public final Provider<Analytics> b;
    public final Provider<NotificationCenterLandingShareInteractor> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<ShareImageInteractor> e;

    public NotificationCenterLandingShareModule_ProvidePresenterFactory(NotificationCenterLandingShareModule notificationCenterLandingShareModule, Provider<Analytics> provider, Provider<NotificationCenterLandingShareInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<ShareImageInteractor> provider4) {
        this.a = notificationCenterLandingShareModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static NotificationCenterLandingShareModule_ProvidePresenterFactory create(NotificationCenterLandingShareModule notificationCenterLandingShareModule, Provider<Analytics> provider, Provider<NotificationCenterLandingShareInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<ShareImageInteractor> provider4) {
        return new NotificationCenterLandingShareModule_ProvidePresenterFactory(notificationCenterLandingShareModule, provider, provider2, provider3, provider4);
    }

    public static NotificationCenterLandingSharePresenter providePresenter(NotificationCenterLandingShareModule notificationCenterLandingShareModule, Analytics analytics, NotificationCenterLandingShareInteractor notificationCenterLandingShareInteractor, SchedulersFactory schedulersFactory, ShareImageInteractor shareImageInteractor) {
        return (NotificationCenterLandingSharePresenter) Preconditions.checkNotNullFromProvides(notificationCenterLandingShareModule.providePresenter(analytics, notificationCenterLandingShareInteractor, schedulersFactory, shareImageInteractor));
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingSharePresenter get() {
        return providePresenter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
