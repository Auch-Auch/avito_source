package com.avito.android.delivery.map.point_info;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsPointInfoViewModelFactory_Factory implements Factory<DeliveryRdsPointInfoViewModelFactory> {
    public final Provider<DeliveryRdsPointInfoInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<String> c;
    public final Provider<String> d;
    public final Provider<Boolean> e;
    public final Provider<String> f;
    public final Provider<DeliveryRdsPointInfoResourceProvider> g;
    public final Provider<Analytics> h;

    public DeliveryRdsPointInfoViewModelFactory_Factory(Provider<DeliveryRdsPointInfoInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<String> provider3, Provider<String> provider4, Provider<Boolean> provider5, Provider<String> provider6, Provider<DeliveryRdsPointInfoResourceProvider> provider7, Provider<Analytics> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static DeliveryRdsPointInfoViewModelFactory_Factory create(Provider<DeliveryRdsPointInfoInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<String> provider3, Provider<String> provider4, Provider<Boolean> provider5, Provider<String> provider6, Provider<DeliveryRdsPointInfoResourceProvider> provider7, Provider<Analytics> provider8) {
        return new DeliveryRdsPointInfoViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static DeliveryRdsPointInfoViewModelFactory newInstance(DeliveryRdsPointInfoInteractor deliveryRdsPointInfoInteractor, SchedulersFactory3 schedulersFactory3, String str, String str2, boolean z, String str3, DeliveryRdsPointInfoResourceProvider deliveryRdsPointInfoResourceProvider, Analytics analytics) {
        return new DeliveryRdsPointInfoViewModelFactory(deliveryRdsPointInfoInteractor, schedulersFactory3, str, str2, z, str3, deliveryRdsPointInfoResourceProvider, analytics);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsPointInfoViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get().booleanValue(), this.f.get(), this.g.get(), this.h.get());
    }
}
