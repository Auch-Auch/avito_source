package com.avito.android.user_adverts.root_screen.adverts_host;

import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.app_rater.AppRaterInteractor;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_adverts.tracker.UserAdvertsTracker;
import com.avito.android.user_adverts_common.safety.SafetyInfoProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserAdvertsHostPresenterImpl_Factory implements Factory<UserAdvertsHostPresenterImpl> {
    public final Provider<UserAdvertsInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TabsDataProvider<TabItem>> c;
    public final Provider<Features> d;
    public final Provider<Analytics> e;
    public final Provider<AppRaterInteractor> f;
    public final Provider<TimeSource> g;
    public final Provider<UserAdvertsTracker> h;
    public final Provider<Bundle> i;
    public final Provider<String> j;
    public final Provider<AccountStateProvider> k;
    public final Provider<SafetyInfoProvider> l;

    public UserAdvertsHostPresenterImpl_Factory(Provider<UserAdvertsInteractor> provider, Provider<SchedulersFactory> provider2, Provider<TabsDataProvider<TabItem>> provider3, Provider<Features> provider4, Provider<Analytics> provider5, Provider<AppRaterInteractor> provider6, Provider<TimeSource> provider7, Provider<UserAdvertsTracker> provider8, Provider<Bundle> provider9, Provider<String> provider10, Provider<AccountStateProvider> provider11, Provider<SafetyInfoProvider> provider12) {
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
    }

    public static UserAdvertsHostPresenterImpl_Factory create(Provider<UserAdvertsInteractor> provider, Provider<SchedulersFactory> provider2, Provider<TabsDataProvider<TabItem>> provider3, Provider<Features> provider4, Provider<Analytics> provider5, Provider<AppRaterInteractor> provider6, Provider<TimeSource> provider7, Provider<UserAdvertsTracker> provider8, Provider<Bundle> provider9, Provider<String> provider10, Provider<AccountStateProvider> provider11, Provider<SafetyInfoProvider> provider12) {
        return new UserAdvertsHostPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static UserAdvertsHostPresenterImpl newInstance(UserAdvertsInteractor userAdvertsInteractor, SchedulersFactory schedulersFactory, TabsDataProvider<TabItem> tabsDataProvider, Features features, Analytics analytics, AppRaterInteractor appRaterInteractor, TimeSource timeSource, UserAdvertsTracker userAdvertsTracker, Bundle bundle, String str, AccountStateProvider accountStateProvider, SafetyInfoProvider safetyInfoProvider) {
        return new UserAdvertsHostPresenterImpl(userAdvertsInteractor, schedulersFactory, tabsDataProvider, features, analytics, appRaterInteractor, timeSource, userAdvertsTracker, bundle, str, accountStateProvider, safetyInfoProvider);
    }

    @Override // javax.inject.Provider
    public UserAdvertsHostPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
