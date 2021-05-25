package com.avito.android.payment.di.module;

import android.content.Context;
import com.avito.android.payment.google_pay.AvitoMerchantInfo;
import com.google.android.gms.wallet.PaymentsClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GooglePayModule_ProvideGooglePaymentClientFactory implements Factory<PaymentsClient> {
    public final GooglePayModule a;
    public final Provider<Context> b;
    public final Provider<AvitoMerchantInfo> c;

    public GooglePayModule_ProvideGooglePaymentClientFactory(GooglePayModule googlePayModule, Provider<Context> provider, Provider<AvitoMerchantInfo> provider2) {
        this.a = googlePayModule;
        this.b = provider;
        this.c = provider2;
    }

    public static GooglePayModule_ProvideGooglePaymentClientFactory create(GooglePayModule googlePayModule, Provider<Context> provider, Provider<AvitoMerchantInfo> provider2) {
        return new GooglePayModule_ProvideGooglePaymentClientFactory(googlePayModule, provider, provider2);
    }

    public static PaymentsClient provideGooglePaymentClient(GooglePayModule googlePayModule, Context context, AvitoMerchantInfo avitoMerchantInfo) {
        return (PaymentsClient) Preconditions.checkNotNullFromProvides(googlePayModule.provideGooglePaymentClient(context, avitoMerchantInfo));
    }

    @Override // javax.inject.Provider
    public PaymentsClient get() {
        return provideGooglePaymentClient(this.a, this.b.get(), this.c.get());
    }
}
