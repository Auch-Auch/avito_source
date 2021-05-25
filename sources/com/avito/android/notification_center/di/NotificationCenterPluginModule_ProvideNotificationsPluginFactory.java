package com.avito.android.notification_center.di;

import android.app.Application;
import com.avito.android.account.plugin.AuthorizationPlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationCenterPluginModule_ProvideNotificationsPluginFactory implements Factory<AuthorizationPlugin> {
    public final Provider<Application> a;

    public NotificationCenterPluginModule_ProvideNotificationsPluginFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static NotificationCenterPluginModule_ProvideNotificationsPluginFactory create(Provider<Application> provider) {
        return new NotificationCenterPluginModule_ProvideNotificationsPluginFactory(provider);
    }

    public static AuthorizationPlugin provideNotificationsPlugin(Application application) {
        return (AuthorizationPlugin) Preconditions.checkNotNullFromProvides(NotificationCenterPluginModule.provideNotificationsPlugin(application));
    }

    @Override // javax.inject.Provider
    public AuthorizationPlugin get() {
        return provideNotificationsPlugin(this.a.get());
    }
}
