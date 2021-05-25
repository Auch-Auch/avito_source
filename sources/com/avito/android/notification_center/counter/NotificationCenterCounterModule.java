package com.avito.android.notification_center.counter;

import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/notification_center/counter/NotificationCenterCounterModule;", "", "Lcom/avito/android/remote/NotificationsApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/notification_center/counter/NotificationCenterCounter;", "provideCounter", "(Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/notification_center/counter/NotificationCenterCounter;", "<init>", "()V", "Bindings", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public class NotificationCenterCounterModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/notification_center/counter/NotificationCenterCounterModule$Bindings;", "", "Lcom/avito/android/notification_center/counter/NotificationCenterCounter;", "counter", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterCleaner;", "bindCounterCleaner", "(Lcom/avito/android/notification_center/counter/NotificationCenterCounter;)Lcom/avito/android/notification_center/counter/NotificationCenterCounterCleaner;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "bindCounterInteractor", "(Lcom/avito/android/notification_center/counter/NotificationCenterCounter;)Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterMarker;", "bindCounterMarker", "(Lcom/avito/android/notification_center/counter/NotificationCenterCounter;)Lcom/avito/android/notification_center/counter/NotificationCenterCounterMarker;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterUpdater;", "bindCounterUpdater", "(Lcom/avito/android/notification_center/counter/NotificationCenterCounter;)Lcom/avito/android/notification_center/counter/NotificationCenterCounterUpdater;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Binds
        @NotNull
        NotificationCenterCounterCleaner bindCounterCleaner(@NotNull NotificationCenterCounter notificationCenterCounter);

        @Binds
        @NotNull
        NotificationCenterCounterInteractor bindCounterInteractor(@NotNull NotificationCenterCounter notificationCenterCounter);

        @Binds
        @NotNull
        NotificationCenterCounterMarker bindCounterMarker(@NotNull NotificationCenterCounter notificationCenterCounter);

        @Binds
        @NotNull
        NotificationCenterCounterUpdater bindCounterUpdater(@NotNull NotificationCenterCounter notificationCenterCounter);
    }

    @Provides
    @Singleton
    @NotNull
    public final NotificationCenterCounter provideCounter(@NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(notificationsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new NotificationCenterCounterImpl(notificationsApi, schedulersFactory3);
    }
}
