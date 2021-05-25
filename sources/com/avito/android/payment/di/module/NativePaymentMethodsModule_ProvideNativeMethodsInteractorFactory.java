package com.avito.android.payment.di.module;

import com.avito.android.Features;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.payment.NativeMethodsInteractor;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import com.google.android.gms.wallet.PaymentsClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NativePaymentMethodsModule_ProvideNativeMethodsInteractorFactory implements Factory<NativeMethodsInteractor> {
    public final NativePaymentMethodsModule a;
    public final Provider<ApplicationInfoProvider> b;
    public final Provider<PaymentsClient> c;
    public final Provider<GooglePayRequestBuilder> d;
    public final Provider<Features> e;

    public NativePaymentMethodsModule_ProvideNativeMethodsInteractorFactory(NativePaymentMethodsModule nativePaymentMethodsModule, Provider<ApplicationInfoProvider> provider, Provider<PaymentsClient> provider2, Provider<GooglePayRequestBuilder> provider3, Provider<Features> provider4) {
        this.a = nativePaymentMethodsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static NativePaymentMethodsModule_ProvideNativeMethodsInteractorFactory create(NativePaymentMethodsModule nativePaymentMethodsModule, Provider<ApplicationInfoProvider> provider, Provider<PaymentsClient> provider2, Provider<GooglePayRequestBuilder> provider3, Provider<Features> provider4) {
        return new NativePaymentMethodsModule_ProvideNativeMethodsInteractorFactory(nativePaymentMethodsModule, provider, provider2, provider3, provider4);
    }

    public static NativeMethodsInteractor provideNativeMethodsInteractor(NativePaymentMethodsModule nativePaymentMethodsModule, ApplicationInfoProvider applicationInfoProvider, PaymentsClient paymentsClient, GooglePayRequestBuilder googlePayRequestBuilder, Features features) {
        return (NativeMethodsInteractor) Preconditions.checkNotNullFromProvides(nativePaymentMethodsModule.provideNativeMethodsInteractor(applicationInfoProvider, paymentsClient, googlePayRequestBuilder, features));
    }

    @Override // javax.inject.Provider
    public NativeMethodsInteractor get() {
        return provideNativeMethodsInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
