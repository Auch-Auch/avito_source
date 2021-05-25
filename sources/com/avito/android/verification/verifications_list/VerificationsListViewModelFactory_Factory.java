package com.avito.android.verification.verifications_list;

import com.avito.android.util.SchedulersFactory3;
import com.avito.android.verification.VerificationResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationsListViewModelFactory_Factory implements Factory<VerificationsListViewModelFactory> {
    public final Provider<VerificationsListInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<VerificationResourceProvider> c;
    public final Provider<VerificationOptionsListConverter> d;

    public VerificationsListViewModelFactory_Factory(Provider<VerificationsListInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<VerificationResourceProvider> provider3, Provider<VerificationOptionsListConverter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static VerificationsListViewModelFactory_Factory create(Provider<VerificationsListInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<VerificationResourceProvider> provider3, Provider<VerificationOptionsListConverter> provider4) {
        return new VerificationsListViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static VerificationsListViewModelFactory newInstance(VerificationsListInteractor verificationsListInteractor, SchedulersFactory3 schedulersFactory3, VerificationResourceProvider verificationResourceProvider, VerificationOptionsListConverter verificationOptionsListConverter) {
        return new VerificationsListViewModelFactory(verificationsListInteractor, schedulersFactory3, verificationResourceProvider, verificationOptionsListConverter);
    }

    @Override // javax.inject.Provider
    public VerificationsListViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
