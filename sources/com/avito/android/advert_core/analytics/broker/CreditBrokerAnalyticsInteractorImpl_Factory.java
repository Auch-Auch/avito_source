package com.avito.android.advert_core.analytics.broker;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.Kundle;
import com.avito.android.util.UUIDRandomKeyProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreditBrokerAnalyticsInteractorImpl_Factory implements Factory<CreditBrokerAnalyticsInteractorImpl> {
    public final Provider<String> a;
    public final Provider<Analytics> b;
    public final Provider<UUIDRandomKeyProvider> c;
    public final Provider<Kundle> d;

    public CreditBrokerAnalyticsInteractorImpl_Factory(Provider<String> provider, Provider<Analytics> provider2, Provider<UUIDRandomKeyProvider> provider3, Provider<Kundle> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CreditBrokerAnalyticsInteractorImpl_Factory create(Provider<String> provider, Provider<Analytics> provider2, Provider<UUIDRandomKeyProvider> provider3, Provider<Kundle> provider4) {
        return new CreditBrokerAnalyticsInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CreditBrokerAnalyticsInteractorImpl newInstance(String str, Analytics analytics, UUIDRandomKeyProvider uUIDRandomKeyProvider, Kundle kundle) {
        return new CreditBrokerAnalyticsInteractorImpl(str, analytics, uUIDRandomKeyProvider, kundle);
    }

    @Override // javax.inject.Provider
    public CreditBrokerAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
