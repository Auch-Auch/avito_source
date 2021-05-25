package com.avito.android.rating.publish.buyer_info;

import com.avito.android.analytics.Analytics;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BuyerInfoFragment_MembersInjector implements MembersInjector<BuyerInfoFragment> {
    public final Provider<BuyerInfoPresenter> a;
    public final Provider<Analytics> b;
    public final Provider<StepListener> c;
    public final Provider<RatingPublishViewData> d;
    public final Provider<RatingPublishData> e;

    public BuyerInfoFragment_MembersInjector(Provider<BuyerInfoPresenter> provider, Provider<Analytics> provider2, Provider<StepListener> provider3, Provider<RatingPublishViewData> provider4, Provider<RatingPublishData> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<BuyerInfoFragment> create(Provider<BuyerInfoPresenter> provider, Provider<Analytics> provider2, Provider<StepListener> provider3, Provider<RatingPublishViewData> provider4, Provider<RatingPublishData> provider5) {
        return new BuyerInfoFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.buyer_info.BuyerInfoFragment.analytics")
    public static void injectAnalytics(BuyerInfoFragment buyerInfoFragment, Analytics analytics) {
        buyerInfoFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.buyer_info.BuyerInfoFragment.presenter")
    public static void injectPresenter(BuyerInfoFragment buyerInfoFragment, BuyerInfoPresenter buyerInfoPresenter) {
        buyerInfoFragment.presenter = buyerInfoPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.buyer_info.BuyerInfoFragment.ratingData")
    public static void injectRatingData(BuyerInfoFragment buyerInfoFragment, RatingPublishData ratingPublishData) {
        buyerInfoFragment.ratingData = ratingPublishData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.buyer_info.BuyerInfoFragment.ratingViewData")
    public static void injectRatingViewData(BuyerInfoFragment buyerInfoFragment, RatingPublishViewData ratingPublishViewData) {
        buyerInfoFragment.ratingViewData = ratingPublishViewData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.buyer_info.BuyerInfoFragment.stepListener")
    public static void injectStepListener(BuyerInfoFragment buyerInfoFragment, StepListener stepListener) {
        buyerInfoFragment.stepListener = stepListener;
    }

    public void injectMembers(BuyerInfoFragment buyerInfoFragment) {
        injectPresenter(buyerInfoFragment, this.a.get());
        injectAnalytics(buyerInfoFragment, this.b.get());
        injectStepListener(buyerInfoFragment, this.c.get());
        injectRatingViewData(buyerInfoFragment, this.d.get());
        injectRatingData(buyerInfoFragment, this.e.get());
    }
}
