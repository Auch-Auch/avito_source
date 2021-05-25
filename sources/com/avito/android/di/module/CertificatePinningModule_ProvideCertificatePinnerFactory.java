package com.avito.android.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.CertificatePinner;
public final class CertificatePinningModule_ProvideCertificatePinnerFactory implements Factory<CertificatePinner> {

    public static final class a {
        public static final CertificatePinningModule_ProvideCertificatePinnerFactory a = new CertificatePinningModule_ProvideCertificatePinnerFactory();
    }

    public static CertificatePinningModule_ProvideCertificatePinnerFactory create() {
        return a.a;
    }

    public static CertificatePinner provideCertificatePinner() {
        return (CertificatePinner) Preconditions.checkNotNullFromProvides(CertificatePinningModule.provideCertificatePinner());
    }

    @Override // javax.inject.Provider
    public CertificatePinner get() {
        return provideCertificatePinner();
    }
}
