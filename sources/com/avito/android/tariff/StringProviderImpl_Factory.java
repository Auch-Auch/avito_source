package com.avito.android.tariff;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StringProviderImpl_Factory implements Factory<StringProviderImpl> {
    public final Provider<Resources> a;

    public StringProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static StringProviderImpl_Factory create(Provider<Resources> provider) {
        return new StringProviderImpl_Factory(provider);
    }

    public static StringProviderImpl newInstance(Resources resources) {
        return new StringProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public StringProviderImpl get() {
        return newInstance(this.a.get());
    }
}
