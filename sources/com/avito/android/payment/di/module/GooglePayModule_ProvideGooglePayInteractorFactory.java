package com.avito.android.payment.di.module;

import com.avito.android.payment.google_pay.GooglePayInteractor;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import com.google.android.gms.wallet.PaymentsClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GooglePayModule_ProvideGooglePayInteractorFactory implements Factory<GooglePayInteractor> {
    public final GooglePayModule a;
    public final Provider<PaymentsClient> b;
    public final Provider<GooglePayRequestBuilder> c;

    public GooglePayModule_ProvideGooglePayInteractorFactory(GooglePayModule googlePayModule, Provider<PaymentsClient> provider, Provider<GooglePayRequestBuilder> provider2) {
        this.a = googlePayModule;
        this.b = provider;
        this.c = provider2;
    }

    public static GooglePayModule_ProvideGooglePayInteractorFactory create(GooglePayModule googlePayModule, Provider<PaymentsClient> provider, Provider<GooglePayRequestBuilder> provider2) {
        return new GooglePayModule_ProvideGooglePayInteractorFactory(googlePayModule, provider, provider2);
    }

    public static GooglePayInteractor provideGooglePayInteractor(GooglePayModule googlePayModule, PaymentsClient paymentsClient, GooglePayRequestBuilder googlePayRequestBuilder) {
        return (GooglePayInteractor) Preconditions.checkNotNullFromProvides(googlePayModule.provideGooglePayInteractor(paymentsClient, googlePayRequestBuilder));
    }

    @Override // javax.inject.Provider
    public GooglePayInteractor get() {
        return provideGooglePayInteractor(this.a, this.b.get(), this.c.get());
    }
}
