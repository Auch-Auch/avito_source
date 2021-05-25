package com.avito.android.events.notifications_settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;", "", "isFavoriteSellersPush", "(Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;)Z", "core_release"}, k = 2, mv = {1, 4, 2})
public final class NotificationSettingsChangeEventKt {
    public static final boolean isFavoriteSellersPush(@NotNull NotificationSettingsChangeEvent notificationSettingsChangeEvent) {
        Intrinsics.checkNotNullParameter(notificationSettingsChangeEvent, "$this$isFavoriteSellersPush");
        return Intrinsics.areEqual(notificationSettingsChangeEvent.getSection(), "fav_sellers") && Intrinsics.areEqual(notificationSettingsChangeEvent.getChannel(), "push");
    }
}
