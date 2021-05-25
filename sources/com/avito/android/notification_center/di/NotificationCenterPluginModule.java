package com.avito.android.notification_center.di;

import android.app.Application;
import android.app.NotificationManager;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.notification_center.counter.NotificationCenterCounterUpdater;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Objects;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/notification_center/di/NotificationCenterPluginModule;", "", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterUpdater;", "notificationCenterCounterUpdater", "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "provideCounterPlugin", "(Lcom/avito/android/notification_center/counter/NotificationCenterCounterUpdater;)Lcom/avito/android/account/plugin/AuthorizationPlugin;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideNotificationsPlugin", "(Landroid/app/Application;)Lcom/avito/android/account/plugin/AuthorizationPlugin;", "<init>", "()V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class NotificationCenterPluginModule {
    @NotNull
    public static final NotificationCenterPluginModule INSTANCE = new NotificationCenterPluginModule();

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final AuthorizationPlugin provideCounterPlugin(@NotNull NotificationCenterCounterUpdater notificationCenterCounterUpdater) {
        Intrinsics.checkNotNullParameter(notificationCenterCounterUpdater, "notificationCenterCounterUpdater");
        return new AuthorizationPlugin(notificationCenterCounterUpdater) { // from class: com.avito.android.notification_center.di.NotificationCenterPluginModule$provideCounterPlugin$1
            public final /* synthetic */ NotificationCenterCounterUpdater a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogin() {
                AuthorizationPlugin.DefaultImpls.onLogin(this);
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogout() {
                AuthorizationPlugin.DefaultImpls.onLogout(this);
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onStateChanged() {
                this.a.update();
            }
        };
    }

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final AuthorizationPlugin provideNotificationsPlugin(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new AuthorizationPlugin(application) { // from class: com.avito.android.notification_center.di.NotificationCenterPluginModule$provideNotificationsPlugin$1
            public final /* synthetic */ Application a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogin() {
                AuthorizationPlugin.DefaultImpls.onLogin(this);
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onLogout() {
                Object systemService = this.a.getSystemService("notification");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                ((NotificationManager) systemService).cancelAll();
            }

            @Override // com.avito.android.account.plugin.AuthorizationPlugin
            public void onStateChanged() {
                AuthorizationPlugin.DefaultImpls.onStateChanged(this);
            }
        };
    }
}
