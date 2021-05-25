package com.avito.android.notification_center.landing.recommends.review_list;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.DialogRouter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NcRecommendsReviewListFragment_MembersInjector implements MembersInjector<NcRecommendsReviewListFragment> {
    public final Provider<AdapterPresenter> a;
    public final Provider<DialogRouter> b;
    public final Provider<ItemBinder> c;
    public final Provider<NcRecommendsReviewListPresenter> d;
    public final Provider<Analytics> e;

    public NcRecommendsReviewListFragment_MembersInjector(Provider<AdapterPresenter> provider, Provider<DialogRouter> provider2, Provider<ItemBinder> provider3, Provider<NcRecommendsReviewListPresenter> provider4, Provider<Analytics> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<NcRecommendsReviewListFragment> create(Provider<AdapterPresenter> provider, Provider<DialogRouter> provider2, Provider<ItemBinder> provider3, Provider<NcRecommendsReviewListPresenter> provider4, Provider<Analytics> provider5) {
        return new NcRecommendsReviewListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragment.adapterPresenter")
    public static void injectAdapterPresenter(NcRecommendsReviewListFragment ncRecommendsReviewListFragment, AdapterPresenter adapterPresenter) {
        ncRecommendsReviewListFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragment.analytics")
    public static void injectAnalytics(NcRecommendsReviewListFragment ncRecommendsReviewListFragment, Analytics analytics) {
        ncRecommendsReviewListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragment.dialogRouter")
    public static void injectDialogRouter(NcRecommendsReviewListFragment ncRecommendsReviewListFragment, DialogRouter dialogRouter) {
        ncRecommendsReviewListFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragment.itemBinder")
    public static void injectItemBinder(NcRecommendsReviewListFragment ncRecommendsReviewListFragment, ItemBinder itemBinder) {
        ncRecommendsReviewListFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListFragment.presenter")
    public static void injectPresenter(NcRecommendsReviewListFragment ncRecommendsReviewListFragment, NcRecommendsReviewListPresenter ncRecommendsReviewListPresenter) {
        ncRecommendsReviewListFragment.presenter = ncRecommendsReviewListPresenter;
    }

    public void injectMembers(NcRecommendsReviewListFragment ncRecommendsReviewListFragment) {
        injectAdapterPresenter(ncRecommendsReviewListFragment, this.a.get());
        injectDialogRouter(ncRecommendsReviewListFragment, this.b.get());
        injectItemBinder(ncRecommendsReviewListFragment, this.c.get());
        injectPresenter(ncRecommendsReviewListFragment, this.d.get());
        injectAnalytics(ncRecommendsReviewListFragment, this.e.get());
    }
}
