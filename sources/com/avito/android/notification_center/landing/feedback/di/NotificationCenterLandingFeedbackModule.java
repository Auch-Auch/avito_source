package com.avito.android.notification_center.landing.feedback.di;

import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackInteractor;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackInteractorImpl;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenter;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackPresenterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackModule;", "", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractorImpl;", "interactor", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractor;", "bindNotificationCenterLandingFeedbackInteractor", "(Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractorImpl;)Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractor;", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenterImpl;", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenter;", "bindNotificationCenterLandingFeedbackPresenter", "(Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenterImpl;)Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenter;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public interface NotificationCenterLandingFeedbackModule {
    @PerActivity
    @Binds
    @NotNull
    NotificationCenterLandingFeedbackInteractor bindNotificationCenterLandingFeedbackInteractor(@NotNull NotificationCenterLandingFeedbackInteractorImpl notificationCenterLandingFeedbackInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    NotificationCenterLandingFeedbackPresenter bindNotificationCenterLandingFeedbackPresenter(@NotNull NotificationCenterLandingFeedbackPresenterImpl notificationCenterLandingFeedbackPresenterImpl);
}
