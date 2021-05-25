package com.avito.android.verification.verifications_list;

import com.avito.android.remote.VerificationApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationsListInteractorImpl_Factory implements Factory<VerificationsListInteractorImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<VerificationApi> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public VerificationsListInteractorImpl_Factory(Provider<SchedulersFactory3> provider, Provider<VerificationApi> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static VerificationsListInteractorImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<VerificationApi> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new VerificationsListInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static VerificationsListInteractorImpl newInstance(SchedulersFactory3 schedulersFactory3, VerificationApi verificationApi, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new VerificationsListInteractorImpl(schedulersFactory3, verificationApi, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public VerificationsListInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
