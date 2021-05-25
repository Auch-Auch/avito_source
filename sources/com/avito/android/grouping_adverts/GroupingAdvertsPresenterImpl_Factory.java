package com.avito.android.grouping_adverts;

import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupingAdvertsPresenterImpl_Factory implements Factory<GroupingAdvertsPresenterImpl> {
    public final Provider<GroupingAdvertsArguments> a;
    public final Provider<GroupingAdvertsInteractor> b;
    public final Provider<SerpAnalyticsInteractor> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<AdapterPresenter> e;
    public final Provider<FavoriteAdvertsPresenter> f;
    public final Provider<SerpItemProcessor> g;
    public final Provider<ViewedAdvertsPresenter> h;
    public final Provider<SerpSpanProvider> i;
    public final Provider<SpannedGridPositionProvider> j;
    public final Provider<GroupingAdvertsResourcesProvider> k;
    public final Provider<ClickStreamLinkHandler> l;
    public final Provider<Formatter<String>> m;
    public final Provider<Analytics> n;
    public final Provider<AbTestGroup<SimpleTestGroupWithControl2>> o;
    public final Provider<AsyncPhonePresenter> p;
    public final Provider<GroupingAdvertsItemsFilter> q;
    public final Provider<Kundle> r;

    public GroupingAdvertsPresenterImpl_Factory(Provider<GroupingAdvertsArguments> provider, Provider<GroupingAdvertsInteractor> provider2, Provider<SerpAnalyticsInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<AdapterPresenter> provider5, Provider<FavoriteAdvertsPresenter> provider6, Provider<SerpItemProcessor> provider7, Provider<ViewedAdvertsPresenter> provider8, Provider<SerpSpanProvider> provider9, Provider<SpannedGridPositionProvider> provider10, Provider<GroupingAdvertsResourcesProvider> provider11, Provider<ClickStreamLinkHandler> provider12, Provider<Formatter<String>> provider13, Provider<Analytics> provider14, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider15, Provider<AsyncPhonePresenter> provider16, Provider<GroupingAdvertsItemsFilter> provider17, Provider<Kundle> provider18) {
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
    }

    public static GroupingAdvertsPresenterImpl_Factory create(Provider<GroupingAdvertsArguments> provider, Provider<GroupingAdvertsInteractor> provider2, Provider<SerpAnalyticsInteractor> provider3, Provider<SchedulersFactory3> provider4, Provider<AdapterPresenter> provider5, Provider<FavoriteAdvertsPresenter> provider6, Provider<SerpItemProcessor> provider7, Provider<ViewedAdvertsPresenter> provider8, Provider<SerpSpanProvider> provider9, Provider<SpannedGridPositionProvider> provider10, Provider<GroupingAdvertsResourcesProvider> provider11, Provider<ClickStreamLinkHandler> provider12, Provider<Formatter<String>> provider13, Provider<Analytics> provider14, Provider<AbTestGroup<SimpleTestGroupWithControl2>> provider15, Provider<AsyncPhonePresenter> provider16, Provider<GroupingAdvertsItemsFilter> provider17, Provider<Kundle> provider18) {
        return new GroupingAdvertsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    public static GroupingAdvertsPresenterImpl newInstance(GroupingAdvertsArguments groupingAdvertsArguments, GroupingAdvertsInteractor groupingAdvertsInteractor, SerpAnalyticsInteractor serpAnalyticsInteractor, SchedulersFactory3 schedulersFactory3, AdapterPresenter adapterPresenter, FavoriteAdvertsPresenter favoriteAdvertsPresenter, SerpItemProcessor serpItemProcessor, ViewedAdvertsPresenter viewedAdvertsPresenter, SerpSpanProvider serpSpanProvider, SpannedGridPositionProvider spannedGridPositionProvider, GroupingAdvertsResourcesProvider groupingAdvertsResourcesProvider, ClickStreamLinkHandler clickStreamLinkHandler, Formatter<String> formatter, Analytics analytics, AbTestGroup<SimpleTestGroupWithControl2> abTestGroup, AsyncPhonePresenter asyncPhonePresenter, GroupingAdvertsItemsFilter groupingAdvertsItemsFilter, Kundle kundle) {
        return new GroupingAdvertsPresenterImpl(groupingAdvertsArguments, groupingAdvertsInteractor, serpAnalyticsInteractor, schedulersFactory3, adapterPresenter, favoriteAdvertsPresenter, serpItemProcessor, viewedAdvertsPresenter, serpSpanProvider, spannedGridPositionProvider, groupingAdvertsResourcesProvider, clickStreamLinkHandler, formatter, analytics, abTestGroup, asyncPhonePresenter, groupingAdvertsItemsFilter, kundle);
    }

    @Override // javax.inject.Provider
    public GroupingAdvertsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get());
    }
}
