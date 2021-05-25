package com.avito.android.section.complementary;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ComplementaryResourceProviderImpl_Factory implements Factory<ComplementaryResourceProviderImpl> {
    public final Provider<Resources> a;

    public ComplementaryResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ComplementaryResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ComplementaryResourceProviderImpl_Factory(provider);
    }

    public static ComplementaryResourceProviderImpl newInstance(Resources resources) {
        return new ComplementaryResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ComplementaryResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
