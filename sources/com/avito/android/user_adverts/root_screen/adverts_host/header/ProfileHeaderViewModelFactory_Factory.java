package com.avito.android.user_adverts.root_screen.adverts_host.header;

import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileHeaderViewModelFactory_Factory implements Factory<ProfileHeaderViewModelFactory> {
    public final Provider<AccountStorageInteractor> a;
    public final Provider<NotificationCenterCounterInteractor> b;
    public final Provider<ProfileHeaderInteractor> c;
    public final Provider<CharityInteractor> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<Analytics> f;
    public final Provider<AccountStateProvider> g;
    public final Provider<Features> h;
    public final Provider<ProfileHeaderResourceProvider> i;
    public final Provider<UserAdvertsTabTestGroup> j;

    public ProfileHeaderViewModelFactory_Factory(Provider<AccountStorageInteractor> provider, Provider<NotificationCenterCounterInteractor> provider2, Provider<ProfileHeaderInteractor> provider3, Provider<CharityInteractor> provider4, Provider<SchedulersFactory> provider5, Provider<Analytics> provider6, Provider<AccountStateProvider> provider7, Provider<Features> provider8, Provider<ProfileHeaderResourceProvider> provider9, Provider<UserAdvertsTabTestGroup> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static ProfileHeaderViewModelFactory_Factory create(Provider<AccountStorageInteractor> provider, Provider<NotificationCenterCounterInteractor> provider2, Provider<ProfileHeaderInteractor> provider3, Provider<CharityInteractor> provider4, Provider<SchedulersFactory> provider5, Provider<Analytics> provider6, Provider<AccountStateProvider> provider7, Provider<Features> provider8, Provider<ProfileHeaderResourceProvider> provider9, Provider<UserAdvertsTabTestGroup> provider10) {
        return new ProfileHeaderViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static ProfileHeaderViewModelFactory newInstance(AccountStorageInteractor accountStorageInteractor, NotificationCenterCounterInteractor notificationCenterCounterInteractor, ProfileHeaderInteractor profileHeaderInteractor, CharityInteractor charityInteractor, SchedulersFactory schedulersFactory, Analytics analytics, AccountStateProvider accountStateProvider, Features features, ProfileHeaderResourceProvider profileHeaderResourceProvider, UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        return new ProfileHeaderViewModelFactory(accountStorageInteractor, notificationCenterCounterInteractor, profileHeaderInteractor, charityInteractor, schedulersFactory, analytics, accountStateProvider, features, profileHeaderResourceProvider, userAdvertsTabTestGroup);
    }

    @Override // javax.inject.Provider
    public ProfileHeaderViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
