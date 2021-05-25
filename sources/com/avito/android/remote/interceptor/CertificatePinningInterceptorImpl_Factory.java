package com.avito.android.remote.interceptor;

import com.avito.android.certificate_pinning.CertificatePinningErrorRouter;
import com.avito.android.certificate_pinning.Pin;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class CertificatePinningInterceptorImpl_Factory implements Factory<CertificatePinningInterceptorImpl> {
    public final Provider<TimeSource> a;
    public final Provider<CertificatePinningErrorRouter> b;
    public final Provider<List<Pin>> c;
    public final Provider<Boolean> d;

    public CertificatePinningInterceptorImpl_Factory(Provider<TimeSource> provider, Provider<CertificatePinningErrorRouter> provider2, Provider<List<Pin>> provider3, Provider<Boolean> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CertificatePinningInterceptorImpl_Factory create(Provider<TimeSource> provider, Provider<CertificatePinningErrorRouter> provider2, Provider<List<Pin>> provider3, Provider<Boolean> provider4) {
        return new CertificatePinningInterceptorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CertificatePinningInterceptorImpl newInstance(TimeSource timeSource, CertificatePinningErrorRouter certificatePinningErrorRouter, List<Pin> list, boolean z) {
        return new CertificatePinningInterceptorImpl(timeSource, certificatePinningErrorRouter, list, z);
    }

    @Override // javax.inject.Provider
    public CertificatePinningInterceptorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get().booleanValue());
    }
}
