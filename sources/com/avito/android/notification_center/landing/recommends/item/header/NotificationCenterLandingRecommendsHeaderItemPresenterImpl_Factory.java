package com.avito.android.notification_center.landing.recommends.item.header;

import dagger.internal.Factory;
public final class NotificationCenterLandingRecommendsHeaderItemPresenterImpl_Factory implements Factory<NotificationCenterLandingRecommendsHeaderItemPresenterImpl> {

    public static final class a {
        public static final NotificationCenterLandingRecommendsHeaderItemPresenterImpl_Factory a = new NotificationCenterLandingRecommendsHeaderItemPresenterImpl_Factory();
    }

    public static NotificationCenterLandingRecommendsHeaderItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static NotificationCenterLandingRecommendsHeaderItemPresenterImpl newInstance() {
        return new NotificationCenterLandingRecommendsHeaderItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public NotificationCenterLandingRecommendsHeaderItemPresenterImpl get() {
        return newInstance();
    }
}
