package com.avito.android.in_app_calls.task;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.in_app_calls.R;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/in_app_calls/task/SetupCallNotificationChannelTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class SetupCallNotificationChannelTask implements ApplicationBackgroundStartupTask {
    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = application.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            notificationManager.deleteNotificationChannel(application.getString(R.string.calls_notification_channel_incoming_id_legacy));
            NotificationChannel notificationChannel = new NotificationChannel(application.getString(R.string.calls_notification_channel_incoming_id), application.getString(R.string.calls_notification_channel_incoming_name), 4);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            notificationChannel.setBypassDnd(true);
            notificationManager.createNotificationChannel(notificationChannel);
            NotificationChannel notificationChannel2 = new NotificationChannel(application.getString(R.string.calls_notification_channel_active_id), application.getString(R.string.calls_notification_channel_active_name), 3);
            notificationChannel2.setDescription(application.getString(R.string.calls_notification_channel_active_description));
            notificationChannel2.enableVibration(false);
            notificationChannel2.setSound(null, null);
            notificationChannel2.setBypassDnd(true);
            notificationManager.createNotificationChannel(notificationChannel2);
            NotificationChannel notificationChannel3 = new NotificationChannel(application.getString(R.string.calls_notification_channel_missed_id), application.getString(R.string.calls_notification_channel_missed_name), 4);
            notificationChannel2.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel3);
        }
    }
}
