package com.avito.android.advert_stats;

import com.avito.android.advert_stats.di.AdvertStatsModuleKt;
import com.avito.android.advert_stats.item.PlotItemPresenter;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerPresenter;
import com.avito.android.advert_stats.item.hint.HintItemPresenter;
import com.avito.android.advert_stats.tracker.AdvertStatsTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Named;
import javax.inject.Provider;
public final class AdvertStatsActivity_MembersInjector implements MembersInjector<AdvertStatsActivity> {
    public final Provider<AdvertStatsViewModel> a;
    public final Provider<Analytics> b;
    public final Provider<ItemBinder> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<PlotItemPresenter> e;
    public final Provider<HintItemPresenter> f;
    public final Provider<NewStatisticsBannerPresenter> g;
    public final Provider<AdvertStatsTracker> h;
    public final Provider<ImplicitIntentFactory> i;

    public AdvertStatsActivity_MembersInjector(Provider<AdvertStatsViewModel> provider, Provider<Analytics> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4, Provider<PlotItemPresenter> provider5, Provider<HintItemPresenter> provider6, Provider<NewStatisticsBannerPresenter> provider7, Provider<AdvertStatsTracker> provider8, Provider<ImplicitIntentFactory> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static MembersInjector<AdvertStatsActivity> create(Provider<AdvertStatsViewModel> provider, Provider<Analytics> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4, Provider<PlotItemPresenter> provider5, Provider<HintItemPresenter> provider6, Provider<NewStatisticsBannerPresenter> provider7, Provider<AdvertStatsTracker> provider8, Provider<ImplicitIntentFactory> provider9) {
        return new AdvertStatsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.adapterPresenter")
    @Named(AdvertStatsModuleKt.STATS_ADAPTER_PRESENTER)
    public static void injectAdapterPresenter(AdvertStatsActivity advertStatsActivity, AdapterPresenter adapterPresenter) {
        advertStatsActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.advertStatsTracker")
    public static void injectAdvertStatsTracker(AdvertStatsActivity advertStatsActivity, AdvertStatsTracker advertStatsTracker) {
        advertStatsActivity.advertStatsTracker = advertStatsTracker;
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.analytics")
    public static void injectAnalytics(AdvertStatsActivity advertStatsActivity, Analytics analytics) {
        advertStatsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.hintItemPresenter")
    public static void injectHintItemPresenter(AdvertStatsActivity advertStatsActivity, HintItemPresenter hintItemPresenter) {
        advertStatsActivity.hintItemPresenter = hintItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(AdvertStatsActivity advertStatsActivity, ImplicitIntentFactory implicitIntentFactory) {
        advertStatsActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.itemBinder")
    @Named(AdvertStatsModuleKt.STATS_ITEM_BINDER)
    public static void injectItemBinder(AdvertStatsActivity advertStatsActivity, ItemBinder itemBinder) {
        advertStatsActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.plotPresenter")
    public static void injectPlotPresenter(AdvertStatsActivity advertStatsActivity, PlotItemPresenter plotItemPresenter) {
        advertStatsActivity.plotPresenter = plotItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.statisticsItemPresenter")
    public static void injectStatisticsItemPresenter(AdvertStatsActivity advertStatsActivity, NewStatisticsBannerPresenter newStatisticsBannerPresenter) {
        advertStatsActivity.statisticsItemPresenter = newStatisticsBannerPresenter;
    }

    @InjectedFieldSignature("com.avito.android.advert_stats.AdvertStatsActivity.viewModel")
    public static void injectViewModel(AdvertStatsActivity advertStatsActivity, AdvertStatsViewModel advertStatsViewModel) {
        advertStatsActivity.viewModel = advertStatsViewModel;
    }

    public void injectMembers(AdvertStatsActivity advertStatsActivity) {
        injectViewModel(advertStatsActivity, this.a.get());
        injectAnalytics(advertStatsActivity, this.b.get());
        injectItemBinder(advertStatsActivity, this.c.get());
        injectAdapterPresenter(advertStatsActivity, this.d.get());
        injectPlotPresenter(advertStatsActivity, this.e.get());
        injectHintItemPresenter(advertStatsActivity, this.f.get());
        injectStatisticsItemPresenter(advertStatsActivity, this.g.get());
        injectAdvertStatsTracker(advertStatsActivity, this.h.get());
        injectImplicitIntentFactory(advertStatsActivity, this.i.get());
    }
}
