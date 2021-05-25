package com.avito.android.notification_center.landing.share;

import com.avito.android.di.PerActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareComponent;", "", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareActivity;", "activity", "", "inject", "(Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareActivity;)V", "Builder", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NotificationCenterLandingShareDependencies.class}, modules = {NotificationCenterLandingShareModule.class})
@PerActivity
public interface NotificationCenterLandingShareComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareComponent$Builder;", "", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareDependencies;", "dependencies", "(Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareDependencies;)Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareComponent$Builder;", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareModule;)Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareComponent$Builder;", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareComponent;", "build", "()Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareComponent;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NotificationCenterLandingShareComponent build();

        @NotNull
        Builder dependencies(@NotNull NotificationCenterLandingShareDependencies notificationCenterLandingShareDependencies);

        @NotNull
        Builder module(@NotNull NotificationCenterLandingShareModule notificationCenterLandingShareModule);
    }

    void inject(@NotNull NotificationCenterLandingShareActivity notificationCenterLandingShareActivity);
}
