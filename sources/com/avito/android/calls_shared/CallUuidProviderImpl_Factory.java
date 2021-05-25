package com.avito.android.calls_shared;

import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class CallUuidProviderImpl_Factory implements Factory<CallUuidProviderImpl> {
    public final Provider<RandomKeyProvider> a;
    public final Provider<Locale> b;

    public CallUuidProviderImpl_Factory(Provider<RandomKeyProvider> provider, Provider<Locale> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CallUuidProviderImpl_Factory create(Provider<RandomKeyProvider> provider, Provider<Locale> provider2) {
        return new CallUuidProviderImpl_Factory(provider, provider2);
    }

    public static CallUuidProviderImpl newInstance(RandomKeyProvider randomKeyProvider, Locale locale) {
        return new CallUuidProviderImpl(randomKeyProvider, locale);
    }

    @Override // javax.inject.Provider
    public CallUuidProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
