package com.avito.android.public_profile.ui;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublicProfileResourceProviderImpl_Factory implements Factory<PublicProfileResourceProviderImpl> {
    public final Provider<Resources> a;

    public PublicProfileResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static PublicProfileResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new PublicProfileResourceProviderImpl_Factory(provider);
    }

    public static PublicProfileResourceProviderImpl newInstance(Resources resources) {
        return new PublicProfileResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public PublicProfileResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
