package com.avito.android.grouping_adverts;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.module.RichStateProvider;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.grouping_adverts.tracker.GroupingAdvertsTracker;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider;
import com.avito.android.ui.adapter.AppendingHandler;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class GroupingAdvertsFragment_MembersInjector implements MembersInjector<GroupingAdvertsFragment> {
    public final Provider<GroupingAdvertsPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<Analytics> f;
    public final Provider<FavoriteAdvertsPresenter> g;
    public final Provider<ViewedAdvertsPresenter> h;
    public final Provider<AsyncPhonePresenter> i;
    public final Provider<GridLayoutManager.SpanSizeLookup> j;
    public final Provider<SpannedGridPositionProvider> k;
    public final Provider<AppendingHandler> l;
    public final Provider<RichSnippetStateProvider> m;
    public final Provider<GroupingAdvertsTracker> n;

    public GroupingAdvertsFragment_MembersInjector(Provider<GroupingAdvertsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<ActivityIntentFactory> provider5, Provider<Analytics> provider6, Provider<FavoriteAdvertsPresenter> provider7, Provider<ViewedAdvertsPresenter> provider8, Provider<AsyncPhonePresenter> provider9, Provider<GridLayoutManager.SpanSizeLookup> provider10, Provider<SpannedGridPositionProvider> provider11, Provider<AppendingHandler> provider12, Provider<RichSnippetStateProvider> provider13, Provider<GroupingAdvertsTracker> provider14) {
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
    }

    public static MembersInjector<GroupingAdvertsFragment> create(Provider<GroupingAdvertsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<ActivityIntentFactory> provider5, Provider<Analytics> provider6, Provider<FavoriteAdvertsPresenter> provider7, Provider<ViewedAdvertsPresenter> provider8, Provider<AsyncPhonePresenter> provider9, Provider<GridLayoutManager.SpanSizeLookup> provider10, Provider<SpannedGridPositionProvider> provider11, Provider<AppendingHandler> provider12, Provider<RichSnippetStateProvider> provider13, Provider<GroupingAdvertsTracker> provider14) {
        return new GroupingAdvertsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(GroupingAdvertsFragment groupingAdvertsFragment, ActivityIntentFactory activityIntentFactory) {
        groupingAdvertsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.adapterPresenter")
    public static void injectAdapterPresenter(GroupingAdvertsFragment groupingAdvertsFragment, AdapterPresenter adapterPresenter) {
        groupingAdvertsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.analytics")
    public static void injectAnalytics(GroupingAdvertsFragment groupingAdvertsFragment, Analytics analytics) {
        groupingAdvertsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.appendingHandler")
    public static void injectAppendingHandler(GroupingAdvertsFragment groupingAdvertsFragment, AppendingHandler appendingHandler) {
        groupingAdvertsFragment.appendingHandler = appendingHandler;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.asyncPhonePresenter")
    public static void injectAsyncPhonePresenter(GroupingAdvertsFragment groupingAdvertsFragment, AsyncPhonePresenter asyncPhonePresenter) {
        groupingAdvertsFragment.asyncPhonePresenter = asyncPhonePresenter;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(GroupingAdvertsFragment groupingAdvertsFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        groupingAdvertsFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.favoriteAdvertsPresenter")
    public static void injectFavoriteAdvertsPresenter(GroupingAdvertsFragment groupingAdvertsFragment, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        groupingAdvertsFragment.favoriteAdvertsPresenter = favoriteAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.gridPositionProvider")
    public static void injectGridPositionProvider(GroupingAdvertsFragment groupingAdvertsFragment, SpannedGridPositionProvider spannedGridPositionProvider) {
        groupingAdvertsFragment.gridPositionProvider = spannedGridPositionProvider;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.itemBinder")
    public static void injectItemBinder(GroupingAdvertsFragment groupingAdvertsFragment, ItemBinder itemBinder) {
        groupingAdvertsFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.presenter")
    public static void injectPresenter(GroupingAdvertsFragment groupingAdvertsFragment, GroupingAdvertsPresenter groupingAdvertsPresenter) {
        groupingAdvertsFragment.presenter = groupingAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.richSnippetStateProvider")
    @RichStateProvider
    public static void injectRichSnippetStateProvider(GroupingAdvertsFragment groupingAdvertsFragment, RichSnippetStateProvider richSnippetStateProvider) {
        groupingAdvertsFragment.richSnippetStateProvider = richSnippetStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.spanLookup")
    public static void injectSpanLookup(GroupingAdvertsFragment groupingAdvertsFragment, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        groupingAdvertsFragment.spanLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.tracker")
    public static void injectTracker(GroupingAdvertsFragment groupingAdvertsFragment, GroupingAdvertsTracker groupingAdvertsTracker) {
        groupingAdvertsFragment.tracker = groupingAdvertsTracker;
    }

    @InjectedFieldSignature("com.avito.android.grouping_adverts.GroupingAdvertsFragment.viewedAdvertsPresenter")
    public static void injectViewedAdvertsPresenter(GroupingAdvertsFragment groupingAdvertsFragment, ViewedAdvertsPresenter viewedAdvertsPresenter) {
        groupingAdvertsFragment.viewedAdvertsPresenter = viewedAdvertsPresenter;
    }

    public void injectMembers(GroupingAdvertsFragment groupingAdvertsFragment) {
        injectPresenter(groupingAdvertsFragment, this.a.get());
        injectAdapterPresenter(groupingAdvertsFragment, this.b.get());
        injectItemBinder(groupingAdvertsFragment, this.c.get());
        injectDeepLinkIntentFactory(groupingAdvertsFragment, this.d.get());
        injectActivityIntentFactory(groupingAdvertsFragment, this.e.get());
        injectAnalytics(groupingAdvertsFragment, this.f.get());
        injectFavoriteAdvertsPresenter(groupingAdvertsFragment, this.g.get());
        injectViewedAdvertsPresenter(groupingAdvertsFragment, this.h.get());
        injectAsyncPhonePresenter(groupingAdvertsFragment, this.i.get());
        injectSpanLookup(groupingAdvertsFragment, this.j.get());
        injectGridPositionProvider(groupingAdvertsFragment, this.k.get());
        injectAppendingHandler(groupingAdvertsFragment, this.l.get());
        injectRichSnippetStateProvider(groupingAdvertsFragment, this.m.get());
        injectTracker(groupingAdvertsFragment, this.n.get());
    }
}
