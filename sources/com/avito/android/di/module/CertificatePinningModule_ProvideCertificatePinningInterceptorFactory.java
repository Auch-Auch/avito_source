package com.avito.android.di.module;

import com.avito.android.certificate_pinning.CertificatePinningErrorRouter;
import com.avito.android.remote.interceptor.CertificatePinningInterceptor;
import com.avito.android.server_time.ServerTimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CertificatePinningModule_ProvideCertificatePinningInterceptorFactory implements Factory<CertificatePinningInterceptor> {
    public final Provider<ServerTimeSource> a;
    public final Provider<CertificatePinningErrorRouter> b;

    public CertificatePinningModule_ProvideCertificatePinningInterceptorFactory(Provider<ServerTimeSource> provider, Provider<CertificatePinningErrorRouter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CertificatePinningModule_ProvideCertificatePinningInterceptorFactory create(Provider<ServerTimeSource> provider, Provider<CertificatePinningErrorRouter> provider2) {
        return new CertificatePinningModule_ProvideCertificatePinningInterceptorFactory(provider, provider2);
    }

    public static CertificatePinningInterceptor provideCertificatePinningInterceptor(ServerTimeSource serverTimeSource, CertificatePinningErrorRouter certificatePinningErrorRouter) {
        return (CertificatePinningInterceptor) Preconditions.checkNotNullFromProvides(CertificatePinningModule.provideCertificatePinningInterceptor(serverTimeSource, certificatePinningErrorRouter));
    }

    @Override // javax.inject.Provider
    public CertificatePinningInterceptor get() {
        return provideCertificatePinningInterceptor(this.a.get(), this.b.get());
    }
}
