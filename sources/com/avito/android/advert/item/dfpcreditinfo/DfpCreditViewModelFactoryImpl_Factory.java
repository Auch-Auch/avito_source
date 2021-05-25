package com.avito.android.advert.item.dfpcreditinfo;

import android.app.Application;
import com.avito.android.ab_tests.configs.SravniWebTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpCreditViewModelFactoryImpl_Factory implements Factory<DfpCreditViewModelFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<DfpCreditBannerLoader> c;
    public final Provider<AdvertDetailsAnalyticsInteractor> d;
    public final Provider<ProfileApi> e;
    public final Provider<AccountStateProvider> f;
    public final Provider<AdvertDetailsCreditStorage> g;
    public final Provider<SingleManuallyExposedAbTestGroup<SravniWebTestGroup>> h;

    public DfpCreditViewModelFactoryImpl_Factory(Provider<Application> provider, Provider<SchedulersFactory3> provider2, Provider<DfpCreditBannerLoader> provider3, Provider<AdvertDetailsAnalyticsInteractor> provider4, Provider<ProfileApi> provider5, Provider<AccountStateProvider> provider6, Provider<AdvertDetailsCreditStorage> provider7, Provider<SingleManuallyExposedAbTestGroup<SravniWebTestGroup>> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static DfpCreditViewModelFactoryImpl_Factory create(Provider<Application> provider, Provider<SchedulersFactory3> provider2, Provider<DfpCreditBannerLoader> provider3, Provider<AdvertDetailsAnalyticsInteractor> provider4, Provider<ProfileApi> provider5, Provider<AccountStateProvider> provider6, Provider<AdvertDetailsCreditStorage> provider7, Provider<SingleManuallyExposedAbTestGroup<SravniWebTestGroup>> provider8) {
        return new DfpCreditViewModelFactoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static DfpCreditViewModelFactoryImpl newInstance(Application application, SchedulersFactory3 schedulersFactory3, DfpCreditBannerLoader dfpCreditBannerLoader, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, ProfileApi profileApi, AccountStateProvider accountStateProvider, AdvertDetailsCreditStorage advertDetailsCreditStorage, SingleManuallyExposedAbTestGroup<SravniWebTestGroup> singleManuallyExposedAbTestGroup) {
        return new DfpCreditViewModelFactoryImpl(application, schedulersFactory3, dfpCreditBannerLoader, advertDetailsAnalyticsInteractor, profileApi, accountStateProvider, advertDetailsCreditStorage, singleManuallyExposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public DfpCreditViewModelFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
