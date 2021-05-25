package ru.avito.messenger.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.avito.messenger.MessengerApi;
public final class ServiceModule_ProvideServiceFactory implements Factory<Class<? extends MessengerApi>> {
    public final ServiceModule a;

    public ServiceModule_ProvideServiceFactory(ServiceModule serviceModule) {
        this.a = serviceModule;
    }

    public static ServiceModule_ProvideServiceFactory create(ServiceModule serviceModule) {
        return new ServiceModule_ProvideServiceFactory(serviceModule);
    }

    public static Class<? extends MessengerApi> provideService(ServiceModule serviceModule) {
        return (Class) Preconditions.checkNotNullFromProvides(serviceModule.provideService());
    }

    @Override // javax.inject.Provider
    public Class<? extends MessengerApi> get() {
        return provideService(this.a);
    }
}
