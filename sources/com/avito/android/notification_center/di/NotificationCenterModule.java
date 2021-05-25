package com.avito.android.notification_center.di;

import com.avito.android.notification_center.counter.NotificationCenterCounterModule;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/notification_center/di/NotificationCenterModule;", "", "<init>", "()V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {NotificationCenterCounterModule.class, NotificationCenterIntentFactoryModule.class, NotificationCenterPluginModule.class, NotificationsTasksModule.class})
public final class NotificationCenterModule {
    @NotNull
    public static final NotificationCenterModule INSTANCE = new NotificationCenterModule();
}
