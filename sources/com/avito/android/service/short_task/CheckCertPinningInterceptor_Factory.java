package com.avito.android.service.short_task;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.CertificatePinner;
public final class CheckCertPinningInterceptor_Factory implements Factory<CheckCertPinningInterceptor> {
    public final Provider<Analytics> a;
    public final Provider<CertificatePinner> b;

    public CheckCertPinningInterceptor_Factory(Provider<Analytics> provider, Provider<CertificatePinner> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CheckCertPinningInterceptor_Factory create(Provider<Analytics> provider, Provider<CertificatePinner> provider2) {
        return new CheckCertPinningInterceptor_Factory(provider, provider2);
    }

    public static CheckCertPinningInterceptor newInstance(Analytics analytics, CertificatePinner certificatePinner) {
        return new CheckCertPinningInterceptor(analytics, certificatePinner);
    }

    @Override // javax.inject.Provider
    public CheckCertPinningInterceptor get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
