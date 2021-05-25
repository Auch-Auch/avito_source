package com.avito.android.notification_center.landing.feedback;

import com.avito.android.remote.model.notification_center.NotificationCenterLandingFeedback;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackInteractor;", "", "", "id", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingFeedback;", "getNotificationCenterLandingFeedback", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "isPositiveResult", "sendNotificationCenterLandingFeedbackResult", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingFeedbackInteractor {
    @NotNull
    Observable<LoadingState<NotificationCenterLandingFeedback>> getNotificationCenterLandingFeedback(@NotNull String str);

    @NotNull
    Observable<LoadingState<String>> sendNotificationCenterLandingFeedbackResult(@NotNull String str, boolean z);
}
