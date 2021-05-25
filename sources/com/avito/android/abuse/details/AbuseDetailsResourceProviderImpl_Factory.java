package com.avito.android.abuse.details;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AbuseDetailsResourceProviderImpl_Factory implements Factory<AbuseDetailsResourceProviderImpl> {
    public final Provider<Resources> a;

    public AbuseDetailsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AbuseDetailsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new AbuseDetailsResourceProviderImpl_Factory(provider);
    }

    public static AbuseDetailsResourceProviderImpl newInstance(Resources resources) {
        return new AbuseDetailsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public AbuseDetailsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
