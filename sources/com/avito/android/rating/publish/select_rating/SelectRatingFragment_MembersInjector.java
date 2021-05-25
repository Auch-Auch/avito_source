package com.avito.android.rating.publish.select_rating;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.ratings.RatingPublishData;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SelectRatingFragment_MembersInjector implements MembersInjector<SelectRatingFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<SelectRatingPresenter> c;
    public final Provider<Analytics> d;
    public final Provider<StepListener> e;
    public final Provider<RatingPublishViewData> f;
    public final Provider<RatingPublishData> g;

    public SelectRatingFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<SelectRatingPresenter> provider3, Provider<Analytics> provider4, Provider<StepListener> provider5, Provider<RatingPublishViewData> provider6, Provider<RatingPublishData> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<SelectRatingFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<SelectRatingPresenter> provider3, Provider<Analytics> provider4, Provider<StepListener> provider5, Provider<RatingPublishViewData> provider6, Provider<RatingPublishData> provider7) {
        return new SelectRatingFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_rating.SelectRatingFragment.analytics")
    public static void injectAnalytics(SelectRatingFragment selectRatingFragment, Analytics analytics) {
        selectRatingFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_rating.SelectRatingFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(SelectRatingFragment selectRatingFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        selectRatingFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_rating.SelectRatingFragment.intentFactory")
    public static void injectIntentFactory(SelectRatingFragment selectRatingFragment, ActivityIntentFactory activityIntentFactory) {
        selectRatingFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_rating.SelectRatingFragment.presenter")
    public static void injectPresenter(SelectRatingFragment selectRatingFragment, SelectRatingPresenter selectRatingPresenter) {
        selectRatingFragment.presenter = selectRatingPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_rating.SelectRatingFragment.ratingData")
    public static void injectRatingData(SelectRatingFragment selectRatingFragment, RatingPublishData ratingPublishData) {
        selectRatingFragment.ratingData = ratingPublishData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_rating.SelectRatingFragment.ratingViewData")
    public static void injectRatingViewData(SelectRatingFragment selectRatingFragment, RatingPublishViewData ratingPublishViewData) {
        selectRatingFragment.ratingViewData = ratingPublishViewData;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.select_rating.SelectRatingFragment.stepListener")
    public static void injectStepListener(SelectRatingFragment selectRatingFragment, StepListener stepListener) {
        selectRatingFragment.stepListener = stepListener;
    }

    public void injectMembers(SelectRatingFragment selectRatingFragment) {
        injectIntentFactory(selectRatingFragment, this.a.get());
        injectDeepLinkIntentFactory(selectRatingFragment, this.b.get());
        injectPresenter(selectRatingFragment, this.c.get());
        injectAnalytics(selectRatingFragment, this.d.get());
        injectStepListener(selectRatingFragment, this.e.get());
        injectRatingViewData(selectRatingFragment, this.f.get());
        injectRatingData(selectRatingFragment, this.g.get());
    }
}
