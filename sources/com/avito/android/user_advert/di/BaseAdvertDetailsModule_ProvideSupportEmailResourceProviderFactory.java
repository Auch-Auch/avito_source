package com.avito.android.user_advert.di;

import android.content.res.Resources;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BaseAdvertDetailsModule_ProvideSupportEmailResourceProviderFactory implements Factory<SupportEmailResourceProvider> {
    public final Provider<Resources> a;
    public final Provider<DeviceMetrics> b;
    public final Provider<ProfileInfoStorage> c;

    public BaseAdvertDetailsModule_ProvideSupportEmailResourceProviderFactory(Provider<Resources> provider, Provider<DeviceMetrics> provider2, Provider<ProfileInfoStorage> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static BaseAdvertDetailsModule_ProvideSupportEmailResourceProviderFactory create(Provider<Resources> provider, Provider<DeviceMetrics> provider2, Provider<ProfileInfoStorage> provider3) {
        return new BaseAdvertDetailsModule_ProvideSupportEmailResourceProviderFactory(provider, provider2, provider3);
    }

    public static SupportEmailResourceProvider provideSupportEmailResourceProvider(Resources resources, DeviceMetrics deviceMetrics, ProfileInfoStorage profileInfoStorage) {
        return (SupportEmailResourceProvider) Preconditions.checkNotNullFromProvides(BaseAdvertDetailsModule.provideSupportEmailResourceProvider(resources, deviceMetrics, profileInfoStorage));
    }

    @Override // javax.inject.Provider
    public SupportEmailResourceProvider get() {
        return provideSupportEmailResourceProvider(this.a.get(), this.b.get(), this.c.get());
    }
}
