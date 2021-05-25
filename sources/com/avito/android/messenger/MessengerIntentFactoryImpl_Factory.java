package com.avito.android.messenger;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.navigation.NavigationTabProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessengerIntentFactoryImpl_Factory implements Factory<MessengerIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<CoreActivityIntentFactory> b;
    public final Provider<NavigationTabProvider> c;
    public final Provider<Features> d;

    public MessengerIntentFactoryImpl_Factory(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2, Provider<NavigationTabProvider> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MessengerIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2, Provider<NavigationTabProvider> provider3, Provider<Features> provider4) {
        return new MessengerIntentFactoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static MessengerIntentFactoryImpl newInstance(Application application, CoreActivityIntentFactory coreActivityIntentFactory, NavigationTabProvider navigationTabProvider, Features features) {
        return new MessengerIntentFactoryImpl(application, coreActivityIntentFactory, navigationTabProvider, features);
    }

    @Override // javax.inject.Provider
    public MessengerIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
