package com.avito.android.advert_core.analytics.sharing;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertSharingEventTrackerImpl_Factory implements Factory<AdvertSharingEventTrackerImpl> {
    public final Provider<Analytics> a;
    public final Provider<AccountStateProvider> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Features> d;

    public AdvertSharingEventTrackerImpl_Factory(Provider<Analytics> provider, Provider<AccountStateProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AdvertSharingEventTrackerImpl_Factory create(Provider<Analytics> provider, Provider<AccountStateProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<Features> provider4) {
        return new AdvertSharingEventTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AdvertSharingEventTrackerImpl newInstance(Analytics analytics, AccountStateProvider accountStateProvider, SchedulersFactory3 schedulersFactory3, Features features) {
        return new AdvertSharingEventTrackerImpl(analytics, accountStateProvider, schedulersFactory3, features);
    }

    @Override // javax.inject.Provider
    public AdvertSharingEventTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
