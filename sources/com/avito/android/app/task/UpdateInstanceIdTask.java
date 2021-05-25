package com.avito.android.app.task;

import com.avito.android.NotificationWorkFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/app/task/UpdateInstanceIdTask;", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "", "execute", "()V", "Lcom/avito/android/NotificationWorkFactory;", "workFactory", "Lcom/avito/android/NotificationWorkFactory;", "<init>", "(Lcom/avito/android/NotificationWorkFactory;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateInstanceIdTask implements ApplicationForegroundStartupTask {
    public final NotificationWorkFactory workFactory;

    public UpdateInstanceIdTask(@NotNull NotificationWorkFactory notificationWorkFactory) {
        Intrinsics.checkNotNullParameter(notificationWorkFactory, "workFactory");
        this.workFactory = notificationWorkFactory;
    }

    @Override // com.avito.android.app.task.ApplicationForegroundStartupTask
    public void execute() {
        this.workFactory.enqueuePushTokenUpdate(null);
    }
}
