package com.avito.android.tariff.landing.viewmodel;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffLandingViewModelFactory_Factory implements Factory<TariffLandingViewModelFactory> {
    public final Provider<LandingInteractor> a;
    public final Provider<SchedulersFactory> b;

    public TariffLandingViewModelFactory_Factory(Provider<LandingInteractor> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffLandingViewModelFactory_Factory create(Provider<LandingInteractor> provider, Provider<SchedulersFactory> provider2) {
        return new TariffLandingViewModelFactory_Factory(provider, provider2);
    }

    public static TariffLandingViewModelFactory newInstance(LandingInteractor landingInteractor, SchedulersFactory schedulersFactory) {
        return new TariffLandingViewModelFactory(landingInteractor, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public TariffLandingViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
