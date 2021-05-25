package com.avito.android.advert;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertDetailsPriceSubscriptionTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsToolbarPresenterImpl_Factory implements Factory<AdvertDetailsToolbarPresenterImpl> {
    public final Provider<AdvertSharingEventTracker> a;
    public final Provider<AdvertDetailsFavoriteInteractor> b;
    public final Provider<ViewedAdvertsInteractor> c;
    public final Provider<Formatter<Throwable>> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<AdvertDetailsResourcesProvider> f;
    public final Provider<AdvertDetailsAnalyticsInteractor> g;
    public final Provider<Preferences> h;
    public final Provider<NotificationManagerProvider> i;
    public final Provider<AccountStateProvider> j;
    public final Provider<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> k;
    public final Provider<Features> l;
    public final Provider<Kundle> m;

    public AdvertDetailsToolbarPresenterImpl_Factory(Provider<AdvertSharingEventTracker> provider, Provider<AdvertDetailsFavoriteInteractor> provider2, Provider<ViewedAdvertsInteractor> provider3, Provider<Formatter<Throwable>> provider4, Provider<SchedulersFactory3> provider5, Provider<AdvertDetailsResourcesProvider> provider6, Provider<AdvertDetailsAnalyticsInteractor> provider7, Provider<Preferences> provider8, Provider<NotificationManagerProvider> provider9, Provider<AccountStateProvider> provider10, Provider<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> provider11, Provider<Features> provider12, Provider<Kundle> provider13) {
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
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
    }

    public static AdvertDetailsToolbarPresenterImpl_Factory create(Provider<AdvertSharingEventTracker> provider, Provider<AdvertDetailsFavoriteInteractor> provider2, Provider<ViewedAdvertsInteractor> provider3, Provider<Formatter<Throwable>> provider4, Provider<SchedulersFactory3> provider5, Provider<AdvertDetailsResourcesProvider> provider6, Provider<AdvertDetailsAnalyticsInteractor> provider7, Provider<Preferences> provider8, Provider<NotificationManagerProvider> provider9, Provider<AccountStateProvider> provider10, Provider<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> provider11, Provider<Features> provider12, Provider<Kundle> provider13) {
        return new AdvertDetailsToolbarPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static AdvertDetailsToolbarPresenterImpl newInstance(AdvertSharingEventTracker advertSharingEventTracker, AdvertDetailsFavoriteInteractor advertDetailsFavoriteInteractor, ViewedAdvertsInteractor viewedAdvertsInteractor, Formatter<Throwable> formatter, SchedulersFactory3 schedulersFactory3, AdvertDetailsResourcesProvider advertDetailsResourcesProvider, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, Preferences preferences, NotificationManagerProvider notificationManagerProvider, AccountStateProvider accountStateProvider, ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> manuallyExposedAbTestGroup, Features features, Kundle kundle) {
        return new AdvertDetailsToolbarPresenterImpl(advertSharingEventTracker, advertDetailsFavoriteInteractor, viewedAdvertsInteractor, formatter, schedulersFactory3, advertDetailsResourcesProvider, advertDetailsAnalyticsInteractor, preferences, notificationManagerProvider, accountStateProvider, manuallyExposedAbTestGroup, features, kundle);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsToolbarPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get());
    }
}
