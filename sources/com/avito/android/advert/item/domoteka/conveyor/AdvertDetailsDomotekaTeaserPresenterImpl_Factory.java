package com.avito.android.advert.item.domoteka.conveyor;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDomotekaTeaserPresenterImpl_Factory implements Factory<AdvertDetailsDomotekaTeaserPresenterImpl> {
    public final Provider<DomotekaTeaserInteractor> a;
    public final Provider<AdvertDetailsAnalyticsInteractor> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<SchedulersFactory3> d;

    public AdvertDetailsDomotekaTeaserPresenterImpl_Factory(Provider<DomotekaTeaserInteractor> provider, Provider<AdvertDetailsAnalyticsInteractor> provider2, Provider<AccountStateProvider> provider3, Provider<SchedulersFactory3> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AdvertDetailsDomotekaTeaserPresenterImpl_Factory create(Provider<DomotekaTeaserInteractor> provider, Provider<AdvertDetailsAnalyticsInteractor> provider2, Provider<AccountStateProvider> provider3, Provider<SchedulersFactory3> provider4) {
        return new AdvertDetailsDomotekaTeaserPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AdvertDetailsDomotekaTeaserPresenterImpl newInstance(DomotekaTeaserInteractor domotekaTeaserInteractor, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, AccountStateProvider accountStateProvider, SchedulersFactory3 schedulersFactory3) {
        return new AdvertDetailsDomotekaTeaserPresenterImpl(domotekaTeaserInteractor, advertDetailsAnalyticsInteractor, accountStateProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDomotekaTeaserPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
