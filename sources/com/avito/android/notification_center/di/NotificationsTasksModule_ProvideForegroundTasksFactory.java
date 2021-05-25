package com.avito.android.notification_center.di;

import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.app.task.NotificationCenterTask;
import com.avito.android.app.task.UpdateInstanceIdTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class NotificationsTasksModule_ProvideForegroundTasksFactory implements Factory<List<ApplicationForegroundStartupTask>> {
    public final Provider<UpdateInstanceIdTask> a;
    public final Provider<NotificationCenterTask> b;

    public NotificationsTasksModule_ProvideForegroundTasksFactory(Provider<UpdateInstanceIdTask> provider, Provider<NotificationCenterTask> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NotificationsTasksModule_ProvideForegroundTasksFactory create(Provider<UpdateInstanceIdTask> provider, Provider<NotificationCenterTask> provider2) {
        return new NotificationsTasksModule_ProvideForegroundTasksFactory(provider, provider2);
    }

    public static List<ApplicationForegroundStartupTask> provideForegroundTasks(UpdateInstanceIdTask updateInstanceIdTask, NotificationCenterTask notificationCenterTask) {
        return (List) Preconditions.checkNotNullFromProvides(NotificationsTasksModule.INSTANCE.provideForegroundTasks(updateInstanceIdTask, notificationCenterTask));
    }

    @Override // javax.inject.Provider
    public List<ApplicationForegroundStartupTask> get() {
        return provideForegroundTasks(this.a.get(), this.b.get());
    }
}
