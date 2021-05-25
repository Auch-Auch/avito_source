package com.avito.android.notification_center.landing.recommends.item.header;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterLandingRecommendsHeaderItemBlueprint_Factory implements Factory<NotificationCenterLandingRecommendsHeaderItemBlueprint> {
    public final Provider<NotificationCenterLandingRecommendsHeaderItemPresenter> a;

    public NotificationCenterLandingRecommendsHeaderItemBlueprint_Factory(Provider<NotificationCenterLandingRecommendsHeaderItemPresenter> provider) {
        this.a = provider;
    }

    public static NotificationCenterLandingRecommendsHeaderItemBlueprint_Factory create(Provider<NotificationCenterLandingRecommendsHeaderItemPresenter> provider) {
        return new NotificationCenterLandingRecommendsHeaderItemBlueprint_Factory(provider);
    }

    public static NotificationCenterLandingRecommendsHeaderItemBlueprint newInstance(NotificationCenterLandingRecommendsHeaderItemPresenter notificationCenterLandingRecommendsHeaderItemPresenter) {
        return new NotificationCenterLandingRecommendsHeaderItemBlueprint(notificationCenterLandingRecommendsHeaderItemPresenter);
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsHeaderItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
