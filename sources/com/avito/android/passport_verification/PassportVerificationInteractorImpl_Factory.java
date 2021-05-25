package com.avito.android.passport_verification;

import com.avito.android.remote.VerificationApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PassportVerificationInteractorImpl_Factory implements Factory<PassportVerificationInteractorImpl> {
    public final Provider<VerificationApi> a;

    public PassportVerificationInteractorImpl_Factory(Provider<VerificationApi> provider) {
        this.a = provider;
    }

    public static PassportVerificationInteractorImpl_Factory create(Provider<VerificationApi> provider) {
        return new PassportVerificationInteractorImpl_Factory(provider);
    }

    public static PassportVerificationInteractorImpl newInstance(VerificationApi verificationApi) {
        return new PassportVerificationInteractorImpl(verificationApi);
    }

    @Override // javax.inject.Provider
    public PassportVerificationInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
