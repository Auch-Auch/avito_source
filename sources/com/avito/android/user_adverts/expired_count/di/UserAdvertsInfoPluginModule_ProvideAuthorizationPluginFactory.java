package com.avito.android.user_adverts.expired_count.di;

import android.app.Application;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsInfoPluginModule_ProvideAuthorizationPluginFactory implements Factory<AuthorizationPlugin> {
    public final Provider<UserAdvertsInfoUpdateRunner> a;
    public final Provider<UserAdvertsInfoStorage> b;
    public final Provider<Application> c;

    public UserAdvertsInfoPluginModule_ProvideAuthorizationPluginFactory(Provider<UserAdvertsInfoUpdateRunner> provider, Provider<UserAdvertsInfoStorage> provider2, Provider<Application> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static UserAdvertsInfoPluginModule_ProvideAuthorizationPluginFactory create(Provider<UserAdvertsInfoUpdateRunner> provider, Provider<UserAdvertsInfoStorage> provider2, Provider<Application> provider3) {
        return new UserAdvertsInfoPluginModule_ProvideAuthorizationPluginFactory(provider, provider2, provider3);
    }

    public static AuthorizationPlugin provideAuthorizationPlugin(UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner, UserAdvertsInfoStorage userAdvertsInfoStorage, Application application) {
        return (AuthorizationPlugin) Preconditions.checkNotNullFromProvides(UserAdvertsInfoPluginModule.provideAuthorizationPlugin(userAdvertsInfoUpdateRunner, userAdvertsInfoStorage, application));
    }

    @Override // javax.inject.Provider
    public AuthorizationPlugin get() {
        return provideAuthorizationPlugin(this.a.get(), this.b.get(), this.c.get());
    }
}
