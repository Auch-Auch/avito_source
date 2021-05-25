package com.avito.android.rating.publish.review_input;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ReviewInputFragment_MembersInjector implements MembersInjector<ReviewInputFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<ReviewInputPresenter> b;
    public final Provider<Analytics> c;
    public final Provider<StepListener> d;
    public final Provider<RatingPublishViewData> e;
    public final Provider<RatingPublishData> f;

    public ReviewInputFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<ReviewInputPresenter> provider2, Provider<Analytics> provider3, Provider<StepListener> provider4, Provider<RatingPublishViewData> provider5, Provider<RatingPublishData> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<ReviewInputFragment> create(Provider<ActivityIntentFactory> provider, Provider<ReviewInputPresenter> provider2, Provider<Analytics> provider3, Provider<StepListener> provider4, Provider<RatingPublishViewData> provider5, Provider<RatingPublishData> provider6) {
        return new ReviewInputFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.review_input.ReviewInputFragment.analytics")
    public static void injectAnalytics(ReviewInputFragment reviewInputFragment, Analytics analytics) {
        reviewInputFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.review_input.ReviewInputFragment.intentFactory")
    public static void injectIntentFactory(ReviewInputFragment reviewInputFragment, ActivityIntentFactory activityIntentFactory) {
        reviewInputFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.review_input.ReviewInputFragment.presenter")
    public static void injectPresenter(ReviewInputFragment reviewInputFragment, ReviewInputPresenter reviewInputPresenter) {
        reviewInputFragment.presenter = reviewInputPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.review_input.ReviewInputFragment.ratingData")
    public static void injectRatingData(ReviewInputFragment reviewInputFragment, RatingPublishData ratingPublishData) {
        reviewInputFragment.ratingData = ratingPublishData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.review_input.ReviewInputFragment.ratingViewData")
    public static void injectRatingViewData(ReviewInputFragment reviewInputFragment, RatingPublishViewData ratingPublishViewData) {
        reviewInputFragment.ratingViewData = ratingPublishViewData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.review_input.ReviewInputFragment.stepListener")
    public static void injectStepListener(ReviewInputFragment reviewInputFragment, StepListener stepListener) {
        reviewInputFragment.stepListener = stepListener;
    }

    public void injectMembers(ReviewInputFragment reviewInputFragment) {
        injectIntentFactory(reviewInputFragment, this.a.get());
        injectPresenter(reviewInputFragment, this.b.get());
        injectAnalytics(reviewInputFragment, this.c.get());
        injectStepListener(reviewInputFragment, this.d.get());
        injectRatingViewData(reviewInputFragment, this.e.get());
        injectRatingData(reviewInputFragment, this.f.get());
    }
}
