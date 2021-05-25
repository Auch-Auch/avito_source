package com.avito.android.di;

import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.permissions.PermissionChecker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/SendMetricsServiceDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "()Lcom/avito/android/permissions/PermissionChecker;", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "()Lcom/avito/android/analytics/NetworkTypeProvider;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "application_release"}, k = 1, mv = {1, 4, 2})
public interface SendMetricsServiceDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    NetworkTypeProvider networkTypeProvider();

    @Override // com.avito.android.notifications_settings.di.NotificationsSettingsDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    NotificationManagerProvider notificationManagerProvider();

    @Override // com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies
    @NotNull
    PermissionChecker permissionChecker();
}
