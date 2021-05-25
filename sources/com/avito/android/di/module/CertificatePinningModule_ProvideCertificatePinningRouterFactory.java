package com.avito.android.di.module;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.app.ActivityProvider;
import com.avito.android.certificate_pinning.CertificatePinningErrorRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CertificatePinningModule_ProvideCertificatePinningRouterFactory implements Factory<CertificatePinningErrorRouter> {
    public final Provider<ActivityProvider> a;
    public final Provider<ActivityIntentFactory> b;

    public CertificatePinningModule_ProvideCertificatePinningRouterFactory(Provider<ActivityProvider> provider, Provider<ActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CertificatePinningModule_ProvideCertificatePinningRouterFactory create(Provider<ActivityProvider> provider, Provider<ActivityIntentFactory> provider2) {
        return new CertificatePinningModule_ProvideCertificatePinningRouterFactory(provider, provider2);
    }

    public static CertificatePinningErrorRouter provideCertificatePinningRouter(ActivityProvider activityProvider, ActivityIntentFactory activityIntentFactory) {
        return (CertificatePinningErrorRouter) Preconditions.checkNotNullFromProvides(CertificatePinningModule.provideCertificatePinningRouter(activityProvider, activityIntentFactory));
    }

    @Override // javax.inject.Provider
    public CertificatePinningErrorRouter get() {
        return provideCertificatePinningRouter(this.a.get(), this.b.get());
    }
}
