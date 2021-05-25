package com.avito.android.serp;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractor;
import com.avito.android.serp.adapter.SerpItemAligner;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.warning.WarningStateProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpInteractorImpl_Factory implements Factory<SerpInteractorImpl> {
    public final Provider<SerpArguments> a;
    public final Provider<SearchApi> b;
    public final Provider<SearchParamsConverter> c;
    public final Provider<SuggestParamsConverter> d;
    public final Provider<TypedErrorThrowableConverter> e;
    public final Provider<CommercialBannersInteractor> f;
    public final Provider<SchedulersFactory3> g;
    public final Provider<SerpItemProcessor> h;
    public final Provider<SerpItemAligner> i;
    public final Provider<Analytics> j;
    public final Provider<SerpResourcesProvider> k;
    public final Provider<ProfileInfoStorage> l;
    public final Provider<Features> m;
    public final Provider<SerpSearchSubscriptionInteractor> n;
    public final Provider<SearchDeepLinkInteractor> o;
    public final Provider<WarningStateProvider> p;
    public final Provider<NotificationManagerProvider> q;
    public final Provider<SerpTracker> r;
    public final Provider<SerpSnippetInteractor> s;
    public final Provider<InlineFiltersInteractor> t;
    public final Provider<Boolean> u;
    public final Provider<Kundle> v;

    public SerpInteractorImpl_Factory(Provider<SerpArguments> provider, Provider<SearchApi> provider2, Provider<SearchParamsConverter> provider3, Provider<SuggestParamsConverter> provider4, Provider<TypedErrorThrowableConverter> provider5, Provider<CommercialBannersInteractor> provider6, Provider<SchedulersFactory3> provider7, Provider<SerpItemProcessor> provider8, Provider<SerpItemAligner> provider9, Provider<Analytics> provider10, Provider<SerpResourcesProvider> provider11, Provider<ProfileInfoStorage> provider12, Provider<Features> provider13, Provider<SerpSearchSubscriptionInteractor> provider14, Provider<SearchDeepLinkInteractor> provider15, Provider<WarningStateProvider> provider16, Provider<NotificationManagerProvider> provider17, Provider<SerpTracker> provider18, Provider<SerpSnippetInteractor> provider19, Provider<InlineFiltersInteractor> provider20, Provider<Boolean> provider21, Provider<Kundle> provider22) {
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
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
        this.u = provider21;
        this.v = provider22;
    }

    public static SerpInteractorImpl_Factory create(Provider<SerpArguments> provider, Provider<SearchApi> provider2, Provider<SearchParamsConverter> provider3, Provider<SuggestParamsConverter> provider4, Provider<TypedErrorThrowableConverter> provider5, Provider<CommercialBannersInteractor> provider6, Provider<SchedulersFactory3> provider7, Provider<SerpItemProcessor> provider8, Provider<SerpItemAligner> provider9, Provider<Analytics> provider10, Provider<SerpResourcesProvider> provider11, Provider<ProfileInfoStorage> provider12, Provider<Features> provider13, Provider<SerpSearchSubscriptionInteractor> provider14, Provider<SearchDeepLinkInteractor> provider15, Provider<WarningStateProvider> provider16, Provider<NotificationManagerProvider> provider17, Provider<SerpTracker> provider18, Provider<SerpSnippetInteractor> provider19, Provider<InlineFiltersInteractor> provider20, Provider<Boolean> provider21, Provider<Kundle> provider22) {
        return new SerpInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22);
    }

    public static SerpInteractorImpl newInstance(SerpArguments serpArguments, SearchApi searchApi, SearchParamsConverter searchParamsConverter, SuggestParamsConverter suggestParamsConverter, TypedErrorThrowableConverter typedErrorThrowableConverter, CommercialBannersInteractor commercialBannersInteractor, SchedulersFactory3 schedulersFactory3, SerpItemProcessor serpItemProcessor, SerpItemAligner serpItemAligner, Analytics analytics, SerpResourcesProvider serpResourcesProvider, ProfileInfoStorage profileInfoStorage, Features features, SerpSearchSubscriptionInteractor serpSearchSubscriptionInteractor, SearchDeepLinkInteractor searchDeepLinkInteractor, WarningStateProvider warningStateProvider, NotificationManagerProvider notificationManagerProvider, SerpTracker serpTracker, SerpSnippetInteractor serpSnippetInteractor, InlineFiltersInteractor inlineFiltersInteractor, boolean z, Kundle kundle) {
        return new SerpInteractorImpl(serpArguments, searchApi, searchParamsConverter, suggestParamsConverter, typedErrorThrowableConverter, commercialBannersInteractor, schedulersFactory3, serpItemProcessor, serpItemAligner, analytics, serpResourcesProvider, profileInfoStorage, features, serpSearchSubscriptionInteractor, searchDeepLinkInteractor, warningStateProvider, notificationManagerProvider, serpTracker, serpSnippetInteractor, inlineFiltersInteractor, z, kundle);
    }

    @Override // javax.inject.Provider
    public SerpInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get().booleanValue(), this.v.get());
    }
}
