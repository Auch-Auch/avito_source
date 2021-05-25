package com.avito.android.rating.check;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class RatingPublishCheckActivity_MembersInjector implements MembersInjector<RatingPublishCheckActivity> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<RatingPublishCheckPresenter> c;
    public final Provider<UnknownScreenTracker> d;

    public RatingPublishCheckActivity_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<RatingPublishCheckPresenter> provider3, Provider<UnknownScreenTracker> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<RatingPublishCheckActivity> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<RatingPublishCheckPresenter> provider3, Provider<UnknownScreenTracker> provider4) {
        return new RatingPublishCheckActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.rating.check.RatingPublishCheckActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(RatingPublishCheckActivity ratingPublishCheckActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        ratingPublishCheckActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.check.RatingPublishCheckActivity.intentFactory")
    public static void injectIntentFactory(RatingPublishCheckActivity ratingPublishCheckActivity, ActivityIntentFactory activityIntentFactory) {
        ratingPublishCheckActivity.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.rating.check.RatingPublishCheckActivity.presenter")
    public static void injectPresenter(RatingPublishCheckActivity ratingPublishCheckActivity, RatingPublishCheckPresenter ratingPublishCheckPresenter) {
        ratingPublishCheckActivity.presenter = ratingPublishCheckPresenter;
    }

    @InjectedFieldSignature("com.avito.android.rating.check.RatingPublishCheckActivity.tracker")
    public static void injectTracker(RatingPublishCheckActivity ratingPublishCheckActivity, UnknownScreenTracker unknownScreenTracker) {
        ratingPublishCheckActivity.tracker = unknownScreenTracker;
    }

    public void injectMembers(RatingPublishCheckActivity ratingPublishCheckActivity) {
        injectIntentFactory(ratingPublishCheckActivity, this.a.get());
        injectDeepLinkIntentFactory(ratingPublishCheckActivity, this.b.get());
        injectPresenter(ratingPublishCheckActivity, this.c.get());
        injectTracker(ratingPublishCheckActivity, this.d.get());
    }
}
