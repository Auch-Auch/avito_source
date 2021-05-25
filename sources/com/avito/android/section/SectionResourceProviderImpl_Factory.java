package com.avito.android.section;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SectionResourceProviderImpl_Factory implements Factory<SectionResourceProviderImpl> {
    public final Provider<Resources> a;

    public SectionResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SectionResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new SectionResourceProviderImpl_Factory(provider);
    }

    public static SectionResourceProviderImpl newInstance(Resources resources) {
        return new SectionResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public SectionResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
