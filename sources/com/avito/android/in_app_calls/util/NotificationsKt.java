package com.avito.android.in_app_calls.util;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.in_app_calls.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/content/Context;", "", "areIncomingCallNotificationsAllowed", "(Landroid/content/Context;)Z", "in-app-calls_release"}, k = 2, mv = {1, 4, 2})
public final class NotificationsKt {
    public static final boolean areIncomingCallNotificationsAllowed(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$areIncomingCallNotificationsAllowed");
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(this)");
        if (from.areNotificationsEnabled()) {
            if (Build.VERSION.SDK_INT < 26) {
                return true;
            }
            String string = context.getString(R.string.calls_notification_channel_incoming_id);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.calls…tion_channel_incoming_id)");
            NotificationChannel notificationChannel = from.getNotificationChannel(string);
            if (notificationChannel == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(notificationChannel, "notificationManager.getN…hannelId) ?: return false");
            if (notificationChannel.getImportance() != 0) {
                return true;
            }
        }
        return false;
    }
}
