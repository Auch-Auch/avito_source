package com.avito.android.tariff.landing.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LandingInteractorImpl_Factory implements Factory<LandingInteractorImpl> {
    public final Provider<String> a;
    public final Provider<TariffApi> b;
    public final Provider<LandingConverter> c;
    public final Provider<SchedulersFactory> d;

    public LandingInteractorImpl_Factory(Provider<String> provider, Provider<TariffApi> provider2, Provider<LandingConverter> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static LandingInteractorImpl_Factory create(Provider<String> provider, Provider<TariffApi> provider2, Provider<LandingConverter> provider3, Provider<SchedulersFactory> provider4) {
        return new LandingInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static LandingInteractorImpl newInstance(String str, TariffApi tariffApi, LandingConverter landingConverter, SchedulersFactory schedulersFactory) {
        return new LandingInteractorImpl(str, tariffApi, landingConverter, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public LandingInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
