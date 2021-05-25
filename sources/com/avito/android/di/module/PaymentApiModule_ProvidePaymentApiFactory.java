package com.avito.android.di.module;

import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PaymentApiModule_ProvidePaymentApiFactory implements Factory<PaymentApi> {
    public final Provider<RetrofitFactory> a;

    public PaymentApiModule_ProvidePaymentApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static PaymentApiModule_ProvidePaymentApiFactory create(Provider<RetrofitFactory> provider) {
        return new PaymentApiModule_ProvidePaymentApiFactory(provider);
    }

    public static PaymentApi providePaymentApi(RetrofitFactory retrofitFactory) {
        return (PaymentApi) Preconditions.checkNotNullFromProvides(PaymentApiModule.INSTANCE.providePaymentApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public PaymentApi get() {
        return providePaymentApi(this.a.get());
    }
}
