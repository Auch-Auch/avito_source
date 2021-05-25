package com.avito.android;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PaymentLibIntentFactoryImpl_Factory implements Factory<PaymentLibIntentFactoryImpl> {
    public final Provider<Application> a;

    public PaymentLibIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static PaymentLibIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new PaymentLibIntentFactoryImpl_Factory(provider);
    }

    public static PaymentLibIntentFactoryImpl newInstance(Application application) {
        return new PaymentLibIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public PaymentLibIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
