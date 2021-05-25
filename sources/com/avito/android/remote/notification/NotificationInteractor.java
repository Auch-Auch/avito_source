package com.avito.android.remote.notification;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/notification/NotificationInteractor;", "", "Lcom/avito/android/remote/notification/NotificationParameters;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "showNotification", "(Lcom/avito/android/remote/notification/NotificationParameters;)V", "", "channelId", "cancelChannelIdNotification", "(Ljava/lang/String;)V", "id", "cancelNotificationCenterNotification", "Lcom/avito/android/remote/notification/NotificationIdentifier;", "identifier", "cancelNotification", "(Lcom/avito/android/remote/notification/NotificationIdentifier;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationInteractor {
    void cancelChannelIdNotification(@NotNull String str);

    void cancelNotification(@NotNull NotificationIdentifier notificationIdentifier);

    void cancelNotificationCenterNotification(@NotNull String str);

    void showNotification(@NotNull NotificationParameters notificationParameters);
}
