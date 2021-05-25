package com.avito.android.shared_providers;

import android.content.res.Resources;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SupportEmailResourceProviderImpl_Factory implements Factory<SupportEmailResourceProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<ProfileInfoStorage> b;
    public final Provider<BuildInfo> c;

    public SupportEmailResourceProviderImpl_Factory(Provider<Resources> provider, Provider<ProfileInfoStorage> provider2, Provider<BuildInfo> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SupportEmailResourceProviderImpl_Factory create(Provider<Resources> provider, Provider<ProfileInfoStorage> provider2, Provider<BuildInfo> provider3) {
        return new SupportEmailResourceProviderImpl_Factory(provider, provider2, provider3);
    }

    public static SupportEmailResourceProviderImpl newInstance(Resources resources, ProfileInfoStorage profileInfoStorage, BuildInfo buildInfo) {
        return new SupportEmailResourceProviderImpl(resources, profileInfoStorage, buildInfo);
    }

    @Override // javax.inject.Provider
    public SupportEmailResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
