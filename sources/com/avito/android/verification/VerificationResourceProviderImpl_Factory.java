package com.avito.android.verification;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationResourceProviderImpl_Factory implements Factory<VerificationResourceProviderImpl> {
    public final Provider<Resources> a;

    public VerificationResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static VerificationResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new VerificationResourceProviderImpl_Factory(provider);
    }

    public static VerificationResourceProviderImpl newInstance(Resources resources) {
        return new VerificationResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public VerificationResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
