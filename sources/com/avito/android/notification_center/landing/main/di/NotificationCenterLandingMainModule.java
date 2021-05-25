package com.avito.android.notification_center.landing.main.di;

import com.avito.android.di.PerActivity;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainInteractor;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainInteractorImpl;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenter;
import com.avito.android.notification_center.landing.main.NotificationCenterLandingMainPresenterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/notification_center/landing/main/di/NotificationCenterLandingMainModule;", "", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractorImpl;", "interactor", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractor;", "bindNotificationCenterLandingMainInteractor", "(Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractorImpl;)Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainInteractor;", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenterImpl;", "presenter", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenter;", "bindNotificationCenterLandingMainPresenter", "(Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenterImpl;)Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenter;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface NotificationCenterLandingMainModule {
    @PerActivity
    @Binds
    @NotNull
    NotificationCenterLandingMainInteractor bindNotificationCenterLandingMainInteractor(@NotNull NotificationCenterLandingMainInteractorImpl notificationCenterLandingMainInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    NotificationCenterLandingMainPresenter bindNotificationCenterLandingMainPresenter(@NotNull NotificationCenterLandingMainPresenterImpl notificationCenterLandingMainPresenterImpl);
}
