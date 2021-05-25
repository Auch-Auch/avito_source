package com.avito.android.notification_center.landing.recommends.item.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsTitleItemBlueprint_Factory implements Factory<NotificationCenterLandingRecommendsTitleItemBlueprint> {
    public final Provider<NotificationCenterLandingRecommendsTitleItemPresenter> a;

    public NotificationCenterLandingRecommendsTitleItemBlueprint_Factory(Provider<NotificationCenterLandingRecommendsTitleItemPresenter> provider) {
        this.a = provider;
    }

    public static NotificationCenterLandingRecommendsTitleItemBlueprint_Factory create(Provider<NotificationCenterLandingRecommendsTitleItemPresenter> provider) {
        return new NotificationCenterLandingRecommendsTitleItemBlueprint_Factory(provider);
    }

    public static NotificationCenterLandingRecommendsTitleItemBlueprint newInstance(NotificationCenterLandingRecommendsTitleItemPresenter notificationCenterLandingRecommendsTitleItemPresenter) {
        return new NotificationCenterLandingRecommendsTitleItemBlueprint(notificationCenterLandingRecommendsTitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsTitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
