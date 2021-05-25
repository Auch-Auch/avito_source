package com.avito.android.remote.notification.deep_link;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.remote.notification.NotificationIdentifier;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/notification/deep_link/NotificationDeepLinkPresenter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/remote/notification/NotificationIdentifier;", "identifier", "Lcom/avito/android/remote/model/notification/Payload;", "payload", "Lcom/avito/android/remote/notification/deep_link/AnalyticParams;", "analytics", "", Tracker.Events.CREATIVE_START, "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/notification/NotificationIdentifier;Lcom/avito/android/remote/model/notification/Payload;Lcom/avito/android/remote/notification/deep_link/AnalyticParams;)V", "notification-deeplink_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationDeepLinkPresenter {
    void start(@Nullable DeepLink deepLink, @Nullable NotificationIdentifier notificationIdentifier, @Nullable Payload payload, @Nullable AnalyticParams analyticParams);
}
