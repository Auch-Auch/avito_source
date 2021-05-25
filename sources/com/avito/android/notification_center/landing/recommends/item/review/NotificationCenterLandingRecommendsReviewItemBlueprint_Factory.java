package com.avito.android.notification_center.landing.recommends.item.review;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsReviewItemBlueprint_Factory implements Factory<NotificationCenterLandingRecommendsReviewItemBlueprint> {
    public final Provider<NotificationCenterLandingRecommendsReviewItemPresenter> a;

    public NotificationCenterLandingRecommendsReviewItemBlueprint_Factory(Provider<NotificationCenterLandingRecommendsReviewItemPresenter> provider) {
        this.a = provider;
    }

    public static NotificationCenterLandingRecommendsReviewItemBlueprint_Factory create(Provider<NotificationCenterLandingRecommendsReviewItemPresenter> provider) {
        return new NotificationCenterLandingRecommendsReviewItemBlueprint_Factory(provider);
    }

    public static NotificationCenterLandingRecommendsReviewItemBlueprint newInstance(NotificationCenterLandingRecommendsReviewItemPresenter notificationCenterLandingRecommendsReviewItemPresenter) {
        return new NotificationCenterLandingRecommendsReviewItemBlueprint(notificationCenterLandingRecommendsReviewItemPresenter);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsReviewItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
