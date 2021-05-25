package com.avito.android.notification_center.list.item;

import com.avito.android.date_time_formatter.RelativeDateFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterListItemPresenterImpl_Factory implements Factory<NotificationCenterListItemPresenterImpl> {
    public final Provider<RelativeDateFormatter> a;
    public final Provider<NotificationCenterListItemClickListener> b;

    public NotificationCenterListItemPresenterImpl_Factory(Provider<RelativeDateFormatter> provider, Provider<NotificationCenterListItemClickListener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationCenterListItemPresenterImpl_Factory create(Provider<RelativeDateFormatter> provider, Provider<NotificationCenterListItemClickListener> provider2) {
        return new NotificationCenterListItemPresenterImpl_Factory(provider, provider2);
    }

    public static NotificationCenterListItemPresenterImpl newInstance(RelativeDateFormatter relativeDateFormatter, NotificationCenterListItemClickListener notificationCenterListItemClickListener) {
        return new NotificationCenterListItemPresenterImpl(relativeDateFormatter, notificationCenterListItemClickListener);
    }

    @Override // javax.inject.Provider
    public NotificationCenterListItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
