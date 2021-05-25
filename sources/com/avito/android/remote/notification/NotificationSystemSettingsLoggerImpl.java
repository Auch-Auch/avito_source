package com.avito.android.remote.notification;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NotificationSystemSettingsChangeEvent;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/notification/NotificationSystemSettingsLoggerImpl;", "Lcom/avito/android/remote/notification/NotificationSystemSettingsLogger;", "", "handleMessage", "()V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/preferences/TokenStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/preferences/TokenStorage;", "tokenStorage", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "c", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/preferences/TokenStorage;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/analytics/Analytics;)V", "push_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationSystemSettingsLoggerImpl implements NotificationSystemSettingsLogger {
    public final Preferences a;
    public final TokenStorage b;
    public final NotificationManagerProvider c;
    public final Analytics d;

    public NotificationSystemSettingsLoggerImpl(@NotNull Preferences preferences, @NotNull TokenStorage tokenStorage, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = preferences;
        this.b = tokenStorage;
        this.c = notificationManagerProvider;
        this.d = analytics;
    }

    @Override // com.avito.android.remote.notification.NotificationSystemSettingsLogger
    public void handleMessage() {
        boolean z = this.a.getBoolean("system_notification_settings_was_enable", true);
        boolean areNotificationsEnabled = this.c.getAreNotificationsEnabled();
        if (areNotificationsEnabled != z) {
            this.a.putBoolean("system_notification_settings_was_enable", areNotificationsEnabled);
            this.d.track(new NotificationSystemSettingsChangeEvent(this.b.getGcmToken(), areNotificationsEnabled));
        }
    }
}
