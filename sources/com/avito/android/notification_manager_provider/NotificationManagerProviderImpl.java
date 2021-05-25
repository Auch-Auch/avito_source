package com.avito.android.notification_manager_provider;

import androidx.core.app.NotificationManagerCompat;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/notification_manager_provider/NotificationManagerProviderImpl;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "Landroidx/core/app/NotificationManagerCompat;", AuthSource.SEND_ABUSE, "Landroidx/core/app/NotificationManagerCompat;", "notificationManagerCompat", "", "getAreNotificationsEnabled", "()Z", "areNotificationsEnabled", "<init>", "(Landroidx/core/app/NotificationManagerCompat;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationManagerProviderImpl implements NotificationManagerProvider {
    public final NotificationManagerCompat a;

    public NotificationManagerProviderImpl(@NotNull NotificationManagerCompat notificationManagerCompat) {
        Intrinsics.checkNotNullParameter(notificationManagerCompat, "notificationManagerCompat");
        this.a = notificationManagerCompat;
    }

    @Override // com.avito.android.notification_manager_provider.NotificationManagerProvider
    public boolean getAreNotificationsEnabled() {
        return this.a.areNotificationsEnabled();
    }
}
