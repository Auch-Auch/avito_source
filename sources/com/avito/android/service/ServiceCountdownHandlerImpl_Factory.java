package com.avito.android.service;

import com.avito.android.service.ServiceCountdownHandler;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ServiceCountdownHandlerImpl_Factory implements Factory<ServiceCountdownHandlerImpl> {
    public final Provider<String> a;
    public final Provider<ServiceCountdownHandler.Listener> b;

    public ServiceCountdownHandlerImpl_Factory(Provider<String> provider, Provider<ServiceCountdownHandler.Listener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ServiceCountdownHandlerImpl_Factory create(Provider<String> provider, Provider<ServiceCountdownHandler.Listener> provider2) {
        return new ServiceCountdownHandlerImpl_Factory(provider, provider2);
    }

    public static ServiceCountdownHandlerImpl newInstance(String str, ServiceCountdownHandler.Listener listener) {
        return new ServiceCountdownHandlerImpl(str, listener);
    }

    @Override // javax.inject.Provider
    public ServiceCountdownHandlerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
