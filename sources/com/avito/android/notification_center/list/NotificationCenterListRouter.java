package com.avito.android.notification_center.list;

import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/notification_center/list/NotificationCenterListRouter;", "", "", "onUpPressed", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/CalledFrom$NotificationCenter;", "calledFrom", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/CalledFrom$NotificationCenter;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openPromoScreen", "(Landroid/net/Uri;Lcom/avito/android/CalledFrom$NotificationCenter;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterListRouter {
    void followDeepLink(@NotNull DeepLink deepLink, @NotNull CalledFrom.NotificationCenter notificationCenter);

    void onUpPressed();

    void openPromoScreen(@NotNull Uri uri, @NotNull CalledFrom.NotificationCenter notificationCenter);
}
