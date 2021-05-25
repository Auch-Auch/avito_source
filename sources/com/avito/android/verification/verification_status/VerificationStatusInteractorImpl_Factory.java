package com.avito.android.verification.verification_status;

import com.avito.android.remote.VerificationApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationStatusInteractorImpl_Factory implements Factory<VerificationStatusInteractorImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<VerificationApi> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public VerificationStatusInteractorImpl_Factory(Provider<SchedulersFactory3> provider, Provider<VerificationApi> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static VerificationStatusInteractorImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<VerificationApi> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new VerificationStatusInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static VerificationStatusInteractorImpl newInstance(SchedulersFactory3 schedulersFactory3, VerificationApi verificationApi, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new VerificationStatusInteractorImpl(schedulersFactory3, verificationApi, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public VerificationStatusInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
