package com.avito.android.messenger;

import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.preferences.MessengerStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerPluginModule_ProvideAuthorizationPluginFactory implements Factory<AuthorizationPlugin> {
    public final Provider<MessengerStorage> a;

    public MessengerPluginModule_ProvideAuthorizationPluginFactory(Provider<MessengerStorage> provider) {
        this.a = provider;
    }

    public static MessengerPluginModule_ProvideAuthorizationPluginFactory create(Provider<MessengerStorage> provider) {
        return new MessengerPluginModule_ProvideAuthorizationPluginFactory(provider);
    }

    public static AuthorizationPlugin provideAuthorizationPlugin(MessengerStorage messengerStorage) {
        return (AuthorizationPlugin) Preconditions.checkNotNullFromProvides(MessengerPluginModule.provideAuthorizationPlugin(messengerStorage));
    }

    @Override // javax.inject.Provider
    public AuthorizationPlugin get() {
        return provideAuthorizationPlugin(this.a.get());
    }
}
