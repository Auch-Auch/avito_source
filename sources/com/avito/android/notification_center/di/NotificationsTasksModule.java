package com.avito.android.notification_center.di;

import com.avito.android.NotificationWorkFactory;
import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.app.task.NotificationCenterTask;
import com.avito.android.app.task.UpdateInstanceIdTask;
import com.avito.android.notification_center.counter.NotificationCenterCounterUpdater;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/notification_center/di/NotificationsTasksModule;", "", "Lcom/avito/android/app/task/UpdateInstanceIdTask;", "updateInstanceIdTask", "Lcom/avito/android/app/task/NotificationCenterTask;", "notificationCenterTask", "", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "provideForegroundTasks", "(Lcom/avito/android/app/task/UpdateInstanceIdTask;Lcom/avito/android/app/task/NotificationCenterTask;)Ljava/util/List;", "Lcom/avito/android/NotificationWorkFactory;", "workFactory", "provideUpdateInstanceIdTask", "(Lcom/avito/android/NotificationWorkFactory;)Lcom/avito/android/app/task/UpdateInstanceIdTask;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterUpdater;", "updater", "provideNotificationCenterTask", "(Lcom/avito/android/notification_center/counter/NotificationCenterCounterUpdater;)Lcom/avito/android/app/task/NotificationCenterTask;", "<init>", "()V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class NotificationsTasksModule {
    @NotNull
    public static final NotificationsTasksModule INSTANCE = new NotificationsTasksModule();

    @Provides
    @NotNull
    @NotificationsTasks
    public final List<ApplicationForegroundStartupTask> provideForegroundTasks(@NotNull UpdateInstanceIdTask updateInstanceIdTask, @NotNull NotificationCenterTask notificationCenterTask) {
        Intrinsics.checkNotNullParameter(updateInstanceIdTask, "updateInstanceIdTask");
        Intrinsics.checkNotNullParameter(notificationCenterTask, "notificationCenterTask");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new ApplicationForegroundStartupTask[]{updateInstanceIdTask, notificationCenterTask});
    }

    @Provides
    @NotNull
    public final NotificationCenterTask provideNotificationCenterTask(@NotNull NotificationCenterCounterUpdater notificationCenterCounterUpdater) {
        Intrinsics.checkNotNullParameter(notificationCenterCounterUpdater, "updater");
        return new NotificationCenterTask(notificationCenterCounterUpdater);
    }

    @Provides
    @NotNull
    public final UpdateInstanceIdTask provideUpdateInstanceIdTask(@NotNull NotificationWorkFactory notificationWorkFactory) {
        Intrinsics.checkNotNullParameter(notificationWorkFactory, "workFactory");
        return new UpdateInstanceIdTask(notificationWorkFactory);
    }
}
