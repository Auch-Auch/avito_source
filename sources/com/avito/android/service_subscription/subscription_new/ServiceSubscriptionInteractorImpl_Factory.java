package com.avito.android.service_subscription.subscription_new;

import com.avito.android.Features;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.service_subscription.remote.ServiceSubscriptionApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ServiceSubscriptionInteractorImpl_Factory implements Factory<ServiceSubscriptionInteractorImpl> {
    public final Provider<ServiceSubscriptionApi> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Features> d;

    public ServiceSubscriptionInteractorImpl_Factory(Provider<ServiceSubscriptionApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ServiceSubscriptionInteractorImpl_Factory create(Provider<ServiceSubscriptionApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory> provider3, Provider<Features> provider4) {
        return new ServiceSubscriptionInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ServiceSubscriptionInteractorImpl newInstance(ServiceSubscriptionApi serviceSubscriptionApi, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory schedulersFactory, Features features) {
        return new ServiceSubscriptionInteractorImpl(serviceSubscriptionApi, typedErrorThrowableConverter, schedulersFactory, features);
    }

    @Override // javax.inject.Provider
    public ServiceSubscriptionInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
