package com.avito.android.notifications_settings.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.NotificationsApi;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/notifications_settings/di/NotificationsSettingsDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/NotificationsApi;", "notificationsApi", "()Lcom/avito/android/remote/NotificationsApi;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;", "notificationSettingsConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationsSettingsDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    NotificationManagerProvider notificationManagerProvider();

    @NotNull
    Consumer<NotificationSettingsChangeEvent> notificationSettingsConsumer();

    @Override // com.avito.android.push.UpdateInstanceIdDependencies
    @NotNull
    NotificationsApi notificationsApi();
}
