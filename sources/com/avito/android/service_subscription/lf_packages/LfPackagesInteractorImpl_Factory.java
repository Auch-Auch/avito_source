package com.avito.android.service_subscription.lf_packages;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.service_subscription.remote.ServiceSubscriptionApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LfPackagesInteractorImpl_Factory implements Factory<LfPackagesInteractorImpl> {
    public final Provider<ServiceSubscriptionApi> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<SchedulersFactory> c;

    public LfPackagesInteractorImpl_Factory(Provider<ServiceSubscriptionApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static LfPackagesInteractorImpl_Factory create(Provider<ServiceSubscriptionApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory> provider3) {
        return new LfPackagesInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static LfPackagesInteractorImpl newInstance(ServiceSubscriptionApi serviceSubscriptionApi, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory schedulersFactory) {
        return new LfPackagesInteractorImpl(serviceSubscriptionApi, typedErrorThrowableConverter, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public LfPackagesInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
