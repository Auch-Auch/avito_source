package com.avito.android.authorization.login.di;

import android.content.res.Resources;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LoginModule_ProvidesSupportEmailResourceProviderFactory implements Factory<SupportEmailResourceProvider> {
    public final Provider<Resources> a;
    public final Provider<ProfileInfoStorage> b;
    public final Provider<BuildInfo> c;

    public LoginModule_ProvidesSupportEmailResourceProviderFactory(Provider<Resources> provider, Provider<ProfileInfoStorage> provider2, Provider<BuildInfo> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static LoginModule_ProvidesSupportEmailResourceProviderFactory create(Provider<Resources> provider, Provider<ProfileInfoStorage> provider2, Provider<BuildInfo> provider3) {
        return new LoginModule_ProvidesSupportEmailResourceProviderFactory(provider, provider2, provider3);
    }

    public static SupportEmailResourceProvider providesSupportEmailResourceProvider(Resources resources, ProfileInfoStorage profileInfoStorage, BuildInfo buildInfo) {
        return (SupportEmailResourceProvider) Preconditions.checkNotNullFromProvides(LoginModule.providesSupportEmailResourceProvider(resources, profileInfoStorage, buildInfo));
    }

    @Override // javax.inject.Provider
    public SupportEmailResourceProvider get() {
        return providesSupportEmailResourceProvider(this.a.get(), this.b.get(), this.c.get());
    }
}
