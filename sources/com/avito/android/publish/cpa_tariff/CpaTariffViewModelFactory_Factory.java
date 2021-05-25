package com.avito.android.publish.cpa_tariff;

import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.cpa_tariff.data.CpaTariffRepository;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CpaTariffViewModelFactory_Factory implements Factory<CpaTariffViewModelFactory> {
    public final Provider<CpaTariffRepository> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<PublishEventTracker> c;

    public CpaTariffViewModelFactory_Factory(Provider<CpaTariffRepository> provider, Provider<SchedulersFactory3> provider2, Provider<PublishEventTracker> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CpaTariffViewModelFactory_Factory create(Provider<CpaTariffRepository> provider, Provider<SchedulersFactory3> provider2, Provider<PublishEventTracker> provider3) {
        return new CpaTariffViewModelFactory_Factory(provider, provider2, provider3);
    }

    public static CpaTariffViewModelFactory newInstance(CpaTariffRepository cpaTariffRepository, SchedulersFactory3 schedulersFactory3, PublishEventTracker publishEventTracker) {
        return new CpaTariffViewModelFactory(cpaTariffRepository, schedulersFactory3, publishEventTracker);
    }

    @Override // javax.inject.Provider
    public CpaTariffViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
