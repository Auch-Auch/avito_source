package com.avito.android.verification.verification_status.actions;

import com.avito.android.util.SchedulersFactory3;
import com.avito.android.verification.VerificationResourceProvider;
import com.avito.android.verification.verification_status.VerificationStatusInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationActionViewModelFactory_Factory implements Factory<VerificationActionViewModelFactory> {
    public final Provider<VerificationStatusInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<VerificationResourceProvider> c;
    public final Provider<String> d;

    public VerificationActionViewModelFactory_Factory(Provider<VerificationStatusInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<VerificationResourceProvider> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static VerificationActionViewModelFactory_Factory create(Provider<VerificationStatusInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<VerificationResourceProvider> provider3, Provider<String> provider4) {
        return new VerificationActionViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static VerificationActionViewModelFactory newInstance(VerificationStatusInteractor verificationStatusInteractor, SchedulersFactory3 schedulersFactory3, VerificationResourceProvider verificationResourceProvider, String str) {
        return new VerificationActionViewModelFactory(verificationStatusInteractor, schedulersFactory3, verificationResourceProvider, str);
    }

    @Override // javax.inject.Provider
    public VerificationActionViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
