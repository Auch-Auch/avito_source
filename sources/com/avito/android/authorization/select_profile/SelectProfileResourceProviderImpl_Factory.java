package com.avito.android.authorization.select_profile;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectProfileResourceProviderImpl_Factory implements Factory<SelectProfileResourceProviderImpl> {
    public final Provider<Resources> a;

    public SelectProfileResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SelectProfileResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SelectProfileResourceProviderImpl_Factory(provider);
    }

    public static SelectProfileResourceProviderImpl newInstance(Resources resources) {
        return new SelectProfileResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SelectProfileResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
