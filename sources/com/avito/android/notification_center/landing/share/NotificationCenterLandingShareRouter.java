package com.avito.android.notification_center.landing.share;

import android.net.Uri;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareRouter;", "", "", "title", "url", "", "share", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/net/Uri;", "imageUri", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "close", "()V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingShareRouter {
    void close();

    void share(@Nullable String str, @NotNull String str2);

    void share(@Nullable String str, @NotNull String str2, @NotNull Uri uri);
}
