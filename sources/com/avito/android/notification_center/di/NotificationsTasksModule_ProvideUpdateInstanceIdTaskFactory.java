package com.avito.android.notification_center.di;

import com.avito.android.NotificationWorkFactory;
import com.avito.android.app.task.UpdateInstanceIdTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationsTasksModule_ProvideUpdateInstanceIdTaskFactory implements Factory<UpdateInstanceIdTask> {
    public final Provider<NotificationWorkFactory> a;

    public NotificationsTasksModule_ProvideUpdateInstanceIdTaskFactory(Provider<NotificationWorkFactory> provider) {
        this.a = provider;
    }

    public static NotificationsTasksModule_ProvideUpdateInstanceIdTaskFactory create(Provider<NotificationWorkFactory> provider) {
        return new NotificationsTasksModule_ProvideUpdateInstanceIdTaskFactory(provider);
    }

    public static UpdateInstanceIdTask provideUpdateInstanceIdTask(NotificationWorkFactory notificationWorkFactory) {
        return (UpdateInstanceIdTask) Preconditions.checkNotNullFromProvides(NotificationsTasksModule.INSTANCE.provideUpdateInstanceIdTask(notificationWorkFactory));
    }

    @Override // javax.inject.Provider
    public UpdateInstanceIdTask get() {
        return provideUpdateInstanceIdTask(this.a.get());
    }
}
