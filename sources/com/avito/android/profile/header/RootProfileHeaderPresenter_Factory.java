package com.avito.android.profile.header;

import com.avito.android.analytics.Analytics;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RootProfileHeaderPresenter_Factory implements Factory<RootProfileHeaderPresenter> {
    public final Provider<UserProfileResourceProvider> a;
    public final Provider<Analytics> b;
    public final Provider<NotificationCenterCounterInteractor> c;
    public final Provider<SchedulersFactory3> d;

    public RootProfileHeaderPresenter_Factory(Provider<UserProfileResourceProvider> provider, Provider<Analytics> provider2, Provider<NotificationCenterCounterInteractor> provider3, Provider<SchedulersFactory3> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static RootProfileHeaderPresenter_Factory create(Provider<UserProfileResourceProvider> provider, Provider<Analytics> provider2, Provider<NotificationCenterCounterInteractor> provider3, Provider<SchedulersFactory3> provider4) {
        return new RootProfileHeaderPresenter_Factory(provider, provider2, provider3, provider4);
    }

    public static RootProfileHeaderPresenter newInstance(UserProfileResourceProvider userProfileResourceProvider, Analytics analytics, NotificationCenterCounterInteractor notificationCenterCounterInteractor, SchedulersFactory3 schedulersFactory3) {
        return new RootProfileHeaderPresenter(userProfileResourceProvider, analytics, notificationCenterCounterInteractor, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public RootProfileHeaderPresenter get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
