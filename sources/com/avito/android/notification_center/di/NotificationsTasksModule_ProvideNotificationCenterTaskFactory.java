package com.avito.android.notification_center.di;

import com.avito.android.app.task.NotificationCenterTask;
import com.avito.android.notification_center.counter.NotificationCenterCounterUpdater;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationsTasksModule_ProvideNotificationCenterTaskFactory implements Factory<NotificationCenterTask> {
    public final Provider<NotificationCenterCounterUpdater> a;

    public NotificationsTasksModule_ProvideNotificationCenterTaskFactory(Provider<NotificationCenterCounterUpdater> provider) {
        this.a = provider;
    }

    public static NotificationsTasksModule_ProvideNotificationCenterTaskFactory create(Provider<NotificationCenterCounterUpdater> provider) {
        return new NotificationsTasksModule_ProvideNotificationCenterTaskFactory(provider);
    }

    public static NotificationCenterTask provideNotificationCenterTask(NotificationCenterCounterUpdater notificationCenterCounterUpdater) {
        return (NotificationCenterTask) Preconditions.checkNotNullFromProvides(NotificationsTasksModule.INSTANCE.provideNotificationCenterTask(notificationCenterCounterUpdater));
    }

    @Override // javax.inject.Provider
    public NotificationCenterTask get() {
        return provideNotificationCenterTask(this.a.get());
    }
}
