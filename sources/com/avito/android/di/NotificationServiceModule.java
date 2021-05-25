package com.avito.android.di;

import com.avito.android.remote.notification.NotificationServiceInteractor;
import com.avito.android.remote.notification.NotificationServiceInteractorImpl;
import com.avito.android.service.ServiceCountdownHandler;
import com.avito.android.service.ServiceCountdownHandlerImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/di/NotificationServiceModule;", "", "Lcom/avito/android/service/ServiceCountdownHandlerImpl;", "handler", "Lcom/avito/android/service/ServiceCountdownHandler;", "bindServiceCountdownHandler", "(Lcom/avito/android/service/ServiceCountdownHandlerImpl;)Lcom/avito/android/service/ServiceCountdownHandler;", "Lcom/avito/android/remote/notification/NotificationServiceInteractorImpl;", "interactor", "Lcom/avito/android/remote/notification/NotificationServiceInteractor;", "bindNotificationServiceInteractor", "(Lcom/avito/android/remote/notification/NotificationServiceInteractorImpl;)Lcom/avito/android/remote/notification/NotificationServiceInteractor;", "notification_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface NotificationServiceModule {
    @PerService
    @Binds
    @NotNull
    NotificationServiceInteractor bindNotificationServiceInteractor(@NotNull NotificationServiceInteractorImpl notificationServiceInteractorImpl);

    @PerService
    @Binds
    @NotNull
    ServiceCountdownHandler bindServiceCountdownHandler(@NotNull ServiceCountdownHandlerImpl serviceCountdownHandlerImpl);
}
