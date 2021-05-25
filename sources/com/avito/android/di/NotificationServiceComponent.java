package com.avito.android.di;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.notification.NotificationService;
import com.avito.android.service.ServiceCountdownHandler;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/NotificationServiceComponent;", "", "Lcom/avito/android/remote/notification/NotificationService;", NotificationCompat.CATEGORY_SERVICE, "", "inject", "(Lcom/avito/android/remote/notification/NotificationService;)V", "Builder", "notification_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {NotificationServiceDependencies.class}, modules = {NotificationServiceModule.class})
public interface NotificationServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/di/NotificationServiceComponent$Builder;", "", "Lcom/avito/android/di/NotificationServiceDependencies;", "dependencies", "(Lcom/avito/android/di/NotificationServiceDependencies;)Lcom/avito/android/di/NotificationServiceComponent$Builder;", "", "name", "withName", "(Ljava/lang/String;)Lcom/avito/android/di/NotificationServiceComponent$Builder;", "Lcom/avito/android/service/ServiceCountdownHandler$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "withCountdownHandlerListener", "(Lcom/avito/android/service/ServiceCountdownHandler$Listener;)Lcom/avito/android/di/NotificationServiceComponent$Builder;", "Lcom/avito/android/di/NotificationServiceComponent;", "build", "()Lcom/avito/android/di/NotificationServiceComponent;", "notification_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NotificationServiceComponent build();

        @NotNull
        Builder dependencies(@NotNull NotificationServiceDependencies notificationServiceDependencies);

        @BindsInstance
        @NotNull
        Builder withCountdownHandlerListener(@Nullable ServiceCountdownHandler.Listener listener);

        @BindsInstance
        @NotNull
        Builder withName(@NotNull String str);
    }

    void inject(@NotNull NotificationService notificationService);
}
