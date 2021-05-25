package com.avito.android.notification_center.landing.feedback;

import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenter;", "", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackView;)V", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackRouter;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "cancelDialog", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingFeedbackPresenter {
    void attachRouter(@NotNull NotificationCenterLandingFeedbackRouter notificationCenterLandingFeedbackRouter);

    void attachView(@NotNull NotificationCenterLandingFeedbackView notificationCenterLandingFeedbackView);

    void cancelDialog();

    void detachRouter();

    void detachView();

    @NotNull
    Kundle getState();
}
