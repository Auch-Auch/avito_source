package com.avito.android.authorization.select_social;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectSocialResourceProviderImpl_Factory implements Factory<SelectSocialResourceProviderImpl> {
    public final Provider<Resources> a;

    public SelectSocialResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SelectSocialResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SelectSocialResourceProviderImpl_Factory(provider);
    }

    public static SelectSocialResourceProviderImpl newInstance(Resources resources) {
        return new SelectSocialResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SelectSocialResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
