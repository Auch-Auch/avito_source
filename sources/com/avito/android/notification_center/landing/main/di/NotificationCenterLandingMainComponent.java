package com.avito.android.notification_center.landing.main.di;

import com.avito.android.di.PerActivity;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainComponent;", "", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainActivity;", "activity", "", "inject", "(Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainActivity;)V", "Builder", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NotificationCenterLandingMainDependencies.class}, modules = {NotificationCenterLandingMainModule.class})
@PerActivity
public interface NotificationCenterLandingMainComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainComponent$Builder;", "", "Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainDependencies;", "dependencies", "(Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainDependencies;)Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainComponent$Builder;", "", "id", "withId", "(Ljava/lang/String;)Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainComponent$Builder;", "Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainComponent;", "build", "()Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainComponent;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NotificationCenterLandingMainComponent build();

        @NotNull
        Builder dependencies(@NotNull NotificationCenterLandingMainDependencies notificationCenterLandingMainDependencies);

        @BindsInstance
        @NotNull
        Builder withId(@NotNull String str);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);
    }

    void inject(@NotNull NotificationCenterLandingMainActivity notificationCenterLandingMainActivity);
}
