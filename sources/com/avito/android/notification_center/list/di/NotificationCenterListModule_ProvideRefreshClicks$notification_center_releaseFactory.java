package com.avito.android.notification_center.list.di;

import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class NotificationCenterListModule_ProvideRefreshClicks$notification_center_releaseFactory implements Factory<PublishRelay<NotificationCenterListItem.ErrorSnippet>> {

    public static final class a {
        public static final NotificationCenterListModule_ProvideRefreshClicks$notification_center_releaseFactory a = new NotificationCenterListModule_ProvideRefreshClicks$notification_center_releaseFactory();
    }

    public static NotificationCenterListModule_ProvideRefreshClicks$notification_center_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<NotificationCenterListItem.ErrorSnippet> provideRefreshClicks$notification_center_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(NotificationCenterListModule.INSTANCE.provideRefreshClicks$notification_center_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<NotificationCenterListItem.ErrorSnippet> get() {
        return provideRefreshClicks$notification_center_release();
    }
}
