package com.avito.android.notification_center.list.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationCenterListItemBlueprint_Factory implements Factory<NotificationCenterListItemBlueprint> {
    public final Provider<NotificationCenterListItemPresenter> a;

    public NotificationCenterListItemBlueprint_Factory(Provider<NotificationCenterListItemPresenter> provider) {
        this.a = provider;
    }

    public static NotificationCenterListItemBlueprint_Factory create(Provider<NotificationCenterListItemPresenter> provider) {
        return new NotificationCenterListItemBlueprint_Factory(provider);
    }

    public static NotificationCenterListItemBlueprint newInstance(NotificationCenterListItemPresenter notificationCenterListItemPresenter) {
        return new NotificationCenterListItemBlueprint(notificationCenterListItemPresenter);
    }

    @Override // javax.inject.Provider
    public NotificationCenterListItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
