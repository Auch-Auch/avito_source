package com.avito.android;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PaymentIntentFactoryImpl_Factory implements Factory<PaymentIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<PaymentLibIntentFactory> b;
    public final Provider<Features> c;

    public PaymentIntentFactoryImpl_Factory(Provider<Application> provider, Provider<PaymentLibIntentFactory> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PaymentIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<PaymentLibIntentFactory> provider2, Provider<Features> provider3) {
        return new PaymentIntentFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static PaymentIntentFactoryImpl newInstance(Application application, PaymentLibIntentFactory paymentLibIntentFactory, Features features) {
        return new PaymentIntentFactoryImpl(application, paymentLibIntentFactory, features);
    }

    @Override // javax.inject.Provider
    public PaymentIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
