package com.avito.android.safedeal.delivery_courier;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierIntentFactoryImpl_Factory implements Factory<DeliveryCourierIntentFactoryImpl> {
    public final Provider<Application> a;

    public DeliveryCourierIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static DeliveryCourierIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new DeliveryCourierIntentFactoryImpl_Factory(provider);
    }

    public static DeliveryCourierIntentFactoryImpl newInstance(Application application) {
        return new DeliveryCourierIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
