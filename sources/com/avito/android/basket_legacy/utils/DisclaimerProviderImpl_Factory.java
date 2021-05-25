package com.avito.android.basket_legacy.utils;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisclaimerProviderImpl_Factory implements Factory<DisclaimerProviderImpl> {
    public final Provider<StringProvider> a;

    public DisclaimerProviderImpl_Factory(Provider<StringProvider> provider) {
        this.a = provider;
    }

    public static DisclaimerProviderImpl_Factory create(Provider<StringProvider> provider) {
        return new DisclaimerProviderImpl_Factory(provider);
    }

    public static DisclaimerProviderImpl newInstance(StringProvider stringProvider) {
        return new DisclaimerProviderImpl(stringProvider);
    }

    @Override // javax.inject.Provider
    public DisclaimerProviderImpl get() {
        return newInstance(this.a.get());
    }
}
