package com.avito.android.shop.detailed;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.navigation.NavigationTabProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopDetailedIntentFactoryImpl_Factory implements Factory<ShopDetailedIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<Features> b;
    public final Provider<NavigationTabProvider> c;
    public final Provider<CoreActivityIntentFactory> d;

    public ShopDetailedIntentFactoryImpl_Factory(Provider<Application> provider, Provider<Features> provider2, Provider<NavigationTabProvider> provider3, Provider<CoreActivityIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ShopDetailedIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<Features> provider2, Provider<NavigationTabProvider> provider3, Provider<CoreActivityIntentFactory> provider4) {
        return new ShopDetailedIntentFactoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ShopDetailedIntentFactoryImpl newInstance(Application application, Features features, NavigationTabProvider navigationTabProvider, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new ShopDetailedIntentFactoryImpl(application, features, navigationTabProvider, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public ShopDetailedIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
