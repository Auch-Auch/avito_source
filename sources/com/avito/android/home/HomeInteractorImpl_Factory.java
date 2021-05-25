package com.avito.android.home;

import com.avito.android.IdProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.adapter.MoreActionsItemProcessor;
import com.avito.android.home.analytics.HomeTracker;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.stories.StartupBannerInteractor;
import com.avito.android.stories.StoriesInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HomeInteractorImpl_Factory implements Factory<HomeInteractorImpl> {
    public final Provider<LocationApi> a;
    public final Provider<SearchApi> b;
    public final Provider<SerpItemProcessor> c;
    public final Provider<MoreActionsItemProcessor> d;
    public final Provider<CommercialBannersInteractor> e;
    public final Provider<SuggestParamsConverter> f;
    public final Provider<TypedErrorThrowableConverter> g;
    public final Provider<SavedLocationInteractor> h;
    public final Provider<IdProvider> i;
    public final Provider<SchedulersFactory3> j;
    public final Provider<AccountStateProvider> k;
    public final Provider<SearchDeepLinkInteractor> l;
    public final Provider<StoriesInteractor> m;
    public final Provider<StartupBannerInteractor> n;
    public final Provider<HomeTracker> o;
    public final Provider<LocationAnalyticsInteractor> p;
    public final Provider<HomeInteractorState> q;

    public HomeInteractorImpl_Factory(Provider<LocationApi> provider, Provider<SearchApi> provider2, Provider<SerpItemProcessor> provider3, Provider<MoreActionsItemProcessor> provider4, Provider<CommercialBannersInteractor> provider5, Provider<SuggestParamsConverter> provider6, Provider<TypedErrorThrowableConverter> provider7, Provider<SavedLocationInteractor> provider8, Provider<IdProvider> provider9, Provider<SchedulersFactory3> provider10, Provider<AccountStateProvider> provider11, Provider<SearchDeepLinkInteractor> provider12, Provider<StoriesInteractor> provider13, Provider<StartupBannerInteractor> provider14, Provider<HomeTracker> provider15, Provider<LocationAnalyticsInteractor> provider16, Provider<HomeInteractorState> provider17) {
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
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
    }

    public static HomeInteractorImpl_Factory create(Provider<LocationApi> provider, Provider<SearchApi> provider2, Provider<SerpItemProcessor> provider3, Provider<MoreActionsItemProcessor> provider4, Provider<CommercialBannersInteractor> provider5, Provider<SuggestParamsConverter> provider6, Provider<TypedErrorThrowableConverter> provider7, Provider<SavedLocationInteractor> provider8, Provider<IdProvider> provider9, Provider<SchedulersFactory3> provider10, Provider<AccountStateProvider> provider11, Provider<SearchDeepLinkInteractor> provider12, Provider<StoriesInteractor> provider13, Provider<StartupBannerInteractor> provider14, Provider<HomeTracker> provider15, Provider<LocationAnalyticsInteractor> provider16, Provider<HomeInteractorState> provider17) {
        return new HomeInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static HomeInteractorImpl newInstance(LocationApi locationApi, SearchApi searchApi, SerpItemProcessor serpItemProcessor, MoreActionsItemProcessor moreActionsItemProcessor, CommercialBannersInteractor commercialBannersInteractor, SuggestParamsConverter suggestParamsConverter, TypedErrorThrowableConverter typedErrorThrowableConverter, SavedLocationInteractor savedLocationInteractor, IdProvider idProvider, SchedulersFactory3 schedulersFactory3, AccountStateProvider accountStateProvider, SearchDeepLinkInteractor searchDeepLinkInteractor, StoriesInteractor storiesInteractor, StartupBannerInteractor startupBannerInteractor, HomeTracker homeTracker, LocationAnalyticsInteractor locationAnalyticsInteractor, HomeInteractorState homeInteractorState) {
        return new HomeInteractorImpl(locationApi, searchApi, serpItemProcessor, moreActionsItemProcessor, commercialBannersInteractor, suggestParamsConverter, typedErrorThrowableConverter, savedLocationInteractor, idProvider, schedulersFactory3, accountStateProvider, searchDeepLinkInteractor, storiesInteractor, startupBannerInteractor, homeTracker, locationAnalyticsInteractor, homeInteractorState);
    }

    @Override // javax.inject.Provider
    public HomeInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get());
    }
}
