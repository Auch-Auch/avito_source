package com.avito.android.user_advert.advert.verification;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationItemConverterImpl_Factory implements Factory<VerificationItemConverterImpl> {
    public final Provider<Features> a;

    public VerificationItemConverterImpl_Factory(Provider<Features> provider) {
        this.a = provider;
    }

    public static VerificationItemConverterImpl_Factory create(Provider<Features> provider) {
        return new VerificationItemConverterImpl_Factory(provider);
    }

    public static VerificationItemConverterImpl newInstance(Features features) {
        return new VerificationItemConverterImpl(features);
    }

    @Override // javax.inject.Provider
    public VerificationItemConverterImpl get() {
        return newInstance(this.a.get());
    }
}
