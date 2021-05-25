package com.avito.android.rating.publish.deal_stage;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DealStageFragment_MembersInjector implements MembersInjector<DealStageFragment> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<Analytics> d;
    public final Provider<DealStagePresenter> e;
    public final Provider<StepListener> f;
    public final Provider<RatingPublishViewData> g;
    public final Provider<RatingPublishData> h;

    public DealStageFragment_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<DealStagePresenter> provider5, Provider<StepListener> provider6, Provider<RatingPublishViewData> provider7, Provider<RatingPublishData> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<DealStageFragment> create(Provider<DeepLinkIntentFactory> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<DealStagePresenter> provider5, Provider<StepListener> provider6, Provider<RatingPublishViewData> provider7, Provider<RatingPublishData> provider8) {
        return new DealStageFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_stage.DealStageFragment.adapterPresenter")
    public static void injectAdapterPresenter(DealStageFragment dealStageFragment, AdapterPresenter adapterPresenter) {
        dealStageFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_stage.DealStageFragment.analytics")
    public static void injectAnalytics(DealStageFragment dealStageFragment, Analytics analytics) {
        dealStageFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_stage.DealStageFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(DealStageFragment dealStageFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        dealStageFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_stage.DealStageFragment.itemBinder")
    public static void injectItemBinder(DealStageFragment dealStageFragment, ItemBinder itemBinder) {
        dealStageFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_stage.DealStageFragment.presenter")
    public static void injectPresenter(DealStageFragment dealStageFragment, DealStagePresenter dealStagePresenter) {
        dealStageFragment.presenter = dealStagePresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_stage.DealStageFragment.ratingData")
    public static void injectRatingData(DealStageFragment dealStageFragment, RatingPublishData ratingPublishData) {
        dealStageFragment.ratingData = ratingPublishData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_stage.DealStageFragment.ratingViewData")
    public static void injectRatingViewData(DealStageFragment dealStageFragment, RatingPublishViewData ratingPublishViewData) {
        dealStageFragment.ratingViewData = ratingPublishViewData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_stage.DealStageFragment.stepListener")
    public static void injectStepListener(DealStageFragment dealStageFragment, StepListener stepListener) {
        dealStageFragment.stepListener = stepListener;
    }

    public void injectMembers(DealStageFragment dealStageFragment) {
        injectDeepLinkIntentFactory(dealStageFragment, this.a.get());
        injectAdapterPresenter(dealStageFragment, this.b.get());
        injectItemBinder(dealStageFragment, this.c.get());
        injectAnalytics(dealStageFragment, this.d.get());
        injectPresenter(dealStageFragment, this.e.get());
        injectStepListener(dealStageFragment, this.f.get());
        injectRatingViewData(dealStageFragment, this.g.get());
        injectRatingData(dealStageFragment, this.h.get());
    }
}
