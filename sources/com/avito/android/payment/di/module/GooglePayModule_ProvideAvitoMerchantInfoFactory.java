package com.avito.android.payment.di.module;

import com.avito.android.Features;
import com.avito.android.payment.google_pay.AvitoMerchantInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GooglePayModule_ProvideAvitoMerchantInfoFactory implements Factory<AvitoMerchantInfo> {
    public final GooglePayModule a;
    public final Provider<Features> b;

    public GooglePayModule_ProvideAvitoMerchantInfoFactory(GooglePayModule googlePayModule, Provider<Features> provider) {
        this.a = googlePayModule;
        this.b = provider;
    }

    public static GooglePayModule_ProvideAvitoMerchantInfoFactory create(GooglePayModule googlePayModule, Provider<Features> provider) {
        return new GooglePayModule_ProvideAvitoMerchantInfoFactory(googlePayModule, provider);
    }

    public static AvitoMerchantInfo provideAvitoMerchantInfo(GooglePayModule googlePayModule, Features features) {
        return (AvitoMerchantInfo) Preconditions.checkNotNullFromProvides(googlePayModule.provideAvitoMerchantInfo(features));
    }

    @Override // javax.inject.Provider
    public AvitoMerchantInfo get() {
        return provideAvitoMerchantInfo(this.a, this.b.get());
    }
}
