package com.avito.android.push;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.PerService;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.push.MessagingInteractor;
import com.avito.android.push.MessagingResourceProvider;
import com.avito.android.remote.notification.NotificationSystemSettingsLogger;
import com.avito.android.remote.notification.NotificationSystemSettingsLoggerImpl;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/push/MessagingModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/push/MessagingResourceProvider;", "messagingResourceProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/push/MessagingInteractor;", "provideMessagingInteractor", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/google/gson/Gson;Lcom/avito/android/push/MessagingResourceProvider;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)Lcom/avito/android/push/MessagingInteractor;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideMessagingResourceProvider", "(Landroid/app/Application;)Lcom/avito/android/push/MessagingResourceProvider;", "Lcom/avito/android/preferences/TokenStorage;", "instanceIdStorage", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/remote/notification/NotificationSystemSettingsLogger;", "provideNotificationSystemSettingsLogger", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/preferences/TokenStorage;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/remote/notification/NotificationSystemSettingsLogger;", "<init>", "()V", "push_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class MessagingModule {
    @NotNull
    public static final MessagingModule INSTANCE = new MessagingModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final MessagingInteractor provideMessagingInteractor(@NotNull Analytics analytics, @NotNull DeepLinkFactory deepLinkFactory, @NotNull Gson gson, @NotNull MessagingResourceProvider messagingResourceProvider, @NotNull NotificationManagerProvider notificationManagerProvider) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(messagingResourceProvider, "messagingResourceProvider");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        return new MessagingInteractor.Impl(analytics, deepLinkFactory, gson, messagingResourceProvider, notificationManagerProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final MessagingResourceProvider provideMessagingResourceProvider(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new MessagingResourceProvider.Impl(application);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final NotificationSystemSettingsLogger provideNotificationSystemSettingsLogger(@NotNull Analytics analytics, @NotNull TokenStorage tokenStorage, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(tokenStorage, "instanceIdStorage");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new NotificationSystemSettingsLoggerImpl(preferences, tokenStorage, notificationManagerProvider, analytics);
    }
}
