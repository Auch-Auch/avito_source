package com.avito.android;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ServiceIntentFactoryImpl_Factory implements Factory<ServiceIntentFactoryImpl> {
    public final Provider<MessengerServiceIntentFactory> a;
    public final Provider<NotificationServiceIntentFactory> b;
    public final Provider<FavoriteSellerServiceIntentFactory> c;
    public final Provider<UserAdvertServiceIntentFactory> d;

    public ServiceIntentFactoryImpl_Factory(Provider<MessengerServiceIntentFactory> provider, Provider<NotificationServiceIntentFactory> provider2, Provider<FavoriteSellerServiceIntentFactory> provider3, Provider<UserAdvertServiceIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ServiceIntentFactoryImpl_Factory create(Provider<MessengerServiceIntentFactory> provider, Provider<NotificationServiceIntentFactory> provider2, Provider<FavoriteSellerServiceIntentFactory> provider3, Provider<UserAdvertServiceIntentFactory> provider4) {
        return new ServiceIntentFactoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ServiceIntentFactoryImpl newInstance(MessengerServiceIntentFactory messengerServiceIntentFactory, NotificationServiceIntentFactory notificationServiceIntentFactory, FavoriteSellerServiceIntentFactory favoriteSellerServiceIntentFactory, UserAdvertServiceIntentFactory userAdvertServiceIntentFactory) {
        return new ServiceIntentFactoryImpl(messengerServiceIntentFactory, notificationServiceIntentFactory, favoriteSellerServiceIntentFactory, userAdvertServiceIntentFactory);
    }

    @Override // javax.inject.Provider
    public ServiceIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
