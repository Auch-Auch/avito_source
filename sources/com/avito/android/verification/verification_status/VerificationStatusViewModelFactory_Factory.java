package com.avito.android.verification.verification_status;

import com.avito.android.util.SchedulersFactory3;
import com.avito.android.verification.VerificationResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationStatusViewModelFactory_Factory implements Factory<VerificationStatusViewModelFactory> {
    public final Provider<VerificationStatusInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<VerificationResourceProvider> c;
    public final Provider<VerificationStatusConverter> d;

    public VerificationStatusViewModelFactory_Factory(Provider<VerificationStatusInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<VerificationResourceProvider> provider3, Provider<VerificationStatusConverter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static VerificationStatusViewModelFactory_Factory create(Provider<VerificationStatusInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<VerificationResourceProvider> provider3, Provider<VerificationStatusConverter> provider4) {
        return new VerificationStatusViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static VerificationStatusViewModelFactory newInstance(VerificationStatusInteractor verificationStatusInteractor, SchedulersFactory3 schedulersFactory3, VerificationResourceProvider verificationResourceProvider, VerificationStatusConverter verificationStatusConverter) {
        return new VerificationStatusViewModelFactory(verificationStatusInteractor, schedulersFactory3, verificationResourceProvider, verificationStatusConverter);
    }

    @Override // javax.inject.Provider
    public VerificationStatusViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
