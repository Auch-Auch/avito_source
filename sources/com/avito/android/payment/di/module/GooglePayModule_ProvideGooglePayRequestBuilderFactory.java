package com.avito.android.payment.di.module;

import com.avito.android.payment.google_pay.AvitoMerchantInfo;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GooglePayModule_ProvideGooglePayRequestBuilderFactory implements Factory<GooglePayRequestBuilder> {
    public final GooglePayModule a;
    public final Provider<AvitoMerchantInfo> b;

    public GooglePayModule_ProvideGooglePayRequestBuilderFactory(GooglePayModule googlePayModule, Provider<AvitoMerchantInfo> provider) {
        this.a = googlePayModule;
        this.b = provider;
    }

    public static GooglePayModule_ProvideGooglePayRequestBuilderFactory create(GooglePayModule googlePayModule, Provider<AvitoMerchantInfo> provider) {
        return new GooglePayModule_ProvideGooglePayRequestBuilderFactory(googlePayModule, provider);
    }

    public static GooglePayRequestBuilder provideGooglePayRequestBuilder(GooglePayModule googlePayModule, AvitoMerchantInfo avitoMerchantInfo) {
        return (GooglePayRequestBuilder) Preconditions.checkNotNullFromProvides(googlePayModule.provideGooglePayRequestBuilder(avitoMerchantInfo));
    }

    @Override // javax.inject.Provider
    public GooglePayRequestBuilder get() {
        return provideGooglePayRequestBuilder(this.a, this.b.get());
    }
}
