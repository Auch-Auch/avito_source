package com.avito.android.advert_core.safedeal;

import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertSafedealServicesViewModelFactory_Factory implements Factory<MyAdvertSafedealServicesViewModelFactory> {
    public final Provider<MyAdvertSafeDealServicesInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<MyAdvertSafeDealResourceProvider> c;
    public final Provider<Relay<MyAdvertSafeDeal>> d;

    public MyAdvertSafedealServicesViewModelFactory_Factory(Provider<MyAdvertSafeDealServicesInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<MyAdvertSafeDealResourceProvider> provider3, Provider<Relay<MyAdvertSafeDeal>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MyAdvertSafedealServicesViewModelFactory_Factory create(Provider<MyAdvertSafeDealServicesInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<MyAdvertSafeDealResourceProvider> provider3, Provider<Relay<MyAdvertSafeDeal>> provider4) {
        return new MyAdvertSafedealServicesViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static MyAdvertSafedealServicesViewModelFactory newInstance(MyAdvertSafeDealServicesInteractor myAdvertSafeDealServicesInteractor, SchedulersFactory3 schedulersFactory3, MyAdvertSafeDealResourceProvider myAdvertSafeDealResourceProvider, Relay<MyAdvertSafeDeal> relay) {
        return new MyAdvertSafedealServicesViewModelFactory(myAdvertSafeDealServicesInteractor, schedulersFactory3, myAdvertSafeDealResourceProvider, relay);
    }

    @Override // javax.inject.Provider
    public MyAdvertSafedealServicesViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
