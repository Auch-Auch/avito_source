package com.avito.android.verification.verification_status;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationStatusConverterImpl_Factory implements Factory<VerificationStatusConverterImpl> {
    public final Provider<Features> a;

    public VerificationStatusConverterImpl_Factory(Provider<Features> provider) {
        this.a = provider;
    }

    public static VerificationStatusConverterImpl_Factory create(Provider<Features> provider) {
        return new VerificationStatusConverterImpl_Factory(provider);
    }

    public static VerificationStatusConverterImpl newInstance(Features features) {
        return new VerificationStatusConverterImpl(features);
    }

    @Override // javax.inject.Provider
    public VerificationStatusConverterImpl get() {
        return newInstance(this.a.get());
    }
}
