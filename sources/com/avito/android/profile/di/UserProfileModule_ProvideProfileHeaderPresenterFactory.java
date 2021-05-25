package com.avito.android.profile.di;

import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.profile.header.ProfileHeaderPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserProfileModule_ProvideProfileHeaderPresenterFactory implements Factory<ProfileHeaderPresenter> {
    public final UserProfileModule a;
    public final Provider<UserAdvertsTabTestGroup> b;
    public final Provider<UserProfileResourceProvider> c;
    public final Provider<Analytics> d;
    public final Provider<NotificationCenterCounterInteractor> e;
    public final Provider<SchedulersFactory3> f;

    public UserProfileModule_ProvideProfileHeaderPresenterFactory(UserProfileModule userProfileModule, Provider<UserAdvertsTabTestGroup> provider, Provider<UserProfileResourceProvider> provider2, Provider<Analytics> provider3, Provider<NotificationCenterCounterInteractor> provider4, Provider<SchedulersFactory3> provider5) {
        this.a = userProfileModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static UserProfileModule_ProvideProfileHeaderPresenterFactory create(UserProfileModule userProfileModule, Provider<UserAdvertsTabTestGroup> provider, Provider<UserProfileResourceProvider> provider2, Provider<Analytics> provider3, Provider<NotificationCenterCounterInteractor> provider4, Provider<SchedulersFactory3> provider5) {
        return new UserProfileModule_ProvideProfileHeaderPresenterFactory(userProfileModule, provider, provider2, provider3, provider4, provider5);
    }

    public static ProfileHeaderPresenter provideProfileHeaderPresenter(UserProfileModule userProfileModule, UserAdvertsTabTestGroup userAdvertsTabTestGroup, UserProfileResourceProvider userProfileResourceProvider, Analytics analytics, NotificationCenterCounterInteractor notificationCenterCounterInteractor, SchedulersFactory3 schedulersFactory3) {
        return (ProfileHeaderPresenter) Preconditions.checkNotNullFromProvides(userProfileModule.provideProfileHeaderPresenter(userAdvertsTabTestGroup, userProfileResourceProvider, analytics, notificationCenterCounterInteractor, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ProfileHeaderPresenter get() {
        return provideProfileHeaderPresenter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
