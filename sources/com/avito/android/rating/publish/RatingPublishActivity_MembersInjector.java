package com.avito.android.rating.publish;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.rating.publish.tracker.RatingPublishTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class RatingPublishActivity_MembersInjector implements MembersInjector<RatingPublishActivity> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<RatingPublishPresenter> b;
    public final Provider<RatingPublishTracker> c;
    public final Provider<Analytics> d;

    public RatingPublishActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<RatingPublishPresenter> provider2, Provider<RatingPublishTracker> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<RatingPublishActivity> create(Provider<DeepLinkIntentFactory> provider, Provider<RatingPublishPresenter> provider2, Provider<RatingPublishTracker> provider3, Provider<Analytics> provider4) {
        return new RatingPublishActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.RatingPublishActivity.analytics")
    public static void injectAnalytics(RatingPublishActivity ratingPublishActivity, Analytics analytics) {
        ratingPublishActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.RatingPublishActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(RatingPublishActivity ratingPublishActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        ratingPublishActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.RatingPublishActivity.presenter")
    public static void injectPresenter(RatingPublishActivity ratingPublishActivity, RatingPublishPresenter ratingPublishPresenter) {
        ratingPublishActivity.presenter = ratingPublishPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.publish.RatingPublishActivity.tracker")
    public static void injectTracker(RatingPublishActivity ratingPublishActivity, RatingPublishTracker ratingPublishTracker) {
        ratingPublishActivity.tracker = ratingPublishTracker;
    }

    public void injectMembers(RatingPublishActivity ratingPublishActivity) {
        injectDeepLinkIntentFactory(ratingPublishActivity, this.a.get());
        injectPresenter(ratingPublishActivity, this.b.get());
        injectTracker(ratingPublishActivity, this.c.get());
        injectAnalytics(ratingPublishActivity, this.d.get());
    }
}
