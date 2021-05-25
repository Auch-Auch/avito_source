package com.avito.android.notification_center.landing.share;

import android.app.Application;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationCenterLandingShareModule_ProvideShareImageInteractorFactory implements Factory<ShareImageInteractor> {
    public final NotificationCenterLandingShareModule a;
    public final Provider<Application> b;
    public final Provider<SchedulersFactory> c;

    public NotificationCenterLandingShareModule_ProvideShareImageInteractorFactory(NotificationCenterLandingShareModule notificationCenterLandingShareModule, Provider<Application> provider, Provider<SchedulersFactory> provider2) {
        this.a = notificationCenterLandingShareModule;
        this.b = provider;
        this.c = provider2;
    }

    public static NotificationCenterLandingShareModule_ProvideShareImageInteractorFactory create(NotificationCenterLandingShareModule notificationCenterLandingShareModule, Provider<Application> provider, Provider<SchedulersFactory> provider2) {
        return new NotificationCenterLandingShareModule_ProvideShareImageInteractorFactory(notificationCenterLandingShareModule, provider, provider2);
    }

    public static ShareImageInteractor provideShareImageInteractor(NotificationCenterLandingShareModule notificationCenterLandingShareModule, Application application, SchedulersFactory schedulersFactory) {
        return (ShareImageInteractor) Preconditions.checkNotNullFromProvides(notificationCenterLandingShareModule.provideShareImageInteractor(application, schedulersFactory));
    }

    @Override // javax.inject.Provider
    public ShareImageInteractor get() {
        return provideShareImageInteractor(this.a, this.b.get(), this.c.get());
    }
}
