package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.favorites.FavoriteAdvertsSyncRunner;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoritePluginModule_ProvideAuthorizationPluginFactory implements Factory<AuthorizationPlugin> {
    public final Provider<Application> a;
    public final Provider<FavoriteAdvertsSyncRunner> b;

    public FavoritePluginModule_ProvideAuthorizationPluginFactory(Provider<Application> provider, Provider<FavoriteAdvertsSyncRunner> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoritePluginModule_ProvideAuthorizationPluginFactory create(Provider<Application> provider, Provider<FavoriteAdvertsSyncRunner> provider2) {
        return new FavoritePluginModule_ProvideAuthorizationPluginFactory(provider, provider2);
    }

    public static AuthorizationPlugin provideAuthorizationPlugin(Application application, FavoriteAdvertsSyncRunner favoriteAdvertsSyncRunner) {
        return (AuthorizationPlugin) Preconditions.checkNotNullFromProvides(FavoritePluginModule.provideAuthorizationPlugin(application, favoriteAdvertsSyncRunner));
    }

    @Override // javax.inject.Provider
    public AuthorizationPlugin get() {
        return provideAuthorizationPlugin(this.a.get(), this.b.get());
    }
}
