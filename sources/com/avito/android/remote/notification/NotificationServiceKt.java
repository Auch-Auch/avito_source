package com.avito.android.remote.notification;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/remote/notification/NotificationParameters;", "notification", "Landroid/content/Intent;", "notificationServiceIntent", "(Landroid/content/Context;Lcom/avito/android/remote/notification/NotificationParameters;)Landroid/content/Intent;", "notification_release"}, k = 2, mv = {1, 4, 2})
public final class NotificationServiceKt {
    @NotNull
    public static final Intent notificationServiceIntent(@NotNull Context context, @NotNull NotificationParameters notificationParameters) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationParameters, "notification");
        Intent putExtra = new Intent(context, NotificationService.class).setAction("com.avito.android.PUSH_NOTIFICATION").putExtra("notification", notificationParameters);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, Notifica…TIFICATION, notification)");
        return putExtra;
    }
}
