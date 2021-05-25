package com.avito.android.rating.publish.deal_proofs;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DealProofsFragment_MembersInjector implements MembersInjector<DealProofsFragment> {
    public final Provider<DealProofsPresenter> a;
    public final Provider<Analytics> b;
    public final Provider<ImageListPresenter> c;
    public final Provider<StepListener> d;
    public final Provider<RatingPublishData> e;
    public final Provider<ActivityIntentFactory> f;

    public DealProofsFragment_MembersInjector(Provider<DealProofsPresenter> provider, Provider<Analytics> provider2, Provider<ImageListPresenter> provider3, Provider<StepListener> provider4, Provider<RatingPublishData> provider5, Provider<ActivityIntentFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<DealProofsFragment> create(Provider<DealProofsPresenter> provider, Provider<Analytics> provider2, Provider<ImageListPresenter> provider3, Provider<StepListener> provider4, Provider<RatingPublishData> provider5, Provider<ActivityIntentFactory> provider6) {
        return new DealProofsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_proofs.DealProofsFragment.analytics")
    public static void injectAnalytics(DealProofsFragment dealProofsFragment, Analytics analytics) {
        dealProofsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_proofs.DealProofsFragment.imageListPresenter")
    public static void injectImageListPresenter(DealProofsFragment dealProofsFragment, ImageListPresenter imageListPresenter) {
        dealProofsFragment.imageListPresenter = imageListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_proofs.DealProofsFragment.intentFactory")
    public static void injectIntentFactory(DealProofsFragment dealProofsFragment, ActivityIntentFactory activityIntentFactory) {
        dealProofsFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_proofs.DealProofsFragment.presenter")
    public static void injectPresenter(DealProofsFragment dealProofsFragment, DealProofsPresenter dealProofsPresenter) {
        dealProofsFragment.presenter = dealProofsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_proofs.DealProofsFragment.ratingData")
    public static void injectRatingData(DealProofsFragment dealProofsFragment, RatingPublishData ratingPublishData) {
        dealProofsFragment.ratingData = ratingPublishData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.deal_proofs.DealProofsFragment.stepListener")
    public static void injectStepListener(DealProofsFragment dealProofsFragment, StepListener stepListener) {
        dealProofsFragment.stepListener = stepListener;
    }

    public void injectMembers(DealProofsFragment dealProofsFragment) {
        injectPresenter(dealProofsFragment, this.a.get());
        injectAnalytics(dealProofsFragment, this.b.get());
        injectImageListPresenter(dealProofsFragment, this.c.get());
        injectStepListener(dealProofsFragment, this.d.get());
        injectRatingData(dealProofsFragment, this.e.get());
        injectIntentFactory(dealProofsFragment, this.f.get());
    }
}
