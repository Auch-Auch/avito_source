package com.avito.android.social_management.di;

import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.preferences.SocialNotificationStateStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SocialManagementPluginModule_ProvideAuthorizationPluginFactory implements Factory<AuthorizationPlugin> {
    public final Provider<SocialNotificationStateStorage> a;

    public SocialManagementPluginModule_ProvideAuthorizationPluginFactory(Provider<SocialNotificationStateStorage> provider) {
        this.a = provider;
    }

    public static SocialManagementPluginModule_ProvideAuthorizationPluginFactory create(Provider<SocialNotificationStateStorage> provider) {
        return new SocialManagementPluginModule_ProvideAuthorizationPluginFactory(provider);
    }

    public static AuthorizationPlugin provideAuthorizationPlugin(SocialNotificationStateStorage socialNotificationStateStorage) {
        return (AuthorizationPlugin) Preconditions.checkNotNullFromProvides(SocialManagementPluginModule.provideAuthorizationPlugin(socialNotificationStateStorage));
    }

    @Override // javax.inject.Provider
    public AuthorizationPlugin get() {
        return provideAuthorizationPlugin(this.a.get());
    }
}
