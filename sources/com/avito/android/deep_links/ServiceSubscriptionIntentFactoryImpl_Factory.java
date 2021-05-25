package com.avito.android.deep_links;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ServiceSubscriptionIntentFactoryImpl_Factory implements Factory<ServiceSubscriptionIntentFactoryImpl> {
    public final Provider<Application> a;

    public ServiceSubscriptionIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static ServiceSubscriptionIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new ServiceSubscriptionIntentFactoryImpl_Factory(provider);
    }

    public static ServiceSubscriptionIntentFactoryImpl newInstance(Application application) {
        return new ServiceSubscriptionIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public ServiceSubscriptionIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
