package com.avito.android.delivery;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryIntentFactoryImpl_Factory implements Factory<DeliveryIntentFactoryImpl> {
    public final Provider<Application> a;

    public DeliveryIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static DeliveryIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new DeliveryIntentFactoryImpl_Factory(provider);
    }

    public static DeliveryIntentFactoryImpl newInstance(Application application) {
        return new DeliveryIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public DeliveryIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
