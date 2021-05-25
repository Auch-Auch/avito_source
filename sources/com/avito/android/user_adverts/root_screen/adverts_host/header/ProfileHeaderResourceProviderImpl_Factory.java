package com.avito.android.user_adverts.root_screen.adverts_host.header;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileHeaderResourceProviderImpl_Factory implements Factory<ProfileHeaderResourceProviderImpl> {
    public final Provider<Resources> a;

    public ProfileHeaderResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ProfileHeaderResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ProfileHeaderResourceProviderImpl_Factory(provider);
    }

    public static ProfileHeaderResourceProviderImpl newInstance(Resources resources) {
        return new ProfileHeaderResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ProfileHeaderResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
