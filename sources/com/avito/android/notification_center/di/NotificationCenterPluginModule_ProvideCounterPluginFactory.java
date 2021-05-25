package com.avito.android.notification_center.di;

import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.notification_center.counter.NotificationCenterCounterUpdater;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationCenterPluginModule_ProvideCounterPluginFactory implements Factory<AuthorizationPlugin> {
    public final Provider<NotificationCenterCounterUpdater> a;

    public NotificationCenterPluginModule_ProvideCounterPluginFactory(Provider<NotificationCenterCounterUpdater> provider) {
        this.a = provider;
    }

    public static NotificationCenterPluginModule_ProvideCounterPluginFactory create(Provider<NotificationCenterCounterUpdater> provider) {
        return new NotificationCenterPluginModule_ProvideCounterPluginFactory(provider);
    }

    public static AuthorizationPlugin provideCounterPlugin(NotificationCenterCounterUpdater notificationCenterCounterUpdater) {
        return (AuthorizationPlugin) Preconditions.checkNotNullFromProvides(NotificationCenterPluginModule.provideCounterPlugin(notificationCenterCounterUpdater));
    }

    @Override // javax.inject.Provider
    public AuthorizationPlugin get() {
        return provideCounterPlugin(this.a.get());
    }
}
