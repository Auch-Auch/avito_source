package com.avito.android.extended_profile;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileResourceProviderImpl_Factory implements Factory<ExtendedProfileResourceProviderImpl> {
    public final Provider<Resources> a;

    public ExtendedProfileResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ExtendedProfileResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ExtendedProfileResourceProviderImpl_Factory(provider);
    }

    public static ExtendedProfileResourceProviderImpl newInstance(Resources resources) {
        return new ExtendedProfileResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ExtendedProfileResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
