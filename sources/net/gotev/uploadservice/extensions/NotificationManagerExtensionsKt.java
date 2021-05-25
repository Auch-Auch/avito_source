package net.gotev.uploadservice.extensions;

import a2.b.a.a.a;
import android.app.NotificationManager;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/app/NotificationManager;", "", "channelID", "", "validateNotificationChannel", "(Landroid/app/NotificationManager;Ljava/lang/String;)V", "uploadservice_release"}, k = 2, mv = {1, 4, 0})
public final class NotificationManagerExtensionsKt {
    public static final void validateNotificationChannel(@NotNull NotificationManager notificationManager, @NotNull String str) {
        Intrinsics.checkNotNullParameter(notificationManager, "$this$validateNotificationChannel");
        Intrinsics.checkNotNullParameter(str, "channelID");
        if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel(str) == null) {
            throw new IllegalArgumentException(a.e3("The provided notification channel ID ", str, " does not exist! You must create it at app startup and before Upload Service!"));
        }
    }
}
