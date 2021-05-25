package com.avito.android.messenger.service.direct_reply;

import androidx.annotation.StringRes;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.notification.NotificationIdentifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJE\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate;", "", "", "channelId", "text", "Lcom/avito/android/remote/notification/NotificationIdentifier;", "notificationId", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate$NotificationController;", "controller", "", "isRetry", MessageBody.RANDOM_ID, "", "sendMessageAndReadChat", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/notification/NotificationIdentifier;Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate$NotificationController;ZLjava/lang/String;)V", "NotificationController", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface DirectReplyServiceDelegate {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate$NotificationController;", "", "Lcom/avito/android/remote/notification/NotificationIdentifier;", "identifier", "", "cancelNotification", "(Lcom/avito/android/remote/notification/NotificationIdentifier;)V", "", "channelId", "text", MessageBody.RANDOM_ID, "showFailureNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "id", "showToast", "(I)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface NotificationController {
        void cancelNotification(@NotNull NotificationIdentifier notificationIdentifier);

        void showFailureNotification(@NotNull String str, @NotNull String str2, @NotNull String str3);

        void showToast(@StringRes int i);
    }

    void sendMessageAndReadChat(@NotNull String str, @Nullable String str2, @Nullable NotificationIdentifier notificationIdentifier, @NotNull NotificationController notificationController, boolean z, @Nullable String str3);
}
