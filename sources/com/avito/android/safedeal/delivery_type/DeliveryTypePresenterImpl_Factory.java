package com.avito.android.safedeal.delivery_type;

import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryTypePresenterImpl_Factory implements Factory<DeliveryTypePresenterImpl> {
    public final Provider<DeliveryTypeInteractor> a;
    public final Provider<IdProvider> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<AccountStateProvider> d;
    public final Provider<DeliveryTypeData> e;
    public final Provider<Analytics> f;
    public final Provider<Features> g;

    public DeliveryTypePresenterImpl_Factory(Provider<DeliveryTypeInteractor> provider, Provider<IdProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<AccountStateProvider> provider4, Provider<DeliveryTypeData> provider5, Provider<Analytics> provider6, Provider<Features> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static DeliveryTypePresenterImpl_Factory create(Provider<DeliveryTypeInteractor> provider, Provider<IdProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<AccountStateProvider> provider4, Provider<DeliveryTypeData> provider5, Provider<Analytics> provider6, Provider<Features> provider7) {
        return new DeliveryTypePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static DeliveryTypePresenterImpl newInstance(DeliveryTypeInteractor deliveryTypeInteractor, IdProvider idProvider, SchedulersFactory3 schedulersFactory3, AccountStateProvider accountStateProvider, DeliveryTypeData deliveryTypeData, Analytics analytics, Features features) {
        return new DeliveryTypePresenterImpl(deliveryTypeInteractor, idProvider, schedulersFactory3, accountStateProvider, deliveryTypeData, analytics, features);
    }

    @Override // javax.inject.Provider
    public DeliveryTypePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
