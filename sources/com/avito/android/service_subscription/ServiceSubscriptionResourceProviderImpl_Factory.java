package com.avito.android.service_subscription;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ServiceSubscriptionResourceProviderImpl_Factory implements Factory<ServiceSubscriptionResourceProviderImpl> {
    public final Provider<Resources> a;

    public ServiceSubscriptionResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ServiceSubscriptionResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ServiceSubscriptionResourceProviderImpl_Factory(provider);
    }

    public static ServiceSubscriptionResourceProviderImpl newInstance(Resources resources) {
        return new ServiceSubscriptionResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ServiceSubscriptionResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
